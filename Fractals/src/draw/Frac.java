package draw;
import java.awt.*;

public class Frac {
	
	Color[] cols = new Color[250];
	
	public Color[] generateColors(int n){
		for(int i = 0; i < n; i++)
		{
			cols[i] = Color.getHSBColor((float) i / (float) n, 0.85f, 1.0f);
		}
		return cols;
	}

	public void drawFrac(Graphics g, int size, int x, int y, double ang, int c){
	
		generateColors(250);
		
		int newSize, x2, y2;
		
		if (size > 6 ) {

			Graphics2D g2 = (Graphics2D) g;
			
			g2.setColor(cols[c]);
			g2.fillOval(x - 20, y - 20, size, size);
	
			
			if (size >= 80){
			
				x2 = (int)Math.round(x - ((size * 0.80) * Math.cos(ang)));
				y2 = (int)Math.round(y - ((size * 0.90) * Math.sin(ang)));
				newSize = (int)Math.round(size * 0.65);
				ang += (Math.PI / 3);
				
			}else if ( size < 80 && size > 45 ){
				
				x2 = (int)Math.round(x - ((size * 1.2) * Math.cos(ang)));
				y2 = (int)Math.round(y - ((size * 1.2) * Math.sin(ang)));
				newSize = (int)Math.round(size * 0.7);
				ang += (Math.PI / 4);
				
			}else{
				
				x2 = (int)Math.round(x - ((size * 1.3) * Math.cos(ang)));
				y2 = (int)Math.round(y - ((size * 1.3) * Math.sin(ang)));
				newSize = (int)Math.round(size * 0.7);
				ang += (Math.PI / 6);
				
			}
			
			g2.fillOval(x - 20, y - 20, size, size);
			c+=25;
			
			drawFrac(g, newSize, x2, y2, ang, c);
		
		}
		
	}
	
}
