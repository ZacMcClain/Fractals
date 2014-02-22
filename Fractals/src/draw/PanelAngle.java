package draw;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PanelAngle extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 17L;
	
	JTextField angle1Enter, angle2Enter;
	JButton submitAng;
	JLabel titel1, titel2;
	ButtonListener listener;
	LineTriangle lineTri;
	double ang1 = 20*(Math.PI/180), ang2 = 20*(Math.PI/180);
	
	public PanelAngle(LineTriangle lineTri){
		
		this.lineTri = lineTri;
		listener = new ButtonListener();
		titel1 = new JLabel("Change angle one");
		titel2 =new JLabel("Change angle two");
		angle1Enter = new JTextField(10);
		angle2Enter = new JTextField(10);
		submitAng = new JButton("Submit Angle");
		submitAng.addActionListener(listener);
		
		setLayout(new FlowLayout());
		setBorder(new TitledBorder (new EtchedBorder(), "Angle"));
		
		add(titel1);
		add(angle1Enter);
		add(titel2);
		add(angle2Enter);
		add(submitAng);
		
		updateAng();
		
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submitAng){
				try{
					ang1 = ((Double.parseDouble(angle1Enter.getText()))*(Math.PI/180));
					ang2 = ((Double.parseDouble(angle2Enter.getText()))*(Math.PI/180));
					updateAng();
				}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "You must fill in both text fields befor you press 'Submit Angel'");
				}
			}
		}
	}

	private void updateAng(){
		lineTri.setAngel_1(ang1);
		lineTri.setAngel_2(ang2);
		lineTri.updateDrawing();
	}
	
	//----------getters and setters----------\\
	
	public JTextField getAngle1Enter() {
		return angle1Enter;
	}

	public JLabel getTitel() {
		return titel1;
	}

	public JTextField getAngle2Enter() {
		return angle2Enter;
	}

	public void setAngle2Enter(JTextField angle2Enter) {
		this.angle2Enter = angle2Enter;
	}

	
}
