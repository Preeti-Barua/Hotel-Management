package hotelmanageproject;

import java.util.List;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Roomscontroller {
	@Autowired
	private RoomserviceIntf s;
	
	@PostMapping("/add")
	public Outputc addrooms(@RequestBody Rooms r) throws JsonParseException 
	
	{ 
		System.out.println("insert is" + r);
		Outputc o= s.addrooms(r);
	return o; 	
	}
	
	@PostMapping("/ss")
	public Outputc singleselect(@RequestParam int roomno)
	{
		Outputc o= s.roomSingleSelect(roomno);
		return o;
	}

	@PostMapping("/d")
	public Outputc deletebyroomno(int roomno)
	{
		Outputc o= s.deleteroom(roomno);
		
		return o;
	}
	
	@PostMapping("/ur")
	public Outputc roomUpdatebyreceptionist(int roomno, String booking_status, String cleaning_status)
	{
		Outputc o= s.roomUpdatebyreceptionist(roomno, booking_status, cleaning_status);
		
		return o;
	}
	
	@PostMapping("/ua")
	public Outputc roomUpdatebyAdmin(int roomno, int seater)
	{
		Outputc o= s.roomUpdatebyAdmin(roomno, seater);
		
		return o;
	}
	
	@PostMapping("/all")
	public List<Rooms> allrooms()
	{
		List<Rooms> l= s.allrooms();
		
		return l;
	}
	
	@PostMapping("/allRB")
	public List<Rooms> allroomsbyBookingS(String booking_status)
	{
		List<Rooms> l= s.allroomsbyBookingS(booking_status);
		
		return l;
	}
	
	@PostMapping("/allRC")
	public List<Rooms> allroomsbycleaningS(String cleaning_status)
	{
		List<Rooms> l= s.allroomsbycleaningS(cleaning_status);
		
		return l;
	}
	
	
	
	
}
