package package1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class searchAddress extends JFrame implements ActionListener
{
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
	int status=5;
	searchAddress(int status)
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
		//设置窗体
		this.setTitle("按照地址查询");
		this.setBounds(500,400,300,100);
		//设置内容板的不拘格式
		pane.setLayout(new FlowLayout());
		jLabel1.setText("请输入要查询的地址");
		//将文本框的内容设置为空
	    jText1.setText(null);
	    //设定按钮的显示内容
	    jButton1.setText("确定");
	    //将内容，按钮放入内容板
	    pane.add(jLabel1);
	    pane.add(jText1);
	    pane.add(jButton1);
	  //窗体向按钮注册监听
		jButton1.addActionListener(this);
	    this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String sql="select * from Student  where Address ='"+jText1.getText()+"'";
		select selectByAddress= new select(sql,status);
		this.dispose();
	}
	
}
