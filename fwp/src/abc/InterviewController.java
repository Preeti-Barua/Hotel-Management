package abc;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Driver;

public class InterviewController {

	public String afterDiscussionTEllWhatDo(HttpServletRequest request) {
		String pageName="/WEB-INF/seeyoulater.html";
		
		
		
		String branch= request.getParameter("branch");
		String univ= request.getParameter("univ");
		System.out.println(branch  + " -- " + univ);
		int x =(int)(Math.random()*10);
		System.out.println("rn " + x);
		if( x <4)
			    pageName="/WEB-INF/meethr.html";
		
		
		
		System.out.println("Step by step prove you reached interview controller");
		return pageName;
	}

}
