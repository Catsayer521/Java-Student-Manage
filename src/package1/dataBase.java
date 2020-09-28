package package1;
import java.sql.*;

//该类主要功能是连接数据库、执行查询、更新、删除和插入，并在完成相应操作后关闭statement对象以及数据库连接
public class dataBase 
{
	 //定义连接数据库需要的对象以及返回的查询结果集
	private Connection conn=null; 
	 private Statement stmt=null;
	  ResultSet rs=null;
	  String sql;
	  String strurl="jdbc:odbc:Student";
	  
	  
	  //建立数据库连接
	  public void openConnection()
	  {
		  try
		  {
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			  conn=DriverManager.getConnection(strurl); 
		  }	
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
	  }
	  
	  
	  //执行查询，返回结果集
	  
	  public ResultSet executeQuery(String sql)
	    {
		  rs=null;
		  stmt=null;
		
		  try { 
		 
		       stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		       rs=stmt.executeQuery(sql);
		      }
		 catch(SQLException e)
		     {
			  System.out.print(e.getMessage().toString());
		     }
		  
			 return rs;
	      }
	  
	//执行更新，此函数可以执行更改、删除、插入的功能，取决于sql字符串
	  public void executeUpdate(String sql)
	  {
		  stmt=null;
		  
		  try
		  {
			  stmt=conn.createStatement();
			  stmt.executeUpdate(sql);  		  
		  }
		  
		  catch(SQLException e)
		     {
			  System.out.print(e.getMessage().toString());
		     }

	     }
	  
	  //关闭statement对象
	  public void closeStatement()
	  {
		  try
		  {
			  stmt.close();
		  }
		  catch(SQLException e)
		     {
			  System.out.print(e.getMessage().toString());
		     }
	  }
	  
	  
	  //关闭数据库连接
	  public void closeConnection()
	  {
		  try
		  {
			  conn.close();
		  }
		  catch(SQLException e)
		     {
			  System.out.print(e.getMessage().toString());
		     }
	  }
	  
	

}
