package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * <h1> An object which every shape inherits from</h1>
 *
 */

public abstract class Drawable {
	
	/**
	 * 
	 * @param g is in instance of a GraphicsContext which a shape draws itself with
	 */
	public abstract void draw(GraphicsContext g);
	/**
	 * 
	 * @return the integer thickness of the outline of a shape
	 */
	public abstract int getThickness();
	/**
	 * 
	 * @return the color of a shape as a string
	 */
	public abstract String getColor();
	/**
	 * 
	 * @param c the color of an object that will be set
	 */
	public abstract void setColor(String c);
	/**
	 * 
	 * @param t the thickness of the outline of a shape that will be set
	 */
	public abstract void setThickness(int t);
	/**
	 * 
	 * @param isOutline a boolean which represent if a shape has an outline
	 */
	public abstract void setOutline(Boolean isOutline);
	/**
	 * 
	 * @return a boolean which represents if a shape has an outline
	 */
	public abstract Boolean isOutline();
	
}
