package ca.utoronto.utm.paint;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
* <h1>Thickness Panel</h1>
*
*
*/


public class ThicknessPanel extends GridPane implements ChangeListener<Number> {

	private View view; // So we can talk to our parent or other components of the view
	private Slider slider;
	private GridPane pane;
	private GridPane subPane;
	
	public ThicknessPanel(View view) {
		/**
		 * Constructs a ToolsPanel in the view class.
		 * @param view type View.
		 */

		this.view = view;

		Label label = new Label("Thickness:");
		label.setTextFill(Color.BLACK);
		
		slider = new Slider();
		slider.setMin(1);
		slider.setMax(10);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(1);
		slider.setMinorTickCount(0);
		slider.setBlockIncrement(1);
		slider.setSnapToTicks(true);
		slider.valueProperty().addListener(this);
		

		pane = new GridPane();
		pane.setMinSize(150, 50);
		pane.setStyle("-fx-background-color: #02396c; -fx-border-color: black");
		subPane = new GridPane();
		subPane.setMinSize(149, 50);
		subPane.paddingProperty();
		subPane.setStyle("-fx-background-color: white; -fx-border-color: black");
		subPane.setPadding(new Insets(3));
		
		subPane.add(label, 0, 0);
		subPane.add(slider, 0, 1);
		
		pane.add(subPane, 1, 1);
		this.add(pane, 0, 1);
	}
	
	/**
	 * 
	 * @param observable
	 * @param oldValue
	 * @param newValue
	 */
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		this.view.getPaintPanel().setThickness((int)this.slider.getValue());
	}

	
}
