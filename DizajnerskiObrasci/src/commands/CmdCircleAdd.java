package commands;

import mvc.Model;
import basicShapes.Circle;

public class CmdCircleAdd implements Command {
	
	Model model;
	Circle circle;

	public CmdCircleAdd(Model model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.addShape(circle);
	}

	@Override
	public void unexecute() {
		model.removeShape(circle);
	}
	
	@Override
	public String toString() {
		return "Added->"+circle.toString();
	}
	
}
