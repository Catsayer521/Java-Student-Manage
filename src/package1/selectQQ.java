package package1;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//������ʾ��ѯ��������������ӡ��޸ĺ�ɾ���Ĺ��ܣ����ݱ�־ֵ����ɣ�
public class selectQQ extends JFrame implements ActionListener
{
	//����һ���ַ������飬������ʾ��ѯ����ı�ͷ
	String[] colName = {"���","ѧԺ","ѧԺQȺ"};
	//����һ�����ݴ�����Ķ���
	QQBean bean1=new QQBean();
	//����һ��������������壬������ʾʹ�ò�ѯ����������ı��
	JScrollPane jScrollPane1,jScrollPane2;
	String sql,T_ID,Academy,QQ;
	
	//����һ��������������ʾ��ѯ���
	
	JTable table;
	
	//�����ĸ���ť���ֱ������ӡ��޸ġ�ɾ�����˳��Ĺ���
	JButton jButton1=new JButton("���");
	JButton jButton2=new JButton("�޸�");
	JButton jButton3=new JButton("ɾ��");
	JButton jButton4=new JButton("�˳�");
	//JButton jButton1=new JButton("��ϵ��ʽ");
	
	//����һ����־λ�����Կ�����Щ��ť����ʹ��
    int status;
    
    //����һ����ά���飬Ӧ�Դ�Ų�ѯ�Ľ����
    String[][] colValue;
    
    
    //���ݲ�ͬ�ı�־λ����ɲ�ͬ����Ӧ�Ĺ���
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
		//����һ��������Բ�ѯ��������Ķ�ά����Ϊ���ݣ��Զ��Ժ��һά����Ϊ��ͷ
		 table=new JTable(colValue,colName);
		  
		  //��ȡId�ֶε�ֵ����Ϊ��ѯ������
		 Academy=(String) table.getValueAt(0, 0);
		 QQ=(String) table.getValueAt(0, 0);
	      //����ŵ��������ʾ
		 jScrollPane1=new JScrollPane(table);
	    //�����ŵ����������λ��
	      this.add(jScrollPane1,BorderLayout.CENTER);
	      
	      //������ʾ���弰�ڲ������С
	      this.pack();
	      
	      this.setLocation(450, 200);
	      
	      //����һ�������󣬴���ĸ���ť
	      JPanel jPan1=new JPanel();
	      
	      //�������Ĳ��ָ�ʽΪ��ʽ����
	      jPan1.setLayout(new FlowLayout());
	      
	      //���ĸ���ť�ŵ������
	      jPan1.add(jButton1);
	      jPan1.add(jButton2);
	      jPan1.add(jButton3);
	      jPan1.add(jButton4);

	      
	      //���������ĸ���ťע�����
	      jButton1.addActionListener(this);
	      jButton2.addActionListener(this);
	      jButton3.addActionListener(this);
	      jButton4.addActionListener(this);
	     
	      jPan1.setVisible(true);
	      
	      //�����ŵ����������λ��
	      this.add(jPan1,BorderLayout.SOUTH);
	      this.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		//���������ǡ��˳�����ť���˳�����
		if(obj==jButton4)
		{
			
			this.dispose();
			
		}
	}
}