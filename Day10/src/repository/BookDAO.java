package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.BookVO;

public class BookDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://70.12.109.107:3306/jsp";
	private final String DB_ID = "root";
	private final String DB_PW = "sds902";
	///////////////////////////////////////////////////////////////////////////////
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	///////////////////////////////////////////////////////////////////////////////
	// �����ڿ��� DB ����̹� �ε�
	public BookDAO() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}
	}

	// Ŀ�ؼ� ���� �޼ҵ�
	private void createConnection() {
		try {
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
		} catch (SQLException e) {
			System.out.println("Ŀ�ؼ� ���� ����");
			e.printStackTrace();
		}
	}

	// Ŀ�ؼ� �����޼ҵ�
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Ŀ�ؼ� ���� ����");
				e.printStackTrace();
			}
		}
	}

	// Statement ����޼ҵ�
	public void closeStatement() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("stmt ���� ����");
				e.printStackTrace();
			}
		}
	}

	// PreparedStatement ����޼ҵ�
	public void closePrepared() {
		if (stmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("pstmt ���� ����");
				e.printStackTrace();
			}
		}
	}
	
	// PreparedStatement ����޼ҵ�
		public void closeResultset() {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("rs ���� ����");
					e.printStackTrace();
				}
			}
		}

	//////////////////////////////////////////////////////////////////////////////
	public int insert(BookVO book) {
		createConnection();
		int result = 0;

		try {
			String sql = "INSERT INTO BOOKS(TITLE,PUBLISHER,YEAR,PRICE)" + "VALUES(?,?,?,?)";
			// 4.Statement ��ü ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getPublisher());
			pstmt.setString(3, book.getYear());
			pstmt.setInt(4, book.getPrice());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert ����");
			e.printStackTrace();
		} finally {
			closePrepared();
			closeConnection();
		}
		return result;
	}

	
	
	 public int delete(int bookId) {
		 createConnection();
		 int result = 0;
		 String sql = "DELETE FROM BOOKS WHERE BOOK_ID=?";
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete ����");
			e.printStackTrace();
		} finally {
			closeConnection();
			closePrepared();
		}
		return result;
	 }
	
	 public int update(BookVO book) {
		 createConnection();
		 int result = 0;
		 String sql = "UPDATE BOOKS SET TITLE=?, PUBLISHER=?, YEAR=?, PRICE=? WHERE BOOK_ID=?";
		 
		 try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getPublisher());
			pstmt.setString(3, book.getYear());
			pstmt.setInt(4, book.getPrice());
			pstmt.setInt(5, book.getBookId());
			
			result = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			System.out.println("update ����");
			e.printStackTrace();
		}
		 return result;
		 
	 }
	 
	 public BookVO select(int bookId) {
		 createConnection();
		 BookVO resultBook = null;
		 String sql = "SELECT BOOK_ID, TITLE, PUBLISHER, YEAR, PRICE "+
				 	" FROM BOOKS WHERE BOOK_ID=?";
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				resultBook = new BookVO();
				resultBook.setBookId(rs.getInt(1));
				resultBook.setTitle(rs.getString(2));
				resultBook.setPublisher(rs.getString(3));
				resultBook.setYear(rs.getString(4));
				resultBook.setPrice(rs.getInt(5));
			}
		 } catch (SQLException e) {
			System.out.println("select ����");
			e.printStackTrace();
		}
		 return resultBook;
	 }
	
	public List<BookVO> selectTotalList() {
		createConnection();
		List<BookVO> booklist = new ArrayList<>();
		String sql = "SELECT BOOK_ID, TITLE, PUBLISHER, YEAR, PRICE FROM BOOKS";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BookVO book = new BookVO();
				book.setBookId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPublisher(rs.getString(3));
				book.setYear(rs.getString(4));
				book.setPrice(rs.getInt(5));
				booklist.add(book);
			}
		} catch (SQLException e) {
			System.out.println("selectTotlList ����");
			e.printStackTrace();
		} finally {
			closeConnection();
			closeResultset();
			closeStatement();
		}
		return booklist;

	}
}
