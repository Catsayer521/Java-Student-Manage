package package1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

import javax.swing.*;

public class TipWizardFrame extends JFrame {

	private JTextField titleTextField;// �����ı���

	private JTextField dateTextField;// �����ı���

	private JTextArea textArea;// �����ı���

	private final static String urlStr = "C:/text/";// �ı��ļ����·��

	private final static String todayDate = String.format("%tF", new Date());// ����ǰ���ڸ�ʽ��Ϊ��2008-08-08����ʽ

	static 
	{// �ھ�̬������г�ʼ���ı��ļ����·��
		File file = new File(urlStr);
		if (!file.exists())
			file.mkdirs();
//		try 
//		{
//			TipWizardFrame frame = new TipWizardFrame();
//			frame.setVisible(true);
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
	}

//	public static void main(String args[]) {
//		try 
//		{
//			TipWizardFrame frame = new TipWizardFrame();
//			frame.setVisible(true);
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}

	public TipWizardFrame() {
		super();
		setTitle("���Ļ�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//JFrame.EXIT_ON_CLOSE
		final JLabel softLabel = new JLabel();
		softLabel.setForeground(new Color(255, 0, 0));
		softLabel.setFont(new Font("", Font.BOLD, 22));
		softLabel.setHorizontalAlignment(SwingConstants.CENTER);
		softLabel.setText("��  ��  ��");
		getContentPane().add(softLabel, BorderLayout.NORTH);

		final JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		final JPanel infoPanel = new JPanel();
		contentPanel.add(infoPanel, BorderLayout.CENTER);

		final JLabel titleLabel = new JLabel();
		titleLabel.setText("��    �⣺");
		infoPanel.add(titleLabel);

		titleTextField = new JTextField();
		titleTextField.setColumns(30);
		titleTextField.setText("���������");
		titleTextField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				titleTextField.setText("");
			}

			public void focusLost(FocusEvent e) {
				String date = titleTextField.getText().trim();
				if (date.length() == 0)
					titleTextField.setText("���������");
			}
		});
		infoPanel.add(titleTextField);

		final JLabel dateLabel = new JLabel();
		dateLabel.setText("��    �ڣ�");
		infoPanel.add(dateLabel);

		dateTextField = new JTextField();
		dateTextField.setColumns(30);
		dateTextField.setText(todayDate);
		dateTextField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				dateTextField.setText("");
			}

			public void focusLost(FocusEvent e) {
				String date = dateTextField.getText().trim();
				if (date.length() != 10)
					dateTextField.setText(todayDate);
			}
		});
		infoPanel.add(dateTextField);

		final JButton seeButton = new JButton();
		seeButton.setText("�鿴");
		seeButton.addActionListener(new SeeButtonActionListener());
		contentPanel.add(seeButton, BorderLayout.EAST);

		final JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.SOUTH);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(12);
		scrollPane.setViewportView(textArea);

		final JPanel buttonPanel = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(20);
		buttonPanel.setLayout(flowLayout);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		final JButton saveButton = new JButton();
		saveButton.setText("����");
		saveButton.addActionListener(new SaveButtonActionListener());
		buttonPanel.add(saveButton);

		final JButton clearButton = new JButton();
		clearButton.setText("���");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleTextField.setText("���������");
				dateTextField.setText(todayDate);
				textArea.setText("");
			}
		});
		buttonPanel.add(clearButton);

		final JButton exitButton = new JButton();
		exitButton.setText("�˳�");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				System.exit(0);
			}
		});
		buttonPanel.add(exitButton);
		//
	}

	private class SeeButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ListDialog listFrame = new ListDialog();
			listFrame.setVisible(true);// ��ʾ�����б���
			File text = listFrame.getText();// ���Զ���
			listFrame.dispose();// ���������б���
			if (text != null) {// �鿴���Զ����Ƿ�Ϊ��
				String[] infos = text.getName().split("��|��");// �ָ������ļ�������
				titleTextField.setText(infos[0]);// �������Ա���
				dateTextField.setText(infos[1]);// ������������
				try {
					FileReader fileReader = new FileReader(text);// �����ַ�������
					char[] cbuf = new char[(int) text.length()];// �����ַ�������
					fileReader.read(cbuf);// �����ļ����ݵ��ַ�������
					fileReader.close();// �ر��ַ�������
					textArea.setText(String.valueOf(cbuf));// ������������
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	private class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String title = titleTextField.getText();// ������Ա���
			String date = dateTextField.getText();// �����������
			String name = title + "��" + date + "��.txt";// ��֯�ı��ļ�����
			File file = new File(urlStr + name);// �����ı��ļ�����
			if (!file.exists()) {// �ж��ļ��Ƿ����
				try {
					file.createNewFile();// ����������򴴽��ļ�
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				FileWriter fileWriter = new FileWriter(file);// �����ַ������
				fileWriter.write(textArea.getText());// ������д���ı��ļ�
				fileWriter.close();// �ر��ַ������
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
