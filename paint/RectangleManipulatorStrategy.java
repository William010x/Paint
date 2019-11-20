package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;
/**
 * 
 * 
 * @author Administrator
 * Used for when the mode is Rectangle, handling all mouse events for Rectangle mode.
 */
public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	public RectangleManipulatorStrategy(PaintPanel panel) {
		this.panel = panel;
	}
	/**
	 *  This method runs when the mouse cursor is moved
	 *  @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}
	/** Recreates the Rectangle accordingly to the users mouse cursor being dragged
	 * @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		int width = (int)e.getX() - (int)this.panel.getRectangle2().gettopleft().getX();
		this.panel.getRectangle2().setWidth(width);
		
		int height = (int)e.getY() - (int)this.panel.getRectangle2().gettopleft().getY();
		this.panel.getRectangle2().setHeight(height);
		
		Point p2 = new Point((int) e.getX(), (int) e.getY());
		this.panel.getRectangle2().setbotright(p2);

		this.panel.getRectangle2().setColor(this.panel.getColored());
		this.panel.getRectangle2().setOutline(this.panel.getOutline());
		
		

		this.panel.getModel().addShape(this.panel.getRectangle2());
	
	}
	/** This method is run when the mouse is left clicked.
	 * @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/** This method is run when the user specifies the first corner of the Rectangle2
	 * @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Point p1 = new Point((int)e.getX(), (int) e.getY());
		Point p2 = new Point((int)e.getX(), (int) e.getY());
		int width = 0;
		int height = 0;
		this.panel.setRectangle2(new Rectangle2(p1,height,width,p2));
		this.panel.getRectangle2().setColor(this.panel.getColored());
		this.panel.getRectangle2().setThickness(this.panel.getThickness());
	}
	
	/** This method is run when a user wants to publish their customized Rectangle2 to the canvas
	 * @param e a MouseEvent representing the actions of the mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		int width = (int)e.getX() - (int)this.panel.getRectangle2().gettopleft().getX();
		this.panel.getRectangle2().setWidth(width);
		
		int height = (int)e.getY() - (int)this.panel.getRectangle2().gettopleft().getY();
		this.panel.getRectangle2().setHeight(height);
		
		Point p2 = new Point((int) e.getX(), (int) e.getY());
		this.panel.getRectangle2().setbotright(p2);
		

		this.panel.getModel().addShape(this.panel.getRectangle2());
		this.panel.setRectangle2(null);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
