package draw;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ControlGUI extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 14L;
	private static final int CONTROL_W = (MyDraw.getWindowh()/4);
	private static final int CONTROL_H = (MyDraw.getWindowh());
	
	PanelAngle anglePanel;
	PanelNumTree incrementPanel;
	
	ControlGUI(LineTriangle lineTri){
		
		anglePanel = new PanelAngle(lineTri);
		incrementPanel = new PanelNumTree(lineTri);
		
		setLayout(new GridLayout(4,0));
		setPreferredSize(new Dimension(CONTROL_W, CONTROL_H));
		setBorder(new TitledBorder (new EtchedBorder(), "Control"));
		
		add(anglePanel);
		add(incrementPanel);
		
	}

	//----------getters and setters----------\\
	
	public static int getControlW() {
		return CONTROL_W;
	}
	
	public static int getControlH() {
		return CONTROL_H;
	}
	
}
