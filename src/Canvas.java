import java.awt.Graphics;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	DrawingPad drawingPad;

	public Canvas(DrawingPad drawingPad2) {
		drawingPad = drawingPad2;
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
//		super.paint(arg0);
		
		switch (drawingPad.figureType) {
		case "R":
//			drawingPad.rectangle.draw(arg0);
			drawingPad.figure = new Rectangle();
			break;
		case "C":
//			drawingPad.circle.draw(arg0);
			drawingPad.figure = new Circle();
			break;
		}
		
//		drawingPad.figure.draw(arg0);
		drawingPad.figures.add(drawingPad.figure);
		
		for (Figure fig : drawingPad.figures) {
			fig.draw(arg0);
		}
	}

}
