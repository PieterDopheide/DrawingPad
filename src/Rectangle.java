import java.awt.Graphics;

public class Rectangle extends Figure {
	
//	int x, y, x2, y2;
	@Override
	public void draw(Graphics arg0) {
		System.out.println("Draw a rectangle");
//		arg0.drawRect(x, y, x2-x, y2-y);
		arg0.drawRect(Math.min(x, x2),Math.min(y, y2),
				(Math.max(x, x2) - Math.min(x, x2)),
				(Math.max(y, y2) - Math.min(y, y2)));
	}

}
