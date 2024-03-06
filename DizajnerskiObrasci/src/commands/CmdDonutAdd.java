package commands;

import mvc.Model;

import basicShapes.Donut;

public class CmdDonutAdd implements Command {
	Model model;
	Donut donut;

	public CmdDonutAdd(Model model, Donut donut) {
		this.model = model;
		this.donut = donut;
	}
	
	@Override
	public void execute() {
		model.addShape(donut);
	}

	@Override
	public void unexecute() {
		model.removeShape(donut);
	}
	@Override
	public String toString() {
		return "Added->" + donut.toString();
	}
	
}

