package commands;

import mvc.Model;
import basicShapes.Line;

public class CmdLineRemove implements Command {

	private Model model;
	private Line line;

	public CmdLineRemove(Model model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.removeShape(line);	
	}

	@Override
	public void unexecute() {
		model.addShape(line);	
	}
}