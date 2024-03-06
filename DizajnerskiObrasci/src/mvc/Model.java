package mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import commands.Command;
import basicShapes.Point;
import basicShapes.Shape;

public class Model {

	private List<Shape> basicShapes = new ArrayList<Shape>();
	private List<Shape> selectedShapes = new ArrayList<Shape>();
	
	private Stack<Command> undoStack = new Stack<>();
	private Stack<Command> redoStack = new Stack<>();
	
	private Point startPoint;
	
	private PropertyChangeSupport propertyChangeSupport;

	public Model() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
	}

	public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
	}
	
	public Stack<Command> getRedoStack() {
		return redoStack;
	}

	public void setRedoStack(Stack<Command> redoStack) {
		this.redoStack = redoStack;
	}

	public Stack<Command> getUndoStack() {
		return undoStack;
	}

	public void setUndoStack(Stack<Command> undoStack) {
		this.undoStack = undoStack;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public List<Shape> getbasicShapes() {
		return basicShapes;
	}

	public void setbasicShapes(List<Shape> basicShapes) {
		this.basicShapes = basicShapes;
	}
	
	public List<Shape> getSelectedShapes() {
		return selectedShapes;
	}

	public void setSelectedShapes(List<Shape> selectedShapes) {
		this.selectedShapes = selectedShapes;
	}

	public Shape getByIndex(int index) {
		return basicShapes.get(index);
	}

	public ArrayList<Shape> getAllShapes() {
		return (ArrayList<Shape>) basicShapes;
	}

	public void addShape(Shape toBeAdded)
	{
		basicShapes.add(toBeAdded);
	}
	
	public void addMultipleShapes(ArrayList<Shape> shapes) {
		this.basicShapes.addAll(shapes);
	}

	public void removeShape(Shape toBeRemoved) {
		int selectedShapesSizeBefore = selectedShapes.size();
		if(basicShapes.remove(toBeRemoved) == false) {
			System.out.println("Shape does not exist in list of shapes!");
		}

		selectedShapes.remove(toBeRemoved);
		propertyChangeSupport.firePropertyChange("Deleted Shapes", selectedShapesSizeBefore, selectedShapes.size());
	}

	public void addSelectedShape(Shape toBeAdded) {
		int selectedShapesSizeBefore = selectedShapes.size();
		selectedShapes.add(toBeAdded);
		System.out.println(basicShapes.get(0).isSelected());
		propertyChangeSupport.firePropertyChange("Selected Shapes", selectedShapesSizeBefore, selectedShapes.size());
	}
	public void removeSelectedShape(Shape toBeRemoved) {
		int index = basicShapes.indexOf(toBeRemoved);
		basicShapes.get(index).setSelected(false);
		selectedShapes.remove(toBeRemoved);
	}

	public void pushToUndoStack(Command toBePushed) {
		int undoStackSizeBefore = undoStack.size();
		this.undoStack.push(toBePushed);
		propertyChangeSupport.firePropertyChange("Undo Stack", undoStackSizeBefore, undoStack.size());
	}

	public void removeFromUndoStack() {
		int undoStackSizeBefore = undoStack.size();
		if(undoStack.peek()!=null) {
			this.undoStack.pop().unexecute();
		}
		propertyChangeSupport.firePropertyChange("Undo Stack Remove", undoStackSizeBefore, undoStack.size());
	}

	public void pushToRedoStack(Command toBePushed) {
		int redoStackSizeBefore = redoStack.size();
		this.redoStack.push(toBePushed);
		propertyChangeSupport.firePropertyChange("Redo Stack", redoStackSizeBefore, redoStack.size());
	}

	public void removeFromRedoStack() {
		int redoStackSizeBefore = redoStack.size();
		if(redoStack.peek()!=null) {
			this.redoStack.pop().execute();
		}
		propertyChangeSupport.firePropertyChange("Redo Stack Remove", redoStackSizeBefore, redoStack.size());
	}
	public int getIndexOfShape(Shape s) {
		int listSize = basicShapes.size() - 1;

		for (int i = 0; i <= listSize; i++) {
			if (basicShapes.get(i).equals(s)) {

				return i;
			}
		}
		return -1;
	}
} 
