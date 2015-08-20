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
		System.out.println("###" + drawingPad.figureType);
		
		switch (drawingPad.figureType) {
		case "Rectangle":
			drawingPad.figure = new Rectangle();
			break;
		case "Circle":
			drawingPad.figure = new Circle();
			break;
		}
		
		drawingPad.figure.setXY(e.getX(), e.getY());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		drawingPad.figure.x2 = e.getX();
		drawingPad.figure.y2 = e.getY();
		
		drawingPad.canvas.repaint();
	};

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		super.mouseReleased(e);
		System.out.println("Released");
		
		drawingPad.figure.setX2Y2(e.getX(), e.getY());
		
		drawingPad.figure.setColor(drawingPad.figureColor);
		
		if (drawingPad.figure != null) {
			drawingPad.figures.add(drawingPad.figure);
		}
		
		drawingPad.canvas.repaint();
	}

}
