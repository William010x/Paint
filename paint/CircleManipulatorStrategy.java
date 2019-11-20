package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * 
 * 
 * @author Administrator
 * Used for when the mode is Circle, handling all mouse events for Circle mode.
 *
 */
public class CircleManipulatorStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;

	public CircleManipulatorStrategy(PaintPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {

	}
	/**
	 *  shows a live update of the circle that can be drawn
	 *  accordingly to the user's preference
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		
		int x = (int)this.panel.getCircle().getCentre().getX() - (int)e.getX();
		int y = (int)this.panel.getCircle().getCentre().getY() - (int)e.getY();
		int radius = (int)Math.sqrt((Math.pow(x,  2) + Math.pow(y, 2)));
		this.panel.getCircle().setRadius(radius);
		
		this.panel.getCircle().setColor(this.panel.getColored());
		this.panel.getCircle().setOutline(this.panel.getOutline());
		
		this.panel.getModel().addShape(this.panel.getCircle());
		this.panel.setCircle(this.panel.getCircle());

	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 *  handles when user wants to draw a circle, the point of click is the center of the
	 *  circle
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int radius = 0;
		this.panel.setCircle(new Circle(centre, radius));
		this.panel.getCircle().setColor(this.panel.getColored());
	
		this.panel.getCircle().setThickness(this.panel.getThickness());
	}

	/**
	 *  handles when the user wants to publish their customized circle to the canvas
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.panel.getCircle() != null) {
			int x = (int)this.panel.getCircle().getCentre().getX() - (int)e.getX();
			int y = (int)this.panel.getCircle().getCentre().getY() - (int)e.getY();
			int radius = (int)Math.sqrt((Math.pow(x,  2) + Math.pow(y, 2)));
			this.panel.getCircle().setRadius(radius);

			this.panel.getModel().addShape(this.panel.getCircle());
			
			this.panel.setCircle(null);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
