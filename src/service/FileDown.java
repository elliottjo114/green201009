package service;

import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;

public class FileDown implements M_Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = request.getRealPath("up");
		path = "C:\\elliott\\study\\jspwork\\mvcProj\\WebContent\\up";

		String ff = request.getParameter("file");
		
		FileInputStream fis = new FileInputStream(path+"\\"+ff);
		
		String fName = URLEncoder.encode(ff,"utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+fName);
		
		//out.clear();
		//out = pageContext.pushBody();
		
		ServletOutputStream sos = response.getOutputStream();
		
		
		byte [] buf = new byte[1024];
		
		while(fis.available()>0){
			int len = fis.read(buf);
			sos.write(buf,0,len);
		}
		
		sos.close(); 
		fis.close();

	}

}
