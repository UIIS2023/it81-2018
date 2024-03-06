package commands;

import mvc.Model;

import basicShapes.Point;

public class CmdPointAdd implements Command {
	
	private Model model;
	private Point point;
	
	public CmdPointAdd(Model model, Point point) {
		this.model = model;
		this.point = point;
	}
	
	@Override
	public void execute() {
		model.addShape(point);
	}

	@Override
	public void unexecute() {
		model.removeShape(point);
	}
	
	@Override
	public String toString() {
		return "Added->" + point.toString();
	}
}
