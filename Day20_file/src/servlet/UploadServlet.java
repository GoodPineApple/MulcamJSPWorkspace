package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns="/upload.do")
public class UploadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		String uploadFolder = "c://uploaded//";
		MultipartRequest mRequest = new MultipartRequest(req, uploadFolder, 1024*1024*5, new DefaultFileRenamePolicy());
		File file = mRequest.getFile("uploadFile");
		
		System.out.println("원본 파일 이름:"+mRequest.getOriginalFileName("uploadFile"));
		System.out.println("저장된 이름:"+file.getName());
		System.out.println("저장된 전체 경로:"+file.getAbsolutePath());
		System.out.println("파일 아닌 일반 파라미터:"+mRequest.getParameter("param"));
		
	}
}
