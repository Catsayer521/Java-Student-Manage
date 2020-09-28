//package package1;
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent; 
//import java.awt.event.ActionListener;
////import java.awt.image.BufferedImage;
////import java.io.File;
////import java.io.IOException;
//import javax.swing.*;
//public class login extends JFrame implements ActionListener 
//{
//	private JPanel jp=new JPanel();
//	private JLabel[] jlArray={new JLabel("用户名"),
//	new JLabel("密　码"),new JLabel("")};
//	private JButton[] jbArray={new JButton("登录"),
//	new JButton("清空")};
//	private JTextField jtxtName =new JTextField();
//	private JPasswordField jtxtPassword= new JPasswordField();
////	JTextField []t=new JTextField("功能:管理学生信息",12);
//	public login()
//	{
//		jp.setLayout(null);
//		for(int i=0;i<2;i++)
//		{
//			jlArray[i].setBounds(30, 20+i*50, 80, 26);
//			jbArray[i].setBounds(50+i*110, 130, 80,26);
//			jp.add(jlArray[i]);
//			jp.add(jbArray[i]);
//			jbArray[i].addActionListener(this);
//		}
//		jtxtName.setBounds(80,20,180,30);//80,20,180,30
//		jp.add(jtxtName);
//		jtxtName.addActionListener(this);
//		jtxtPassword.setBounds(80,70,180,30);//80,70,180,30
//		jp.add(jtxtPassword);
//		jtxtPassword.setEchoChar('*');
//		jtxtPassword.addActionListener(this);
//		jlArray[2].setBounds(10, 180, 300, 30);
//		jp.add(jlArray[2]);
//		this.add(jp);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setTitle("登录");
//		this.setResizable(false);
//		this.setBounds(300, 300, 300, 250);//修改窗体大小
//		this.setVisible(true);
//		ImageIcon img = new ImageIcon("src/image/Ld.jpg");//这是背景图片    
//		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。    
//		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。     
//		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//设置背景标签的位置    
//		Container cp=this.getContentPane();    
//		cp.setLayout(new BorderLayout());    
//		((JPanel)cp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。  
//	}
//	
//	public void actionPerformed(ActionEvent e)
//	{
//		if(e.getSource()==jtxtName)
//		{
//			jtxtPassword.requestFocus();
//		}
//		else if(e.getSource()==jbArray[1])
//		{
//			jlArray[2].setText("");
//			jtxtName.setText("");
//			jtxtPassword.setText("");
//			jtxtName.requestFocus();
//		}
//		else
//		{
//			if(jtxtName.getText().equals("小明")&&String.valueOf(jtxtPassword.getPassword()).equals("123"))
//			{
//				jlArray[2].setText("登录成功");
//				this.dispose();
//				mainFrame sl = new mainFrame(); 
//				sl.setVisable(true); 
//			}
//			else
//			{
//				jlArray[2].setText("登录错误");
//			}
//		}
//	}
//
//}
package package1;

import java.awt.Font;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.xml.transform.Source;
public class login extends JFrame implements ActionListener
{
      JButton jbLogin,jbExit;//登录，退出按钮
      JLabel a1,a2,a3;//标签
      JTextField b;//文本框
      JPasswordField pw;//密码框
      public login(){
    	  Container con=super.getContentPane();//顶级容器
    	  con.setLayout(null);//空布局
    	  
    	  a1=new JLabel("登录");
    	  a1.setBounds(255,10,100,100);
    	  a1.setFont(new Font("宋体", Font.PLAIN, 16));
    	  
    	  a2=new JLabel("用户名：");
    	  a2.setBounds(100,85,100,60);//设置组件的位置，大小（x,y,width, height）
    	  a2.setFont(new Font("宋体", Font.PLAIN, 16));
    	  b=new JTextField(20);
    	  b.setBounds(180,100,200,30);
    	 // b.setBackground(Color.CYAN);//设置颜色
 
    	  a3=new JLabel("密 码：");
    	  a3.setBounds(100,145,100,60);
    	  a3.setFont(new Font("宋体", Font.PLAIN, 16));
    	  pw=new JPasswordField(20);
    	  pw.setBounds(180,160,200,30);
    	 // pw.setBackground(Color.CYAN);
    	
    	  jbLogin=new JButton("登录");
    	  jbLogin.setBounds(200,250,60,40);
    	  jbLogin.setFont(new Font("宋体", Font.PLAIN, 12));
    	 // jbLogin.setBackground(Color.CYAN);
    	  jbExit=new JButton("退出");
    	  jbExit.setBounds(300,250,60,40);
    	  jbExit.setFont(new Font("宋体", Font.PLAIN, 12));
    	 // jbExit.setBackground(Color.CYAN);
    	  con.add(a1);
    	  con.add(a2);//把组件添加到界面上
    	  con.add(b);
    	  con.add(a3);
    	  con.add(pw);
    	  con.add(jbLogin);
    	  con.add(jbExit);
    	  super.setTitle("登录");
    	  super.setBackground(Color.white);
    	  super.setSize(550, 350);//设置窗口大小
    	  super.setLocation(600,280);
    	  super.setVisible(true);//设置窗口为可见的
    	  super.setResizable(false);
    	  
    	  ImageIcon img = new ImageIcon("src/image/小黄鸭.gif");//这是背景图片
    	  ImageIcon img1=new ImageIcon("src/image/小黄鸭3.gif");
    	  JLabel imgLabel1=new JLabel(img1);
    	  JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
    	  super.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
    	  super.getLayeredPane().add(imgLabel1, new Integer(Integer.MIN_VALUE));
    	  //imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//设置背景标签的位置
    	  imgLabel.setBounds(400,200,img.getIconWidth(), img.getIconHeight());//设置背景标签的位置
    	  imgLabel1.setBounds(20, 200,img.getIconWidth(), img.getIconHeight());
    	  Container cp=super.getContentPane();
    	  cp.setLayout(new BorderLayout());
    	  ((JPanel)cp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
    	  

       	  super.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭按钮 
       	  //ButtonListener this=new ButtonListener();
       	  jbExit.addActionListener( this);//注册监听事件
       	  jbLogin.addActionListener(this);
      }
      
     //main函数      
      public static void main(String [] args)
      {
    	  login mw=new login();
      }
	  public void actionPerformed(ActionEvent e)
	  {
		Object source=e.getSource();
		if(source instanceof JButton )
		{
		    JButton jb=(JButton)source;//按钮
		    String txt=jb.getText();
		    String userName=b.getText();//用户名
		    String password=pw.getText();//密码
		    if(txt.equals("登录"))
		    {
		        if(userName.equals("小明")&&password.equals("123"))
		        {					
			    JOptionPane.showMessageDialog(null, "登录成功!!");//提示
			    this.dispose();
			    setDefaultCloseOperation(EXIT_ON_CLOSE);
				mainFrame sl = new mainFrame(); 
				sl.setVisable(true); 
				setDefaultCloseOperation(EXIT_ON_CLOSE);
		        }
		        else
		        {
			    JOptionPane.showMessageDialog(null, "用户名或密码错误!!");
			}
		    }
		    else if(txt.equals("退出"))
		    {
			System.exit(0);
		    }
		}

	  }
    }
