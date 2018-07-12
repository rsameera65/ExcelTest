package excelOperations;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Admin");
		btnNewButton.setBounds(334, 238, 77, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AdminLogin login = new AdminLogin();
				login.LoginAdmin();
				dispose();

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(247, 21, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = textField.getText();

				FileInputStream fis;
				Workbook wb;
				Sheet sh;
				Boolean status = false;

				try {
					fis = new FileInputStream(
							"C:\\Users\\rpa19\\workspace\\ExcelProject\\res\\input\\testReadExcel.xlsx");
					wb = WorkbookFactory.create(fis);
					sh = wb.getSheet("Department");

					for (Row myrow : sh) {
						// System.out.println(myrow.getCell(0).getStringCellValue());
						if (myrow.getCell(0).getStringCellValue().equals(username)) {
							// JOptionPane.showMessageDialog(null,
							// "Login Complete");
							// System.out.println("User Found");
							status = true;
							break;
						}
					}

					if (status == true)
						JOptionPane.showMessageDialog(null, "Login Complete");
					else
						JOptionPane.showMessageDialog(null, "Login Failed");

					fis.close();
				} catch (EncryptedDocumentException | InvalidFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(247, 63, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
