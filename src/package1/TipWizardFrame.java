package package1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

import javax.swing.*;

public class TipWizardFrame extends JFrame {

	private JTextField titleTextField;// 标题文本框

	private JTextField dateTextField;// 日期文本框

	private JTextArea textArea;// 内容文本域

	private final static String urlStr = "C:/text/";// 文本文件存放路径

	private final static String todayDate = String.format("%tF", new Date());// 将当前日期格式化为“2008-08-08”格式

	static 
	{// 在静态代码块中初始化文本文件存放路径
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
		setTitle("悄悄话");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//JFrame.EXIT_ON_CLOSE
		final JLabel softLabel = new JLabel();
		softLabel.setForeground(new Color(255, 0, 0));
		softLabel.setFont(new Font("", Font.BOLD, 22));
		softLabel.setHorizontalAlignment(SwingConstants.CENTER);
		softLabel.setText("悄  悄  话");
		getContentPane().add(softLabel, BorderLayout.NORTH);

		final JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		final JPanel infoPanel = new JPanel();
		contentPanel.add(infoPanel, BorderLayout.CENTER);

		final JLabel titleLabel = new JLabel();
		titleLabel.setText("标    题：");
		infoPanel.add(titleLabel);

		titleTextField = new JTextField();
		titleTextField.setColumns(30);
		titleTextField.setText("请输入标题");
		titleTextField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				titleTextField.setText("");
			}

			public void focusLost(FocusEvent e) {
				String date = titleTextField.getText().trim();
				if (date.length() == 0)
					titleTextField.setText("请输入标题");
			}
		});
		infoPanel.add(titleTextField);

		final JLabel dateLabel = new JLabel();
		dateLabel.setText("日    期：");
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
		seeButton.setText("查看");
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
		saveButton.setText("保存");
		saveButton.addActionListener(new SaveButtonActionListener());
		buttonPanel.add(saveButton);

		final JButton clearButton = new JButton();
		clearButton.setText("清空");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleTextField.setText("请输入标题");
				dateTextField.setText(todayDate);
				textArea.setText("");
			}
		});
		buttonPanel.add(clearButton);

		final JButton exitButton = new JButton();
		exitButton.setText("退出");
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
			listFrame.setVisible(true);// 显示留言列表窗体
			File text = listFrame.getText();// 留言对象
			listFrame.dispose();// 销毁留言列表窗体
			if (text != null) {// 查看留言对象是否为空
				String[] infos = text.getName().split("（|）");// 分割留言文件的名称
				titleTextField.setText(infos[0]);// 设置留言标题
				dateTextField.setText(infos[1]);// 设置留言日期
				try {
					FileReader fileReader = new FileReader(text);// 创建字符输入流
					char[] cbuf = new char[(int) text.length()];// 创建字符型数组
					fileReader.read(cbuf);// 读入文件内容到字符型数组
					fileReader.close();// 关闭字符输入流
					textArea.setText(String.valueOf(cbuf));// 设置留言内容
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
			String title = titleTextField.getText();// 获得留言标题
			String date = dateTextField.getText();// 获得留言日期
			String name = title + "（" + date + "）.txt";// 组织文本文件名称
			File file = new File(urlStr + name);// 创建文本文件对象
			if (!file.exists()) {// 判断文件是否存在
				try {
					file.createNewFile();// 如果不存在则创建文件
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				FileWriter fileWriter = new FileWriter(file);// 创建字符输出流
				fileWriter.write(textArea.getText());// 将内容写入文本文件
				fileWriter.close();// 关闭字符输出流
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
