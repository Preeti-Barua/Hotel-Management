package deptpackage;

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
	public void registerUserInDb(Emp user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		PreparedStatement st=null ;
		String sql ="insert into Employee( empno,name,deptid) values (?,?,?)";
		try {
			 st = con.prepareStatement(sql);
			
			
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setString(3, user.getDeptid());
			st.setString(2,user.getName());
			st.setInt(1, user.getEmpno());
					
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
	public Emp getUserDetailsFromDb(int userid) {
		// TODO Auto-generated method stub
		Emp user =new Emp(userid, "","");
		
		String sql ="select empno,name,deptid from Employee  where empno=?";
		//count the number of ? marks... so many question we have to fill up
		//question makr no is left to right
		
			
		try {
			PreparedStatement st = con.prepareStatement(sql);
						
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setInt(1, userid);

					
			ResultSet ra = st.executeQuery();//function to issue dml command.
			//whenever constraint is violated you will see that it results in sql exception or its subclasses.
			if(ra.next())
			{
				String  nm= ra.getString(2);
				String dpt = ra.getString(3);
				int eno=ra.getInt(1);
				user.setName(nm);
				user.setEmpno(eno);
				user.setDeptid(dpt);
				
				
				
			}
			
			
			st.close(); //probability of failing is  less. hence no finally block...
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("123");
		}
		
		
		
		return user;
	}

	@Override
	public boolean updateDetailsInDb(Emp user) {
		// TODO Auto-generated method stub
		boolean updated = false;
		
		String sql ="update  Employee set name =?,deptid=? where empno=?";
		//count the number of ? marks... so many question we have to fill up
		//question makr no is left to right
		
			
		try {
			PreparedStatement st = con.prepareStatement(sql);
						
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setString(2, user.getDeptid());
			st.setString(1,user.getName());
			st.setInt(3, user.getEmpno());
			
					
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
	public boolean removeUserInDb(int empid) {
		boolean deleted = false;
		String sql="delete from Employee where empno=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, empid);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				deleted = true;
			}
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;
	}

	@Override
	public List<Emp> getAllUsersFromDBBasedonDept(String deptid) {
		// TODO Auto-generated method stub
		List<Emp> users =new ArrayList<>();
			
		String sql ="select empno,name,deptid from Employee where deptid=?";
		//count the number of ? marks... so many question we have to fill up
		//question makr no is left to right
		
			
		try {
			PreparedStatement st = con.prepareStatement(sql);
						
			//fillup the question marks .. we need to know what datatype of the column in the table.
			st.setString(1, deptid);

					
			ResultSet ra = st.executeQuery();//function to issue dml command.
			//whenever constraint is violated you will see that it results in sql exception or its subclasses.
			
			while(ra.next())
			{
				Emp user =new Emp(0, "","");
				String  nm= ra.getString(2);
				String dpt = ra.getString(3);
				int eno=ra.getInt(1);
				user.setName(nm);
				user.setEmpno(eno);
				user.setDeptid(dpt);
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
