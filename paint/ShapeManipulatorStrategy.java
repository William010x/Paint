package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * 
 * 
 * @author Administrator
 * Structural outline of how each Shape strategy should be implemented for all mouse events
 *
 */
public interface ShapeManipulatorStrategy {
	
	DrawingOperator  commands = new DrawingOperator();
	
	public void mouseMoved(MouseEvent e);
	public void mouseDragged(MouseEvent e);
	public void mouseClicked(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseEntered(MouseEvent e);
	public void mouseExited(MouseEvent e);
	
}
