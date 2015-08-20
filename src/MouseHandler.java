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
		
		switch (drawingPad.figureType) {
		case "Rectangle":
			drawingPad.figure = new Rectangle();
			break;
		case "Circle":
			drawingPad.figure = new Circle();
			break;
		}
		
		if (drawingPad.figure != null) {
			drawingPad.figures.add(drawingPad.figure);
		}
		
		drawingPad.figure.setColor(drawingPad.figureColor);
		drawingPad.figure.setXY(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		super.mouseReleased(e);
		System.out.println("Released");
		
		drawingPad.figure.setX2Y2(e.getX(), e.getY());
		
		drawingPad.canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
//		super.mouseDragged(e);
		System.out.println("Dragged");
		
		drawingPad.figure.setX2Y2(e.getX(), e.getY());
		
		drawingPad.canvas.repaint();
	}

}
