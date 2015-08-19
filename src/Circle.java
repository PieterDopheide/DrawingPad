import java.awt.Graphics;

public class Circle extends Figure {
	
//	int x, y, x2, y2;
	
	public void draw(Graphics arg0) {
		System.out.println("Draw a circle");
//		arg0.drawOval(x, y, x2-x, y2-y);
		arg0.drawOval(Math.min(x, x2),Math.min(y, y2),
				(Math.max(x, x2) - Math.min(x, x2)),
				(Math.max(y, y2) - Math.min(y, y2)));
	}

}
