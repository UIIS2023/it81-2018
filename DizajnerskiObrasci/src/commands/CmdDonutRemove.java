package commands;

import mvc.Model;
import basicShapes.Donut;

public class CmdDonutRemove implements Command {

	private Model model;
	private Donut donut;

	public CmdDonutRemove(Model model, Donut donut) {
		this.model = model;
		this.donut = donut;
	}

	@Override
	public void execute() {
		model.removeShape(donut);	
	}

	@Override
	public void unexecute() {
		model.addShape(donut);	
	}
}