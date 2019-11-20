package ca.utoronto.utm.paint;

/**
 * <h1>Point object, where the set of x, y points is made</h1>
 *
 */
public class Point {
	int x, y;
	private int thickness;

	Point(int x, int y) {
		/**
		 * Constructs a Point of the specified parameter.
		 * @param x type int, position x on the canvas
		 * @param y type int, position y on the canvas.
		 */
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return the position x of the Point.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * The attribute x of the current instance of Point is set to x.
	 * @param x type int, set x to the new position x.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return the position y of the Point.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * The attribute y of the current instance of Point is set to y.
	 * @param y type int, set y to the new position y.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @return the current thickness of Point.
	 */
	public int getThickness() {
		return this.thickness;
	}
	
	/**
	 * The attribute thickness of the current instance of Point is set to thickness.
	 * @param thickness type int, set thickness to the new thickness.
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
}
