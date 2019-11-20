package ca.utoronto.utm.paint;


import java.util.ArrayList;

import com.sun.prism.paint.Color;

import javafx.scene.input.MouseEvent;

public class EraserStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	public EraserStrategy(PaintPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		Point linePoint = new Point((int) e.getX(), (int) e.getY());
		linePoint.setThickness(this.panel.getThickness());
		this.panel.getPoints().add(linePoint);
		ArrayList<Point> copiedPoints = new ArrayList<Point>();
		copiedPoints.addAll(this.panel.getPoints());
		this.panel.setSquiggle(new Squiggle(copiedPoints));
		this.panel.getSquiggle().setThickness(this.panel.getThickness());
		this.panel.getSquiggle().setColor("white");
		this.panel.getModel().addShape(this.panel.getSquiggle());

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<Point> copiedPoints = new ArrayList<Point>();
		copiedPoints.addAll(this.panel.getPoints());

		this.panel.setSquiggle(new Squiggle(copiedPoints));
		this.panel.getSquiggle().setThickness(this.panel.getThickness());
		this.panel.getSquiggle().setColor("white");


		

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
