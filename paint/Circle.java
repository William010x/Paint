package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
/**
 * <h1>Circle object, creates circle using the DRAWABLE COMMAND</h1>
 *
 */

public class Circle extends Drawable{
	private Point centre;
	private int radius;
	private String color;
	private int thickness;
	private boolean outline = true;
	private DrawingOperator  commands = new DrawingOperator();

	public Circle(Point centre, int radius) {
		/**
		 * Constructs a Circle of the specified parameter.
		 * @param centre type Point, the Point where the mouse is clicked, 
		 * @param radius type int,represents the integer of the distance dragged
		 * from the point.
		 */
		
		this.centre = centre;
		this.radius = radius;
	}
	
	/**
	 * 
	 * @return centre of the circle.
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * The attribute centre of the current instance of Circle is set to centre.
	 * @param centre type Point, is set to the new centre(i.e point clicked).
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * 
	 * @return radius of the circle.
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * The attribute radius of the current instance of Circle is set to radius.
	 * @param radius type int,  is set to new radius(i.e point to new location).
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
	 * The attribute color of the current instance of Circle is set to C.
	 * @param C type String, Change the color of the circle to a new color(String)
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
	 * The attribute thickness of the current instance of Circle is set to thickness.
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
	 * The attribute outline of the current instance of Circle is set to outline.
	 * @param outline type Boolean.
	 */
	public void setOutline(boolean outline) {
		this.outline= outline;
	}
	
	/**
	 * 
	 * @param g a canvas object. draws new circle using,
	 *  the Drawable abstract class draw.
	 */
	@Override
	public void draw(GraphicsContext g) {
		int x = this.getCentre().getX();
		int y = this.getCentre().getY();
		
		
		commands.acceptCommand(new ColorCommand(this));
		commands.acceptCommand(new ThicknessCommand(this));
		commands.operateAll(g);
		if (this.outline) {
		g.strokeOval(x-radius, y-radius, radius*2, radius*2);
		}
		else {
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		}

	}
	
	/**
	 * The attribute outline of the current instance of Circle is set to isOutline.
	 * @param isOutline type boolean, set the outline of the circle.
	 */
	@Override
	public void setOutline(Boolean isOutline) {
		this.outline=isOutline;
	}


	

	
	
}
