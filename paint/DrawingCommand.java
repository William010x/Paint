package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
/**
 * An interface whose purpose is to force any type of command that implements this to define an execute method with 
 * a GraphicsContext
 */
public interface DrawingCommand {
	/**
	 * @param g The GraphicsContext that will be used to draw shapes, and change the thickness & color of g.
	 */
	public void execute(GraphicsContext g);

}
