package ca.utoronto.utm.paint;
/**
 *  
 *  Factory design pattern that creates Shape strategies 
 */
public class ShapeFactory {
	
	/**
	 * 
	 * @param shape String of the shape
	 * @param panel PaintPanel being used
	 * @return returns a new instance of a shape strategy accordingly to the shape.
	 */
	public ShapeManipulatorStrategy createStrategy(String shape, PaintPanel panel){
		if(shape.equals("Circle")){
			return new CircleManipulatorStrategy(panel);
		}
		
		else if(shape.equals("Rectangle")){
			return new RectangleManipulatorStrategy(panel);
		}
		else if(shape.equals("Square")){
			return new SquareManipulatorStrategy(panel);
		}
		else if(shape.equals("Squiggle")){
			return new SquiggleManipulatorStrategy(panel);
		}
		else if(shape.equals("Polyline")){
			return new PolylineManipulatorStrategy(panel);
		}
		else if(shape.equals("Eraser")){
			return new EraserStrategy(panel);
		}
		
		
		
		return null;
		
	}
}
