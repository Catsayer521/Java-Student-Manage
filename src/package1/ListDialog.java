package package1;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ListDialog extends JDialog {

	private static File file = null;// �ı��ļ�����ļ��ж���

	private File[] files = null;// �ı��ļ���������

	private File text = null;// �鿴���ı��ļ�����

	private JPanel allPanel;

	static {// �ھ�̬������г�ʼ���ı��ļ�����ļ��ж���
		file = new File("C:/text");
	}

	public ListDialog() {
		super();
		setModal(true);
		setTitle("�����б�");
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
			delButton.setText("ɾ ��");
			delButton.setName("" + i);
			delButton.addActionListener(new DelButtonActionListener());
			onePanel.add(delButton, BorderLayout.CENTER);

			final JButton seeButton = new JButton();
			seeButton.setText("�� ��");
			seeButton.setName("" + i);
			seeButton.addActionListener(new SeeButtonActionListener());
			onePanel.add(seeButton, BorderLayout.EAST);
		}

		final JButton returnButton = new JButton();
		returnButton.setText("�� ��");
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
			text = files[Integer.valueOf(name)];// ���ò鿴�����ļ�����
			setVisible(false);
		}
	}

	private class DelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int index = Integer.valueOf(button.getName());
			files[index].delete();// ɾ�������ļ�
			allPanel.remove(index);// �������б���ɾ����־
			SwingUtilities.updateComponentTreeUI(allPanel);// ˢ�´���
		}
	}

	public File getText() {
		return text;
	}

}
