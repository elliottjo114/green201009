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

public class ModifyReg implements M_Action {
	
	
	
	

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
				case "title":
					dto.setTitle(item.getString("utf-8"));
					break;
				case "pw":
					dto.setPw(item.getString("utf-8"));
					break;
				case "pname":
					dto.setPname(item.getString("utf-8"));
					break;
				case "content":
					dto.setContent(item.getString("utf-8"));
					break;
				case "upfile":
					if(item.isFormField()) {  ///일반필드라면--> 기존파일 그대로 사용
						dto.setUpfile(item.getString("utf-8"));
						
					}else {  ///파일이라면
						
						if(isSave=!item.getName().equals("")) {  //파일 존재한다면
							///파일명 새로 얻기
							dto.setUpfile(new FileRename().newName(path,item.getName()));
							///파일 저장
							saveItem = item;
						}
							
						
					}
					break;
			
			}
			
			
		}
		
		String msg = "암호 불일치";
		String goUrl = "ModifyForm?id="+dto.getId()+"&page="+page;
		//DB 저장
		if(new CenterDAO().modify(dto)>0) {  ///유효성 검사 통과
			msg="수정되었습니다.";
			goUrl = "Detail?id="+dto.getId()+"&page="+request.getAttribute("page");
			if(isSave) { ///파일저장 존재유무
				saveItem.write(new File(path+"\\"+  dto.getUpfile()));
			}
		}
		
		///redirect
		request.setAttribute("msg",msg );
		request.setAttribute("goUrl",goUrl);
		request.setAttribute("mainUrl", "alert");

	}

}
