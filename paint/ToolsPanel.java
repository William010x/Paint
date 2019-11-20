package ca.utoronto.utm.paint;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

/**
 * <h1>Circle object, creates circle using the DRAWABLE COMMAND</h1>
 * @author ayoolate
 *
 */

public class ToolsPanel extends GridPane implements EventHandler<ActionEvent>{
	private View view;
	private GridPane pane;
	private GridPane subPane;
	private Label infoLabel;
	private Label infoVals;
	private Label getId;
	private Tooltip tp;
	private Button[] buttons = new Button[2];
	private Button btn;
	
	/**
	 * Constructs a ToolsPanel in the view class.
	 * @param view type view.
	 */
	public ToolsPanel(View view) {
		this.view = view;
		pane = new GridPane();
		pane.setMinSize(150, 50);
		pane.setStyle("-fx-background-color: #02396c; -fx-border-color: black");
		subPane = new GridPane();
		subPane.setMinSize(149, 50);
		subPane.paddingProperty();
		this.infoLabel = new Label();
		this.infoVals = new Label();
		this.getId = new Label();
		if (view.getPaintPanel().getStrokeText() != null) {
			infoLabel.setText("Point Value: " + view.getPaintPanel().getStrokeText());
		}
		else {
			infoLabel.setText("Point Value: 0");
		}
		infoVals.setText("X: , Y: ");
		getId.setText("None");
		subPane.add(infoLabel, 0, 0);
		subPane.add(infoVals, 0, 1);
		subPane.add(getId, 0, 2);
		subPane.setStyle("-fx-background-color: white; -fx-border-color: black");
		subPane.setPadding(new Insets(3));
		pane.add(subPane, 1, 1);
		this.add(pane, 0, 1);
	}
	
	/**
	 * 
	 * @param pointValue type String,
	 * set the information of the points made on the canvas.
	 */
	public void setInfoLabel(String pointValue) {
		this.infoLabel.setText("Point Value: " + pointValue);
	}
	
	/**
	 * 
	 * @param idObject type String,
	 * set what current object is drawn on the canvas;
	 *  eg("Circle", when circle is drawn)
	 */
	public void setGetId(String idObject) { //mode or shape chosen
		this.getId.setText(idObject);
	}
	
	/**
	 * 
	 * @param x type int, point of the x axis.
	 * @param y type int, point of the y axis.
	 * Set the information view to show
	 * the current mouse location on the canvas.
	 */
	public void setInfoVals(int x, int y) {
		String val = "X: "+ x +" "+"Y: " + y;
		this.infoVals.setText(val);
	}
	
	
	/**
	 * 
	 * control the action of what the particular button selected done.
	 */
	@Override
	public void handle(ActionEvent event) {
		String id = ((Button)event.getSource()).getId();
		Button source = (Button)event.getSource();
		this.view.getPaintPanel().setMode(id);
		
	}
	

}
