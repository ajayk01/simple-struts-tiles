import java.sql.*;
public class Login {
private String name,password;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String execute(){
	int f=0;
 try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","");   
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from users where name='"+name+"' and password='"+password+"'");
		rs.last();
		int l = rs.getRow();
//		while(rs.next())  
//			System.out.println(rs.getString(1)+"  "+rs.getString(2));  
		System.out.println(l);
		con.close();  
		if(l==1)
		     f=1;
	}
catch(Exception e)
  {
	 System.out.println(e);
  } 
 if(f==1)
	 return "success";
 else
	 return "error";
}  


}
