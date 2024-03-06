package commands;

import mvc.Model;

import basicShapes.Line;

public class CmdLineAdd implements Command {
	
	private Model model;
	private Line line;

	public CmdLineAdd(Model model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.addShape(line);
	}

	@Override
	public void unexecute() {
		model.removeShape(line);
	}
	

	@Override
	public String toString() {
		return "Added->" + line.toString();
	}
}

