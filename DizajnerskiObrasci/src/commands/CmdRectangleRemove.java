package commands;

import mvc.Model;
import basicShapes.Rectangle;

public class CmdRectangleRemove implements Command {

	private Model model;
	private Rectangle rectangle;

	public CmdRectangleRemove(Model model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.removeShape(rectangle);
	}

	@Override
	public void unexecute() {
		model.addShape(rectangle);	
	}
}