package service;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import di.M_Action;
import model.CenterDAO;
import model.CenterDTO;

public class FileDelete implements M_Action {
	
	
	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = request.getRealPath("up");
		path = "C:\\elliott\\study\\jspwork\\mvcProj\\WebContent\\up";
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		java.util.List<FileItem> items = upload.parseRequest(request);
		
		CenterDTO dto = new CenterDTO();
		
		boolean isSave = false;
		FileItem saveItem = null;
		String page = "1";
		
		for (FileItem item : items) {
			switch(item.getFieldName()) {
				case "page":
					page = item.getString("utf-8");
				break;
				case "id":
					dto.setId(Integer.parseInt(item.getString("utf-8")));
				break;
				case "pw":
					dto.setPw(item.getString("utf-8"));
					break;
				case "title":
					dto.setTitle(item.getString("utf-8"));
					break;
				case "pname":
					dto.setPname(item.getString("utf-8"));
					break;
				case "content":
					dto.setContent(item.getString("utf-8"));
					break;
				case "upfile":
					dto.setUpfile(item.getString("utf-8"));
					break;
			
			}
			
			
		}
		
		String msg = "암호 불일치";
		
		CenterDTO fileDTO = new CenterDAO().fileSch(dto);
		//DB 저장
		if(fileDTO!=null) {  ///유효성 검사 통과
			new File(path+"\\"+fileDTO.getUpfile()).delete();  //파일
			dto.setUpfile(null);
			msg="파일 삭제되었습니다.";
			
			
		}
		request.setAttribute("page",page );
		request.setAttribute("dto",dto );
		request.setAttribute("mainUrl","ModifyForm" );

		request.setAttribute("msg",msg );

	}

}
