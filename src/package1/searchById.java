package package1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//������ɰ��ձ�Ž��в�ѯ��������־ֵstatus��select���󴫵�
public class searchById extends JFrame implements ActionListener
{
	
	//����Ҫ��ʾ�ı��������
	String[] colName = {"ѧ��","����","�Ա�","�༶","��ַ","�绰����","����","����"};
	
	StudentBean bean=new StudentBean();
	
	JScrollPane jScrollPane1;
	//����������ʾ��ѯ�ı�ǩ
	JLabel jLabel1=new JLabel();
	
	//�����ŵ��ı���
	JTextField jText1=new JTextField(4);
	//ȷ����ť
	JButton jButton1=new JButton();
	
	//��ȡ���屾������������
	Container pane=this.getContentPane();
	
	//����״̬�ĳ�ʼֵ
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
		//���ô���ı���
		this.setTitle("����ѧ�Ų�ѯ");
		this.setBounds(500, 400, 300, 100);
		
		//�����������Ĳ��и�ʽ
	    pane.setLayout(new FlowLayout());
	    
	    //���ñ�ǩ����ʾ����
	    jLabel1.setText("������Ҫ��ѯ��ѧ��:");
	    
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
		String sql="select * from Student  where ID="+jText1.getText();
		select selectById= new select(sql,status);
		this.dispose();
		 
	}

}
