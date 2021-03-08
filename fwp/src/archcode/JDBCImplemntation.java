package archcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCImplemntation implements DAOInterface {
	
	private Connection con;
	
	public JDBCImplemntation()
	{
	
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edacsep2020";
		String userid="root";
		String password="root";
		try {
			Class.forName(driverName);
			con =DriverManager.getConnection(url,userid,password);
			//con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
	
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("shortcut is to hell only");
			
			
		}
		
	}
	

	@Override
	public void registerUserInDb(CUser user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		PreparedStatement st=null ;
		String sql ="insert into cuser( username,password,email,pincode) values (?,?,?,?)";
		try {
			 st = con.prepareStatement(sql);
			
			
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setString(3, user.getEmail());
			st.setString(1, user.getUsername());
			st.setString(2,user.getPassword());
			st.setInt(4, user.getPincode());
					
			int ra = st.executeUpdate();//function to issue dml command.
			//whenever constraint is violated you will see that it results in sql exception or its subclasses.
			
			System.out.println("insert suceeded");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DuplicateUserException d =new DuplicateUserException("hey duplicate id");// assumptions
			//are bad we assume all the time. playing with probabities....
			throw d;
			
		}finally
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fate catch hold of exception dont let it escape in finally ");
			}
			
		}
	
		}
		
		
		



	@Override
	public CUser getUserDetailsFromDb(String userid) {
		// TODO Auto-generated method stub
		CUser user =new CUser(userid, "","", 0);
		
		String sql ="select username,password, email, pincode from cuser  where username=?";
		//count the number of ? marks... so many question we have to fill up
		//question makr no is left to right
		
			
		try {
			PreparedStatement st = con.prepareStatement(sql);
						
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setString(1, userid);

					
			ResultSet ra = st.executeQuery();//function to issue dml command.
			//whenever constraint is violated you will see that it results in sql exception or its subclasses.
			if(ra.next())
			{
				String  un= ra.getString("username");
				String pwd = ra.getString("password");
				String email =ra.getString("email");
				int pincode=ra.getInt("pincode");
				user.setUsername(un);
				user.setPassword(pwd);
				user.setEmail(email);
				user.setPincode(pincode);
				
				
				
			}
			
			
			st.close(); //probability of failing is  less. hence no finally block...
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("123");
		}
		
		
		
		return user;
	}

	@Override
	public boolean updateDetailsInDb(CUser user) {
		// TODO Auto-generated method stub
		boolean updated = false;
		
		String sql ="update  cuser set password =?,email=?,pincode=?  where username=?";
		//count the number of ? marks... so many question we have to fill up
		//question makr no is left to right
		
			
		try {
			PreparedStatement st = con.prepareStatement(sql);
						
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setInt(3, user.getPincode());
			st.setString(1,user.getPassword());
			st.setString(2,user.getEmail());
			st.setString(4,user.getUsername());
			
					
			int ra = st.executeUpdate();//function to issue dml command.
			//whenever constraint is violated you will see that it results in sql exception or its subclasses.
			if( ra > 0)
				updated =true;
			else
				System.out.println("update failed where condition was not met");
			
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return updated;
	}

	@Override
	public boolean removeUserInDb(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CUser> getAllUsersFromDBBasedonPincode(int pincode) {
		// TODO Auto-generated method stub
		List<CUser> users =new ArrayList<>();
			
		String sql ="select username,password, email,  pincode from cuser where pincode=?";
		//count the number of ? marks... so many question we have to fill up
		//question makr no is left to right
		
			
		try {
			PreparedStatement st = con.prepareStatement(sql);
						
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setInt(1, pincode);

					
			ResultSet ra = st.executeQuery();//function to issue dml command.
			//whenever constraint is violated you will see that it results in sql exception or its subclasses.
			
			while(ra.next())
			{
				CUser user =new CUser();
				user.setUsername(ra.getString("username"));
				user.setPassword(ra.getString("password"));
				user.setEmail(ra.getString("email"));
				user.setPincode(ra.getInt("pincode"));
				users.add(user) ;//add the object into a list
			}
			
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}



	public void releaseDb() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
