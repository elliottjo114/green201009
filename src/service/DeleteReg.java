package service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;
import model.CenterDAO;
import model.CenterDTO;

public class DeleteReg implements M_Action {
	
	
	
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = request.getRealPath("up");
		path = "C:\\elliott\\study\\jspwork\\mvcProj\\WebContent\\up";
		
		CenterDTO dto = new CenterDTO();
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setPw(request.getParameter("pw"));
		
		String msg = "암호 불일치";
		String goUrl = "DeleteForm?id="+dto.getId()+"&page="+request.getAttribute("page");
		
		CenterDTO fileDTO = new CenterDAO().fileSch(dto);
		
		if(fileDTO!=null && fileDTO.getUpfile() != null) {
			new File(path+"\\"+fileDTO.getUpfile()).delete();  //파일삭제
		}
		
		if(new CenterDAO().delete(dto)>0) {  //db 삭제
			msg = "삭제되었습니다.";
			goUrl = "List";
		}
		
		
		///redirect
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl",goUrl);
		request.setAttribute("mainUrl", "alert");

	}

}
