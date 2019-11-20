package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * <h1> The command that will be preformed on objects for changing the thickness of
 *  GraphicsContext g</h1>
 *
 */

public class ThicknessCommand implements DrawingCommand{
	private Drawable o;
	
	/**
	 * 
	 * @param o an object that will have have a thickness
	 * of o.getThickness()
	 */
	public ThicknessCommand(Drawable o) {
		this.o=o;
		
	}


	

	/**
	 * @param g the GraphicsContext that will have a thickness of the shape o
	 */
	@Override
	public void execute(GraphicsContext g) {
		
		g.setLineWidth(o.getThickness());
	}
	

}
