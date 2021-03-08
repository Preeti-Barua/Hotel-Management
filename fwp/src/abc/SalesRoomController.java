package abc;

import javax.servlet.http.HttpServletRequest;

public class SalesRoomController {

	public String afterDiscussionTellWhattoDo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pageName="/WEB-INF/dontcomeback.html";
		
		
		String prd = request.getParameter("product");
		if(prd.equalsIgnoreCase("casio"))
			  pageName="/WEB-INF/buyit.html";
		
		
		System.out.println("Step by step prove you reached controller");
		return pageName;
	}

}
