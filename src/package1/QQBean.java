package package1;
import java.sql.*;

//������Ҫ��ɶ������ݿ�Ĳ�ѯ�����롢�޸ĺ�ɾ���Ĳ���
import javax.swing.JOptionPane;
public class QQBean
{
	
	//��ѯ���ܣ�������ɶ�ĳ�����Ӧ�Ĳ�ѯ��������ȫ��Ҳ��������Լ�������Ĳ�ѯ
	public String[][] search(String sql)
	
	{
		int i=0;
		int rows=0;
		String[][] result=null;
	    dataBase db=new dataBase();
		try
		{
		//�����ݿ�����	
		db.openConnection();
		
		//ִ�в�ѯ�����ؽ����
		ResultSet rs=db.executeQuery(sql);
		
		//���α��ƶ�����������һ�������ؽ��������
		if(rs.last())	
		     rows=rs.getRow();
		
		 result=new String[rows][8];
		 
		 //��Ҫ���α��Ƶ���һ����¼��ǰ���λ�ã��Ա��ڱ��������
		 rs.first();
		 rs.previous();
		 
		 //ͨ��ѭ������������е����ݴ����һ����ά����
		while(rs.next())
		{
			
			result[i][0] = rs.getString("T_ID");
			result[i][1] = rs.getString("Academy");
			result[i][2] = rs.getString("QQ");
			i++;
		 }
		//�ر���Ӧ�Ķ�������
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