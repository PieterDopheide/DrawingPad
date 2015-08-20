import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DrawingPad extends JFrame implements ActionListener {
	
	Canvas canvas = new Canvas(this);
	MouseHandler mouseHandler = new MouseHandler(this);
	Figure figure = null;
	Color figureColor;
	String figureType= "Rectangle";
	ArrayList<Figure> figures = new ArrayList<Figure>();
	
	public DrawingPad() {
		this.setTitle("Drawing Pad");
		
		getContentPane().add(canvas);
		canvas.addMouseListener(mouseHandler);
		canvas.addMouseMotionListener(mouseHandler);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu figures = new JMenu("Figures");
		menuBar.add(file);
		menuBar.add(figures);
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenuItem clearItem = new JMenuItem("Clear");
		clearItem.addActionListener(this);
		menuBar.add(clearItem);
		
		JMenuItem colorItem = new JMenuItem("Color");
		colorItem.addActionListener(this);
		menuBar.add(colorItem);

		JMenuItem saveItem = new JMenuItem("Save");
//		saveItem.setAccelerator(KeyStroke.getKeyStroke(
//		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		saveItem.addActionListener(this);
		file.add(saveItem);
		
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(this);
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
			case "Color":
				figureColor = JColorChooser.showDialog(null, "JColorChooser Sample", null);
				break;
			case "Save":
				String outFile = showFileDialog("save");
				saveFigures(outFile);
				break;
			case "Open":
				String inFile = showFileDialog("load");
				openFigures(inFile);
				break;
			default:
				figureType = arg0.getActionCommand();
				break;
		}
	}
	
	private void saveFigures(String filePath) {
		try {
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(figures);
			fout.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void openFigures(String filePath) {
		try {
			FileInputStream fins = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fins);
			figures = (ArrayList<Figure>) ois.readObject();
			fins.close();
			ois.close();
			canvas.repaint();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String showFileDialog(String operation) {
		String filePath = null;
		FileDialog fd = null;
		
		if (operation.equals("save")) {
			fd = new FileDialog(this, "Choose a file", FileDialog.SAVE);
		}
		else if (operation.equals("load")) {
			fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
		}
		fd.setDirectory("C:\\");
		fd.setFile("*.ser");
		fd.setVisible(true);
		filePath = fd.getFile();
		if (filePath == null)
			System.out.println("You cancelled the choice");
		else
			System.out.println("You chose " + filePath);
		
		return filePath;
	}

}
