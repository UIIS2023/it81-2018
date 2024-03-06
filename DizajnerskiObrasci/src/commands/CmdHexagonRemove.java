package commands;

import adapter.HexagonAdapter;
import mvc.Model;

public class CmdHexagonRemove implements Command {

	private Model model;
	private HexagonAdapter hexagon;

	public CmdHexagonRemove(Model model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;
	}

	@Override
	public void execute() {
		model.removeShape(hexagon);
	}

	@Override
	public void unexecute() {
		model.addShape(hexagon);	
	}
}