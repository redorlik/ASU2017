package dk.au.ase.asu.beertab.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GUILabelFieldButton extends JPanel {

	private JLabel lblUser;
	private JTextField txtUser;
	private JButton btnUser;
	private DefaultTableModel myData;
	private String type;

	/**
	 * Create the panel.
	 */
	public GUILabelFieldButton(String type,DefaultTableModel myData) {
		this.myData = myData;
		this.type = type;
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 100, 100, 0};
		gbl_panel.rowHeights = new int[]{20, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		lblUser = new JLabel("New "+type);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 0;
		this.add(lblUser, gbc_lblUser);
		
		txtUser = new JTextField();
		txtUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newThing();
			}
		});
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.anchor = GridBagConstraints.NORTH;
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 0;
		this.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		btnUser = new JButton("OK");
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				newThing();
			}
		});
		btnUser.setToolTipText("Add new "+type);
		btnUser.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnUser = new GridBagConstraints();
		gbc_btnUser.insets = new Insets(0, 0, 5, 0);
		gbc_btnUser.gridx = 2;
		gbc_btnUser.gridy = 0;
		this.add(btnUser, gbc_btnUser);
		
	}
	public void newThing() {
		String name = txtUser.getText();
		txtUser.setText("");
		if(name.length() > 0){
			if (this.type.equals("User")) {
				myData.addRow(new Object[]{name});
			}else {
				myData.addColumn(name,new Object[]{name});
			}
			
		}
	}

}
