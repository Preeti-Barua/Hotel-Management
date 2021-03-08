package archcode;

import java.util.List;

public interface ServiceInf {

	boolean registerUser(CUser user);

	CUser getUserDetails(String userid);

	boolean updateUserDetails(CUser user);

	boolean removeUser(String userid);

	List<CUser> getUsersBasedOnPincode(int pincode);

}
