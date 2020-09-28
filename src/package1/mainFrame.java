package package1;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//该类主要是程序的主界面，里面有一个窗体和一个菜单工具条以及相应的菜单项
public class mainFrame extends JFrame implements ActionListener
{
	
	
	//设置窗口的菜单条，所有的菜单都要放到这上面
	static	JMenuBar  bar=new JMenuBar();
		
		//创建“学生管理”菜单组	
	static	JMenu manage=new JMenu("学生管理");
	static	JMenuItem add=new JMenuItem("添加");
	static	JMenuItem modify=new JMenuItem("修改");
	static	JMenuItem delete=new JMenuItem("删除");
		
		
		
		//创建“信息查询”菜单组
	static	JMenu search=new JMenu("信息查询");
	static	JMenuItem all=new JMenuItem("查询所有");
	static	JMenuItem byId=new JMenuItem("按学号查询");
	static  JMenuItem ByAddress=new JMenuItem("按地址查询");
	static  JMenuItem ByClass=new  JMenuItem("查询17级信息");
	//创建“鲁大校历”菜单组
	static JMenu LD=new JMenu("鲁大校历");
	static JMenuItem calendar=new JMenuItem("校历");
	static JMenuItem time=new JMenuItem("授课时间表");
	//创建“校园留言箱”菜单组
	static  JMenu School=new JMenu("校园留言箱");
	static  JMenuItem note=new JMenuItem("留言");
	//创建“校园通信录”菜单组
	static  JMenu tele=new JMenu("校园通信录");
	static  JMenuItem tel=new JMenuItem("联系方式");
	static  JMenuItem qq=new JMenuItem("学院Q群");
		//创建“系统”菜单组
	static	JMenu system=new JMenu("系统");
	static	JMenuItem exit=new JMenuItem("退出");
		

		
	
	//主函数，所有程序的入口
	public static void main(String[] args)
	{
		new login();	
	}	
	
	//选择相应的菜单项的事件处理
	public void actionPerformed(ActionEvent e) 
	{
		Object obj=e.getSource();
		
		//系统--退出菜单项
		if (obj==exit)
		{
			System.exit(0);
		}
		
		//信息查询--查询所有
		else	if (obj==all)
		{
			String sql="select * from Student order by ID";
			select all=new select(sql,1);	
		}
		
		//信息查询--按编号查询
		else	if (obj==byId)
			
		{
			searchById bYid=new searchById(1);
			
		}
		
		//学生管理--添加
        else	if (obj==add)
			
		{
        	String sql="";
			select all=new select(sql,2);
			
		}
		
		//学生管理--修改
        else	if (obj==modify)
			
		{
        	
			searchById sBId=new searchById(3);
			
		}
		
		
		//学生管理--删除
        else	if (obj==delete)
			
		{
        	
			searchById delete=new searchById(4);
			
		}
        else if(obj==ByAddress)
        {
        	searchAddress ByAddress=new searchAddress(5);
        }
        else if(obj==ByClass)
        {
      	searchByClass ByClass=new searchByClass(6);
        }
        else if(obj==note)
        {
        	TipWizardFrame frame = new TipWizardFrame();
			frame.setVisible(true);
        }
        else if(obj==calendar)
        {
        	xiaoli frame=new xiaoli();
        	frame.setVisible(true);
        }
        else if(obj==time)
        {
        	Time frame=new Time();
        	frame.setVisible(true);
        }
        else if(obj==tel)
        {
        	tele tel=new tele(7);
        }
        else if(obj==qq)
        {
        	String sql="select T_ID,Academy,QQ from List order by T_ID";
			selectQQ all=new selectQQ(sql,8);
        }
	}
	public void setVisable(boolean b) 
	{
		//创建一个框架	
		mainFrame frame=new mainFrame();
		//设置窗口处的尺寸
	    frame.setLocation(400, 200);
		frame.setSize(550,400);
		
		       //将“资产管理”的相关菜单项添加进去
				manage.add(add);
				manage.add(modify);
				manage.add(delete);
				
		        //将“查询”的相关菜单项添加进去
				search.add(all);
				search.add(byId);
				search.add(ByAddress);
				search.add(ByClass);
				//将“鲁大校历”的相关菜单项添加进去
				LD.add(calendar);
				LD.add(time);
				//将“校园留言箱”的相关菜单项添加进去
				School.add(note);
				//将“校园通信录”的相关菜单项添加进去
				tele.add(tel);
				tele.add(qq);
		        //将“系统”的相关菜单项添加进去		
				system.add(exit);
				
				//将三个菜单添加到菜单工具条
				bar.add(manage);
				bar.add(search);
				bar.add(LD);
				bar.add(School);
				bar.add(tele);
				bar.add(system);
				
				
				//监听者frame向各菜单项注册
				add.addActionListener(frame);
				modify.addActionListener(frame);
				delete.addActionListener(frame);
				all.addActionListener(frame);
				byId.addActionListener(frame);
				exit.addActionListener(frame);
				ByAddress.addActionListener(frame);
				ByClass.addActionListener(frame);
				note.addActionListener(frame);
				calendar.addActionListener(frame);
				time.addActionListener(frame);
				tel.addActionListener(frame);
			    qq.addActionListener(frame);
				
				//设置窗体的菜单工具条
		      frame.setJMenuBar(bar) ;
		      frame.setVisible(true);
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      JLabel L=new JLabel();
		      L.setIcon(new ImageIcon("src/image/Ld.jpg"));
		      frame.add(L);
		      frame.setResizable(false);
	}
}

