package package1;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Time extends JFrame
{
	static JFrame jfrm=new JFrame("³��У��");

	public Time()
	{
		jfrm.setSize(400,500);
		jfrm.setBackground(Color.yellow);
		jfrm.setLocation(260, 150);
		jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jfrm.setVisible(true);
		JLabel L=new JLabel();
	    L.setIcon(new ImageIcon("src/image/ʱ���.jpg"));
	    jfrm.add(L);
	    jfrm.setResizable(false);
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
