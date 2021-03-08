package deptpackage;

import java.util.List;

public class ServiceImplementation implements ServiceInf {
	
	private DAOInterface daoInterface;
	
	

	public ServiceImplementation() {
		// TODO Auto-generated constructor stub
//		daoInterface = new ListBasedMockDAOImplementation();
		
//		daoInterface = new MapBasedMockDAOImplementation();

		daoInterface = new JDBCImplemntation();
		
	}



	@Override
	public boolean registerUser(Emp user) {
		// TODO Auto-generated method stub
		
		boolean insertStatus = false;		
		try {
			daoInterface.registerUserInDb(user);
			insertStatus=true;
		} catch (DuplicateUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertStatus;
	}



	@Override
	public Emp getUserDetails(int empid) {
		// TODO Auto-generated method stub
		Emp user = daoInterface.getUserDetailsFromDb(empid);
		return user;
	}



	@Override
	public boolean updateUserDetails(Emp user) {
		// TODO Auto-generated method stub
		return daoInterface.updateDetailsInDb(user);
	}



	@Override
	public boolean removeUser(int empid) {
		// TODO Auto-generated method stub
		return daoInterface.removeUserInDb(empid);
	}



	@Override
	public List<Emp> getUsersBasedOnDept(String deptid) {
		// TODO Auto-generated method stub
		return daoInterface.getAllUsersFromDBBasedonDept(deptid);
	}



}
