package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * 
 * <h1> A new View class which adds on the the built-in javafx view by tailoring it
 * to be able to handle buttons, and contain a system of panels in regard to the drawing of shapes.
 * </h1>
 *
 */
public class View implements EventHandler<ActionEvent> {

	private PaintModel model;

	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorButtonPanel colorButtonPanel;
	private ThicknessPanel thicknessPanel;
	private SetOutlineFill setOutlineFill;
	private ToolsPanel toolsPanel;


	private Scene scene;
	/**
	 * 
	 * @param model an instance of PaintPanel which will be added to scene
	 * @param stage an instance of Scene which will be added to scene
	 */
	public View(PaintModel model, Stage stage) {

		this.model = model;
		initUI(stage);
	}
	/**
	 * 
	 * @param stage an instance of Stage, which will contain all of the panels(paintPanel, shapeChooserPanel,
	 * colorButtonChooserPanel, thicknessPanel, setOutlineFill, and toolsPanel)
	 */
	private void initUI(Stage stage) {
		this.paintPanel = new PaintPanel(this.model, this);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.colorButtonPanel = new ColorButtonPanel(this);
		this.thicknessPanel = new ThicknessPanel(this);
		this.setOutlineFill = new SetOutlineFill(this);
		this.toolsPanel = new ToolsPanel(this);
		
		

		BorderPane root = new BorderPane();
		root.setTop(createMenuBar());
		root.setCenter(this.paintPanel);
		root.setStyle("-fx-background-color: #add8e6");
		
		BorderPane subroot = new BorderPane();
		
		subroot.setBottom(colorButtonPanel);
		
		

		
		VBox a = new VBox();
		a.setSpacing(15);
		a.getChildren().addAll(this.shapeChooserPanel, this.thicknessPanel,this.setOutlineFill, this.toolsPanel);
		
		subroot.setCenter(a);
		root.setLeft(subroot);
		
		Scene scene = new Scene(root);
		this.scene = scene;
		stage.setScene(scene);
		stage.setTitle("Paint");
		stage.show();
	}
	
	/**
	 * 
	 * @return returns the paint panel of this instance of view
	 */
	public PaintPanel getPaintPanel() {
		return paintPanel;
	}
	/**
	 * 
	 * @return returns the shape chooser panel of this instance of view
	 */
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	
	/**
	 * 
	 * @return returns the thickness panel of this instance of view
	 */
	public ThicknessPanel getThicknessPanel() {
		return thicknessPanel;
	}
	/**
	 * 
	 * @return returns the tool pane of this instance of view
	 */
	public ToolsPanel getToolsPanel() {
		return toolsPanel;
	}
	
	
	/**
	 * 
	 * @return a MenuBar with the buttons New, Open, Save, and etc.
	 */
	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;
		menuBar.setStyle("-fx-background-color: #4d7a97");

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		return menuBar;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(((MenuItem)event.getSource()).getText());
	}

	/**
	 * 
	 * @return Returns the scene, which is the entirity of the front end of the paint application
	 */
	public Scene getScene() {
		return this.scene;
	}
}
