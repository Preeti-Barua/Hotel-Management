package abc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class TypingImprovementEnds
 */
@WebServlet("/lastservlet")
public class TypingImprovementEnds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RController sl ;
	private EmpController em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypingImprovementEnds() {
        super();
        sl =new RController();
        em=new EmpController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageName="/r1.html";
		
		//you are askign the reqeust why you came..
		String why= request.getParameter("por");
		
		
		
		
		if(why.equals("insert"))
		{
			
			pageName=sl.adduser(request);
			
			
		}
		
		
		else if(why.equals("get users on pincode"))
		{
			
			pageName=sl.getusersonpincode(request);
			
			
		}
		else 	if(why.equals("update"))
		{
			
			pageName=sl.updatedetails(request);
			
			
		}
		else if(why.equals("getdetails"))
		{
		
			pageName=sl.learntodopoc(request);
			
			
		}
		else if(why.equals("empgetdetails"))
		{
		
			pageName=em.getdetails(request);
			
			
		}
		else if(why.equals("empinsert"))
		{
//			RController sl =new RController();
			pageName=em.insert(request);
			
			
		}
		else if(why.equals("empupdate"))
		{
//			RController sl =new RController();
			pageName=em.update(request);
			
			
		}
		else if(why.equals("empmultisel"))
		{
//			RController sl =new RController();
			pageName=em.multiSel(request);
			
			
		}
		else if(why.equals("empremove"))
		{
//			RController sl =new RController();
			pageName=em.remove(request);
			
			
		}
		else if(why.equals("nbus1"))
		{
			ListController sl =new ListController();
			pageName=sl.afterDiscussionTellWhattoDo(request);
			
			
		}
		
		else if(why.equals("sales"))
		{
			SalesRoomController sl =new SalesRoomController();
			pageName=sl.afterDiscussionTellWhattoDo(request);
			
			
		}
		else if(why.equals("interview"))
		{
			InterviewController cl =new InterviewController();
			pageName = cl.afterDiscussionTEllWhatDo(request);
			
		}
		else if(why.equals("posorneg"))
		{
			NumController cl =new NumController();
			pageName = cl.afterDiscussionTellPosOrNeg(request);
			
		}
		else if(why.equals("unb"))
		{
			NBC cl =new NBC();
			pageName = cl.afterDiscussionTell7thMultiple(request);
			
		}
		
		
		
		
		
		
		System.out.println("this is page we are seeing" + pageName);
		RequestDispatcher rd = request.getRequestDispatcher(pageName);
		rd.forward(request, response);
	
	
	
	}

}
