package commands;

import mvc.Model;
import basicShapes.Shape;

public class CmdSelect implements Command {

	private Model model;
	private Shape selectedShape;

	public CmdSelect(Model model, Shape selectedShape) {
		this.model = model;
		this.selectedShape = selectedShape;
	}

	@Override
	public void execute() {
		selectedShape.setSelected(true);
		model.addSelectedShape(selectedShape);
	}

	@Override
	public void unexecute() {
		selectedShape.setSelected(false);
		model.getSelectedShapes().remove(selectedShape);

	}
	
	@Override
	public String toString() {
		return "Selected->" + selectedShape.toString();
	}
}
	


