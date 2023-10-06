package views;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Defeat {
	public static void display(String title, String message, Image image){
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		BorderPane b=new BorderPane();
		
    	BackgroundImage bImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
    	Background back = new Background(bImage);
    	b.setBackground(back);
    	Scene s=new Scene(b);
    	
    	window.setTitle(title);
    	window.setScene(s);
		window.showAndWait();
		
	}
}
