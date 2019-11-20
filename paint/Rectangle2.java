package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * @author Administrator
 * Rectangle2 object, creates rectangles using the DRAWABLE COMMAND
 */
public class Rectangle2 extends Drawable {
	private Point topleft;
	private Point botright;
	private int width;
	private String color;
	private int height;
	private int thickness;
	private boolean outline = true;
	private DrawingOperator  commands = new DrawingOperator();
	
	
	/**
	 * Constructs a Rectangle of the specified parameters
	 * @param topleft represents the initial Point the user clicks
	 * @param height an integer that represents the height of the rectangle
	 * @param width an integer that represents the width of the rectangle
	 * @param botright Represents the latest Point that the users cursor is on, usually
	 * the bottom right corner of the rectangle
	 */
	public Rectangle2(Point topleft, int height, int width, Point botright) {
		this.topleft = topleft;
		this.height = height;
		this.width = width;
	}

	/**
	 * The topleft attribute of the current instance of Rectangle2 is set to tl
	 *@param tl a Point representing the first point clicked on panel for Rectangle
	 *mode
	 *
	 */
	public void settopleft(Point tl) {
		this.topleft = tl;
	}
	
	/**
	 * 
	 *@return returns the topleft attribute of the current Rectangle2 instance
	 */
	public Point gettopleft() {
		return this.topleft;
	}
	
	/**
	 * The botright attribute of the current instance of Rectangle2 is set to br
	 *@param br a Point representing the latest point clicked on panel for Rectangle
	 *mode
	 *
	 */
	public void setbotright(Point br) {
		this.botright = br;
	}
	/**
	 * 
	 * 
	 * @return returns a Point representing the botright attribute of the current
	 * Rectangle2 instance
	 */
	public Point getbotright() {
		return this.botright;
	}
	
	/**
	 * 
	 * 
	 * @return returns an integer representing the height of the
	 * current Rectangle2 instance.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * sets the attribute height of the current instance of Rectangle2
	 * to the parameter height
	 * 
	 * @param height an integer representing the height of the rectangle
	 * 
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 *
	 * @return returns an integer representing the width of the current instance
	 * of rectangle2.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * sets the width attribute of the current Rectangle2 instance to parameter
	 * width
	 * 
	 * @param width an integer representing the width of the rectangle
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * 
	 * @return returns a String representing the color of the current Rectangle2 instance
	 * 
	 */
	public String getColor() {
		return this.color;
	}
	
	/**
	 * sets the color attribute of the current Rectangle2 instance to the parameter c
	 * @param c a String representing the the color of the rectangle
	 */
	public void setColor(String c) {
		this.color=c;
	}

	/**
	 * @return returns an integer representing the thickness of 
	 * the current Rectangle2 instance
	 */
	public int getThickness() {
		return this.thickness;
	}
	
	/**
	 * sets the thickness attribute of the current Rectangle2 instance to
	 * the parameter thickness
	 * @param thickness an integer representing the thickness of Rectangle2
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	

	/**
	 * draws a rectangle
	 * @param g a canvas object. draws new Rectangle using,
	 *  the Drawable abstract class draw.
	 */
	@Override
	public void draw(GraphicsContext g) {
		int x1 = Math.min(this.gettopleft().getX(),this.getbotright().getX());
		int y1 = Math.min(this.gettopleft().getY(),this.getbotright().getY());
		int width = Math.abs(this.getWidth());
		int height = Math.abs(this.getHeight());
		
		commands.acceptCommand(new ColorCommand(this));
		commands.acceptCommand(new ThicknessCommand(this));
		commands.operateAll(g);
		
		if (this.outline) {
			g.strokeRect(x1, y1, width, height);
		}
		else {
			g.fillRect(x1, y1, width, height);
		}
		
		}

	/**
	 * sets the outline attribute of the current instance of Rectangle2 to IsOutline
	 * @param outline
	 */
	@Override
	public void setOutline(Boolean isOutline) {
		
		this.outline=isOutline;
	}

	/**
	 * 
	 * @param isOutline set the outline of the Rectangle.
	 */
	@Override
	public Boolean isOutline() {
		
		return this.outline;
	}
	}


