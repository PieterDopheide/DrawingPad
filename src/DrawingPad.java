import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPad extends JFrame implements ActionListener {
	
	Canvas canvas = new Canvas(this);
	MouseHandler mouseHandler = new MouseHandler(this);
//	Rectangle rectangle = new Rectangle();
//	Circle circle = new Circle();
	Figure figure;
	
	String figureType= "R";
	
	ArrayList<Figure> figures = new ArrayList<Figure>();
	
	public DrawingPad() {
		this.setTitle("Drawing Pad");
		
		getContentPane().add(canvas);
		canvas.addMouseListener(mouseHandler);
		
		JPanel panel = new JPanel();
		
		JButton rectButton = new JButton();
		rectButton.setText("R");
		panel.add(rectButton, BorderLayout.CENTER);
		rectButton.addActionListener(this);
		
		JButton circleButton = new JButton();
		circleButton.setText("C");
		panel.add(circleButton, BorderLayout.EAST);
		circleButton.addActionListener(this);
		
		JButton clearButton = new JButton();
		clearButton.setText("Clear");
		panel.add(clearButton, BorderLayout.WEST);
		clearButton.addActionListener(this);
		
		getContentPane().add(panel, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		DrawingPad drawingPad = new DrawingPad();
		drawingPad.setSize(300, 300);
		drawingPad.setVisible(true);
		drawingPad.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		figureType = arg0.getActionCommand();
		
		switch (figureType) {
			case "Clear":
				figures.clear();
				canvas.repaint();
				System.out.println("clear");
				break;
		}
	}

}
