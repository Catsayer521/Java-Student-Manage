package package1;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//������Ҫ�ǳ���������棬������һ�������һ���˵��������Լ���Ӧ�Ĳ˵���
public class mainFrame extends JFrame implements ActionListener
{
	
	
	//���ô��ڵĲ˵��������еĲ˵���Ҫ�ŵ�������
	static	JMenuBar  bar=new JMenuBar();
		
		//������ѧ�������˵���	
	static	JMenu manage=new JMenu("ѧ������");
	static	JMenuItem add=new JMenuItem("���");
	static	JMenuItem modify=new JMenuItem("�޸�");
	static	JMenuItem delete=new JMenuItem("ɾ��");
		
		
		
		//��������Ϣ��ѯ���˵���
	static	JMenu search=new JMenu("��Ϣ��ѯ");
	static	JMenuItem all=new JMenuItem("��ѯ����");
	static	JMenuItem byId=new JMenuItem("��ѧ�Ų�ѯ");
	static  JMenuItem ByAddress=new JMenuItem("����ַ��ѯ");
	static  JMenuItem ByClass=new  JMenuItem("��ѯ17����Ϣ");
	//������³��У�����˵���
	static JMenu LD=new JMenu("³��У��");
	static JMenuItem calendar=new JMenuItem("У��");
	static JMenuItem time=new JMenuItem("�ڿ�ʱ���");
	//������У԰�����䡱�˵���
	static  JMenu School=new JMenu("У԰������");
	static  JMenuItem note=new JMenuItem("����");
	//������У԰ͨ��¼���˵���
	static  JMenu tele=new JMenu("У԰ͨ��¼");
	static  JMenuItem tel=new JMenuItem("��ϵ��ʽ");
	static  JMenuItem qq=new JMenuItem("ѧԺQȺ");
		//������ϵͳ���˵���
	static	JMenu system=new JMenu("ϵͳ");
	static	JMenuItem exit=new JMenuItem("�˳�");
		

		
	
	//�����������г�������
	public static void main(String[] args)
	{
		new login();	
	}	
	
	//ѡ����Ӧ�Ĳ˵�����¼�����
	public void actionPerformed(ActionEvent e) 
	{
		Object obj=e.getSource();
		
		//ϵͳ--�˳��˵���
		if (obj==exit)
		{
			System.exit(0);
		}
		
		//��Ϣ��ѯ--��ѯ����
		else	if (obj==all)
		{
			String sql="select * from Student order by ID";
			select all=new select(sql,1);	
		}
		
		//��Ϣ��ѯ--����Ų�ѯ
		else	if (obj==byId)
			
		{
			searchById bYid=new searchById(1);
			
		}
		
		//ѧ������--���
        else	if (obj==add)
			
		{
        	String sql="";
			select all=new select(sql,2);
			
		}
		
		//ѧ������--�޸�
        else	if (obj==modify)
			
		{
        	
			searchById sBId=new searchById(3);
			
		}
		
		
		//ѧ������--ɾ��
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
		//����һ�����	
		mainFrame frame=new mainFrame();
		//���ô��ڴ��ĳߴ�
	    frame.setLocation(400, 200);
		frame.setSize(550,400);
		
		       //�����ʲ���������ز˵�����ӽ�ȥ
				manage.add(add);
				manage.add(modify);
				manage.add(delete);
				
		        //������ѯ������ز˵�����ӽ�ȥ
				search.add(all);
				search.add(byId);
				search.add(ByAddress);
				search.add(ByClass);
				//����³��У��������ز˵�����ӽ�ȥ
				LD.add(calendar);
				LD.add(time);
				//����У԰�����䡱����ز˵�����ӽ�ȥ
				School.add(note);
				//����У԰ͨ��¼������ز˵�����ӽ�ȥ
				tele.add(tel);
				tele.add(qq);
		        //����ϵͳ������ز˵�����ӽ�ȥ		
				system.add(exit);
				
				//�������˵���ӵ��˵�������
				bar.add(manage);
				bar.add(search);
				bar.add(LD);
				bar.add(School);
				bar.add(tele);
				bar.add(system);
				
				
				//������frame����˵���ע��
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
				
				//���ô���Ĳ˵�������
		      frame.setJMenuBar(bar) ;
		      frame.setVisible(true);
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      JLabel L=new JLabel();
		      L.setIcon(new ImageIcon("src/image/Ld.jpg"));
		      frame.add(L);
		      frame.setResizable(false);
	}
}

