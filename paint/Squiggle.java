package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
/**
 * <h1>Circle object, creates circle using the DRAWABLE COMMAND
 * make arrays of points that forms squiggle lines.</h1>
 *
 */

public class Squiggle extends Drawable{
	private ArrayList<Point> points;
	private String color;
	private int thickness;
	private DrawingOperator  commands = new DrawingOperator();
	
public Squiggle(ArrayList<Point> points) {
	/**
	 * 
	 * Constructs points x, y to construct line for squiggle.
	 * @param points type ArrayList<point>.
	 * 
	 */
	this.points = points;
}

/**
 * 
 * @return the current color of Squiggle.
 */
@Override
public String getColor() {
	return this.color;
}

/**
 * The attribute color of the current instance of Squiggle is set to c.
 * @param c type String, set the color of squiggle to c.
 */
public void setColor(String c) {
	this.color=c;
}


/**
 * 
 * @return the current thickness of squiggle.
 */
@Override
public int getThickness() {
	return this.thickness;
}

/**
 * The attribute thickness of the current instance of Squiggle is set to thickness.
 * @param thickness type int,  is set to new thickness for the Squiggle.
 */
public void setThickness(int thickness) {
	this.thickness = thickness;
}

/**
 * 
 * @return points of that makes up Squiggle.
 */
public ArrayList<Point> getPoints() {
	return this.points;
}

/**
 * 
 * @return the current size of points (ArrayList<Point> points).
 */
public int getSize() {
	return this.points.size();
}

/**
 * The attribute point of the current instance of Squiggle adds in new Points.
 * @param point type Point,  adds new point to the array.
 */
public void addPoints(Point Point) {
	this.points.add(Point);
	
}

/**
 * 
 * @param g a canvas object. draws new squiggle giving the arrays of points using,
 *  the Drawable abstract class draw.
 */
@Override
public void draw(GraphicsContext g) {
	// TODO Auto-generated method stub
	for (int i = 0; i < this.points.size() - 1 ; i++) {
		Point p1 = this.points.get(i);
		Point p2 = this.points.get(i+1);
		commands.acceptCommand(new ColorCommand(this));
		commands.acceptCommand(new ThicknessCommand(this));
		commands.operateAll(g);
		g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
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