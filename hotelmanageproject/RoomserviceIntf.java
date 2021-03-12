package hotelmanageproject;

import java.util.List;

public interface RoomserviceIntf {
	
	Outputc addrooms(Rooms r);
	Outputc deleteroom(int roomno);
	Outputc roomSingleSelect(int roomno);
	Outputc roomUpdatebyreceptionist(int roomno,String booking_status, String cleaning_status);
	Outputc roomUpdatebyAdmin(int roomno,int seater);
	List<Rooms> allrooms();
	List <Rooms> allroomsbyBookingS(String booking_status);
	List <Rooms> allroomsbycleaningS(String cleaning_status);
	

}
