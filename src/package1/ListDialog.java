package package1;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ListDialog extends JDialog {

	private static File file = null;// 文本文件存放文件夹对象

	private File[] files = null;// 文本文件对象数组

	private File text = null;// 查看的文本文件对象

	private JPanel allPanel;

	static {// 在静态代码块中初始化文本文件存放文件夹对象
		file = new File("C:/text");
	}

	public ListDialog() {
		super();
		setModal(true);
		setTitle("留言列表");
		setBounds(100, 100, 500, 375);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

		files = file.listFiles();

		allPanel = new JPanel();
		allPanel.setPreferredSize(new Dimension(450, files.length * 36));
		scrollPane.setViewportView(allPanel);

		for (int i = 0; i < files.length; i++) {
			String name = "    " + files[i].getName();
			name = name.substring(0, name.length() - 4);

			final JPanel onePanel = new JPanel();
			allPanel.add(onePanel);
			onePanel.setBorder(new LineBorder(Color.black, 1, false));
			onePanel.setLayout(new BorderLayout());

			final JLabel label = new JLabel();
			label.setPreferredSize(new Dimension(330, 0));
			label.setText(name);
			onePanel.add(label, BorderLayout.WEST);

			final JButton delButton = new JButton();
			delButton.setText("删 除");
			delButton.setName("" + i);
			delButton.addActionListener(new DelButtonActionListener());
			onePanel.add(delButton, BorderLayout.CENTER);

			final JButton seeButton = new JButton();
			seeButton.setText("查 看");
			seeButton.setName("" + i);
			seeButton.addActionListener(new SeeButtonActionListener());
			onePanel.add(seeButton, BorderLayout.EAST);
		}

		final JButton returnButton = new JButton();
		returnButton.setText("返 回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		getContentPane().add(returnButton, BorderLayout.SOUTH);
		//
	}

	private class SeeButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			String name = button.getName();
			text = files[Integer.valueOf(name)];// 设置查看留言文件对象
			setVisible(false);
		}
	}

	private class DelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int index = Integer.valueOf(button.getName());
			files[index].delete();// 删除留言文件
			allPanel.remove(index);// 从留言列表中删除日志
			SwingUtilities.updateComponentTreeUI(allPanel);// 刷新窗体
		}
	}

	public File getText() {
		return text;
	}

}
