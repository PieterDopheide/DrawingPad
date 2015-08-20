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
		
		if (!drawingPad.figures.isEmpty()) {
			for (Figure fig : drawingPad.figures) {
				fig.draw(arg0);
			}
		}
	}

}
