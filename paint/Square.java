package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * <h1>Square object, creates square using the DRAWABLE COMMAND</h1>
 *
 */

public class Square extends Drawable{
	
	private Point centre;
	private int radius;
	private String color;
	private int thickness;
	private boolean outline = true;
	private DrawingOperator  commands = new DrawingOperator();

	public Square(Point centre, int radius) {
		/**
		 * Constructs a Square of the specified parameter.
		 * @param centre the Point where the mouse is clicked, Radius
		 * represents the integer of the distance dragged from the point.
		 */
		this.centre = centre;
		this.radius = radius;
	}

	/**
	 * 
	 * @return centre of the square.
	 */
	public Point getCentre() {
		return centre;
	}
	/**
	 * 
	 * @param centre is set to the new centre(i.e point clicked).
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	/**
	 * 
	 * @return radius of the square.
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * 
	 * @param radius is set to new radius(i.e point to new location).
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	/**
	 * 
	 * @return current color of Circle.
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * 
	 * @param C, Change the color of the circle to a new color(String)
	 */
	public void setColor(String c) {
		this.color=c;
	}
	/**
	 * 
	 * @return the thickness of the circle.
	 */
	public int getThickness() {
		return this.thickness;
	}
	/**
	 * 
	 * @param thickness, changes the thickness of the circle (integer).
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	/**
	 * 
	 * @return True if the outline button is clicked, false otherwise.
	 */
	public Boolean isOutline() {
		return this.outline;
	}
	/**
	 * 
	 * @param g a canvas object. draws new square using,
	 *  the Drawable abstract class draw.
	 */
	public void draw(GraphicsContext g) {
		int x = this.getCentre().getX();
		int y = this.getCentre().getY();
		
		commands.acceptCommand(new ColorCommand(this));
		commands.acceptCommand(new ThicknessCommand(this));
		commands.operateAll(g);
		
		if (this.outline) {
			g.strokeRect(x-this.radius, y-this.radius, radius*2, radius*2);
		}
		else {
			g.fillRect(x-this.radius, y-this.radius, radius*2, radius*2);
		}
				
	}
	/**
	 * 
	 * @param isOutline set the outline of the square.
	 */
	@Override
	public void setOutline(Boolean isOutline) {
		// TODO Auto-generated method stub
		this.outline=isOutline;
	}


}
