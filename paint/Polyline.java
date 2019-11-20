package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * <h1>Polyline object, creates a polyline using the DRAWABLE COMMAND</h1>
 *
 */
public class Polyline extends Drawable{
	private ArrayList<Point> points;
	private String color;
	private int thickness;
	private DrawingOperator  commands = new DrawingOperator();
	
	
	/**
	 * 
	 * @param points An array of Points for a polyline to be drawn with
	 */
	public Polyline(ArrayList<Point> points) {
		this.points = points;
	}
	@Override
	public String getColor() {
		return this.color;
	}
	/**
	 * @param c a string for the color of polyline
	 */
	public void setColor(String c) {
		this.color=c;
	}
	@Override
	public int getThickness() {
		return this.thickness;
	}
	/**
	 * @param the integer thickness of the lines of a polyline
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	/**
	 * 
	 * @return an array list of points for an instance of polyline
	 */
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	/**
	 * 
	 * @return returns an integer representation of the size of the array list
	 */
	public int getSize() {
		return this.points.size();
	}
	/**
	 * 
	 * @param Point adds a point of type Point an an the arraylist of the current polyline
	 */
	public void addPoints(Point Point) {
		this.points.add(Point);
	}

	@Override
	public void draw(GraphicsContext g) {
		
	
			for (int i = 0; i < this.getPoints().size() - 1; i++) {
				commands.acceptCommand(new ColorCommand(this));
				commands.acceptCommand(new ThicknessCommand(this));
				commands.operateAll(g);
				Point p1 = this.points.get(i);
				Point p2 = this.points.get(i+1);
				g.strokeLine(p1.getX(), p1.getY(),p2.getX(), p2.getY());
			}
	}
	@Override
	public void setOutline(Boolean isOutline) {
		
		
	}
	@Override
	public Boolean isOutline() {
		
		return true;
	}
	
}