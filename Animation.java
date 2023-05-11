/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drone_david;
/**
 *
 * @author davidlimbu
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JFileChooser;


 public class Animation extends Application {
    private int CanvasX = 750, CanvasY = 500; 
    private MyCanvas mc;
    private static DroneArena myArena;
    private static AnimationTimer timer;
    
    JFileChooser chooser = new JFileChooser(); 
    
    private void showMessage(String TStr, String CStr) {
		    Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setTitle(TStr);
		    alert.setHeaderText(null);
		    alert.setContentText(CStr);

		    alert.showAndWait();
	}
   /**
	 * function to show in a box ABout the program
	 */
	 private void showAbout() {
		 showMessage("About", "GUI drone simulation");
	 }
               private void saveFile() {
		  JFileChooser chooser = new JFileChooser();						//Declaring File chooser
	   
	  													//If saving option is true
		  System.out.println("FILE SAVER OPEN BEHIND MAIN WINDOW");
	   int returnValue = chooser.showSaveDialog(null);
       if (returnValue == JFileChooser.APPROVE_OPTION) {
         File selectedFile = chooser.getSelectedFile();					//Creating new file
         if(selectedFile.canWrite()) {									//Checking if writing permission is true
        	 try {														//Try func to catch exceptions
        		 FileWriter file_writer = new FileWriter(chooser.getSelectedFile());	//Assign file to file_writer
        		 file_writer.write(myArena.toString());								//Writing to buffer building string
        		 file_writer.close();													//Closing file writer to write from buffer
        		 System.out.println("Arena INFO CORRECTLY SAVED TO FILE");			//Output result if successful
        	 }
        	 catch(Exception ex){														//Exception catch
        		 System.out.println("ERROR ENCOUNTERED WHILE WRITING TO FILE");			//Print error message (prevent crash)
        		 ex.printStackTrace();													//Print error in console
        	 }
        	 
         }
       }
	  
	
	   	
	}
	/**
	 * function to show in a box Help the program
	 */
	 private void showHelp() {
		 showMessage("Help", "This interface demonstrates the animation of Arena with Random Drones and Obstacles." + "\n" +
	                         "You have Add Drone and Add Obstacles button to add random drones in random position" + "\n" +
                   			 "Then start animation by clicking on Start and stop animation using Stop");
	 }

	/**
	 * Function to set up the menu
	 */
	public MenuBar setMenu() {
		MenuBar menuBar = new MenuBar();		// create menu

		Menu mHelp = new Menu("Help");			// have entry for help
					// then add sub menus for About and Help
					// add the item and then the action to perform
		MenuItem mAbout = new MenuItem("About");
		mAbout.setOnAction(new EventHandler<ActionEvent>() {
	           @Override
	           public void handle(ActionEvent actionEvent) {
	            	showAbout();				// show the about message
	           }	
		});
               
		MenuItem mfHelp = new MenuItem("Help");
		mfHelp.setOnAction(new EventHandler<ActionEvent>() {
	           @Override
	           public void handle(ActionEvent actionEvent) {
	            	showHelp();				// show the about message
	           }	
		});
		mHelp.getItems().addAll(mAbout, mfHelp); 	// add submenu to Help
			
				// now add File menu, which here only has Exit
		Menu mFile = new Menu("File");	
                // create File Menu
                 MenuItem mSave = new MenuItem("Save"); //create the save button
		mSave.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				timer.stop();
				saveFile(); //calls save file
			}
		});
		MenuItem mExit = new MenuItem("Exit");		// and Exit submenu
		mExit.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {		// and add handler
		        System.exit(0);						// quit program
		    }
		});
		mFile.getItems().addAll(mSave,mExit);	// add Exit submenu to File
			
		menuBar.getMenus().addAll(mFile, mHelp);	// menu has File and Help
			
		return menuBar;					// return the menu, so can be added
	}
    
    
    
    
    
    
    
    
    public static void fillList(ListView<Drone> ListDrone,ListView<Obstacle> ListObstacle){
		//clear the list view
		ListDrone.getItems().clear();
                ListObstacle.getItems().clear();
		//loop through drones and add them to the list view
			for (Drone d : myArena.dronelist)
				ListDrone.getItems().add(d);
                        for (Obstacle b : myArena.allObjects)
				ListObstacle.getItems().add(b);
               
			
		}
	;
    
    
    public void start(Stage stagePrimary) throws Exception  {
        stagePrimary.setTitle("David Drones GUI");


	    
		Group root = new Group();
		//setting canvas details and adding it to the stage
		Canvas canvas = new Canvas(750, 500);
		root.getChildren().add(canvas);
		//creating the canvas using the x and y and adding the drone arena
		
                mc = new MyCanvas(canvas.getGraphicsContext2D(), CanvasX, CanvasY);
		myArena = new DroneArena(750, 500);
		mc.fillCanvas(CanvasX, CanvasY);
		
			//timer used to start and stop the simulation
		timer = new AnimationTimer() {
			public void handle(long now) {
				//will stop or start the moveAllDrones function
				myArena.moveAllDrones(mc);
                                
			}
		};
                
		//List View Drone contains variables 'objects'
		ListView<Drone> Objects = new ListView<>();
                ListView<Obstacle> obstacleObject = new ListView<>();
		
                VBox vbList = new VBox();
		//sets positioning and formatting for the vblist
		vbList.getChildren().addAll(Objects,obstacleObject);
		vbList.setAlignment(Pos.CENTER);
		vbList.setPadding(new Insets(0, 0, 0, 50));
                
		//button to add a normal drone
		Button AddDrone_btn = new Button("Add Drone");
		AddDrone_btn.setOnAction(e -> {
			//drone added to arena using my canvas functions and objects variable
			myArena.addDrone(mc, Objects,obstacleObject);
		});
                
		//button formatting
		AddDrone_btn.setMinSize(125, 50);
		AddDrone_btn.setMaxSize(125, 50);
                //Obstacle Button
                Button btnAddObstacle = new Button("Add Obstacle");
                btnAddObstacle.setMinSize(125, 50);
		btnAddObstacle.setMaxSize(125, 50);
                btnAddObstacle.setOnAction(e -> {
			//drone added to arena using my canvas functions and objects variable
			myArena.addObstacle(mc,Objects,obstacleObject);
                       drawObstacleWorld();
                 	
		});
	   
                //start button
		Button Start_btn = new Button("Start");
		//starts timer
		Start_btn.setOnAction(e -> timer.start());
		//formatting
		Start_btn.setMinSize(125, 50);
		Start_btn.setMaxSize(125, 50);

		//stop button
		Button Stop_btn = new Button("Stop");
		//stops timer
		Stop_btn.setOnAction(e -> timer.stop());
		//button formatting
		Stop_btn.setMinSize(125, 50);
		Stop_btn.setMaxSize(125, 50);

		//sets padding and formatting for console
		HBox hbButtons = new HBox(20);
		hbButtons.setAlignment(Pos.CENTER);
		hbButtons.setPadding(new Insets(0, 0, 50, 0));

		//adds all button to the console
		hbButtons.getChildren().addAll(AddDrone_btn,btnAddObstacle, Start_btn, Stop_btn);

		//creates borderpane
		
                BorderPane borderPane = new BorderPane(); // New borderpane to store all
													// features

		//formats borderpane inserting items in certain areas of screen
		borderPane.setTop(setMenu());
                borderPane.setCenter(root);
		borderPane.setBottom(hbButtons);
		borderPane.setLeft(vbList);

		// Set the scene with the borderpane, with the size being the slightly
		// smaller than the screen.
		Scene scene1 = new Scene(borderPane, 1200, 700);

		stagePrimary.setScene(scene1); // Put the scene in the window

		stagePrimary.show();
	
    }
    public void drawObstacleWorld () {		
	 	myArena.drawArena(mc);
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Application.launch(args);
        }
        catch(Exception e){
            System.out.println(e);
        e.printStackTrace();
        
        }
    }
    
}
