package draw;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MyDraw extends JFrame {
	/**
	 * 
	 */
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final double SCREENW = screenSize.getWidth();
	private static final double SCREENH = screenSize.getHeight();

	private static final long serialVersionUID = 12L;
	static final int WINDOWH = (int)Math.round(SCREENH * 0.95);
	static final int WINDOWW = (int)Math.round(SCREENW  * 0.95);
	
	private LineTriangle lineTri;
	//private Frac frac;
	private ControlGUI control;
	
	public MyDraw(){
		
		setTitle("Fractal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		setSize(WINDOWW, WINDOWH);
		
		lineTri = new LineTriangle();
		control = new ControlGUI(lineTri);
		//frac = new Frac();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
		add(lineTri, BorderLayout.CENTER);
		add(control, BorderLayout.EAST);
	}
	
	// File menu in menu bar.
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createFileNotesItem());
		menu.add(createFileExitItem());
		return menu;
	}
	
	// Menu bar listener.
	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	// GUINotes listener.
	private JMenuItem createFileNotesItem() {
		JMenuItem item = new JMenuItem("Line Fractal");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	//----------getters and setters----------\\
	
	public static Dimension getScreenSize() {
		return screenSize;
	}
	
	public static void setScreenSize(Dimension screenSize) {
		MyDraw.screenSize = screenSize;
	}
	
	public static double getScreenw() {
		return SCREENW;
	}
	
	public static double getScreenh() {
		return SCREENH;
	}
	
	public static int getWindowh() {
		return WINDOWH;
	}
	
	public static int getWindoww() {
		return WINDOWW;
	}
	
	//----------Main----------\\
	
	public static void main(String[] args) {
		MyDraw draw = new MyDraw();
		draw.setForeground(Color.BLACK);
		draw.setVisible(true);
	}
	
}
