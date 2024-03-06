package commands;

import java.util.Collections;
import mvc.Model;
import basicShapes.Shape;

public class CmdToFront implements Command {

	private Model model;
	private int index;
	private Shape shape;

	public CmdToFront(Model model, int index, Shape shape) {
		this.model = model;
		this.index = index;
		this.shape = shape;
	}

	@Override
	public void execute() {
		index++;
		if(index!=model.getbasicShapes().size()-1) {
			Collections.swap(model.getbasicShapes(), index+1, index);
		}	
	}

	@Override
	public void unexecute() {
		if(index!=model.getbasicShapes().size()-1) {
			Collections.swap(model.getbasicShapes(), index, index+1);
		}
	}
	@Override
	public String toString() {
		return "Moved to front->" + shape.toString();
	}
	
}