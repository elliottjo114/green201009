package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import di.M_Action;

@WebServlet("/center/notice/*")
public class F_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			int page = 1;
			if(request.getParameter("page")!=null)
				page = Integer.parseInt(request.getParameter("page"));
			
			request.setAttribute("page", page);
			
			String service =request.getRequestURI().substring(       // 경로지정  지금 어디에 있고 어디로 보내야하는지
					(request.getContextPath()+"/center/notice/").length());
			
			//response.getWriter().append("f_contoller>>> "+service);
			
			request.setAttribute("mainUrl", service); //template에서 포워딩할 주소 세팅
			
			
			ArrayList<String> nonCla = new ArrayList<String>(); //M_Action 실행안할 리트스
			nonCla.add("InsertForm");
			nonCla.add("DeleteForm");
			
			if(!nonCla.contains(service)) { // 속하지 않는다면 실행
				M_Action action = (M_Action)Class.forName("service."+service).newInstance();
				action.execute(request, response);
			}
			
			if(!service.equals("FileDown")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../../view/template.jsp"); //여기로 보내
				dispatcher.forward(request, response);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
