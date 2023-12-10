package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;


public class Dbconn {
	    public static	Map<String,Integer> step1 = new HashMap<>();
	    public static	Map<String,Integer> step2 = new HashMap<>();
		public static	Map<String,Integer> step3 = new HashMap<>();
		public static	Map<String,Integer> step4 = new HashMap<>();
		public static	Map<String,Integer> step5 = new HashMap<>();
		public static String Semail="",Gemail="",Uemail="",Dist_email="",Departmentemail="";
		public static String rolls="";
	   public Dbconn() throws SQLException {
        super();
       }

public static Connection conn()throws SQLException,ClassNotFoundException{
	Connection con;
	
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost/22ci1537_allocation_and_tracking_public_funds", "root", "Admin");
	return (con);
}
public static void main(String[] srg)
{
	
	try {
		Random r=new Random();
		Connection con;
		con = Dbconn.conn();
		Statement st=con.createStatement();
		for(int i=1;i<11;i++)
		{
			int max=1234567890;
			int min=1000000001;
			int id=r.nextInt(max - min + 1) + min;
			int max1=99,min1=10;
			int id1=r.nextInt(max1 - min1 + 1) + min1;
			String s=String.valueOf(id)+String.valueOf(id1);
			System.out.println(s);
			st.executeUpdate("insert into tblgov(Adhar_id) values('"+s+"')");
			
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
