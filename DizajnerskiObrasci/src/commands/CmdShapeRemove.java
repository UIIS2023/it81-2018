package commands;

import mvc.Model;
import basicShapes.Shape;

public class CmdShapeRemove implements Command {

	private Model model;
	private Shape shape;

	public CmdShapeRemove(Model model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		model.removeShape(shape);
		model.getSelectedShapes().remove(shape);
	}

	@Override
	public void unexecute() {
		model.getbasicShapes().add(shape);
	}
	
	@Override
	public String toString() {
		return "Deleted->" + shape.toString();
	}
}