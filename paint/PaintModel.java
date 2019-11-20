package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;
/**
 * <h1>PaintModel (observable), where the shapes are initialised,
 *  and set for manipulation</h1>
 *
 */

public class PaintModel extends Observable {

	private ArrayList<Point> points = new ArrayList<Point>();

	private ArrayList<Drawable> Shapes = new ArrayList<Drawable>();


	/**
	 * 
	 * @return the attribute Shapes, the instance of PaintModel.
	 */
	public ArrayList<Drawable> getShapes(){
		return this.Shapes;
	}
	
	/**
	 * 
	 * The attribute Shapes of the current instance of PaintModel
	 * removes shape at the end of the array.
	 * 
	 */
	public void removeShape() {
		if (this.Shapes.size()>0) {
		this.Shapes.remove(this.Shapes.size()-1);
		}
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * 
	 * The attribute Shapes of the current instance of PaintModel
	 * adds shape at the end of the array.
	 * 
	 */
	public void addShape(Drawable d) {
		this.Shapes.add(d);
		this.setChanged();
		this.notifyObservers();
	}
	

	/**
	 * 
	 * The attribute points of the current instance of PaintModel
	 * adds new points at the end of the array.
	 * 
	 */
	public void addPoint(Point p) {
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
		
	}
	
	/**
	 * 
	 * @return points from the arrays of points.
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}




	

	
}
