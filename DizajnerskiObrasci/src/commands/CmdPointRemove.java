package commands;

import mvc.Model;
import basicShapes.Point;

public class CmdPointRemove implements Command {

	private Model model;
	private Point point;

	public CmdPointRemove(Model model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.removeShape(point);	
	}

	@Override
	public void unexecute() {
		model.addShape(point);	
	}
}