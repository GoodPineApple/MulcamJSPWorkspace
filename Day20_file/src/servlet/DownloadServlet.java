package servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/download.do")
public class DownloadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String folderPath = "c:/uploaded/";
		String fileName = "cos.jar";
		String fileURL = folderPath+fileName;
		
		resp.setHeader("Content-Disposition", "attachment;filename=" + 
						new String(fileName.getBytes(), "ISO8859_1"));
		
		FileInputStream fis = new FileInputStream(fileURL);
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[] buf = new byte[1024];
		int size = 0;
		while((size=fis.read(buf))!=-1){
			sos.write(buf, 0, size);
			sos.flush();
		}
		fis.close();
		sos.close();
	}
}
