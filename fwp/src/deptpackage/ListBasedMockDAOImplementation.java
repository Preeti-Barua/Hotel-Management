package deptpackage;

import java.util.ArrayList;
import java.util.List;

public class ListBasedMockDAOImplementation implements DAOInterface {
	
	private List<Emp> users ;
	
	public ListBasedMockDAOImplementation()
	{
		
		users=new ArrayList<>();
		users.add(new Emp(1,"A","d1"));
		users.add(new Emp(2,"B","d2"));
		users.add(new Emp(3,"C","d1"));
		
	}

	@Override
	public void registerUserInDb(Emp user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		int position = users.indexOf(user);
		if (position != -1)
		{  
			throw new DuplicateUserException("duplicate User found");
			
		}
		users.add(user);
		
	}

	@Override
	public Emp getUserDetailsFromDb(int userid) {
		// TODO Auto-generated method stub
		
		Emp userToFind = new Emp(userid,"","");//think why we did not pass other parameters.
		int pos = users.indexOf(userToFind);
		if(pos != -1)
		{
			userToFind = users.get(pos);
			
		}
//		System.out.println(userToFind.name+" "+pos);
//		System.out.println(userToFind.deptid);
		return userToFind;
	}

	@Override
	public boolean updateDetailsInDb(Emp user) {
		// TODO Auto-generated method stub
		
		boolean updatedStatus = false;
		int pos = users.indexOf(user);
		System.out.println(pos+" "+user.getEmpno());
		if(pos != -1)
		{
			//think why are we doing this.
			Emp userFromList = users.get(pos);
			userFromList.setName(user.getName());
			userFromList.setDeptid(user.getDeptid());
			updatedStatus = true;
				System.out.println(user.getName());
		}
//		System.out.println("mm"+user.getName());
		return updatedStatus;
	}

	@Override
	public boolean removeUserInDb(int empid) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Emp userToFind = new Emp(empid,"","");//think why we did not pass other parameters.
		int pos = users.indexOf(userToFind);
		if(pos != -1)
		{
			users.remove(pos);
			deleted  =true;
			
		}
		return deleted;
	}

	@Override
	public List<Emp> getAllUsersFromDBBasedonDept(String deptid) {
		// TODO Auto-generated method stub
		List<Emp> cusers =new ArrayList<Emp>(); //if i change the refernce to users what will happen think
		for(Emp user: users)
		{
			if(user.getDeptid().equals(deptid)) //think why == was used and not .equals.
			{
				cusers.add(user);
			}
			
		}
		return cusers;
	}
	
	
	

}
