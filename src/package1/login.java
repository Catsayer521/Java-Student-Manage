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
//	private JLabel[] jlArray={new JLabel("�û���"),
//	new JLabel("�ܡ���"),new JLabel("")};
//	private JButton[] jbArray={new JButton("��¼"),
//	new JButton("���")};
//	private JTextField jtxtName =new JTextField();
//	private JPasswordField jtxtPassword= new JPasswordField();
////	JTextField []t=new JTextField("����:����ѧ����Ϣ",12);
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
//		this.setTitle("��¼");
//		this.setResizable(false);
//		this.setBounds(300, 300, 300, 250);//�޸Ĵ����С
//		this.setVisible(true);
//		ImageIcon img = new ImageIcon("src/image/Ld.jpg");//���Ǳ���ͼƬ    
//		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�    
//		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����     
//		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//���ñ�����ǩ��λ��    
//		Container cp=this.getContentPane();    
//		cp.setLayout(new BorderLayout());    
//		((JPanel)cp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������  
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
//			if(jtxtName.getText().equals("С��")&&String.valueOf(jtxtPassword.getPassword()).equals("123"))
//			{
//				jlArray[2].setText("��¼�ɹ�");
//				this.dispose();
//				mainFrame sl = new mainFrame(); 
//				sl.setVisable(true); 
//			}
//			else
//			{
//				jlArray[2].setText("��¼����");
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
      JButton jbLogin,jbExit;//��¼���˳���ť
      JLabel a1,a2,a3;//��ǩ
      JTextField b;//�ı���
      JPasswordField pw;//�����
      public login(){
    	  Container con=super.getContentPane();//��������
    	  con.setLayout(null);//�ղ���
    	  
    	  a1=new JLabel("��¼");
    	  a1.setBounds(255,10,100,100);
    	  a1.setFont(new Font("����", Font.PLAIN, 16));
    	  
    	  a2=new JLabel("�û�����");
    	  a2.setBounds(100,85,100,60);//���������λ�ã���С��x,y,width, height��
    	  a2.setFont(new Font("����", Font.PLAIN, 16));
    	  b=new JTextField(20);
    	  b.setBounds(180,100,200,30);
    	 // b.setBackground(Color.CYAN);//������ɫ
 
    	  a3=new JLabel("�� �룺");
    	  a3.setBounds(100,145,100,60);
    	  a3.setFont(new Font("����", Font.PLAIN, 16));
    	  pw=new JPasswordField(20);
    	  pw.setBounds(180,160,200,30);
    	 // pw.setBackground(Color.CYAN);
    	
    	  jbLogin=new JButton("��¼");
    	  jbLogin.setBounds(200,250,60,40);
    	  jbLogin.setFont(new Font("����", Font.PLAIN, 12));
    	 // jbLogin.setBackground(Color.CYAN);
    	  jbExit=new JButton("�˳�");
    	  jbExit.setBounds(300,250,60,40);
    	  jbExit.setFont(new Font("����", Font.PLAIN, 12));
    	 // jbExit.setBackground(Color.CYAN);
    	  con.add(a1);
    	  con.add(a2);//�������ӵ�������
    	  con.add(b);
    	  con.add(a3);
    	  con.add(pw);
    	  con.add(jbLogin);
    	  con.add(jbExit);
    	  super.setTitle("��¼");
    	  super.setBackground(Color.white);
    	  super.setSize(550, 350);//���ô��ڴ�С
    	  super.setLocation(600,280);
    	  super.setVisible(true);//���ô���Ϊ�ɼ���
    	  super.setResizable(false);
    	  
    	  ImageIcon img = new ImageIcon("src/image/С��Ѽ.gif");//���Ǳ���ͼƬ
    	  ImageIcon img1=new ImageIcon("src/image/С��Ѽ3.gif");
    	  JLabel imgLabel1=new JLabel(img1);
    	  JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
    	  super.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
    	  super.getLayeredPane().add(imgLabel1, new Integer(Integer.MIN_VALUE));
    	  //imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//���ñ�����ǩ��λ��
    	  imgLabel.setBounds(400,200,img.getIconWidth(), img.getIconHeight());//���ñ�����ǩ��λ��
    	  imgLabel1.setBounds(20, 200,img.getIconWidth(), img.getIconHeight());
    	  Container cp=super.getContentPane();
    	  cp.setLayout(new BorderLayout());
    	  ((JPanel)cp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������
    	  

       	  super.setDefaultCloseOperation(EXIT_ON_CLOSE);//�رհ�ť 
       	  //ButtonListener this=new ButtonListener();
       	  jbExit.addActionListener( this);//ע������¼�
       	  jbLogin.addActionListener(this);
      }
      
     //main����      
      public static void main(String [] args)
      {
    	  login mw=new login();
      }
	  public void actionPerformed(ActionEvent e)
	  {
		Object source=e.getSource();
		if(source instanceof JButton )
		{
		    JButton jb=(JButton)source;//��ť
		    String txt=jb.getText();
		    String userName=b.getText();//�û���
		    String password=pw.getText();//����
		    if(txt.equals("��¼"))
		    {
		        if(userName.equals("С��")&&password.equals("123"))
		        {					
			    JOptionPane.showMessageDialog(null, "��¼�ɹ�!!");//��ʾ
			    this.dispose();
			    setDefaultCloseOperation(EXIT_ON_CLOSE);
				mainFrame sl = new mainFrame(); 
				sl.setVisable(true); 
				setDefaultCloseOperation(EXIT_ON_CLOSE);
		        }
		        else
		        {
			    JOptionPane.showMessageDialog(null, "�û������������!!");
			}
		    }
		    else if(txt.equals("�˳�"))
		    {
			System.exit(0);
		    }
		}

	  }
    }
