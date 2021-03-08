package deptpackage;

import java.util.List;

public interface ServiceInf {

	boolean registerUser(Emp user);

	Emp getUserDetails(int empid);

	boolean updateUserDetails(Emp user);

	boolean removeUser(int empid);

	List<Emp> getUsersBasedOnDept(String deptid);

}
