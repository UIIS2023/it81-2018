package commands;

import mvc.Model;
import basicShapes.Shape;

public class CmdBringToBack implements Command {

	private Model model;
	private int index;
	private Shape shape;

	public CmdBringToBack(Model model, int index, Shape shape) {
		this.model = model;
		this.index = index;
		this.shape = shape;
	}

	@Override
	public void execute() {
		if(index != 0) {
			model.getbasicShapes().remove(shape);
			model.getbasicShapes().add(0, shape);
		}
	}

	@Override
	public void unexecute() {
		model.getbasicShapes().remove(shape);
		model.getbasicShapes().add(index, shape);
	}
	
	@Override
	public String toString() {
		return "Brought to back->" + shape.toString();
	}
	
}

