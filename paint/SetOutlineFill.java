package ca.utoronto.utm.paint;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * <h1>The model for the deciding whether or not an object will be filled or outlined</h1>
 *
 */

public class SetOutlineFill extends GridPane implements EventHandler{
	private Button [] b = new Button[2];
	private static final String buttonColor = "-fx-background-color: #02396c";
	private Button buttonSelected;
	private View view;
	
	public SetOutlineFill(View view) {
		/**
		 * Constructs a instance of a GridePane which contains the buttons for outlining and filling
		 * @param view is of type View, and is to connect PaintPanel with this GridPane
		 */
		this.view = view;
		Button outline = new Button(); Button fill = new Button();
		this.b[0] = outline; this.b[1] = fill;
		outline.setText("Outline"); fill.setText("Fill");
		
		int row = 0;
		for (Button button: this.b) {
			button.setMinWidth(150);
			button.setStyle(buttonColor);
			button.setTextFill(Color.WHITE);
			button.setOnAction(this);
			this.add(button, 0, row);
			row++;
		}
		buttonSelected = outline;
		buttonSelected.setDisable(true);

	}
	
	/**
	 * 
	 * @return true iff the current mode is "Outline"
	 */
	public boolean isOutline() {
		if (this.buttonSelected.getText()=="Outline") {
			return true;
		}
		return false;
	}
		
		

	/**
	 * handle updates the current button selected, and disables the one that was last selcted. Then
	 * PaintPanel gets notified about this.
	 */
	@Override
	public void handle(Event event) {
		Button source = (Button)event.getSource();
		if (source.getText()!=this.buttonSelected.getText()) {
			this.buttonSelected.setDisable(false);
			this.buttonSelected = source;
			this.buttonSelected.setDisable(true);
			System.out.println(this.isOutline());
			this.view.getPaintPanel().setOutline(isOutline());
			
			
		}
	}

}
