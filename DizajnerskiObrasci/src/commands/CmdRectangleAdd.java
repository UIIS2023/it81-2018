package commands;

import mvc.Model;

import basicShapes.Rectangle;

public class CmdRectangleAdd implements Command {
	
	private Model model;
	private Rectangle rectangle;

	public CmdRectangleAdd(Model model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}
	
	@Override
	public void execute() {
		model.addShape(rectangle);
	}

	@Override
	public void unexecute() {
		model.removeShape(rectangle);
	}
	
	@Override
	public String toString() {
		return "Added->" + rectangle.toString();
	}
}
