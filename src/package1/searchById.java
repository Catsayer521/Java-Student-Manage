package package1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//该类完成按照编号进行查询，并将标志值status向select对象传递
public class searchById extends JFrame implements ActionListener
{
	
	//定义要显示的标题的内容
	String[] colName = {"学号","姓名","性别","班级","地址","电话号码","民族","宿舍"};
	
	StudentBean bean=new StudentBean();
	
	JScrollPane jScrollPane1;
	//定义用于提示查询的标签
	JLabel jLabel1=new JLabel();
	
	//输入编号的文本框
	JTextField jText1=new JTextField(4);
	//确定按钮
	JButton jButton1=new JButton();
	
	//获取窗体本身带的内容面板
	Container pane=this.getContentPane();
	
	//定义状态的初始值
	int status=1;
	searchById(int status)
	{
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
		//设置窗体的标题
		this.setTitle("按照学号查询");
		this.setBounds(500, 400, 300, 100);
		
		//设置内容面板的不拘格式
	    pane.setLayout(new FlowLayout());
	    
	    //设置标签的提示内容
	    jLabel1.setText("请输入要查询的学号:");
	    
	    //将文本框的内容设置为空
	    jText1.setText(null);
	    
	    //设定按钮的显示内容
	    jButton1.setText("确定");
	    //将标签、文本框和按钮放入内容面板
	    pane.add(jLabel1);
	    pane.add(jText1);
	    pane.add(jButton1);   
	    
	    //窗体向按钮注册监听
		jButton1.addActionListener(this);
	    this.setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		//按照学好查询，并将标志值status向select对象传递
		String sql="select * from Student  where ID="+jText1.getText();
		select selectById= new select(sql,status);
		this.dispose();
		 
	}

}
