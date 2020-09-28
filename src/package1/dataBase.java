package package1;
import java.sql.*;

//������Ҫ�������������ݿ⡢ִ�в�ѯ�����¡�ɾ���Ͳ��룬���������Ӧ������ر�statement�����Լ����ݿ�����
public class dataBase 
{
	 //�����������ݿ���Ҫ�Ķ����Լ����صĲ�ѯ�����
	private Connection conn=null; 
	 private Statement stmt=null;
	  ResultSet rs=null;
	  String sql;
	  String strurl="jdbc:odbc:Student";
	  
	  
	  //�������ݿ�����
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
	  
	  
	  //ִ�в�ѯ�����ؽ����
	  
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
	  
	//ִ�и��£��˺�������ִ�и��ġ�ɾ��������Ĺ��ܣ�ȡ����sql�ַ���
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
	  
	  //�ر�statement����
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
	  
	  
	  //�ر����ݿ�����
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
