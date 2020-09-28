package package1;
import java.sql.*;

//该类主要完成对于数据库的查询、插入、修改和删除的操作
import javax.swing.JOptionPane;
public class StudentBean
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
			
			result[i][0] = rs.getString("ID");
			result[i][1] = rs.getString("Name");
			result[i][2] = rs.getString("Sex");
			result[i][3] = rs.getString("Class");
			result[i][4] = rs.getString("Address");
			result[i][5] = rs.getString("Tele");
			result[i][6] = rs.getString("Nation");
			result[i][7] = rs.getString("Dorm");
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
	
	//删除一条记录
	public void delete(String sql )
	{
		dataBase db=new dataBase();
		db.openConnection();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null,"成功删除一条新的记录！");
		db.closeStatement();
		db.closeConnection();
	}
	
	//修改一条记录
	public void modify(String sql)
	{
		dataBase db=new dataBase();
		db.openConnection();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null,"成功修改一条记录！");
		db.closeStatement();
		db.closeConnection();
	}
	
	
	//插入一条记录
	public void insert(String sql)
	{
		dataBase db=new dataBase();
		db.openConnection();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null,"成功插入一条记录！");
		db.closeStatement();
		db.closeConnection();
	}
	
   

}