package dk.au.ase.elektronik.GUI;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.teamdev.jxbrowser.chromium.Browser;

public class SwingURL {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingURL window = new SwingURL();
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
	public SwingURL() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Browser bro = new Browser();
//		BrowserView brow = new BrowserView(bro);
//		bro.loadURL("ing.dk");
		JEditorPane editorPane = new JEditorPane("http://www.oleriis.dk/");
		frame.getContentPane().add(editorPane, BorderLayout.WEST);
		
		//JTextPane textPane = new JTextPane();
		//frame.getContentPane().add(textPane, BorderLayout.EAST);
		//textPane.setPage("http://jp.dk/");
	}

}
