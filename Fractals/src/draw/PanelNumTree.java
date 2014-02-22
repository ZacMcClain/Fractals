package draw;

import java.awt.FlowLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PanelNumTree extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 91L;
	
	JComboBox<String> numCombo;
	JButton submitInc;
	JLabel titel1;
	ButtonListener listener;
	LineTriangle lineTri;
	int num = 0;
	
	public PanelNumTree(LineTriangle lineTri){
		
		this.lineTri = lineTri;
		listener = new ButtonListener();
		numCombo = new JComboBox<String>();
		numCombo.addItem("Unselected");
		numCombo.addItem("1");
		numCombo.addItem("2");
		numCombo.addItem("3");
		numCombo.addItem("4");
		numCombo.addItem("5");
		numCombo.addItem("6");
		numCombo.addItem("7");
		numCombo.addItem("8");
		submitInc = new JButton("Submit");
		titel1 = new JLabel("Change Number of Trees");
		
		submitInc.addActionListener(listener);
		
		setLayout(new FlowLayout());
		setBorder(new TitledBorder (new EtchedBorder(), "Number of Trees"));
		
		add(titel1);
		add(numCombo);
		add(submitInc);
		
		updateNum();
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submitInc){
				try{
					num = Integer.parseInt(numCombo.getSelectedItem().toString());
				}catch(NumberFormatException e2){
					JOptionPane.showMessageDialog(null, "You must select a number of trees press 'Submit'");
				}
				updateNum();
			}
		}
	}
	
	private void updateNum(){
		lineTri.setNumTree(num);
		lineTri.updateDrawing();
	}
	
}
