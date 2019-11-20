package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * <h1>ColorButonPanel where the actual buttons with colors are created.</h1>
 *
 */
public class ColorButtonPanel extends GridPane implements EventHandler<ActionEvent>{
	private ColorButton[] colorButtons = new ColorButton[12];
	private String currentColor;
	private ColorButton button;
	private View view;
	
	static String colors [][] = {{"white","#ff0000","#ffa500","#ffff00", "#000000"}, {"#008000","#0000ff","#800080", "#797069", "wheat"},
			{"#FF3E96", "#EE4000", "#7171C6", "#71C671", "#003300"}}; 
					
	public ColorButtonPanel(View view) {
		/**
		 * Constructs Buttons with the given colors.
		 * @param view type View, where the class is implemented
		 * 
		 */
		this.view = view;
		int row = 0;
		int col = 0;
		for (String[] c: colors) {
			for (String s : c) {
				ColorButton b = new ColorButton(s);
				b.setMinWidth(30);
				colorButtons[row] = b;
				b.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
				this.add(b, col, row);
				col++;
				b.setOnAction(this);
			}
			row++;
			col *= 0;
		}
		
		currentColor = colors[0][0];
		button = colorButtons[0];
		button.setDisable(true);
	}
	
	/**
	 * 
	 * @return return the nested arrays of colors,
	 * representing the row, and columns of the colors in grid form.
	 */
	public static String[][] getColors() {
		return colors;
	}
	
	/**
	 * 
	 * @return the current button selected.
	 */
	public ColorButton getSelected() {
		return button;
		
	}
	
	/**
	 * 
	 * control the action of what the particular button selected done.
	 */
	@Override
	public void handle(ActionEvent event) {
		ColorButton source = (ColorButton)event.getSource();
		source.setDisable(true);
		currentColor = source.getColor();
		button.setDisable(false);
		button = source;
		this.view.getPaintPanel().setColorMode(currentColor);
		
		
	}



}
