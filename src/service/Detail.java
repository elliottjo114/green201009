package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;
import model.CenterDAO;

public class Detail implements M_Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id")); //center/List.jsp에서 보낸 id값을 받아서 인트로 변환
		new CenterDAO().addCount(id); //조회수 늘리기 ( 디테일 들어가면 조회수 늘어남)
		request.setAttribute("dto", new CenterDAO().detail(id));//키값 dto 에 id로 검색한 값들을 넣고 어트리뷰트로 보내기 

	}

}
