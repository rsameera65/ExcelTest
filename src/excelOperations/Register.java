package excelOperations;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Register extends JFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void New() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String SAMPLE_XLSX_FILE_PATH = "/input/testReadExcel.xlsx/";
				ExcelReader excelReader = new ExcelReader();

				try {

					String username = textField.getText();

					if (username.length() == 0) {
						JOptionPane.showMessageDialog(null, "Please enter a valid user name to registerd", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{

					boolean RegMmbers = excelReader.readExcelFile(SAMPLE_XLSX_FILE_PATH, username);

					if (RegMmbers == true){
						JOptionPane.showMessageDialog(null, "Member " +username + " Registered");
						textField.setText(null);
					}
					else
						JOptionPane.showMessageDialog(null, "Member Registration Failed", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (EncryptedDocumentException | InvalidFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnRegister.setBounds(190, 51, 89, 23);
		frame.getContentPane().add(btnRegister);

		JLabel lbl1 = new JLabel("User Name");
		lbl1.setBounds(42, 23, 71, 14);
		frame.getContentPane().add(lbl1);

		textField = new JTextField();
		textField.setBounds(190, 20, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBack = new JButton("Home");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HomePage home = new HomePage();
				home.setVisible(true);
				frame.dispose();

			}
		});
		btnBack.setBounds(0, 239, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
