package mvc;

import java.awt.Graphics;
import java.util.ListIterator;
import javax.swing.JPanel;

import basicShapes.Shape;

public class View extends JPanel {

	private Model model = new Model();

	public View() {

	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}

	
	public void paint(Graphics g) {
		super.paint(g);
		ListIterator<Shape> it = model.getbasicShapes().listIterator();
		while (it.hasNext()) {
			it.next().draw(g);
		}
	}
}
