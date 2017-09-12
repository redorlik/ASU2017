package dk.au.ase.asu.beertab.GUI;

import java.awt.EventQueue;

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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTable table;
	private JPanel panel;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblBeerTab = new JLabel("Beer Tab");
		lblBeerTab.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeerTab.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblBeerTab, BorderLayout.NORTH);
		
		table = new JTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		table.setGridColor(Color.BLACK);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)){
					int row = table.rowAtPoint(e.getPoint());
					int col = table.columnAtPoint(e.getPoint());
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
					int row = table.rowAtPoint(e.getPoint());
					int col = table.columnAtPoint(e.getPoint());
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
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 100, 100, 0};
		gbl_panel.rowHeights = new int[]{20, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblUser = new JLabel("New User:");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 0;
		panel.add(lblUser, gbc_lblUser);
		
		txtUser = new JTextField();
		txtUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newUser();
			}
		});
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.anchor = GridBagConstraints.NORTH;
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 0;
		panel.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		btnUser = new JButton("OK");
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				newUser();
			}
		});
		btnUser.setToolTipText("Add new user");
		btnUser.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnUser = new GridBagConstraints();
		gbc_btnUser.insets = new Insets(0, 0, 5, 0);
		gbc_btnUser.gridx = 2;
		gbc_btnUser.gridy = 0;
		panel.add(btnUser, gbc_btnUser);
		
		lblBeverage = new JLabel("New Beverage:");
		GridBagConstraints gbc_lblBeverage = new GridBagConstraints();
		gbc_lblBeverage.anchor = GridBagConstraints.WEST;
		gbc_lblBeverage.insets = new Insets(0, 0, 0, 5);
		gbc_lblBeverage.gridx = 0;
		gbc_lblBeverage.gridy = 1;
		panel.add(lblBeverage, gbc_lblBeverage);
		
		txtBeverage = new JTextField();
		txtBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Event activated by <CR>
				newBeverage();
			}
		});
		GridBagConstraints gbc_txtBeverage = new GridBagConstraints();
		gbc_txtBeverage.insets = new Insets(0, 0, 0, 5);
		gbc_txtBeverage.anchor = GridBagConstraints.NORTH;
		gbc_txtBeverage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBeverage.gridx = 1;
		gbc_txtBeverage.gridy = 1;
		panel.add(txtBeverage, gbc_txtBeverage);
		txtBeverage.setColumns(10);
		
		btnBeverage = new JButton("OK");
		btnBeverage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newBeverage();
			}
		});
		btnBeverage.setToolTipText("Add new beverage");
		btnBeverage.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnBeverage = new GridBagConstraints();
		gbc_btnBeverage.gridx = 2;
		gbc_btnBeverage.gridy = 1;
		panel.add(btnBeverage, gbc_btnBeverage);
	}
	
	public void newUser() {
		String name = txtUser.getText();
		txtUser.setText("");
		if(name.length() > 0){
			myData.addRow(new Object[]{name});
		}
	}
	public void newBeverage() {
		String name = txtBeverage.getText();
		txtBeverage.setText("");
		if(name.length() > 0){
			myData.addColumn(name, new Object[]{name});
		}
	}
}
