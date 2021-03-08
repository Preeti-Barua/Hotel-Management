package abc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import deptpackage.ServiceImplementation;
import deptpackage.ServiceInf;
import deptpackage.Emp;

public class EmpController {
	
	private ServiceInf serviceInf;
	
	public EmpController()
	{
		serviceInf = new ServiceImplementation();
	}
	public String insert(HttpServletRequest request)
	{
		String page="/emp1.jsp";
		int empid =(Integer.parseInt(request.getParameter("uno")));
		String name = request.getParameter("uname");
		String dep = request.getParameter("dept");
		// you must know service is required cuser object.
		Emp x =new Emp(empid, name, dep);
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
		x =new Emp(0, "", "");
		
		request.setAttribute("details",x );
		return page;
		
	}

	public String update(HttpServletRequest request) {
		String page="/emp1.jsp";
		int empid =(Integer.parseInt(request.getParameter("uno")));
		String name = request.getParameter("uname");
		String dep = request.getParameter("dept");
		// you must know service is required cuser object.
		Emp x =new Emp(empid, name, dep);
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
		x.setName("");
		x.setDeptid("");
		x.setEmpno(0);
		request.setAttribute("details",x );
		
		return page;
		
	}

	public String multiSel(HttpServletRequest request) {
		String page="/emp1.jsp";
		String dept = request.getParameter("dept");
		List<Emp> users = serviceInf.getUsersBasedOnDept(dept);
		if(users.size() ==0)
			request.setAttribute("k1", "no users found in the dept");
		else
			request.setAttribute("k1", "users found in dept");
		request.setAttribute("ms", users);
		return page;
	}

	public String remove(HttpServletRequest request) {
		String page="/emp1.jsp";
		int empid=Integer.parseInt(request.getParameter("uno"));
		boolean i=serviceInf.removeUser(empid);
		if(i)
		{
			request.setAttribute("k1", "deleted");
		}
		else
		{
			request.setAttribute("k1", "could not delete");
		}
		
		return page;
	}
	
	public String getdetails(HttpServletRequest request) {
		String page="/emp1.jsp";
		request.setAttribute("k1","ok one day i have to do select here");
		int empid =(Integer.parseInt(request.getParameter("uno")));
		Emp user = serviceInf.getUserDetails(empid);
		if(user.getName() =="")
		{
			request.setAttribute("k1", "user details not found");
			
		}
		else
		{
			request.setAttribute("k1", "user details found");
			request.setAttribute("details", user);
		}
		// TODO Auto-generated method stub
		return page;
	}

}
