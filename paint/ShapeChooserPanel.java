package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
/**
 * 
 * <h1> An instance of a  GridPane for choosing a desired shape</h1>
 *
 */
public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; 
	private Button button;
	private Tooltip tp;

	private Button[] buttons = new Button[6];

	/**
	 * This method also sets up the appearance & layout of the Buttons for the mode of selection
	 * 
	 * @param view an instance of View which will be used to let PaintPanel know which Shape/Mode
	 * is currently chosen
	 */
	public ShapeChooserPanel(View view) {

		this.view = view;
		
		String[][] buttonIcons = { {"Circle", "file:src/ca/utoronto/utm/icons/circle-icon.png" },
				{"Rectangle", "file:src/ca/utoronto/utm/icons/recc.png"},
				{"Square", "file:src/ca/utoronto/utm/icons/square-icon.png"},
				{"Squiggle", "file:src/ca/utoronto/utm/icons/squiggle-icon.png.png"},


				{"Polyline", "file:src/ca/utoronto/utm/icons/polyline-icon.png"}, 
				{"Eraser", "file:src/ca/utoronto/utm/icons/Eraser-icon.png"}};



		int row = 0;
		for (String[] icon : buttonIcons) {
			button = new Button();
			tp = new Tooltip(icon[0]);
			button.setMinSize(75, 50);
			button.setGraphic(new ImageView(icon[1]));
			button.setStyle("-fx-background-color: #02396c; -fx-border-color: black");
			tp.setStyle("-fx-background-color: green; -fx-border-color: black");
			button.setId(icon[0]);
			button.setTooltip(tp);
			buttons[row] = button;
			if (row < 3) {
				this.add(button, 0, row);
			}
			else {
				this.add(button, 1, row-3);

			}
			row++;
			button.setOnAction(this);
		}
	}
	
	/**
	 * Handles the events in where a mode of selection, such as any shape or eraser is selected.
	 * This handles the events by selecting the button chosen, and deselecting all the other buttons
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getId();
		Button source = (Button)event.getSource();

		for (int i = 0; i < 6; i++) {

			this.buttons[i].setStyle("-fx-background-color: #02396c; -fx-border-color: black");
		}
		source.setStyle("-fx-background-color: green; -fx-border-color: powderblue");
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
	}
}
