package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;

/**
 * 
 * 
 * @author Administrator
 * Used for when the mode is Squiggle, handling all mouse events for Squiggle mode.
 *
 */
public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	public SquiggleManipulatorStrategy(PaintPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	/**
	 *  handles when the user is drawing with squiggle
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseDragged(MouseEvent e) {

		Point linePoint = new Point((int) e.getX(), (int) e.getY());
		linePoint.setThickness(this.panel.getThickness());
		this.panel.getPoints().add(linePoint);
		ArrayList<Point> copiedPoints = new ArrayList<Point>();
		copiedPoints.addAll(this.panel.getPoints());
		this.panel.setSquiggle(new Squiggle(copiedPoints));
		this.panel.getSquiggle().setThickness(this.panel.getThickness());
		this.panel.getSquiggle().setColor(this.panel.getColored());
	

		
		this.panel.getModel().addShape(this.panel.getSquiggle());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}
	/**
	 *  handles when the user does not want to draw squiggle anymore
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<Point> copiedPoints = new ArrayList<Point>();
		copiedPoints.addAll(this.panel.getPoints());
		this.panel.setSquiggle(new Squiggle(copiedPoints));
		
		this.panel.getSquiggle().setThickness(this.panel.getThickness());
		this.panel.getSquiggle().setColor(this.panel.getColored());
		
		

		this.panel.getModel().addShape(this.panel.getSquiggle());
		this.panel.getPoints().clear();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
