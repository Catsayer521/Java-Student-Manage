package package1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//������ɰ��ձ�Ž��в�ѯ��������־ֵstatus��select���󴫵�
public class tele extends JFrame implements ActionListener
{
	
	//����Ҫ��ʾ�ı��������
	String[] colName = {"���","ѧԺ","��ϵ��ʽ"};
	static JFrame jfrm=new JFrame("У԰ͨѶ¼");
	teleBean bean1=new teleBean();
	
	JScrollPane jScrollPane1;
	//����������ʾ��ѯ�ı�ǩ
	JLabel jLabel1=new JLabel();
	
	//�����ŵ��ı���
	JTextField jText1=new JTextField(7);
	//ȷ����ť
	JButton jButton1=new JButton();
	
	//��ȡ���屾������������
	Container pane=this.getContentPane();
	
	//����״̬�ĳ�ʼֵ
	int status=7;
	tele(int status)
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
		//���ô���ı���
		this.setTitle("����ѧԺ��ѯ");
		this.setBounds(500, 400, 300, 100);
		
		//�����������Ĳ��и�ʽ
	    pane.setLayout(new FlowLayout());
	    
	    //���ñ�ǩ����ʾ����
	    jLabel1.setText("������Ҫ��ѯ��ѧԺ:");
	    
	    //���ı������������Ϊ��
	    jText1.setText(null);
	    
	    //�趨��ť����ʾ����
	    jButton1.setText("ȷ��");
	    //����ǩ���ı���Ͱ�ť�����������
	    pane.add(jLabel1);
	    pane.add(jText1);
	    pane.add(jButton1);   
	    
	    //������ťע�����
		jButton1.addActionListener(this);
	    this.setVisible(true);
	}	
	public void actionPerformed(ActionEvent e) 
	{
		//����ѧ�ò�ѯ��������־ֵstatus��select���󴫵�
		String sql="select T_ID,Academy,Phone from List  where Academy='"+jText1.getText()+"'";
		select_tele tel= new select_tele(sql,status);
		this.dispose();
	}
}
