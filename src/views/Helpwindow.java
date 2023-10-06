package views;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Helpwindow {
	public static void display(){
		Stage window=new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Instructions");
		window.setMinWidth(250);
		
		Label label0= new Label();
		label0.setText("Click on a target to set target");
		Label label= new Label();
		label.setText("Press w to move up");
		Label label1= new Label();
		label1.setText("Press s to move down");
		Label label2= new Label();
		label2.setText("Press d to move right");
		Label label3= new Label();
		label3.setText("Press a to move left");
		Label label4= new Label();
		label4.setText("Press x to attack");
		Label label5= new Label();
		label5.setText("Press c to cure");
		Label label6= new Label();
		label6.setText("Press r to use special");
		Label label7= new Label();
		label7.setText("Press e to end turn");
		Label label8= new Label();
		label8.setText("Click on the the desired hero you want to change to and press Q to change hero");
		Button Close=new Button("Close");
		Close.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				window.close();
			}
			
		});

		VBox lay=new VBox(10);
		lay.getChildren().addAll(label0,label ,label1,label2,label3,label4,label5,label6,label7,label8, Close);
		lay.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(lay,600,500);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode()==KeyCode.ENTER){
					window.close();
				}
			}
			
		});
		window.setScene(scene);
		window.showAndWait();
	}
}

