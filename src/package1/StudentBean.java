package package1;
import java.sql.*;

//������Ҫ��ɶ������ݿ�Ĳ�ѯ�����롢�޸ĺ�ɾ���Ĳ���
import javax.swing.JOptionPane;
public class StudentBean
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
	
	//ɾ��һ����¼
	public void delete(String sql )
	{
		dataBase db=new dataBase();
		db.openConnection();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null,"�ɹ�ɾ��һ���µļ�¼��");
		db.closeStatement();
		db.closeConnection();
	}
	
	//�޸�һ����¼
	public void modify(String sql)
	{
		dataBase db=new dataBase();
		db.openConnection();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null,"�ɹ��޸�һ����¼��");
		db.closeStatement();
		db.closeConnection();
	}
	
	
	//����һ����¼
	public void insert(String sql)
	{
		dataBase db=new dataBase();
		db.openConnection();
		db.executeUpdate(sql);
		JOptionPane.showMessageDialog(null,"�ɹ�����һ����¼��");
		db.closeStatement();
		db.closeConnection();
	}
	
   

}