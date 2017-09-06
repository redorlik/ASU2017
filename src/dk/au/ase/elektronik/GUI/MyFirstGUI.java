package dk.au.ase.elektronik.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

public class MyFirstGUI {

	private JFrame frmMywindow;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstGUI window = new MyFirstGUI();
					window.frmMywindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFirstGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMywindow = new JFrame();
		frmMywindow.setTitle("MyWindow");
		frmMywindow.setBackground(UIManager.getColor("Button.select"));
		frmMywindow.setBounds(100, 100, 835, 605);
		frmMywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		frmMywindow.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Opkald");
		frmMywindow.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		
		JButton myNewButton = new JButton("Læg på");
		frmMywindow.getContentPane().add(myNewButton, BorderLayout.EAST);
		
		JButton btnButton = new JButton("button2");
		btnButton.setBackground(Color.ORANGE);
		frmMywindow.getContentPane().add(btnButton, BorderLayout.WEST);
	}

}
