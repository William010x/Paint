package ca.utoronto.utm.paint;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * A subclass of StackPane which is used for handling all the backend tasks, such as handling events,
 * modes chosen, and updating the canvas. 
 *
 */
class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private int i = 0;
	private PaintModel model;
	private View view;
	private String strokeText;
	
	private String mode;
	private Circle circle; 
	private Rectangle2 rectangle; 
	private Squiggle squiggle; 
	private Polyline polyline; 
	private Square square;
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private boolean startedLine = false;
	
	private String colored; 
	private int thickness; 
	private boolean outline;
	
	private ShapeManipulatorStrategy strategy;

	private Canvas canvas;
	private Scene scene;
	

	/**
	 * 
	 * @param model the model of this paint application
	 * @param view the View of this paint application
	 */
	public PaintPanel(PaintModel model, View view) {
		this.canvas = new Canvas(500, 500);

		this.getChildren().add(this.canvas);
		this.colored = "0x000000ff";
		this.outline=true;
	
		this.setStyle("-fx-background-color: white");
		
		

		this.addEventHandler(MouseEvent.ANY, this);

		this.mode = null;
		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}
	
	/**
	 * Redraws all of the shapes onto the canvas
	 */
	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();


		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setStroke(Color.web(colored));
		g.setLineWidth(1);
		
		this.strokeText = "" + i;
		view.getToolsPanel().setInfoLabel(this.strokeText);
		view.getToolsPanel().setGetId(this.mode);
		i = i + 1;

		
		for (Drawable d: this.getModel().getShapes()) {
			d.draw(g);

			
		}
		
		g.setStroke(Color.web(colored));
		g.setLineWidth(this.thickness);
		
	}
	/**
	 * 
	 * @return a string of what the stroke text is
	 */
	public String getStrokeText() {
		return this.strokeText;
	}
	

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}

	/**
	 * 
	 * @param mode A string of the mode chosen by a user (ex circle, eraser, and etc)
	 */
	public void setMode(String mode) {
		if (this.mode == "Polyline") {
			PolylineManipulatorStrategy s = new PolylineManipulatorStrategy(this);
			s.endLine();
		}

		this.mode = mode;

		ShapeFactory factory = new ShapeFactory();
		ShapeManipulatorStrategy strat1 = factory.createStrategy(this.mode,this);
		this.strategy = strat1;
		
	
	}
	/**
	 * 
	 * @param thickness an integer of the thickness to be appiled on the next drawn object
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
		
	}
	/**
	 * 
	 * @param color a string of the color to be appiled on the next drawn object
	 */
	public void setColorMode(String color) { 
		this.colored = color;
	}
	/**
	 * 
	 * @param b a boolean which for if outline is selected
	 */
	public void setOutline(boolean b) {
		this.outline = b;
	}
	/**
	 * 
	 * @return the canvas of paint
	 */
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	//zoom
	

	@Override
	public void handle(MouseEvent event) {
		
		if (this.strategy != null) {
			if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
				strategy.mouseDragged(event);
			} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
				strategy.mousePressed(event);
			} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
				view.getToolsPanel().setInfoVals((int)event.getX(), (int)event.getY());
				strategy.mouseMoved(event);
			} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
				strategy.mouseClicked(event);
			} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
				strategy.mouseReleased(event);
			} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
				strategy.mouseEntered(event);
			} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
				strategy.mouseExited(event);
			}
		}
	}

	/**
	 * 
	 * @return the current circle getting drawn
	 */
	public Circle getCircle() {
		return this.circle;
	}
	/**
	 * 
	 * @return the current rectangle getting drawn
	 */
	public Rectangle2 getRectangle2() {
		return this.rectangle;
	}
	

	/**
	 * 
	 * @return the current square getting drawn
	 */
	public Square getSquare() {
		return this.square;
	}

	/**
	 * 
	 * @return the current Squiggle getting drawn
	 */
	public Squiggle getSquiggle() {
		return this.squiggle;
	}
	/**
	 * 
	 * @return the current polyline being drawn
	 */
	public Polyline getPolyline() {
		return this.polyline;
	}
	
	/**
	 * 
	 * @return an array of points
	 */
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	/**
	 * 
	 * @return the starting line for a polyline
	 */
	public boolean getStartedLine() {
		return this.startedLine;
	}
	/**
	 * 
	 * @return the current thickness chosen
	 */
	public int getThickness() {
		return this.thickness;
	}
	/**
	 * 
	 * @return the current color chosen
	 */
	public String getColored() {
		return this.colored;
	}
	/**
	 * 
	 * @return the current state of outline
	 */
	public boolean getOutline() {
		return this.outline;
	}
	/**
	 * 
	 * @return the current state of model
	 */
	public PaintModel getModel() {
		return this.model;
	}
	/**
	 * 
	 * @param circle the new circle which will update the current one
	 */
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	/**
	 * 
	 * @param rectangle the new rectangle which will update the current one
	 */
	public void setRectangle2(Rectangle2 rectangle) {
		this.rectangle = rectangle;
	}
	/**
	 * 
	 * @param square the new square which will update the current one
	 */
	public void setSquare(Square square) {
		this.square = square;
	}
	
	/**
	 * 
	 * @param squiggle the new squiggle which will update the current one
	 */
	public void setSquiggle(Squiggle squiggle) {
		this.squiggle = squiggle;
	}
	/**
	 * 
	 * @param polyline the new polyline which will update the current one
	 */
	public void setPolyline(Polyline polyline) {
		this.polyline = polyline;
	}
	/**
	 * 
	 * @param x a boolean for if there is a starting line or polyline
	 */
	public void setStartedLine(boolean x) {
		this.startedLine = x;
	}
	
	
}
