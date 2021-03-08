package abc;

import javax.servlet.http.HttpServletRequest;

public class NumController {

	public String afterDiscussionTellPosOrNeg(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pn ="/WEB-INF/neg.html";
		
		int x=23;// this is data 
		
		
		String param = request.getParameter("ne");
		int i = Integer.parseInt(param.trim());
		if( i > 0)
				pn ="/WEB-INF/pos.html";
	System.out.println("in num controller");
		return pn;
	}

}
