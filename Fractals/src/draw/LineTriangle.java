package draw;
import java.awt.*;

import javax.swing.JPanel;

public class LineTriangle extends JPanel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	static final int PANEL_H = MyDraw.getWindowh();
	static final int PANEL_W = (MyDraw.getWindoww()-ControlGUI.getControlW());
	private static final int LENGTH = ( (PANEL_W * PANEL_H)/8500 );
	private static final int X = (PANEL_W/2);
	private static final int Y = (PANEL_H/2)-20;
	
	double angel_1, angel_2, increment;
	int numTree, numColor;
	
	public LineTriangle(){
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(PANEL_W, PANEL_H));
	}
	
	public void paintComponent(Graphics g) {

		g.setColor(getBackground());
		g.fillRect(0, 0, PANEL_W, PANEL_H);

		if(numTree == 1){
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
		}else if(numTree == 2){
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 2));
		}else if(numTree == 3){
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 4));
		}else if(numTree == 4){
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (5 * Math.PI));
			drawLineTriangle(g, LENGTH, X, Y, 0);
		}else if(numTree == 5){
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, -(Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, -(3 * Math.PI / 4));
		}else if(numTree == 6){
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (5 * Math.PI));
			drawLineTriangle(g, LENGTH, X, Y, 0);
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, -(Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, -(3 * Math.PI / 4));
		}else if(numTree == 7){
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (5 * Math.PI));
			drawLineTriangle(g, LENGTH, X, Y, 0);
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, -(Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, -(3 * Math.PI / 4));
		}else{
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (5 * Math.PI));
			drawLineTriangle(g, LENGTH, X, Y, 0);
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 2));
			drawLineTriangle(g, LENGTH, X, Y, (Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, -(Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, (3 * Math.PI / 4));
			drawLineTriangle(g, LENGTH, X, Y, -(3 * Math.PI / 4));
		}

	}
	
	public void updateDrawing(){
		
		repaint();

	}
	
	public void drawLineTriangle(Graphics g, int len, int x, int y, double angle){
		
		
		if (len > 4 ) {
			
			Graphics2D g2 = (Graphics2D) g;
			int x2 = (int)Math.round(x + len * Math.cos(angle));
			int y2 = (int)Math.round(y + len * Math.sin(angle));
			
			if(numColor == 1){
				
			}else if(numColor == 2){
				
			}else if(numColor == 3){
				
			}else if(numColor == 4){
				
			}else if(numColor == 5){
				
			}else{
				g2.setColor(Color.getHSBColor(2.76f, 1.0f, 0.48f));
			}

			if (len > 70){
				if(numColor == 0){
				g2.setColor(Color.getHSBColor(2.76f, 1.0f, 0.48f));
				}
				g2.setStroke(new BasicStroke(4));
				increment = 0.6;
			} else if ( len > 40 && len <= 70 ) {
				if(numColor == 0){
				g2.setColor(Color.BLUE);
				}
				g2.setStroke(new BasicStroke(3));
				increment = 0.6;
			} else if ( len > 20 && len <= 40 ) {
				if(numColor == 0){
				g2.setColor(Color.getHSBColor(0.60f, 1.0f, 1.0f));
				}
				g2.setStroke(new BasicStroke(2));
			} else if (len > 15 && len <= 20){
				if(numColor == 0){
				g2.setStroke(new BasicStroke(2));
				}
				g2.setColor(Color.getHSBColor(1.27f, 1.0f, 1.0f));
				increment = 0.7;
			}else if (len > 10 && len <= 17) {
				if(numColor == 0){
				g2.setColor(Color.getHSBColor(0.25f, 0.83f, 1.0f));
				}
				g2.setStroke(new BasicStroke(1));
				increment = 0.8;
			}else{
				if(numColor == 0){
				g2.setColor(Color.red);
				}
				g2.setStroke(new BasicStroke(1));
			}
			g2.drawLine(x, y, x2, y2);

			int newLen = (int)Math.round(len * increment);

			drawLineTriangle(g, newLen, x2, y2, angle + angel_1);
			drawLineTriangle(g, newLen, x2, y2, angle - angel_2);
		}
		
	}
	
	//----------getters and setters----------\\
	
	
	public double getAngel_1() {
		return angel_1;
	}

	public void setAngel_1(double angel_1) {
		this.angel_1 = angel_1;
	}

	public double getAngel_2() {
		return angel_2;
	}

	public void setAngel_2(double angel_2) {
		this.angel_2 = angel_2;
	}
	
		public double getIncrement() {
		return increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}

	public int getNumTree() {
		return numTree;
	}

	public void setNumTree(int numTree) {
		this.numTree = numTree;
	}
	
	
}
