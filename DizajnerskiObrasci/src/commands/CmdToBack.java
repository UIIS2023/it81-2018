package commands;

import java.util.Collections;
import mvc.Model;
import basicShapes.Shape;

public class CmdToBack implements Command {

	private Model model;
	private int index;
	private Shape shape;

	public CmdToBack(Model model, int index, Shape shape) {
		this.model = model;
		this.index = index;
		this.shape = shape;
	}

	@Override
	public void execute() {
		if(index!=0) { 
			Collections.swap(model.getbasicShapes(), index-1, index);
		}	
	}

	@Override
	public void unexecute() {
		index++;
		if(index!=0) {
			Collections.swap(model.getbasicShapes(), index, index-1);
		}
	}
	
	@Override
	public String toString() {
		return "Moved to back->" + shape.toString();
	}
}
