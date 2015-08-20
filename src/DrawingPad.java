import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DrawingPad extends JFrame implements ActionListener {
	
	Canvas canvas = new Canvas(this);
	MouseHandler mouseHandler = new MouseHandler(this);
	Figure figure = null;
	String figureType= "Rectangle";
	ArrayList<Figure> figures = new ArrayList<Figure>();
	
	public DrawingPad() {
		this.setTitle("Drawing Pad");
		
		getContentPane().add(canvas);
		canvas.addMouseListener(mouseHandler);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu figures = new JMenu("Figures");
		JMenu color = new JMenu("Color");
		menuBar.add(file);
		menuBar.add(figures);
		menuBar.add(color);
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenuItem clearItem = new JMenuItem("Clear");
		clearItem.addActionListener(this);
		menuBar.add(clearItem);

		JMenuItem saveItem = new JMenuItem("Save");
//		saveItem.setAccelerator(KeyStroke.getKeyStroke(
//		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		file.add(saveItem);
		
		JMenuItem openItem = new JMenuItem("Open");
		file.add(openItem);
		
		JMenuItem rectItem = new JMenuItem("Rectangle");
		rectItem.addActionListener(this);
		figures.add(rectItem);
		JMenuItem circleItem = new JMenuItem("Circle");
		circleItem.addActionListener(this);
		figures.add(circleItem);
	}

	public static void main(String[] args) {
		DrawingPad drawingPad = new DrawingPad();
		drawingPad.setSize(800, 600);
		drawingPad.setVisible(true);
		drawingPad.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (arg0.getActionCommand()) {
			case "Clear":
				figure = null;
				figures.clear();
				canvas.repaint();
				System.out.println("clear");
				break;
			default:
				figureType = arg0.getActionCommand();
				break;
		}
	}

}
