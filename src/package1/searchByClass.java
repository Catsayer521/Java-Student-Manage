package package1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class searchByClass extends JFrame implements ActionListener
{
	String[] colName = {"学号","姓名","性别","班级","地址","电话号码","民族","宿舍"};
	int status=6;
	searchByClass(int status)
	{
		this.status=status;
		  try
		  {
			    String sql="select * from Student  where Class like	'17%'";
				select selectByClass= new select(sql,status);
				this.dispose();
			  
		  }
		  catch(Exception e)
		  {
			  System.out.print(e.getMessage());
		  }
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
