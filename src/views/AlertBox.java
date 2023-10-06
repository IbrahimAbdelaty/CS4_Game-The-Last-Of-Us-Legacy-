package views;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;

public class AlertBox {
 
	public static void display(String title, String message ,MediaPlayer mp){
		mp.pause();
		Stage window=new Stage();
		mp.play();
		//mp.setAutoPlay(true);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label= new Label();
		label.setText(message);
		Button Close=new Button("Close");
		Close.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				window.close();
				mp.play();
				//mp.setAutoPlay(true);
				
			}
			
		});

		VBox lay=new VBox(10);
		lay.getChildren().addAll(label,Close);
		lay.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(lay);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode()==KeyCode.ENTER){
					window.close();
					mp.play();
//					mp.setAutoPlay(true);
				}
			}
			
		});
		window.setScene(scene);
		window.showAndWait();
//        Media media = new Media(new File("D:\\Study\\CS4\\Game\\Main\\Media\\The Last of Us Theme  8-Bit Version.mp3").toURI().toString());
//        MediaPlayer GameMP3 = new MediaPlayer(media); 
//        GameMP3.setAutoPlay(true);
//        GameMP3.getOnPaused()
	}
}
