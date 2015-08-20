import java.awt.Graphics;

public class Circle extends Figure {
	
	public void draw(Graphics arg0) {
		System.out.println("Draw a circle");
		
		arg0.setColor(figureColor);
		
		arg0.drawOval(Math.min(x, x2),Math.min(y, y2),
				(Math.max(x, x2) - Math.min(x, x2)),
				(Math.max(y, y2) - Math.min(y, y2)));
	}

}
