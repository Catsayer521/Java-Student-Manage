package package1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class searchAddress extends JFrame implements ActionListener
{
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
		//���ô���
		this.setTitle("���յ�ַ��ѯ");
		this.setBounds(500,400,300,100);
		//�������ݰ�Ĳ��и�ʽ
		pane.setLayout(new FlowLayout());
		jLabel1.setText("������Ҫ��ѯ�ĵ�ַ");
		//���ı������������Ϊ��
	    jText1.setText(null);
	    //�趨��ť����ʾ����
	    jButton1.setText("ȷ��");
	    //�����ݣ���ť�������ݰ�
	    pane.add(jLabel1);
	    pane.add(jText1);
	    pane.add(jButton1);
	  //������ťע�����
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
