package dk.au.ase.asu.beertab.GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTable table;
	private JPanel panel,bev;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblBeverage;
	private JTextField txtBeverage;
	private JButton btnUser;
	private JButton btnBeverage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}
	
	DefaultTableModel myData = new DefaultTableModel(
			new Object[][] {{"Name\\Beverage"}
			},
			new String[] {"test"
			}
		);
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("BeerTab");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
//		JLabel lblBeerTab = new JLabel("Beer Tab");
//		lblBeerTab.setHorizontalAlignment(SwingConstants.CENTER);
//		lblBeerTab.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		frame.getContentPane().add(lblBeerTab, BorderLayout.NORTH);
		
		table = new JTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		table.setGridColor(Color.BLACK);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				if(SwingUtilities.isLeftMouseButton(e)){
					if(row>0 && col>0){
						Object val = myData.getValueAt(row, col);//table.getValueAt(row, col);
						if(val == null){
							myData.setValueAt(1, row, col);
						}else if(val instanceof Integer){
							Integer i = (Integer) val;
							myData.setValueAt(i+1, row, col);
						}else{
							System.out.println("error");
						}
					}
				}
				if(SwingUtilities.isRightMouseButton(e)){
					if(row>0 && col>0){
						Object val = myData.getValueAt(row, col);
						if(val == null){
							myData.setValueAt(0, row, col);
						}else if(val instanceof Integer){
							Integer i = (Integer) val;
							if(i > 0) myData.setValueAt(i-1, row, col);
						}else{
							System.out.println("error");
						}
					}
				}
			}
		});
		table.setModel(myData);
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
		JDialog dia = new JDialog(frame,"My dialog",false);
		dia.setLayout(new FlowLayout());
		panel = new GUILabelFieldButton("User",myData);
		dia.getContentPane().add(panel, BorderLayout.NORTH);
		
		bev = new GUILabelFieldButton("Beverage",myData);
		dia.add(bev, BorderLayout.SOUTH);
		dia.setSize(500,200);
		dia.setVisible(true);
	};
	
	
}
