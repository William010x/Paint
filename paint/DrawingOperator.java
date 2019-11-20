package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

/**
 * An object meant to take in a commands and add it into a commands list, which will then be used to preform all commands added into DrawingOperator
 */
public class DrawingOperator {
	
	ArrayList<DrawingCommand> commandQueue;
	
	/**
	 * Creates an empty array list for the drawing commands that will be preformed
	 */
	public DrawingOperator() {
		commandQueue = new ArrayList<DrawingCommand>();
	}
	/**
	 * 
	 * @param command a DrawingCommand that will be added onto the drawing command array list
	 */
	public void acceptCommand(DrawingCommand command) {
		this.commandQueue.add(command);
	}
	/**
	 * 
	 * @param g this is the GraphicsContext that all the drawing commands will be preformed on
	 */
	public void operateAll(GraphicsContext g) {
		for(DrawingCommand command: this.commandQueue) {
			command.execute(g);
		}
		commandQueue.clear();
		
	}
	
	
	

}
