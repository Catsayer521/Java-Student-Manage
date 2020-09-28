package package1;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//该类显示查询结果，并且完成添加、修改和删除的功能（依据标志值来完成）
public class selectQQ extends JFrame implements ActionListener
{
	//定义一个字符串数组，用作显示查询结果的表头
	String[] colName = {"编号","学院","学院Q群"};
	//定义一个数据处理类的对象，
	QQBean bean1=new QQBean();
	//生成一个带滚动条的面板，用以显示使用查询结果内容填充的表格
	JScrollPane jScrollPane1,jScrollPane2;
	String sql,T_ID,Academy,QQ;
	
	//定义一个表格对象，用以显示查询结果
	
	JTable table;
	
	//定义四个按钮，分别完成添加、修改、删除和退出的功能
	JButton jButton1=new JButton("添加");
	JButton jButton2=new JButton("修改");
	JButton jButton3=new JButton("删除");
	JButton jButton4=new JButton("退出");
	//JButton jButton1=new JButton("联系方式");
	
	//定义一个标志位，用以控制哪些按钮可以使用
    int status;
    
    //定义一个二维数组，应以存放查询的结果集
    String[][] colValue;
    
    
    //根据不同的标志位，完成不同的相应的功能
	selectQQ(String sql,int status)
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
		 if(status==8)
		 {
			 String[][] colValue1=bean1.search(sql); 
			 colValue=colValue1;	
			 jButton1.setVisible(false);
			 jButton2.setVisible(false);
			 jButton3.setVisible(false);
		 }
		//建立一个表对象，以查询结果集填充的二维数组为内容，以定以后的一维数组为表头
		 table=new JTable(colValue,colName);
		  
		  //获取Id字段的值，作为查询的依据
		 Academy=(String) table.getValueAt(0, 0);
		 QQ=(String) table.getValueAt(0, 0);
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		//如果点击的是“退出”按钮，退出界面
		if(obj==jButton4)
		{
			
			this.dispose();
			
		}
	}
}