package commands;

import mvc.Model;
import basicShapes.Circle;

public class CmdCircleRemove implements Command {

	private Model model;
	private Circle circle;

	public CmdCircleRemove(Model model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.removeShape(circle);
	}

	@Override
	public void unexecute() {
		model.addShape(circle);	
	}
}