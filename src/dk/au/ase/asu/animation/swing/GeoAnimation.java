package dk.au.ase.asu.animation.swing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class GeoAnimation extends JPanel {

	
	private int y1=200;
	private int y2=200;
	private int x2=200;
	private int x1=200;
	private double FI=0;
	private JButton btnMyButton;
	int HEIGHT = 0;
	/**
	 * Create the panel.
	 */
	public GeoAnimation() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Point mouse = e.getPoint();
				Point loc = btnMyButton.getLocation();
				if ((mouse.x-loc.x)<100) loc.x += 10; 
				if ((mouse.y-loc.y)<60) loc.y += 10;
				if ((loc.x-mouse.x)<100) loc.x -= 10; 
				if ((loc.y-mouse.y)<60) loc.y -= 10;
				if (loc.y<0) loc.y += 400;
				if (loc.x<0) loc.x += 400 ;
				System.out.println(loc+" "+WIDTH+" "+HEIGHT);
				btnMyButton.setLocation(loc);
			}
			
		});
		JFrame frame = new JFrame("Animation Background");
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new DrawTask(), 500, 100);
		setVisible(true);
		frame.setSize(400, 400);
		frame.getContentPane().add(this);
		
		btnMyButton = new JButton("My Button");
		add(btnMyButton);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //paintComponent2(this.getGraphics());

	}
	public void paintComponent(Graphics grp) {
		
		super.paintComponent(grp);
		
	//			loc.x += 10; //this.getWidth();
//			loc.y -= 10; //this.getHeight();
//			if (loc.y<0) loc.y += this.getHeight();
//			if (loc.x<0) loc.x += this.getWidth();
//			loc.x = Math.floorMod(loc.x, this.getWidth());
//			loc.y = Math.floorMod(loc.y, this.getHeight());
//		}

		double scale = 10;
		grp.setColor(Color.black);
		x2 = 200; y2 = 200+(int)scale;
		for (double fi=0;fi<FI;fi+=0.01) {
			x1 = x2;
			y1 = y2;
			
			y2 = 200+(int) (scale*(Math.cos(fi)+ fi*Math.sin(fi)));
			x2 = 200+(int) (scale*(Math.sin(fi)- fi*Math.cos(fi)));
			grp.drawLine(x1, y1, x2, y2);
		}
		
		//grp.drawLine(0, 0, 100, 100);
	}
	public static void main(String[] args) {
		GeoAnimation geo = new GeoAnimation();
		
	}

	class DrawTask extends TimerTask{

		private Double fi=0.;
		private Double scale=40.;
		private double delta = 0.01;
		@Override
		public void run() {
			FI += delta;
			if (FI>15 || 0>FI) delta *= -1;
			repaint();
		}

	}
}