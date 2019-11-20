package ca.utoronto.utm.paint;

import javafx.scene.control.Button;

public class ColorButton extends Button{
	/**
	 * <h1>Color of Buttons</h1>
	 *
	 */
	
	private String colorStyle;
	
	
	public ColorButton(String colorStyle) {
		/**
		 * Constructs a ColorButton of the specified parameter.
		 * @param colorStyle, represents the color that the button's
		 * background becomes.
		 * 
		 */
		this.setStyle("-fx-background-color: "+colorStyle);
		this.setMinWidth(150);
		
		this.colorStyle = colorStyle;
	}
	
	/**
	 * 
	 * @return the current color of the button.
	 */
	public String getColor() {
		return this.colorStyle;
	}

}
