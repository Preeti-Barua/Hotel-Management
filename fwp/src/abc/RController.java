package abc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import archcode.CUser;
import archcode.ServiceImplementation;
import archcode.ServiceInf;

public class RController {
	
	private ServiceInf serviceInf;
	
	public RController()
	{
		serviceInf = new ServiceImplementation();
	}
	

	public String learntodopoc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String page="/start.jsp";
		request.setAttribute("k1","ok one day i have to do select here");
		String userid = request.getParameter("uname");
		CUser user = serviceInf.getUserDetails(userid);
		
		if(user.getPincode() ==0)
		{
			request.setAttribute("k1", "user details not found");
			
		}
		else
		{
			request.setAttribute("k1", "user details found");
			request.setAttribute("existingdetails", user);
		}
		
		
		return page;
	}

	public String updatedetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String page="/start.jsp";
		String userid = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String pincode = request.getParameter("pincode");
		// you must know service is required cuser object.
		CUser x =new CUser(userid, pwd, email, Integer.parseInt(pincode));
		boolean y = serviceInf.updateUserDetails(x);
		System.out.println("value of y is" + y);
		if(y)
		{
			request.setAttribute("k1","details updated");
		}
		else
		{
			request.setAttribute("k1","details not updated");
		}
		x.setUsername("");
		x.setPassword("");
		x.setPincode(0);
		x.setEmail("");
		request.setAttribute("existingdetails",x );

		
		
		
		
		
		return page;
	}


	public String getusersonpincode(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String page="/start.jsp";
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		List<CUser> users = serviceInf.getUsersBasedOnPincode(pincode);
		if(users.size() ==0)
			request.setAttribute("k1", "no users found in the pincode");
		else
			request.setAttribute("k1", "users found in pincode");
		request.setAttribute("ms", users);
		return page;
	}


	public String adduser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String page="/start.jsp";
		String userid = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String pincode = request.getParameter("pincode");
		// you must know service is required cuser object.
		CUser x =new CUser(userid, pwd, email, Integer.parseInt(pincode));
		boolean y = serviceInf.registerUser(x);
		System.out.println("value of y is" + y);
		if(y)
		{
			request.setAttribute("k1","inserted");
		}
		else
		{
			request.setAttribute("k1","details not added");
		}
		x =new CUser("", "", "", 0);
		
		request.setAttribute("existingdetails",x );
		return page;
		
	}

}
