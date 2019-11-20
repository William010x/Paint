package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;
/**
 * 
 * 
 * @author Administrator
 * Used for when the mode is Square, handling all mouse events for Square mode.
 *
 */
public class SquareManipulatorStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	public SquareManipulatorStrategy(PaintPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
	/**
	 *  when the user moves their cursor, a live update of the square that can be drawn
	 *  is shown on the canvas.
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = Math.abs((int)this.panel.getSquare().getCentre().getX() - (int)e.getX());
		int y = Math.abs((int)this.panel.getSquare().getCentre().getY() - (int)e.getY());
		int radius;
		if (x>y) {
			radius = x;
		}
		else {radius = y;}
		this.panel.getSquare().setRadius(radius);
		//this.panel.setThickness(this.panel.getThickness());
		this.panel.getSquare().setOutline(this.panel.getOutline());
		
		this.panel.getModel().addShape(this.panel.getSquare());

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 *  when the user wants to draw a square, the point of click is the center of the square
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int radius = 0;
		this.panel.setSquare(new Square(centre, radius));
		this.panel.getSquare().setColor(this.panel.getColored());
		this.panel.getSquare().setThickness(this.panel.getThickness());

	}
	/**
	 *  handles when the user finishes drawing their specified square
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.panel.getSquare() != null) {
			int x = Math.abs((int)this.panel.getSquare().getCentre().getX() - (int)e.getX());
			int y = Math.abs((int)this.panel.getSquare().getCentre().getY() - (int)e.getY());
			int radius;
			if (x>y) {
				radius = x;
			}
			else {radius = y;}
			this.panel.getSquare().setRadius(radius);

			this.panel.getModel().addShape(this.panel.getSquare());
			this.panel.setSquare(null);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
