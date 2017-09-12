package dk.au.ase.elektronik.beertab.GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Labelfieldbutton extends JPanel implements MouseListener {

	private int count = 0;
	private JLabel lblTilfjdrik;
	private String labeltxt;

	public Labelfieldbutton(String labeltxt, String buttontxt){
		super();
		this.labeltxt = labeltxt;
		lblTilfjdrik = new JLabel(labeltxt);
		this.add(lblTilfjdrik);
		
		JTextField textFielddrik = new JTextField();
		this.add(textFielddrik);
		textFielddrik.setColumns(10);
		
		JButton btnTilfjdrik = new JButton(buttontxt);
		this.add(btnTilfjdrik);
		
		btnTilfjdrik.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Hey du klikkede!");
		this.count  += 1;
		this.lblTilfjdrik.setText(this.labeltxt+" "+this.count);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Hey du rørte mig!");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
