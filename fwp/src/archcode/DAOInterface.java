package archcode;

import java.util.List;

public interface DAOInterface {

	void registerUserInDb(CUser user) throws DuplicateUserException;

	CUser getUserDetailsFromDb(String userid);

	boolean updateDetailsInDb(CUser user);

	boolean removeUserInDb(String userid);

	List<CUser> getAllUsersFromDBBasedonPincode(int pincode);

}
