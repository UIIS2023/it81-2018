package commands;

import mvc.Model;
import basicShapes.Shape;

public class CmdUnselect implements Command {
	
	private Model model;
	private Shape selectedShape;
	
	public CmdUnselect(Model model, Shape selectedShape) {
		this.model = model;
		this.selectedShape = selectedShape;
	}

	@Override
	public void execute() {
		model.getbasicShapes().get(model.getbasicShapes().indexOf(selectedShape)).setSelected(false);
		model.getSelectedShapes().remove(selectedShape);
	}

	@Override
	public void unexecute() {
		model.getbasicShapes().get(model.getbasicShapes().indexOf(selectedShape)).setSelected(true);
		model.getSelectedShapes().add(selectedShape);
	}
}
