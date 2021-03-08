package deptpackage;

import java.util.List;

public interface DAOInterface {

	void registerUserInDb(Emp user) throws DuplicateUserException;

	Emp getUserDetailsFromDb(int empid);

	boolean updateDetailsInDb(Emp user);

	boolean removeUserInDb(int empid);

	List<Emp> getAllUsersFromDBBasedonDept(String deptid);

}
