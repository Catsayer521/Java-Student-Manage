package package1;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//������ʾ��ѯ��������������ӡ��޸ĺ�ɾ���Ĺ��ܣ����ݱ�־ֵ����ɣ�
public class select extends JFrame implements ActionListener
{
	//����һ���ַ������飬������ʾ��ѯ����ı�ͷ
	String[] colName = {"ѧ��","����","�Ա�","�༶","��ַ","�绰����","����","����"};
	
	//����һ�����ݴ�����Ķ���
	StudentBean bean=new StudentBean();
	
	//����һ��������������壬������ʾʹ�ò�ѯ����������ı��
	JScrollPane jScrollPane1,jScrollPane2;
	String sql,ID,Address;
	
	//����һ��������������ʾ��ѯ���
	
	JTable table;
	
	//�����ĸ���ť���ֱ������ӡ��޸ġ�ɾ�����˳��Ĺ���
	JButton jButton1=new JButton("���");
	JButton jButton2=new JButton("�޸�");
	JButton jButton3=new JButton("ɾ��");
	JButton jButton4=new JButton("�˳�");
	
	//����һ����־λ�����Կ�����Щ��ť����ʹ��
    int status;
    
    //����һ����ά���飬Ӧ�Դ�Ų�ѯ�Ľ����
    String[][] colValue;
    
    
    //���ݲ�ͬ�ı�־λ����ɲ�ͬ����Ӧ�Ĺ���
	select(String sql,int status)
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
		
		 
		 //Ϊ��1��ʱִֻ�в�ѯ�������ǲ�ѯȫ�������ǰ��ձ�Ų�ѯ���ĸ���ťֻ��ʾ���˳�����ť���������ε�
		 if (status==1)
		 {
			 String[][] colValue1=bean.search(sql); 
			colValue=colValue1;
			jButton1.setVisible(false);
			jButton2.setVisible(false);
			jButton3.setVisible(false);
		 }
		 
		 //Ϊ��2��ʱ�������ӵĹ���
		 else if(status==2)
		 {
			 String[][] colValue2={{"0","0","0","0","0","0","0","0"}};
			 colValue=colValue2;
			 jButton2.setVisible(false);
			 jButton3.setVisible(false);
			 
		 }
		 
		 //Ϊ��3��ʱ������޸ĵĹ���
		 else if(status==3)
		 {
			    String[][] colValue1=bean.search(sql); 
				colValue=colValue1;
				jButton1.setVisible(false);
				jButton2.setVisible(true);
				jButton3.setVisible(false);
		 }
		 
		 
		 //Ϊ��4��ʱ�����ɾ���Ĺ���
		 else if(status==4)
		 {
			    String[][] colValue1=bean.search(sql); 
				colValue=colValue1;
				jButton1.setVisible(false);
				jButton2.setVisible(false);
				jButton3.setVisible(true);
		 }
		 else if(status==5)
		 {
			 String[][] colValue1=bean.search(sql);
			 colValue=colValue1;
			 jButton1.setVisible(false);
			 jButton2.setVisible(false);
			 jButton3.setVisible(false);
		 }
		 else if(status==6)
		 {
			 String[][] colValue1=bean.search(sql);
			 colValue=colValue1;
			 jButton1.setVisible(false);
			 jButton2.setVisible(false);
			 jButton3.setVisible(false);
		 }
		 //����һ��������Բ�ѯ��������Ķ�ά����Ϊ���ݣ��Զ��Ժ��һά����Ϊ��ͷ
		 table=new JTable(colValue,colName);
		  
		  //��ȡId�ֶε�ֵ����Ϊ��ѯ������
	      ID=(String) table.getValueAt(0, 0);
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
	
	public void actionPerformed(ActionEvent e) 
	{
		Object obj = e.getSource();
		
		//���������ǡ��˳�����ť���˳�����
		if(obj==jButton4)
		{
			
			this.dispose();
			
		}
		
		//��������ɾ������ť���Ƚ��а���Ų�ѯ��Ȼ����ɾ��
		else if(obj==jButton3)
		{
			sql="delete from Student where ID="+ID;
			StudentBean bean=new StudentBean();
			
			this.dispose();
			bean.delete(sql);
			
		}
		
		//������޸ġ���ť������޸Ĺ���
		else if(obj==jButton2)	
		{
			//�趨��������ݷ����޸ĺ󣬿��Ի�ȡ�޸ĺ������
			table.getCellEditor().stopCellEditing();
			
			//��ȡ������޸ĺ������
			String Name= (String) table.getValueAt(0, 1);
			String Sex= (String) table.getValueAt(0, 2);
			String Class= (String) table.getValueAt(0, 3);
			String Address= (String) table.getValueAt(0, 4);
			String Tele= (String) table.getValueAt(0, 5);
			String Nation= (String) table.getValueAt(0, 6);
			String Dorm= (String) table.getValueAt(0, 7);
			
			//ִ���޸�
			sql="update Student set Name='"+Name+"',Sex='"+Sex+"',Class = '" +Class+"',Address = '" +Address+"',Tele = '"+Tele+"',Nation ='" +Nation+"',Dorm='"+Dorm+"' where ID="+ID;
			StudentBean bean=new StudentBean();
			bean.modify(sql);
			this.dispose();	
		}
		 
		//�������ӡ���ť�������ӹ���
		else if(obj==jButton1)	
		{
			table.getCellEditor().stopCellEditing();
			String ID= (String) table.getValueAt(0, 0);
			String Name= (String) table.getValueAt(0, 1);
			String Sex= (String) table.getValueAt(0, 2);
			String Class= (String) table.getValueAt(0, 3);
			String Address= (String) table.getValueAt(0, 4);
			String Tele= (String) table.getValueAt(0, 5);
			String Nation= (String) table.getValueAt(0, 6);
			String Dorm= (String) table.getValueAt(0, 7);
			
			sql = "insert into Student(ID,Name,Sex,Class,Address,Tele,Nation,Dorm) values ('"+ID+"','"+Name+"','"+Sex+"','"+Class+"','"+Address+"','"+Tele+"','"+Nation+"','"+Dorm+"')";
			
			
			
			StudentBean bean=new StudentBean();
			bean.insert(sql);
			this.dispose();	
		}
		 
		
	}
}