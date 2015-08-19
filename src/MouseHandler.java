import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
	DrawingPad drawingPad;

	public MouseHandler(DrawingPad drawingPad2) {
		drawingPad = drawingPad2;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		super.mousePressed(e);
		System.out.println("Pressed");
//		drawingPad.rectangle.x = e.getX();
//		drawingPad.rectangle.y = e.getY();
//		
//		drawingPad.circle.x = e.getX();
//		drawingPad.circle.y = e.getY();
		
		drawingPad.figure.x = e.getX();
		drawingPad.figure.y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		super.mouseReleased(e);
		System.out.println("Released");
//		drawingPad.rectangle.x2 = e.getX();
//		drawingPad.rectangle.y2 = e.getY();
//		
//		drawingPad.circle.x2 = e.getX();
//		drawingPad.circle.y2 = e.getY();
		
		drawingPad.figure.x2 = e.getX();
		drawingPad.figure.y2 = e.getY();
		
		drawingPad.canvas.repaint();
	}

}
