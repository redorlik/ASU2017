package dk.au.ase.elektronik.beertab.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TabGUI implements Runnable{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new TabGUI() {
			
		});
	}

	/**
	 * Create the application.
	 */
	public TabGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Labelfieldbutton panel = new Labelfieldbutton("Ny bruger","Tilføj bruger");
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		Labelfieldbutton panel2 = new Labelfieldbutton("Ny drikkevare","Tilføj drikkevare");
		frame.getContentPane().add(panel2, BorderLayout.SOUTH);
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TabGUI window = new TabGUI();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
