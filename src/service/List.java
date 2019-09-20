package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;
import model.CenterDAO;

public class List implements M_Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int limit = 3;			//한 페이지당 게시물 수
		int pageLimit = 4;		//페이지 번호 갯수
		
		int page = (int)request.getAttribute("page");
		
		int start = (page-1) * limit;  //게시물 시작 번호
		
		request.setAttribute("data", new CenterDAO().list(start, limit));
		
		
		////>>>>>>>>>>>>>>페이지번호
		
		int total =  new CenterDAO().total();
		int pageTotal = total/limit;
		if(total%limit>0)
			pageTotal++;
		
		//System.out.println(pageTotal+","+total);
		
		int pageStart = (page-1)/pageLimit*pageLimit+1;
		int pageEnd = pageStart +pageLimit -1;
		
		if(pageEnd>pageTotal)
			pageEnd=pageTotal;
		
		request.setAttribute("start", start);
		
		request.setAttribute("pageStart", pageStart);
		request.setAttribute("pageEnd", pageEnd);
		request.setAttribute("pageTotal", pageTotal);

	}

}
