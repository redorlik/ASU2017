package dk.au.ase.asu.animation.swing;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class AnimationBackground {

    public AnimationBackground() {
        Random random = new Random();
        JFrame frame = new JFrame("Animation Background");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(0, 1, 10, 10));
        //frame.setLayout(new GridLayout(0, 3, 10, 10));
        //for (int iPanels = 0; iPanels < 3; iPanels++) {
        for (int iPanels = 0; iPanels < 1; iPanels++) {
            final MyJPanel panel = new MyJPanel();
            panel.setBackground(Color.BLACK);
            for (int i = 0; i < 50; i++) {
                Star star = new Star(new Point(random.nextInt(490), random.nextInt(490)));
                star.setColor(new Color(100 + random.nextInt(155), 100 + random.nextInt(155), 100 + random.nextInt(155)));
                star.setxIncr(-4 + random.nextInt(7));
                star.setyIncr(-5 + random.nextInt(7));
                panel.add(star);
            }
            panel.setLayout(new GridLayout(10, 1));
            JLabel label = new JLabel("This is a Starry background.", JLabel.CENTER);
            label.setForeground(Color.WHITE);
            panel.add(label);
            JPanel stopPanel = new JPanel();
            stopPanel.setOpaque(false);
            stopPanel.add(new JButton(new AbstractAction("Stop this madness!!") {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.stopAnimation();
                }
            }));
            panel.add(stopPanel);
            JPanel startPanel = new JPanel();
            startPanel.setOpaque(false);
            startPanel.add(new JButton(new AbstractAction("Start moving...") {

                private static final long serialVersionUID = 1L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.startAnimation();
                }
            }));
            panel.add(startPanel);
            frame.add(panel);
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                AnimationBackground animationBackground = new AnimationBackground();
                
            }
        });
    }

    class Star extends Polygon {

        private static final long serialVersionUID = 1L;
        private Point location = null;
        private Color color = Color.YELLOW;
        private int xIncr, yIncr;
        static final int WIDTH = 500, HEIGHT = 500;

        Star(Point location) {
            int x = location.x;
            int y = location.y;
            this.location = location;
            this.addPoint(x, y + 8);
            this.addPoint(x + 8, y + 8);
            this.addPoint(x + 11, y);
            this.addPoint(x + 14, y + 8);
            this.addPoint(x + 22, y + 8);
            this.addPoint(x + 17, y + 12);
            this.addPoint(x + 21, y + 20);
            this.addPoint(x + 11, y + 14);
            this.addPoint(x + 3, y + 20);
            this.addPoint(x + 6, y + 12);
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void move() {
            if (location.x < 0 || location.x > WIDTH) {
                xIncr = -xIncr;
            }
            if (location.y < 0 || location.y > WIDTH) {
                yIncr = -yIncr;
            }
            translate(xIncr, yIncr);
            location.setLocation(location.x + xIncr, location.y + yIncr);
        }

        public void setxIncr(int xIncr) {
            this.xIncr = xIncr;
        }

        public void setyIncr(int yIncr) {
            this.yIncr = yIncr;
        }

        public Color getColor() {
            return color;   
        }
        
        public void collide(Star star2){
        	int xTemp = xIncr;
        	int yTemp = yIncr;
        	xIncr = star2.xIncr;
        	yIncr = star2.yIncr;
        	star2.xIncr = xTemp;
        	star2.yIncr = yTemp;
        }
    }

    class MyJPanel extends JPanel {

        private static final long serialVersionUID = 1L;
        private ArrayList<Star> stars = new ArrayList<Star>();
        private Timer timer = new Timer(30, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Star star : stars) {
                    star.move();
                }
                repaint();
                for(int i=0; i<stars.size();i ++){
                	for(int j=i+1; j<stars.size(); j++){
                		if(stars.get(i).location.distance(stars.get(j).location) < 20)
                		stars.get(i).collide(stars.get(j));
                	}
                }
            }
        });

        public void stopAnimation() {
            if (timer.isRunning()) {
                timer.stop();
            }
        }

        public void startAnimation() {
            if (!timer.isRunning()) {
                timer.start();
            }
        }

        @Override
        public void addNotify() {
            super.addNotify();
            timer.start();
        }

        @Override
        public void removeNotify() {
            super.removeNotify();
            timer.stop();
        }

        MyJPanel() {
            this.setPreferredSize(new Dimension(520, 520));
        }

        public void add(Star star) {
            stars.add(star);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            for (Star star : stars) {
                g.setColor(star.getColor());
                g.fillPolygon(star);
            }
        }
    }
}