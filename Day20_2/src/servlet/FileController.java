package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FileDAO;
import vo.FileVO;

@WebServlet("/file.do")
public class FileController extends HttpServlet{
	private FileDAO dao = FileDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String viewPath = "";
		if(action==null || action.equals("fileList")){
			//현재 서버에 업로드된 파일 목록보여주기
			List<FileVO> fileList = dao.selectFileList();
			req.setAttribute("fileList", fileList);
			viewPath = "file_list.jsp";
		} else if(action.equals("uploadForm")){
			viewPath="upload_form.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일업로드 될때에는 post
		req.setCharacterEncoding("euc-kr");
		String uploadFolder = "c://uploaded//";
		MultipartRequest mRequest = new MultipartRequest(req, uploadFolder, 1024*1024*5, new DefaultFileRenamePolicy());
		//서버폴더에 저장되는 문장
		File file = mRequest.getFile("uploadFile");
		
		//폴더에 저장된 파일 정보를 DB에 insert시키기
		FileVO fileVO = new FileVO();
		fileVO.setFileName(mRequest.getOriginalFileName("uploadFile")); //원래이름
		fileVO.setSavedPath(file.getAbsolutePath()); //저장경로
		fileVO.setFileSize((int)file.length()); //파일크기
		fileVO.setDownCount(0); //다운횟수 초기화
		
		int result = dao.insert(fileVO);
		//DB작업 결과를 request에 기록해서 forward
		req.setAttribute("uploadResult", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("upload_result.jsp");
		dispatcher.forward(req, resp);
	}
}
