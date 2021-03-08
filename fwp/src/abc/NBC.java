package abc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class NBC {

	public String afterDiscussionTell7thMultiple(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pn="/WEB-INF/res.jsp";
		String x = request.getParameter("ne");
		int i = Integer.parseInt(x);
		int result = i *7;//this we want to show
		//in the jsp
		//i have to write to the notice board
		
		request.setAttribute("k1", result); //writing
		request.setAttribute("k2","junk");
		List<String> l =new ArrayList<String>();
		l.add("hi");
		l.add("hello");
		request.setAttribute("k3",l);
		//onto the notice board
		
		
		
		
		return pn;
	}

}
