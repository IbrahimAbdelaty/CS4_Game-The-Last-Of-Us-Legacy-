package views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.characters.Hero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.*;



	
	public class startSelect {
		
		static String localDir = System.getProperty("user.dir");
		
		static String backblack= localDir + "\\BackBlack.png";
		static String startblack= localDir + "\\StartBlack.png";
		static String backwhite= localDir + "\\BackWhite.png";
		static String startwhite= localDir + "\\StartWhiteBG.png";
		static String fighterdec= localDir + "\\StatsFighter.png";
		static String fighterbg= localDir + "\\FighterBG.png";
		static String meddesc= localDir + "\\Med Description.png";
		static String medbg= localDir + "\\MedicBG.png";
		static String expodesc= localDir + "\\Expo desc.png";
		static String expobg= localDir + "\\Expo Bg.png";
		
		
		
		
		//Stage window;
		static Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10, scenestart;
		//    main,  joel , game,  ellie,  tess,  riley,tommy , bill, david, henry
		static Hero h;
		
		
		
//		public static void main(String []args) {
//			launch(args);
//		}
//		
//		@Override
		public static void display(Stage primaryStage) throws Exception{
			
		//Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10, scenestart;
		engine.Game.loadHeroes(localDir + "\\Heros.csv");	
		Media music = new Media(new File(localDir + "\\The Last Of Us.mp3").toURI().toString());
        MediaPlayer musicMP3 = new MediaPlayer(music);
        musicMP3.setCycleCount(musicMP3.INDEFINITE);
        musicMP3.setAutoPlay(true);
//        musicMP3.setVolume(0.3);
			
			
/*		window = primaryStage;
			
			Label label1 = new Label("welcome to scene 1");
			
			Label l1 = new Label("Name: Joel Miller");
			l1.setFont(new Font("Comic Sans MS", 28));
			l1.setTextFill(Color.web("#FFFFFF"));
			
			Label l2 = new Label("Hero Class: Fighter");
			l2.setFont(new Font("Comic Sans MS", 28));
			l2.setTextFill(Color.web("#FFFFFF"));
			
			Label l3 = new Label("HP: 140");
			l3.setFont(new Font("Comic Sans MS", 28));
			l3.setTextFill(Color.web("#FFFFFF"));
			
			Label l4 = new Label("Attack Damgae: 30");
			l4.setFont(new Font("Comic Sans MS", 28));
			l4.setTextFill(Color.web("#FFFFFF"));
			
			Label l5 = new Label("Max Moves: 5");
			l5.setFont(new Font("Comic Sans MS", 28));
			l5.setTextFill(Color.web("#FFFFFF"));
			
			
			
			VBox layout1 = new VBox(20);
			button1 = new Button("Click me");
			button1.setTranslateX(200);
		    button1.setTranslateY(25);
			button1.setOnAction(e -> window.setScene(scene2));
			layout1.getChildren().addAll(label1,button1);
			scene1 = new Scene (layout1, 1000, 500);
			window.setScene(scene1);

			
			
			StackPane layout2 = new StackPane();
			button2 = new Button("Do not Click me");
			button2.setOnAction(e -> window.setScene(scene1));
			layout2.getChildren().add(button2);
			scene2 = new Scene (layout2, 1000, 500);
			
			window.setTitle("omak ar3a");
			window.show();  
			*/
				//start game window
			InputStream streamstart = new FileInputStream(localDir + "\\start.png");
		      Image imagestart = new Image(streamstart);
		      ImageView imageViewstart = new ImageView();
		      imageViewstart.setImage(imagestart);
		      imageViewstart.setX(1);
		      imageViewstart.setY(1);
		      imageViewstart.setFitWidth(1200);
		      imageViewstart.setPreserveRatio(true);
		      
		      Image imgstart = new Image(new FileInputStream(localDir + "\\StartButton!.png"));
				ImageView viewstart = new ImageView(imgstart);
				viewstart.setFitHeight(100);
				viewstart.setPreserveRatio(true);
				
//				Label credits=new Label("Credits:");
//				credits.set
//				Label Developers=new Label("Developers:");
//				Label Ibrahim=new Label("Ibrahim Amr");
//				Label Omar=new Label("Omar Hany");
//				Label Osama=new Label("Mohamed Osama");
//				Label Music=new Label("Music by:");
//				Label Ibrahim1=new Label("Ibrahim Amr");
//				
//				HBox Credits=new HBox();
//				 
//				Credits.getChildren().addAll(credits,Developers,Ibrahim,Omar,Osama,Music,Ibrahim1);
//				
//				Credits.setAlignment(Pos.BOTTOM_LEFT);
				
				
				
				
				Button buttonstart = new Button();
				buttonstart.setTranslateX(420);
				buttonstart.setTranslateY(550);
				buttonstart.setBackground(null);
				buttonstart.setOnAction(e -> primaryStage.setScene(scene1));
				buttonstart.setPrefSize(100,200);
				buttonstart.setGraphic(viewstart);
		      
		      Group rootstart = new Group(imageViewstart,buttonstart);
				scenestart = new Scene(rootstart, 1200, 700, Color.BLACK);   													//     joel          ellie          tess         riley          tommy           bill            david           henry
				primaryStage.setScene(scenestart);
			
			      //main label
			Label label1 = new Label("Please Select you Hero:");
			label1.setFont(new Font("Comic Sans MS", 28));
			label1.setTranslateX(430);
			label1.setTranslateY(20);
			label1.setTextFill(Color.web("#FFFFFF"));
			
			Label label2 = new Label("Joel Miller");
			label2.setFont(new Font("Comic Sans MS", 20));
			label2.setTranslateX(135);
			label2.setTranslateY(70);
			label2.setTextFill(Color.web("#FFFFFF"));
			
			Label label3 = new Label("(FIGH)");
			label3.setFont(new Font("Comic Sans MS", 20));
			label3.setTranslateX(150);
			label3.setTranslateY(90);
			label3.setTextFill(Color.web("#FFFFFF"));
			
			Label label4 = new Label("Ellie Williams");
			label4.setFont(new Font("Comic Sans MS", 20));
			label4.setTranslateX(365);
			label4.setTranslateY(70);
			label4.setTextFill(Color.web("#FFFFFF"));
			
			Label label5 = new Label("(MED)");
			label5.setFont(new Font("Comic Sans MS", 20));
			label5.setTranslateX(400);
			label5.setTranslateY(90);
			label5.setTextFill(Color.web("#FFFFFF"));
			
			Label label6 = new Label("Tess");
			label6.setFont(new Font("Comic Sans MS", 20));
			label6.setTranslateX(660);
			label6.setTranslateY(70);
			label6.setTextFill(Color.web("#FFFFFF"));
			
			Label label7 = new Label("(EXP)");
			label7.setFont(new Font("Comic Sans MS", 20));
			label7.setTranslateX(660);
			label7.setTranslateY(90);
			label7.setTextFill(Color.web("#FFFFFF"));
			
			Label label8 = new Label("Riley Abel");
			label8.setFont(new Font("Comic Sans MS", 20));
			label8.setTranslateX(865);
			label8.setTranslateY(70);
			label8.setTextFill(Color.web("#FFFFFF"));
			
			Label label9 = new Label("(EXP)");
			label9.setFont(new Font("Comic Sans MS", 20));
			label9.setTranslateX(890);
			label9.setTranslateY(90);
			label9.setTextFill(Color.web("#FFFFFF"));
			
			Label label10 = new Label("Tommy Miller");
			label10.setFont(new Font("Comic Sans MS", 20));
			label10.setTranslateX(110);
			label10.setTranslateY(370);
			label10.setTextFill(Color.web("#FFFFFF"));
			
			Label label11 = new Label("(EXP)");
			label11.setFont(new Font("Comic Sans MS", 20));
			label11.setTranslateX(145);
			label11.setTranslateY(390);
			label11.setTextFill(Color.web("#FFFFFF"));
			
			Label label12 = new Label("Bill");
			label12.setFont(new Font("Comic Sans MS", 20));
			label12.setTranslateX(390);
			label12.setTranslateY(370);
			label12.setTextFill(Color.web("#FFFFFF"));
			
			Label label13 = new Label("(MED)");
			label13.setFont(new Font("Comic Sans MS", 20));
			label13.setTranslateX(375);
			label13.setTranslateY(390);
			label13.setTextFill(Color.web("#FFFFFF"));
			
			Label label14 = new Label("David");
			label14.setFont(new Font("Comic Sans MS", 20));
			label14.setTranslateX(655);
			label14.setTranslateY(370);
			label14.setTextFill(Color.web("#FFFFFF"));
			
			Label label15 = new Label("(FIGH)");
			label15.setFont(new Font("Comic Sans MS", 20));
			label15.setTranslateX(650);
			label15.setTranslateY(390);
			label15.setTextFill(Color.web("#FFFFFF"));
			
			Label label16 = new Label("Henry Burell");
			label16.setFont(new Font("Comic Sans MS", 20));
			label16.setTranslateX(865);
			label16.setTranslateY(370);
			label16.setTextFill(Color.web("#FFFFFF"));
			
			Label label17 = new Label("(MED)");
			label17.setFont(new Font("Comic Sans MS", 20));
			label17.setTranslateX(890);
			label17.setTranslateY(390);
			label17.setTextFill(Color.web("#FFFFFF"));
			
			
			
			//background
			
			  InputStream streammain = new FileInputStream(localDir + "\\BG1.png");
		      Image imagemain = new Image(streammain);
		      ImageView imageViewmain = new ImageView();
		      imageViewmain.setImage(imagemain);
		      imageViewmain.setX(1);
		      imageViewmain.setY(1);
		      imageViewmain.setFitWidth(1200);
		      imageViewmain.setPreserveRatio(true);
		      
		      //back button
		      /*Image imgback = new Image(new FileInputStream("D:\\Study\\CS4\\Game\\Main\\Media\\Back Button BG.png"));
				ImageView viewback = new ImageView(imgback);
				viewback.setFitHeight(200);
				viewback.setPreserveRatio(true);
				Button buttonback = new Button();
				buttonback.setTranslateX(600);
				buttonback.setTranslateY(150);
				buttonback.setOnAction(e -> primaryStage.setScene(scene1));
				buttonback.setPrefSize(100,200);
				buttonback.setGraphic(viewback);
				*/
			//start button 
				
				/*Image imgstart = new Image(new FileInputStream("/Users/taliaseif/Desktop/Screen_Shot_2023-05-23_at_11.35.08_PM-removebg-preview.png"));
				ImageView viewstart = new ImageView(imgstart);
				viewstart.setFitHeight(200);
				viewstart.setPreserveRatio(true);
				Button buttonstart = new Button();
				buttonstart.setTranslateX(600);
				buttonstart.setTranslateY(150);
				buttonstart.setOnAction(e -> primaryStage.setScene(scene3));
				buttonstart.setPrefSize(100,200);
				buttonstart.setGraphic(viewstart);*/
			
			//joel miller
			
			Image img = new Image(new FileInputStream(localDir + "\\JoeMiller.png"));
			ImageView view = new ImageView(img);
			view.setFitHeight(200);
			view.setPreserveRatio(true);
			      //Creating a Button
			Button button = new Button();
			      //Setting the location of the button
			button.setTranslateX(100);
			button.setTranslateY(120);
			button.setBackground(null);
			button.setOnAction(e ->primaryStage.setScene(scene2));
			      //Setting the size of the button
			button.setPrefSize(100,200);
			      //Setting a graphic to the button
			button.setGraphic(view);
			      //Setting the stage
			
			InputStream stream1 = new FileInputStream(localDir + "\\FighterBG.png");
		      Image image1 = new Image(stream1);
		      ImageView imageView1 = new ImageView();
		      imageView1.setImage(image1);
		      imageView1.setX(1);
		      imageView1.setY(1);
		      imageView1.setFitWidth(1200);
		      imageView1.setPreserveRatio(true);
			
			Image imgstart1 = new Image(new FileInputStream(startwhite));
			ImageView viewstart1 = new ImageView(imgstart1);
			viewstart1.setFitHeight(100);
			viewstart1.setPreserveRatio(true);
			Button buttonstart1 = new Button();
			buttonstart1.setTranslateX(900);
			buttonstart1.setTranslateY(50);
			buttonstart1.setBackground(null);
			buttonstart1.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(0));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart1.setPrefSize(100,100);
			buttonstart1.setGraphic(viewstart1);
			
			Image imgback1 = new Image(new FileInputStream(backwhite));
			ImageView viewback1 = new ImageView(imgback1);
			viewback1.setFitHeight(100);
			viewback1.setPreserveRatio(true);
			Button buttonback1 = new Button();
			buttonback1.setTranslateX(50);
			buttonback1.setTranslateY(50);
			buttonback1.setBackground(null);
			buttonback1.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback1.setPrefSize(100,100);
			buttonback1.setGraphic(viewback1);
			
				//describe
			
			InputStream streamjoel = new FileInputStream(localDir + "\\JoelMillerTransparet.png");
		      Image imagejoel = new Image(streamjoel);
		      ImageView imageViewjoel = new ImageView();
		      imageViewjoel.setImage(imagejoel);
		      imageViewjoel.setX(20);
		      imageViewjoel.setY(300);
		      imageViewjoel.setFitWidth(400);
		      imageViewjoel.setPreserveRatio(true);
		      
		      Label l1 = new Label("Name: Joel Miller");
				l1.setFont(new Font("Comic Sans MS", 30));
				l1.setTextFill(Color.web("#FFFFFF"));
				
				Label l2 = new Label("Hero Class: Fighter");
				l2.setFont(new Font("Comic Sans MS", 30));
				l2.setTextFill(Color.web("#FFFFFF"));
				
				Label l3 = new Label("HP: 140");
				l3.setFont(new Font("Comic Sans MS", 30));
				l3.setTextFill(Color.web("#FFFFFF"));
				
				Label l4 = new Label("Attack Damgae: 30");
				l4.setFont(new Font("Comic Sans MS", 30));
				l4.setTextFill(Color.web("#FFFFFF"));
				Label l5 = new Label("Max Moves: 5");
				l5.setFont(new Font("Comic Sans MS", 30));
				l5.setTextFill(Color.web("#FFFFFF"));
				
				VBox layout1 = new VBox(20);
				layout1.getChildren().addAll(l1,l2,l3,l4,l5);
				layout1.setTranslateX(450);
				layout1.setTranslateY(100);
				
				InputStream streama = new FileInputStream(fighterdec);
			      Image imagea = new Image(streama);
			      ImageView imageViewa = new ImageView();
			      imageViewa.setImage(imagea);
			      imageViewa.setX(800);
			      imageViewa.setY(475);
			      imageViewa.setFitWidth(400);
			      imageViewa.setPreserveRatio(true);
			
			Group root1 = new Group(imageView1,buttonstart1,buttonback1,imageViewjoel,layout1,imageViewa);
			scene2 = new Scene(root1, 1200, 700, Color.BLACK);
			
			
			//ellie williams
			
			Image img2 = new Image(new FileInputStream(localDir + "\\Ellie.png"));
			ImageView view2 = new ImageView(img2);
			view2.setFitHeight(200);
			view2.setPreserveRatio(true);
			Button button2 = new Button();
			button2.setTranslateX(350);
			button2.setTranslateY(120);
			button2.setBackground(null);
			button2.setOnAction(e -> primaryStage.setScene(scene4));
			button2.setPrefSize(100,200);
			button2.setGraphic(view2);
			
			InputStream stream2 = new FileInputStream(medbg);
		      Image image2 = new Image(stream2);
		      ImageView imageView2 = new ImageView();
		      imageView2.setImage(image2);
		      imageView2.setX(1);
		      imageView2.setY(1);
		      imageView2.setFitWidth(1200);
		      imageView2.setPreserveRatio(true);
			
			Image imgstart2 = new Image(new FileInputStream(startblack));
			ImageView viewstart2 = new ImageView(imgstart2);
			viewstart2.setFitHeight(100);
			viewstart2.setPreserveRatio(true);
			Button buttonstart2 = new Button();
			buttonstart2.setTranslateX(900);
			buttonstart2.setTranslateY(50);
			buttonstart2.setBackground(null);
			buttonstart2.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(1));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart2.setPrefSize(100,100);
			buttonstart2.setGraphic(viewstart2);
			
			Image imgback2 = new Image(new FileInputStream(backblack));
			ImageView viewback2 = new ImageView(imgback2);
			viewback2.setFitHeight(100);
			viewback2.setPreserveRatio(true);
			Button buttonback2 = new Button();
			buttonback2.setTranslateX(50);
			buttonback2.setTranslateY(50);
			buttonback2.setBackground(null);
			buttonback2.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback2.setPrefSize(100,100);
			buttonback2.setGraphic(viewback2);
			
					//description
			
			InputStream streamellie = new FileInputStream(localDir + "\\EllieTransparentBG.png");
		      Image imageellie = new Image(streamellie);
		      ImageView imageViewellie = new ImageView();
		      imageViewellie.setImage(imageellie);
		      imageViewellie.setX(20);
		      imageViewellie.setY(300);
		      imageViewellie.setFitWidth(400);
		      imageViewellie.setPreserveRatio(true);
		      
		      Label l6 = new Label("Name: Ellie Williams");
				l6.setFont(new Font("Comic Sans MS", 30));
				l6.setTextFill(Color.web("#c4d79b"));
				
				Label l7 = new Label("Hero Class: Medic");
				l7.setFont(new Font("Comic Sans MS", 30));
				l7.setTextFill(Color.web("#c4d79b"));
				
				Label l8 = new Label("HP: 110");
				l8.setFont(new Font("Comic Sans MS", 30));
				l8.setTextFill(Color.web("#c4d79b"));
				
				Label l9 = new Label("Attack Damgae: 15");
				l9.setFont(new Font("Comic Sans MS", 30));
				l9.setTextFill(Color.web("#c4d79b"));
				
				Label l10 = new Label("Max Moves: 6");
				l10.setFont(new Font("Comic Sans MS", 30));
				l10.setTextFill(Color.web("#c4d79b"));
				
				VBox layout2 = new VBox(20);
				layout2.getChildren().addAll(l6,l7,l8,l9,l10);
				layout2.setTranslateX(450);
				layout2.setTranslateY(100);
				
				InputStream streamb = new FileInputStream(meddesc);
			      Image imageb = new Image(streamb);
			      ImageView imageViewb = new ImageView();
			      imageViewb.setImage(imageb);
			      imageViewb.setX(800);
			      imageViewb.setY(475);
			      imageViewb.setFitWidth(400);
			      imageViewb.setPreserveRatio(true);
			
			Group root2 = new Group(imageView2,buttonstart2,buttonback2,imageViewellie,layout2,imageViewb);
			scene4 = new Scene(root2, 1200, 700, Color.BLACK);
			
			
			
			//Tess
			
			Image img3 = new Image(new FileInputStream(localDir + "\\Tess.png"));
			ImageView view3 = new ImageView(img3);
			view3.setFitHeight(200);
			view3.setPreserveRatio(true);
			Button button3 = new Button();
			button3.setTranslateX(600);
			button3.setTranslateY(120);
			button3.setBackground(null);
			button3.setOnAction(e -> primaryStage.setScene(scene5));
			button3.setPrefSize(100,200);
			button3.setGraphic(view3);
			
			InputStream stream3 = new FileInputStream(expobg);
		      Image image3 = new Image(stream3);
		      ImageView imageView3 = new ImageView();
		      imageView3.autosize();
		      imageView3.setImage(image3);
		      imageView3.setX(1);
		      imageView3.setY(1);
		      imageView3.setFitWidth(1200);
		      imageView3.setPreserveRatio(true);
			
			Image imgstart3 = new Image(new FileInputStream(startblack));
			ImageView viewstart3 = new ImageView(imgstart3);
			viewstart3.setFitHeight(100);
			viewstart3.setPreserveRatio(true);
			Button buttonstart3 = new Button();
			buttonstart3.setTranslateX(900);
			buttonstart3.setTranslateY(50);
			buttonstart3.setBackground(null);
			buttonstart3.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(2));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart3.setPrefSize(100,100);
			buttonstart3.setGraphic(viewstart3);
			
			Image imgback3 = new Image(new FileInputStream(backblack));
			ImageView viewback3 = new ImageView(imgback3);
			viewback3.setFitHeight(100);
			viewback3.setPreserveRatio(true);
			Button buttonback3 = new Button();
			buttonback3.setTranslateX(50);
			buttonback3.setTranslateY(50);
			buttonback3.setBackground(null);
			buttonback3.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback3.setPrefSize(100,100);
			buttonback3.setGraphic(viewback3);
			
					//description
			
			InputStream streamtess = new FileInputStream(expodesc);
		      Image imagetess = new Image(streamtess);
		      ImageView imageViewtess = new ImageView();
		      imageViewtess.setImage(imagetess);
		      imageViewtess.setX(-100);
		      imageViewtess.setY(300);
		      imageViewtess.setFitWidth(500);
		      imageViewtess.setPreserveRatio(true);
		      
		      Label l11 = new Label("Name: Tess");
				l11.setFont(new Font("Comic Sans MS", 30));
				l11.setTextFill(Color.web("#e27602"));
				
				Label l12 = new Label("Hero Class: Explorer");
				l12.setFont(new Font("Comic Sans MS", 30));
				l12.setTextFill(Color.web("#e27602"));
				
				Label l13 = new Label("HP: 80");
				l13.setFont(new Font("Comic Sans MS", 30));
				l13.setTextFill(Color.web("#e27602"));
				
				Label l14 = new Label("Attack Damgae: 20");
				l14.setFont(new Font("Comic Sans MS", 30));
				l14.setTextFill(Color.web("#e27602"));
				
				Label l15 = new Label("Max Moves: 6");
				l15.setFont(new Font("Comic Sans MS", 30));
				l15.setTextFill(Color.web("#e27602"));
				
				VBox layout3 = new VBox(20);
				layout3.getChildren().addAll(l11,l12,l13,l14,l15);
				layout3.setTranslateX(450);
				layout3.setTranslateY(100);
				
				InputStream streamc = new FileInputStream(localDir + "\\tessnobg.png");
			      Image imagec = new Image(streamc);
			      ImageView imageViewc = new ImageView();
			      imageViewc.setImage(imagec);
			      imageViewc.setX(800);
			      imageViewc.setY(475);
			      imageViewc.setFitWidth(400);
			      imageViewc.setPreserveRatio(true);
			
			Group root3 = new Group(imageView3,buttonstart3,buttonback3,imageViewtess,layout3,imageViewc);
			scene5 = new Scene(root3, 1200, 700, Color.BLACK);
			
			
			//Riley Abel
			
			Image img4 = new Image(new FileInputStream(localDir + "\\Rileyreal.png"));
			ImageView view4 = new ImageView(img4);
			view4.setFitHeight(200);
			view4.setPreserveRatio(true);
			Button button4 = new Button();
			button4.setTranslateX(850);
			button4.setTranslateY(120);
			button4.setBackground(null);
			button4.setOnAction(e -> primaryStage.setScene(scene6));
			button4.setPrefSize(100,200);
			button4.setGraphic(view4);
			
			InputStream stream4 = new FileInputStream(expobg);
		      Image image4 = new Image(stream4);
		      ImageView imageView4 = new ImageView();
		      imageView4.autosize();
		      imageView4.setImage(image4);
		      imageView4.setX(1);
		      imageView4.setY(1);
		      imageView4.setFitWidth(1200);
		      imageView4.setPreserveRatio(true);
			
			Image imgstart4 = new Image(new FileInputStream(startblack));
			ImageView viewstart4 = new ImageView(imgstart4);
			viewstart4.setFitHeight(100);
			viewstart4.setPreserveRatio(true);
			Button buttonstart4 = new Button();
			buttonstart4.setTranslateX(900);
			buttonstart4.setTranslateY(50);
			buttonstart4.setBackground(null);
			buttonstart4.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(3));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart4.setPrefSize(100,100);
			buttonstart4.setGraphic(viewstart4);
			
			Image imgback4 = new Image(new FileInputStream(backblack));
			ImageView viewback4 = new ImageView(imgback4);
			viewback4.setFitHeight(100);
			viewback4.setPreserveRatio(true);
			Button buttonback4 = new Button();
			buttonback4.setTranslateX(50);
			buttonback4.setTranslateY(50);
			buttonback4.setBackground(null);
			buttonback4.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback4.setPrefSize(100,100);
			buttonback4.setGraphic(viewback4);
			
					//description
			
			InputStream streamriley = new FileInputStream(localDir + "\\Rileyrealnobg.png");
		      Image imageriley = new Image(streamriley);
		      ImageView imageViewriley = new ImageView();
		      imageViewriley.setImage(imageriley);
		      imageViewriley.setX(-50);
		      imageViewriley.setY(300);
		      imageViewriley.setFitWidth(400);
		      imageViewriley.setPreserveRatio(true);
		      
		      Label l16 = new Label("Name: Riley Abel");
				l16.setFont(new Font("Comic Sans MS", 30));
				l16.setTextFill(Color.web("#e27602"));
				
				Label l17 = new Label("Hero Class: Explorer");
				l17.setFont(new Font("Comic Sans MS", 30));
				l17.setTextFill(Color.web("#e27602"));
				
				Label l18 = new Label("HP: 90");
				l18.setFont(new Font("Comic Sans MS", 30));
				l18.setTextFill(Color.web("#e27602"));
				
				Label l19 = new Label("Attack Damgae: 25");
				l19.setFont(new Font("Comic Sans MS", 30));
				l19.setTextFill(Color.web("#e27602"));
				
				Label l20 = new Label("Max Moves: 5");
				l20.setFont(new Font("Comic Sans MS", 30));
				l20.setTextFill(Color.web("#e27602"));
				
				VBox layout4 = new VBox(20);
				layout4.getChildren().addAll(l16,l17,l18,l19,l20);
				layout4.setTranslateX(450);
				layout4.setTranslateY(100);
				
				InputStream streamd = new FileInputStream(expodesc);
			      Image imaged = new Image(streamd);
			      ImageView imageViewd = new ImageView();
			      imageViewd.setImage(imaged);
			      imageViewd.setX(800);
			      imageViewd.setY(475);
			      imageViewd.setFitWidth(400);
			      imageViewd.setPreserveRatio(true);
			
			Group root4 = new Group(imageView4,buttonstart4,buttonback4,imageViewriley,layout4,imageViewd);
			scene6 = new Scene(root4, 1200, 700, Color.BLACK);
			
			//Tommy Miller
			
			Image img5 = new Image(new FileInputStream(localDir + "\\Tonny.png"));
			ImageView view5 = new ImageView(img5);
			view5.setFitHeight(200);
			view5.setPreserveRatio(true);
			Button button5 = new Button();
			button5.setTranslateX(100);
			button5.setTranslateY(420);
			button5.setBackground(null);
			button5.setOnAction(e -> primaryStage.setScene(scene7));
			button5.setPrefSize(100,200);
			button5.setGraphic(view5);
			
			InputStream stream5 = new FileInputStream(expobg);
		      Image image5 = new Image(stream5);
		      ImageView imageView5 = new ImageView();
		      imageView5.autosize();
		      imageView5.setImage(image5);
		      imageView5.setX(1);
		      imageView5.setY(1);
		      imageView5.setFitWidth(1200);
		      imageView5.setPreserveRatio(true);
			
			Image imgstart5 = new Image(new FileInputStream(startblack));
			ImageView viewstart5 = new ImageView(imgstart5);
			viewstart5.setFitHeight(100);
			viewstart5.setPreserveRatio(true);
			Button buttonstart5 = new Button();
			buttonstart5.setTranslateX(900);
			buttonstart5.setTranslateY(50);
			buttonstart5.setBackground(null);
			buttonstart5.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(4));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart5.setPrefSize(100,100);
			buttonstart5.setGraphic(viewstart5);
			
			Image imgback5 = new Image(new FileInputStream(backblack));
			ImageView viewback5 = new ImageView(imgback5);
			viewback5.setFitHeight(100);
			viewback5.setPreserveRatio(true);
			Button buttonback5 = new Button();
			buttonback5.setTranslateX(50);
			buttonback5.setTranslateY(50);
			buttonback5.setBackground(null);
			buttonback5.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback5.setPrefSize(100,100);
			buttonback5.setGraphic(viewback5);
			
					//description
			
			InputStream streamtommy = new FileInputStream(localDir + "\\tonnynobg.png");
		      Image imagetommy = new Image(streamtommy);
		      ImageView imageViewtommy = new ImageView();
		      imageViewtommy.setImage(imagetommy);
		      imageViewtommy.setX(-40);
		      imageViewtommy.setY(300);
		      imageViewtommy.setFitWidth(400);
		      imageViewtommy.setPreserveRatio(true);
		      
		      Label l21 = new Label("Name: Tommy Miller");
				l21.setFont(new Font("Comic Sans MS", 30));
				l21.setTextFill(Color.web("#e27602"));
				
				Label l22 = new Label("Hero Class: Explorer");
				l22.setFont(new Font("Comic Sans MS", 30));
				l22.setTextFill(Color.web("#e27602"));
				
				Label l23 = new Label("HP: 95");
				l23.setFont(new Font("Comic Sans MS", 30));
				l23.setTextFill(Color.web("#e27602"));
				
				Label l24 = new Label("Attack Damgae: 25");
				l24.setFont(new Font("Comic Sans MS", 30));
				l24.setTextFill(Color.web("#e27602"));
				
				Label l25 = new Label("Max Moves: 5");
				l25.setFont(new Font("Comic Sans MS", 30));
				l25.setTextFill(Color.web("#e27602"));
				
				VBox layout5 = new VBox(20);
				layout5.getChildren().addAll(l21,l22,l23,l24,l25);
				layout5.setTranslateX(450);
				layout5.setTranslateY(100);
				
				InputStream streame = new FileInputStream(expodesc);
			      Image imagee = new Image(streame);
			      ImageView imageViewe = new ImageView();
			      imageViewe.setImage(imagee);
			      imageViewe.setX(800);
			      imageViewe.setY(475);
			      imageViewe.setFitWidth(400);
			      imageViewe.setPreserveRatio(true);
			
			Group root5 = new Group(imageView5,buttonstart5,buttonback5,imageViewtommy,layout5,imageViewe);
			scene7 = new Scene(root5, 1200, 700, Color.BLACK);
			
			//Bill
			
			Image img6 = new Image(new FileInputStream(localDir + "\\Riley Abdel.png"));
			ImageView view6 = new ImageView(img6);
			view6.setFitHeight(200);
			view6.setPreserveRatio(true);
			Button button6 = new Button();
			button6.setTranslateX(350);
			button6.setTranslateY(420);
			button6.setBackground(null);
			button6.setOnAction(e -> primaryStage.setScene(scene8));
			button6.setPrefSize(100,200);
			button6.setGraphic(view6);
			
			InputStream stream6 = new FileInputStream(medbg);
		      Image image6 = new Image(stream6);
		      ImageView imageView6 = new ImageView();
		      imageView6.setImage(image6);
		      imageView6.setX(1);
		      imageView6.setY(1);
		      imageView6.setFitWidth(1200);
		      imageView6.setPreserveRatio(true);
			
			Image imgstart6 = new Image(new FileInputStream(startblack));
			ImageView viewstart6 = new ImageView(imgstart6);
			viewstart6.setFitHeight(100);
			viewstart6.setPreserveRatio(true);
			Button buttonstart6 = new Button();
			buttonstart6.setTranslateX(900);
			buttonstart6.setTranslateY(50);
			buttonstart6.setBackground(null);
			buttonstart6.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(5));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart6.setPrefSize(100,100);
			buttonstart6.setGraphic(viewstart2);
			
			Image imgback6 = new Image(new FileInputStream(backblack));
			ImageView viewback6 = new ImageView(imgback6);
			viewback6.setFitHeight(100);
			viewback6.setPreserveRatio(true);
			Button buttonback6 = new Button();
			buttonback6.setTranslateX(50);
			buttonback6.setTranslateY(50);
			buttonback6.setBackground(null);
			buttonback6.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback6.setPrefSize(100,100);
			buttonback6.setGraphic(viewback6);
			
					//description
			
			InputStream streambill = new FileInputStream(localDir + "\\rileynobg.png");
		      Image imagebill = new Image(streambill);
		      ImageView imageViewbill = new ImageView();
		      imageViewbill.setImage(imagebill);
		      imageViewbill.setX(20);
		      imageViewbill.setY(300);
		      imageViewbill.setFitWidth(400);
		      imageViewbill.setPreserveRatio(true);
		      
		      Label l26 = new Label("Name: Bill");
				l26.setFont(new Font("Comic Sans MS", 30));
				l26.setTextFill(Color.web("#c4d79b"));
				
				Label l27 = new Label("Hero Class: Medic");
				l27.setFont(new Font("Comic Sans MS", 30));
				l27.setTextFill(Color.web("#c4d79b"));
				
				Label l28 = new Label("HP: 100");
				l28.setFont(new Font("Comic Sans MS", 30));
				l28.setTextFill(Color.web("#c4d79b"));
				
				Label l29 = new Label("Attack Damgae: 10");
				l29.setFont(new Font("Comic Sans MS", 30));
				l29.setTextFill(Color.web("#c4d79b"));
				
				Label l30 = new Label("Max Moves: 7");
				l30.setFont(new Font("Comic Sans MS", 30));
				l30.setTextFill(Color.web("#c4d79b"));
				
				VBox layout6 = new VBox(20);
				layout6.getChildren().addAll(l26,l27,l28,l29,l30);
				layout6.setTranslateX(450);
				layout6.setTranslateY(100);
				
				InputStream streamf = new FileInputStream(meddesc);
			      Image imagef = new Image(streamf);
			      ImageView imageViewf = new ImageView();
			      imageViewf.setImage(imagef);
			      imageViewf.setX(800);
			      imageViewf.setY(475);
			      imageViewf.setFitWidth(400);
			      imageViewf.setPreserveRatio(true);
			
			Group root6 = new Group(imageView6,buttonstart6,buttonback6,imageViewbill,layout6,imageViewf);
			scene8 = new Scene(root6, 1200, 700, Color.BLACK);
			
			//David
			
			Image img7 = new Image(new FileInputStream(localDir + "\\David.png"));
			ImageView view7 = new ImageView(img7);
			view7.setFitHeight(200);
			view7.setPreserveRatio(true);
			Button button7 = new Button();
			button7.setTranslateX(600);
			button7.setTranslateY(420);
			button7.setBackground(null);
			button7.setOnAction(e -> primaryStage.setScene(scene9));
			button7.setPrefSize(100,200);
			button7.setGraphic(view7);
			
			InputStream stream7 = new FileInputStream(fighterbg);
		      Image image7 = new Image(stream7);
		      ImageView imageView7 = new ImageView();
		      imageView7.setImage(image7);
		      imageView7.setX(1);
		      imageView7.setY(1);
		      imageView7.setFitWidth(1200);
		      imageView7.setPreserveRatio(true);
			
			Image imgstart7 = new Image(new FileInputStream(startwhite));
			ImageView viewstart7 = new ImageView(imgstart7);
			viewstart7.setFitHeight(100);
			viewstart7.setPreserveRatio(true);
			Button buttonstart7 = new Button();
			buttonstart7.setTranslateX(900);
			buttonstart7.setTranslateY(50);
			buttonstart7.setBackground(null);
			buttonstart7.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(6));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart7.setPrefSize(100,100);
			buttonstart7.setGraphic(viewstart7);
			
			Image imgback7 = new Image(new FileInputStream(backwhite));
			ImageView viewback7 = new ImageView(imgback7);
			viewback7.setFitHeight(100);
			viewback7.setPreserveRatio(true);
			Button buttonback7 = new Button();
			buttonback7.setTranslateX(50);
			buttonback7.setTranslateY(50);
			buttonback7.setBackground(null);
			buttonback7.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback7.setPrefSize(100,100);
			buttonback7.setGraphic(viewback7);
			
					//description
			
			InputStream streamdavid = new FileInputStream(localDir + "\\Davidnobg.png");
		      Image imagedavid = new Image(streamdavid);
		      ImageView imageViewdavid = new ImageView();
		      imageViewdavid.setImage(imagedavid);
		      imageViewdavid.setX(-50);
		      imageViewdavid.setY(300);
		      imageViewdavid.setFitWidth(400);
		      imageViewdavid.setPreserveRatio(true);
		      
		      Label l31 = new Label("Name: David");
				l31.setFont(new Font("Comic Sans MS", 30));
				l31.setTextFill(Color.web("#FFFFFF"));
				
				Label l32 = new Label("Hero Class: Fighter");
				l32.setFont(new Font("Comic Sans MS", 30));
				l32.setTextFill(Color.web("#FFFFFF"));
				
				Label l33 = new Label("HP: 150");
				l33.setFont(new Font("Comic Sans MS", 30));
				l33.setTextFill(Color.web("#FFFFFF"));
				
				Label l34 = new Label("Attack Damgae: 35");
				l34.setFont(new Font("Comic Sans MS", 30));
				l34.setTextFill(Color.web("#FFFFFF"));
				
				Label l35 = new Label("Max Moves: 4");
				l35.setFont(new Font("Comic Sans MS", 30));
				l35.setTextFill(Color.web("#FFFFFF"));
				
				VBox layout7 = new VBox(20);
				layout7.getChildren().addAll(l31,l32,l33,l34,l35);
				layout7.setTranslateX(450);
				layout7.setTranslateY(100);
				
				InputStream streamg = new FileInputStream(fighterdec);
			      Image imageg = new Image(streamg);
			      ImageView imageViewg = new ImageView();
			      imageViewg.setImage(imageg);
			      imageViewg.setX(800);
			      imageViewg.setY(475);
			      imageViewg.setFitWidth(400);
			      imageViewg.setPreserveRatio(true);
			
			Group root7 = new Group(imageView7,buttonstart7,buttonback7,imageViewdavid,layout7,imageViewg);
			scene9 = new Scene(root7, 1200, 700, Color.BLACK);
			
			
			//Henry Burell
			
			Image img8 = new Image(new FileInputStream(localDir + "\\Henry.png"));
			ImageView view8 = new ImageView(img8);
			view8.setFitHeight(200);
			view8.setPreserveRatio(true);
			Button button8 = new Button();
			button8.setTranslateX(850);
			button8.setTranslateY(420);
			button8.setBackground(null);
			button8.setOnAction(e -> primaryStage.setScene(scene10));
			button8.setPrefSize(100,200);
			button8.setGraphic(view8);
			
			InputStream stream8 = new FileInputStream(medbg);
		      Image image8 = new Image(stream8);
		      ImageView imageView8 = new ImageView();
		      imageView8.setImage(image8);
		      imageView8.setX(1);
		      imageView8.setY(1);
		      imageView8.setFitWidth(1200);
		      imageView8.setPreserveRatio(true);
			
			Image imgstart8 = new Image(new FileInputStream(startblack));
			ImageView viewstart8 = new ImageView(imgstart8);
			viewstart8.setFitHeight(100);
			viewstart8.setPreserveRatio(true);
			Button buttonstart8 = new Button();
			buttonstart8.setTranslateX(900);
			buttonstart8.setTranslateY(50);
			buttonstart8.setBackground(null);
			buttonstart8.setOnAction(e -> {
				try {
					musicMP3.stop();
					NodeDemo.display(primaryStage, engine.Game.availableHeroes.remove(7
							));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			buttonstart8.setPrefSize(100,100);
			buttonstart8.setGraphic(viewstart8);
			
			Image imgback8 = new Image(new FileInputStream(backblack));
			ImageView viewback8 = new ImageView(imgback8);
			viewback8.setFitHeight(100);
			viewback8.setPreserveRatio(true);
			Button buttonback8 = new Button();
			buttonback8.setTranslateX(50);
			buttonback8.setTranslateY(50);
			buttonback8.setBackground(null);
			buttonback8.setOnAction(e -> primaryStage.setScene(scene1));
			buttonback8.setPrefSize(100,100);
			buttonback8.setGraphic(viewback8);
			
					//description
			
			InputStream streamhenry = new FileInputStream(localDir + "\\Henry no bg.png");
		      Image imagehenry = new Image(streamhenry);
		      ImageView imageViewhenry = new ImageView();
		      imageViewhenry.setImage(imagehenry);
		      imageViewhenry.setX(-50);
		      imageViewhenry.setY(300);
		      imageViewhenry.setFitWidth(400);
		      imageViewhenry.setPreserveRatio(true);
		      
		      Label l36 = new Label("Name: Henry Burell");
				l36.setFont(new Font("Comic Sans MS", 30));
				l36.setTextFill(Color.web("#c4d79b"));
				
				Label l37 = new Label("Hero Class: Medic");
				l37.setFont(new Font("Comic Sans MS", 30));
				l37.setTextFill(Color.web("#c4d79b"));
				
				Label l38 = new Label("HP: 105");
				l38.setFont(new Font("Comic Sans MS", 30));
				l38.setTextFill(Color.web("#c4d79b"));
				
				Label l39 = new Label("Attack Damgae: 15");
				l39.setFont(new Font("Comic Sans MS", 30));
				l39.setTextFill(Color.web("#c4d79b"));
				
				Label l40 = new Label("Max Moves: 6");
				l40.setFont(new Font("Comic Sans MS", 30));
				l40.setTextFill(Color.web("#c4d79b"));
				
				VBox layout8 = new VBox(20);
				layout8.getChildren().addAll(l36,l37,l38,l39,l40);
				layout8.setTranslateX(450);
				layout8.setTranslateY(100);
				
				InputStream streamh = new FileInputStream(meddesc);
			      Image imageh = new Image(streamh);
			      ImageView imageViewh = new ImageView();
			      imageViewh.setImage(imageh);
			      imageViewh.setX(800);
			      imageViewh.setY(475);
			      imageViewh.setFitWidth(400);
			      imageViewh.setPreserveRatio(true);
			
			Group root8 = new Group(imageView8,buttonstart8,buttonback8,imageViewhenry,layout8,imageViewh);
			scene10 = new Scene(root8, 1200, 700, Color.BLACK);
			
			
			
			
			
			Group root = new Group(imageViewmain,button,button2,button3,button4,button5,button6,button7,button8,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17);
			scene1 = new Scene(root, 1200, 700, Color.BLACK);   													//     joel          ellie          tess         riley          tommy           bill            david           henry	
			primaryStage.setTitle("The Last of Us: Legacy");
			primaryStage.show();
			
			//return h;
			
		}
		
		
			
		}
		
	

