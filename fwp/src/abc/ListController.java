package abc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ListController {

	public String afterDiscussionTellWhattoDo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pg="/WEB-INF/hi.jsp";
		
		Rct r =new Rct(3,4);//assume this came from service.
		
		request.setAttribute("k2",r);
		
		
		String x = request.getParameter("enterednumber");
		int i = Integer.parseInt(x);
		List<Integer> j = new ArrayList<Integer>();
		for(int k=1 ; k <5; k++)
		{
				j.add(i * k);
			
			
		}
		request.setAttribute("k1",j);
		
		return pg;
	}

}
