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

public class ReplyReg implements M_Action {
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		CenterDTO dto = new CenterDTO();
		
					dto.setGid(Integer.parseInt(request.getParameter("gid")));
					dto.setSeq(Integer.parseInt(request.getParameter("seq")));
					dto.setLev(Integer.parseInt(request.getParameter("lev")));
					dto.setTitle(request.getParameter("title"));
				
					dto.setPw(request.getParameter("pw"));
					
					dto.setPname(request.getParameter("pname"));
					
					dto.setContent(request.getParameter("content"));
					
		
		//DB 저장
		new CenterDAO().reply(dto);
		
		///redirect
		request.setAttribute("msg","작성되었습니다." );
		request.setAttribute("goUrl","Detail?id="+dto.getId()+"&page="+request.getAttribute("page"));
		request.setAttribute("mainUrl", "alert");

	}

}
