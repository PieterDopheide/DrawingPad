import java.awt.Graphics;

public class Rectangle extends Figure {
	
	@Override
	public void draw(Graphics arg0) {
		System.out.println("Draw a rectangle");
		arg0.drawRect(Math.min(x, x2),Math.min(y, y2),
				(Math.max(x, x2) - Math.min(x, x2)),
				(Math.max(y, y2) - Math.min(y, y2)));
		arg0.setColor(figureColor);
	}

}
