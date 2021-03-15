package hotelmanageproject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rooms {
	@Id
 private int roomno;
 public Rooms(int roomno, int seater, String booking_status, String cleaning_status) {
		super();
		this.roomno = roomno;
		this.seater = seater;
		this.booking_status = booking_status;
		this.cleaning_status = cleaning_status;
	}
private int seater;
 private String booking_status;
 private String cleaning_status;
 
public Rooms() {
	
	// TODO Auto-generated constructor stub
}
public int getRoomno() {
	return roomno;
}
public void setRoomno(int roomno) {
	this.roomno = roomno;
}
@Override
public String toString() {
	return "Rooms [roomno=" + roomno + ", seater=" + seater + ", booking_status=" + booking_status
			+ ", cleaning_status=" + cleaning_status + "]";
}
public int getSeater() {
	return seater;
}
public void setSeater(int seater) {
	this.seater = seater;
}
public String getBooking_status() {
	return booking_status;
}
public void setBooking_status(String booking_status) {
	this.booking_status = booking_status;
}
public String getCleaning_status() {
	return cleaning_status;
}
public void setCleaning_status(String cleaning_status) {
	this.cleaning_status = cleaning_status;
}
 
 
}
