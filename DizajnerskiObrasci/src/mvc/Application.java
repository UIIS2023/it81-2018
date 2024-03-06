package mvc;

import javax.swing.JFrame;

public class Application {

	public static void main(String[] args) {
		
		Model model = new Model();
		Frame frame = new Frame();
		Controller controller = new Controller(model, frame);
		frame.getView().setModel(model);
		frame.setController(controller);
		model.addPropertyChangeListener(controller);
		frame.setSize(900,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
