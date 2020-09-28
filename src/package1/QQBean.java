package package1;
import java.sql.*;

//该类主要完成对于数据库的查询、插入、修改和删除的操作
import javax.swing.JOptionPane;
public class QQBean
{
	
	//查询功能，可以完成对某表的相应的查询，可以是全部也可以是有约束条件的查询
	public String[][] search(String sql)
	
	{
		int i=0;
		int rows=0;
		String[][] result=null;
	    dataBase db=new dataBase();
		try
		{
		//打开数据库连接	
		db.openConnection();
		
		//执行查询并返回结果集
		ResultSet rs=db.executeQuery(sql);
		
		//将游标移动结果集的最后一条，返回结果的行数
		if(rs.last())	
		     rows=rs.getRow();
		
		 result=new String[rows][8];
		 
		 //需要将游标移到第一条记录的前面的位置，以便于遍历结果集
		 rs.first();
		 rs.previous();
		 
		 //通过循环，将结果集中的数据传输给一个二维数组
		while(rs.next())
		{
			
			result[i][0] = rs.getString("T_ID");
			result[i][1] = rs.getString("Academy");
			result[i][2] = rs.getString("QQ");
			i++;
		 }
		//关闭相应的对象及连接
		  db.closeStatement();
		  db.closeConnection();
		}
		
		catch(SQLException e)
		{
			System.out.print(e.getMessage());
		}
		
		return result;
	}

	public void insert(String sql) {
		dataBase db=new dataBase();
		db.openConnection();
		db.executeUpdate(sql);
		db.closeStatement();
		db.closeConnection();
		
	}
}