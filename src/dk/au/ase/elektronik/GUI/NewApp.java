package dk.au.ase.elektronik.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;

public class NewApp {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewApp window = new NewApp();
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
	public NewApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{112, 112, 112, 112, 0};
		gridBagLayout.rowHeights = new int[]{278, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 1;
		frame.getContentPane().add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1.gridx = 0;
		gbc_chckbxNewCheckBox_1.gridy = 2;
		frame.getContentPane().add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_2.gridx = 0;
		gbc_chckbxNewCheckBox_2.gridy = 3;
		frame.getContentPane().add(chckbxNewCheckBox_2, gbc_chckbxNewCheckBox_2);
	}
}
