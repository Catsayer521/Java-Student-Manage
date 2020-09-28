package package1;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//该类显示查询结果，并且完成添加、修改和删除的功能（依据标志值来完成）
public class select extends JFrame implements ActionListener
{
	//定义一个字符串数组，用作显示查询结果的表头
	String[] colName = {"学号","姓名","性别","班级","地址","电话号码","民族","宿舍"};
	
	//定义一个数据处理类的对象，
	StudentBean bean=new StudentBean();
	
	//生成一个带滚动条的面板，用以显示使用查询结果内容填充的表格
	JScrollPane jScrollPane1,jScrollPane2;
	String sql,ID,Address;
	
	//定义一个表格对象，用以显示查询结果
	
	JTable table;
	
	//定义四个按钮，分别完成添加、修改、删除和退出的功能
	JButton jButton1=new JButton("添加");
	JButton jButton2=new JButton("修改");
	JButton jButton3=new JButton("删除");
	JButton jButton4=new JButton("退出");
	
	//定义一个标志位，用以控制哪些按钮可以使用
    int status;
    
    //定义一个二维数组，应以存放查询的结果集
    String[][] colValue;
    
    
    //根据不同的标志位，完成不同的相应的功能
	select(String sql,int status)
	{
		this.sql=sql;
		this.status=status;
	  try{
		  
		  init();
		  
		  
	      }
	  catch(Exception e)
	     {
		  System.out.print(e.getMessage());
	     }
	}
	
	
	void init()
	{
		
		 
		 //为“1”时只执行查询，可以是查询全部或者是按照编号查询，四个按钮只显示“退出”按钮，其余屏蔽掉
		 if (status==1)
		 {
			 String[][] colValue1=bean.search(sql); 
			colValue=colValue1;
			jButton1.setVisible(false);
			jButton2.setVisible(false);
			jButton3.setVisible(false);
		 }
		 
		 //为“2”时，完成添加的功能
		 else if(status==2)
		 {
			 String[][] colValue2={{"0","0","0","0","0","0","0","0"}};
			 colValue=colValue2;
			 jButton2.setVisible(false);
			 jButton3.setVisible(false);
			 
		 }
		 
		 //为“3”时，完成修改的功能
		 else if(status==3)
		 {
			    String[][] colValue1=bean.search(sql); 
				colValue=colValue1;
				jButton1.setVisible(false);
				jButton2.setVisible(true);
				jButton3.setVisible(false);
		 }
		 
		 
		 //为“4”时，完成删除的功能
		 else if(status==4)
		 {
			    String[][] colValue1=bean.search(sql); 
				colValue=colValue1;
				jButton1.setVisible(false);
				jButton2.setVisible(false);
				jButton3.setVisible(true);
		 }
		 else if(status==5)
		 {
			 String[][] colValue1=bean.search(sql);
			 colValue=colValue1;
			 jButton1.setVisible(false);
			 jButton2.setVisible(false);
			 jButton3.setVisible(false);
		 }
		 else if(status==6)
		 {
			 String[][] colValue1=bean.search(sql);
			 colValue=colValue1;
			 jButton1.setVisible(false);
			 jButton2.setVisible(false);
			 jButton3.setVisible(false);
		 }
		 //建立一个表对象，以查询结果集填充的二维数组为内容，以定以后的一维数组为表头
		 table=new JTable(colValue,colName);
		  
		  //获取Id字段的值，作为查询的依据
	      ID=(String) table.getValueAt(0, 0);
	      //将表放到面板中显示
		 jScrollPane1=new JScrollPane(table);
	    //将面板放到窗体的中心位置
	      this.add(jScrollPane1,BorderLayout.CENTER);
	      
	      //重新显示窗体及内部组件大小
	      this.pack();
	      
	      this.setLocation(450, 200);
	      
	      //定义一个面板对象，存放四个按钮
	      JPanel jPan1=new JPanel();
	      
	      //设置面板的布局格式为流式布局
	      jPan1.setLayout(new FlowLayout());
	      
	      //将四个按钮放到面板中
	      jPan1.add(jButton1);
	      jPan1.add(jButton2);
	      jPan1.add(jButton3);
	      jPan1.add(jButton4);
	      
	      //将窗体向四个按钮注册监听
	      jButton1.addActionListener(this);
	      jButton2.addActionListener(this);
	      jButton3.addActionListener(this);
	      jButton4.addActionListener(this);
	      jPan1.setVisible(true);
	      
	      //将面板放到窗体的下面位置
	      this.add(jPan1,BorderLayout.SOUTH);
	      this.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Object obj = e.getSource();
		
		//如果点击的是“退出”按钮，退出界面
		if(obj==jButton4)
		{
			
			this.dispose();
			
		}
		
		//如果点击“删除”按钮，先进行按编号查询，然后再删除
		else if(obj==jButton3)
		{
			sql="delete from Student where ID="+ID;
			StudentBean bean=new StudentBean();
			
			this.dispose();
			bean.delete(sql);
			
		}
		
		//点击“修改”按钮，完成修改功能
		else if(obj==jButton2)	
		{
			//设定当表格内容发生修改后，可以获取修改后的内容
			table.getCellEditor().stopCellEditing();
			
			//获取表格中修改后的内容
			String Name= (String) table.getValueAt(0, 1);
			String Sex= (String) table.getValueAt(0, 2);
			String Class= (String) table.getValueAt(0, 3);
			String Address= (String) table.getValueAt(0, 4);
			String Tele= (String) table.getValueAt(0, 5);
			String Nation= (String) table.getValueAt(0, 6);
			String Dorm= (String) table.getValueAt(0, 7);
			
			//执行修改
			sql="update Student set Name='"+Name+"',Sex='"+Sex+"',Class = '" +Class+"',Address = '" +Address+"',Tele = '"+Tele+"',Nation ='" +Nation+"',Dorm='"+Dorm+"' where ID="+ID;
			StudentBean bean=new StudentBean();
			bean.modify(sql);
			this.dispose();	
		}
		 
		//点击“添加”按钮，完成添加功能
		else if(obj==jButton1)	
		{
			table.getCellEditor().stopCellEditing();
			String ID= (String) table.getValueAt(0, 0);
			String Name= (String) table.getValueAt(0, 1);
			String Sex= (String) table.getValueAt(0, 2);
			String Class= (String) table.getValueAt(0, 3);
			String Address= (String) table.getValueAt(0, 4);
			String Tele= (String) table.getValueAt(0, 5);
			String Nation= (String) table.getValueAt(0, 6);
			String Dorm= (String) table.getValueAt(0, 7);
			
			sql = "insert into Student(ID,Name,Sex,Class,Address,Tele,Nation,Dorm) values ('"+ID+"','"+Name+"','"+Sex+"','"+Class+"','"+Address+"','"+Tele+"','"+Nation+"','"+Dorm+"')";
			
			
			
			StudentBean bean=new StudentBean();
			bean.insert(sql);
			this.dispose();	
		}
		 
		
	}
}