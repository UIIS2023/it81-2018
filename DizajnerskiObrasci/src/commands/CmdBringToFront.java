package commands;

import mvc.Model;
import basicShapes.Shape;

public class CmdBringToFront implements Command {

	private Model model;
	private int beforeIndex;
	private Shape shape;

	public CmdBringToFront(Model model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		beforeIndex=model.getIndexOfShape(shape);
		model.getbasicShapes().remove(shape);
		model.getbasicShapes().add(shape);
	}

	@Override
	public void unexecute() {
		model.getbasicShapes().remove(shape);
		model.getbasicShapes().add(beforeIndex, shape);
	}
	
	@Override
	public String toString() {
		return "Brought to front->" + shape.toString();
	}
	
}