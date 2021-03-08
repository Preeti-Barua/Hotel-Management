package deptpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBasedMockDAOImplementation implements DAOInterface {
	
	private Map<Integer,Emp> users ;
	
	public MapBasedMockDAOImplementation()
	{
		
		users=new HashMap<>();
		Emp user =new Emp(1,"A","d1");
		users.put(user.getEmpno(), user);
		user =new Emp(2,"B","d2"); //why are we writing user = and not Cuser user = ?
		users.put(user.getEmpno(), user);
		user =new Emp(3,"C","d1");		
		users.put(user.getEmpno(), user);
		
		
		
	}

	@Override
	public void registerUserInDb(Emp user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		Emp u = users.get(user.getEmpno());
		if (u != null)//if key is present, that means it is a duplicate userid.
		{  
			throw new DuplicateUserException("duplicate User found");
			
		}
		users.put(user.getEmpno(),user);
		
		
	}

	@Override
	public Emp getUserDetailsFromDb(int userid) {
		// TODO Auto-generated method stub
		
		Emp userToFind = null;//think why we did not pass other parameters.
		userToFind = users.get(userid);
		if (userToFind == null)
		{  
			userToFind = new Emp(userid,"","");
		}
//		System.out.println(userToFind.deptid);
		return userToFind;
	}
	
	
	
	
	

	@Override
	public boolean updateDetailsInDb(Emp user) {
		// TODO Auto-generated method stub
		
		boolean updatedStatus = false;
		Emp cUser = users.get(user.getEmpno()); //think why we created a new reference cUser here
		//and not used user = users.get(user.getUsername()
		
		if(cUser != null)
		{
//			think why are we doing this.
			cUser.setName(user.getName());
			cUser.setDeptid(user.getDeptid());
			updatedStatus = true;
			System.out.println("****$"+cUser.getDeptid());
		}
		System.out.println("****"+cUser.getDeptid());
		return updatedStatus;
	}



	@Override
	public List<Emp> getAllUsersFromDBBasedonDept(String deptid) {
		// TODO Auto-generated method stub
		List<Emp> cusers = new ArrayList<>();
		for(Emp user: users.values())  //find out what is return type of user.values functions
		{
			if(user.getDeptid().equals(deptid)) //think why == was used and not .equals.
			{
				cusers.add(user);
				System.out.println("$$"+user.getDeptid());
			}
			
		}
		
		return cusers;
	}

	@Override
	public boolean removeUserInDb(int empid) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Emp cUser = users.remove(empid); //think why we created a new reference cUser here
		//and not used user = users.get(user.getUsername()
		
		if(cUser != null)
		{
				deleted = true;
				System.out.println("$$");
		}
		return deleted;
		
	}
	
	
	

}
