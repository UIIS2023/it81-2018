package commands;

import adapter.HexagonAdapter;

import mvc.Model;

public class CmdHexagonAdd implements Command {
	
	private Model model;
	HexagonAdapter hexagon;

	public CmdHexagonAdd(Model model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;
	}

	@Override
	public void execute() {
		model.addShape(hexagon);
	}

	@Override
	public void unexecute() {
		model.removeShape(hexagon);
	}
	
	@Override
	public String toString() {
		return "Added->"+hexagon.toString();
	}
}
