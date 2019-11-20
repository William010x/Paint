package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * <h1> The command that will be preformed on objects for changing the color of
 *  GraphicsContext g</h1>
 *
 */
public class ColorCommand implements DrawingCommand{

	private Drawable o;
	
	/**
	 * 
	 * @param o an object that will have have a color of o.getColor()
	 */
	public ColorCommand(Drawable o) {
		this.o=o; 

	}

	@Override
	/**
	 * @param g the GraphicsContext that will have a color of the shape o
	 */
	public void execute(GraphicsContext g) {
		
		if (o.isOutline()) {
			g.setStroke(Color.web(o.getColor()));
		}
		else {
			g.setFill(Color.web(o.getColor()));
		}
	}
	
}
