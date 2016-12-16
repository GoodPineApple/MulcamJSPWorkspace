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

@WebServlet(urlPatterns="/file.do")
public class FileController extends HttpServlet{
	FileDAO dao = FileDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewPath = "";
		String action = req.getParameter("action");
		
		if(action == null || action.equals("main")){
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
		req.setCharacterEncoding("euc-kr");
		String uploadFolder = "c://uploaded//";
		MultipartRequest mRequest = new MultipartRequest(req, uploadFolder, 1024*1024*5, new DefaultFileRenamePolicy());
		File file = mRequest.getFile("uploadFile");
		
		FileVO fileVO = new FileVO();
		fileVO.setFileName(mRequest.getOriginalFileName("uploadFile")); 
		fileVO.setSavedPath(file.getAbsolutePath()); 
		fileVO.setFileSize((int)file.length()); 
		fileVO.setDownCount(0);
		
		int result = dao.insert(fileVO);
		//DB작업 결과를 request에 기록해서 forward
		req.setAttribute("uploadResult", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("upload_result.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
}
