package excelOperations;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JButton;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Home {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl3 = new JLabel("New label");
		lbl3.setBounds(208, 214, 46, 14);
		frame.getContentPane().add(lbl3);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String SAMPLE_XLSX_FILE_PATH = "/input/testReadExcel.xlsx/";
				ExcelReader excelReader = new ExcelReader();

				try {

					String username = textField.getText();

					int RegMmbers = excelReader.readExcelFile(SAMPLE_XLSX_FILE_PATH, username);

					lbl3.setText(Integer.toString(RegMmbers));

				} catch (EncryptedDocumentException | InvalidFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnRegister.setBounds(151, 119, 89, 23);
		frame.getContentPane().add(btnRegister);

		JLabel lbl1 = new JLabel("User Name");
		lbl1.setBounds(42, 23, 71, 14);
		frame.getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("Data");
		lbl2.setBounds(42, 214, 46, 14);
		frame.getContentPane().add(lbl2);

		textField = new JTextField();
		textField.setBounds(190, 20, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
