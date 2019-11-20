package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 
 * @author Administrator
 * Used for when the mode is Polyline, handling all mouse events for Polyline mode.
 *
 */
public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	
	public PolylineManipulatorStrategy(PaintPanel panel) {
		this.panel = panel;
	}
	/**
	 * shows a live update on the canvas of the next polyline from the last point clicked
	 *@param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.panel.getStartedLine() == true) {
			ArrayList<Point> copiedPoints = new ArrayList<Point>();
			copiedPoints.addAll(this.panel.getPoints());
			copiedPoints.add(new Point((int) e.getX(), (int) e.getY()));
			this.panel.setPolyline(new Polyline(copiedPoints));
			this.panel.getPolyline().setColor(this.panel.getColored());
			this.panel.getPolyline().setThickness(this.panel.getThickness());

			this.panel.getModel().removeShape();
			this.panel.getModel().addShape(this.panel.getPolyline());
			

			
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		endLine();
	}
	/**
	 *  method run when the user wants to specify the initial point of the Polyline
	 *@param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		MouseButton click = e.getButton();
		if (click == MouseButton.PRIMARY) {
			this.panel.getPoints().add(new Point((int) e.getX(), (int) e.getY()));
			this.panel.setPolyline(new Polyline(this.panel.getPoints()));
			this.panel.getPolyline().setColor(this.panel.getColored());
			this.panel.getPolyline().setThickness(this.panel.getThickness());
			this.panel.getModel().addShape(this.panel.getPolyline());
			this.panel.setStartedLine(true);
		}
		else if (click == MouseButton.SECONDARY && this.panel.getPoints() != null) {
			endLine();	
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	
	/**
	 * handles when user's polyline leaves the canvas
	 *@param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if (this.panel.getStartedLine() == true) {

			this.panel.getModel().removeShape();
			endLine();
		}
	}
	/**
	 * specifies when the polyline stopping drawing anymore
	 *@param e a MouseEvent representing the actions of the mouse
	 */
	public void endLine() {
		if (this.panel.getPoints() != null) {
			ArrayList<Point> copiedPoints = new ArrayList<Point>();
			copiedPoints.addAll(this.panel.getPoints());
			this.panel.setPolyline(new Polyline(copiedPoints));
			this.panel.getPolyline().setThickness(this.panel.getThickness());
			this.panel.getPolyline().setColor(this.panel.getColored());


			this.panel.getModel().addShape(this.panel.getPolyline());
			this.panel.getPoints().clear();
			
			this.panel.setStartedLine(false);
		}
	}
}
