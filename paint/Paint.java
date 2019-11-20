package ca.utoronto.utm.paint;

import javafx.application.Application;
import javafx.stage.Stage;

public class Paint extends Application {

	PaintModel model; 
	View view; 
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * represents controller for MVC style design pattern.
	 * @param stage of type Stage, run the PaintModel and View
	 */
	@Override
	public void start(Stage stage) throws Exception {
		
		this.model = new PaintModel();
		
		
		this.view = new View(model, stage);
		stage.setResizable(false);
	}
}
