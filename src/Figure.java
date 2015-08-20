import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	
	protected int x, y, x2, y2;
	protected Color figureColor;

	public abstract void draw(Graphics arg0);
	
	public void setXY(int setX, int setY) {
		x = setX;
		y = setY;
	}
	
	public void setX2Y2(int setX2, int setY2) {
		x2 = setX2;
		y2 = setY2;
	}
	
	public void setColor(Color figCol) {
		figureColor = figCol;
	}
	
}
