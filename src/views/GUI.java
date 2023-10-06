package views;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI extends Application {
	
public void start(Stage Window) throws Exception {
		// TODO Auto-generated method stub
		startSelect.display(Window);
	
	}
public static void main (String[]args){
		launch(args);// Step 5
	}
}
