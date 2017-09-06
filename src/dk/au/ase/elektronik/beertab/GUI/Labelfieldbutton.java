package dk.au.ase.elektronik.beertab.GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Labelfieldbutton extends JPanel {

	public Labelfieldbutton(String labeltxt, String buttontxt){
		super();
		JLabel lblTilfjdrik = new JLabel(labeltxt);
		this.add(lblTilfjdrik);
		
		JTextField textFielddrik = new JTextField();
		this.add(textFielddrik);
		textFielddrik.setColumns(10);
		
		JButton btnTilfjdrik = new JButton(buttontxt);
		this.add(btnTilfjdrik);
		
	}
}
