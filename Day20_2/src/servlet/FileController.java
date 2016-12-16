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
			//���� ������ ���ε�� ���� ��Ϻ����ֱ�
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
		// ���Ͼ��ε� �ɶ����� post
		req.setCharacterEncoding("euc-kr");
		String uploadFolder = "c://uploaded//";
		MultipartRequest mRequest = new MultipartRequest(req, uploadFolder, 1024*1024*5, new DefaultFileRenamePolicy());
		//���������� ����Ǵ� ����
		File file = mRequest.getFile("uploadFile");
		
		//������ ����� ���� ������ DB�� insert��Ű��
		FileVO fileVO = new FileVO();
		fileVO.setFileName(mRequest.getOriginalFileName("uploadFile")); //�����̸�
		fileVO.setSavedPath(file.getAbsolutePath()); //������
		fileVO.setFileSize((int)file.length()); //����ũ��
		fileVO.setDownCount(0); //�ٿ�Ƚ�� �ʱ�ȭ
		
		int result = dao.insert(fileVO);
		//DB�۾� ����� request�� ����ؼ� forward
		req.setAttribute("uploadResult", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("upload_result.jsp");
		dispatcher.forward(req, resp);
	}
}