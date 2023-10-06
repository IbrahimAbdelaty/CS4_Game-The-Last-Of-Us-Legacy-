package views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import model.characters.*;
import model.collectibles.*;
import model.world.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import engine.*;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import static engine.Game.map;
import static views.startSelect.localDir;

public class NodeDemo {
    static Hero h;

    public static void display(Stage primaryStage,Hero h1) throws Exception {
    	h=h1;
    	Image Zombie = new Image(new FileInputStream(localDir + "\\2.png"));
    	Image Medic = new Image(new FileInputStream(localDir + "\\medic ++2.png"));
    	Image Vaccine = new Image(new FileInputStream(localDir + "\\vaccine1.png"));
    	Image Supply = new Image(new FileInputStream(localDir + "\\images1.png"));
    	Image Explorer = new Image(new FileInputStream(localDir + "\\expo1.png"));
    	Image Fighter = new Image(new FileInputStream(localDir + "\\download1 (2).png"));
    	Image empty = new Image(new FileInputStream(localDir + "\\empt.png"));
    	Image win = new Image(new FileInputStream(localDir + "\\win1.png"));
    	Image defeat = new Image(new FileInputStream(localDir + "\\defeat.png"));
    	Image background=new Image(new FileInputStream(localDir + "\\map (3) (1).png"));
    	GridPane mapGrid = new GridPane();
//    	Game.loadHeroes("D:\\Study\\CS4\\Game\\Mile stone 1\\Heroes cvv\\Heros.csv");
//    	h=Game.availableHeroes.get(0);
    	Game.startGame(h);
		setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
    	BackgroundImage bImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(mapGrid.getHeight(), mapGrid.getWidth()
    			, true, true, true, false));
    	Background back = new Background(bImage);
    	
    	
    	
    	mapGrid.setBackground(back);
    	mapGrid.setAlignment(Pos.CENTER);
    	Group root = new Group();
    	root.setAutoSizeChildren(true);
    	root.getChildren().addAll(mapGrid);
        Scene Game = new Scene( root, 1130,990);
        
        
        Media move = new Media(new File(localDir + "\\move.mp3").toURI().toString());
        MediaPlayer moveMP3 = new MediaPlayer(move);
        
        Media attack = new Media(new File(localDir + "\\Attack.mp3").toURI().toString());
        MediaPlayer attackMP3 = new MediaPlayer(attack);
        
        Media cure = new Media(new File(localDir + "\\Cure.mp3").toURI().toString());
        MediaPlayer cureMP3 = new MediaPlayer(cure);
        
        Media special = new Media(new File(localDir + "\\special.mp3").toURI().toString());
        MediaPlayer specialMP3 = new MediaPlayer(special);
        
        Media trap = new Media(new File(localDir + "\\Trap.mp3").toURI().toString());
        MediaPlayer trapMP3 = new MediaPlayer(trap);
        
        Media swap = new Media(new File(localDir + "\\switch.mp3").toURI().toString());
        MediaPlayer switchMP3 = new MediaPlayer(swap);
        
        
        Media main = new Media(new File(localDir + "\\The Last Of Us.mp3").toURI().toString());
        MediaPlayer GameMP3 = new MediaPlayer(main);
        GameMP3.setCycleCount(GameMP3.INDEFINITE);
        GameMP3.setAutoPlay(true);
//        GameMP3.setVolume(0.3);
        
        Game.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
					if(event.getCode()==KeyCode.W){
					try {
						int prevHP=h.getCurrentHp();
						h.move(model.characters.Direction.UP);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						if(prevHP==h.getCurrentHp()){
							moveMP3.play();
							moveMP3.seek(Duration.seconds(0.0));
						}else{
							trapMP3.play();	
							//trapMP3.setOnEndOfMedia(()->{
								//trapMP3.seek(Duration.ZERO);
								//trapMP3.stop();
								trapMP3.seek(Duration.seconds(0.0));
							//});
							}
						
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (MovementException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					}
					
				}
				if(event.getCode()==KeyCode.S){
					try {
						int prevHP=h.getCurrentHp();
						h.move(model.characters.Direction.DOWN);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						if(prevHP==h.getCurrentHp()){
							moveMP3.play();
							moveMP3.seek(Duration.seconds(0.0));
						}else{
							trapMP3.play();	
							trapMP3.seek(Duration.seconds(0.0));
							}
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (MovementException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					}
					
				}
				if(event.getCode()==KeyCode.D){
					try {
						int prevHP=h.getCurrentHp();
						h.move(model.characters.Direction.RIGHT);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						if(prevHP==h.getCurrentHp()){
							moveMP3.play();
							moveMP3.seek(Duration.seconds(0.0));
						}else{
							trapMP3.play();
							trapMP3.seek(Duration.seconds(0.0));
							}
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (MovementException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					}
					
				}
				if(event.getCode()==KeyCode.A){
					try {
						int prevHP=h.getCurrentHp();
						h.move(model.characters.Direction.LEFT);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						if(prevHP==h.getCurrentHp()){
							moveMP3.play();
							moveMP3.seek(Duration.seconds(0.0));
						}else{
							trapMP3.play();
							trapMP3.seek(Duration.seconds(0.0));
							}
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (MovementException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					}
					
				}
				
				if(event.getCode()==KeyCode.C){
					try {
						h.cure();
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						cureMP3.play();
						cureMP3.seek(Duration.seconds(0.0));
					} catch (InvalidTargetException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (NoAvailableResourcesException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					}
				}
				
				if(event.getCode()==KeyCode.R){
					try {
						h.useSpecial();
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						specialMP3.play();
						specialMP3.seek(Duration.seconds(0.0));
					} catch (NoAvailableResourcesException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (InvalidTargetException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					}
				}
				
				if(event.getCode()==KeyCode.X){
					try {
						h.attack();
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						attackMP3.setVolume(0.17 );
						attackMP3.play();
						attackMP3.seek(Duration.seconds(0.0));
					} catch (InvalidTargetException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
					}
				}
				
				if(event.getCode()==KeyCode.E){
					try {
						engine.Game.endTurn();
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						if(engine.Game.checkWin()){
							Media media = new Media(new File(localDir + "\\Rick Astley - Never Gonna Give You Up (Official Music Video).mp3").toURI().toString());
					        MediaPlayer winMP3 = new MediaPlayer(media); 
					        winMP3.setAutoPlay(true);
					        GameMP3.pause();
							endgame.display("Congrats You Won" , win ,winMP3);
							primaryStage.close();
						}else{
						if(engine.Game.checkGameOver()){
							Media media = new Media(new File(localDir + "\\defeat.mp3").toURI().toString());
					        MediaPlayer loseMP3 = new MediaPlayer(media); 
					        loseMP3.setAutoPlay(true);
					        GameMP3.pause();
							endgame.display("Defeat", defeat,loseMP3);
							primaryStage.close();
						}}
					} catch (InvalidTargetException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Error", e.getMessage(),GameMP3);
					}
				}
				if(event.getCode()==KeyCode.Q){
					if(h.getTarget() instanceof Hero){
						Hero tmp=(Hero) h.getTarget();
						h=tmp;
						setmap(mapGrid,map,Zombie,Medic,Explorer,Fighter,Vaccine,Supply,empty,background);
						switchMP3.play();
						switchMP3.seek(Duration.seconds(0.0));
				}else{
					AlertBox.display("Invalid Target", "Please click on a hero in order to change you controlled hero" ,GameMP3);
				}
				
			}
        	
			}});
        

        
       // startSelect.display(primaryStage);
        primaryStage.setScene(Game);
        primaryStage.show();
        

    }
    
    public static void setmap(GridPane map , Cell cell[][] ,Image Zombie ,Image Medic , Image Explorer, Image Fighter , Image Vaccine ,Image Supply,Image empty , Image background){
    	map.getChildren().clear();
    	for(int i = 0 ; i<15 ; i++){
    		for(int j = 0 ; j<15;j++){
    			if(cell[i][j] instanceof CharacterCell && ((CharacterCell) cell[i][j]).getCharacter()!=null && cell[i][j].isVisible() ){
    				if(((CharacterCell) cell[i][j]).getCharacter() instanceof Zombie){
    					Button b=new Button();
    					b.setPrefSize(60, 60);
        				BackgroundImage bImage = new BackgroundImage(Zombie, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
    					
        				Background backGround = new Background(bImage);
    					b.setBackground(backGround);
    					map.add(b,j,15-i);
    					int x=i;
    					int y=j;
    					b.setOnAction(new EventHandler<ActionEvent>(){
    						public void handle(ActionEvent event) {	
    							h.setTarget(((CharacterCell) cell[x][y]).getCharacter());
    						}
    						
    					});
    				}
    				if(((CharacterCell) cell[i][j]).getCharacter() instanceof Medic){
    					Button b=new Button();
    					b.setPrefSize(60,60);
        				BackgroundImage bImage = new BackgroundImage(Medic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
    					
        				Background backGround = new Background(bImage);
    					b.setBackground(backGround);
    					map.add(b,j,15-i);
    					int x=i;
    					int y=j;
    					b.setOnAction(new EventHandler<ActionEvent>(){
    						public void handle(ActionEvent event) {
    								h.setTarget(((CharacterCell) cell[x][y]).getCharacter());
    						}
    						
    					});
    				}
    				if(((CharacterCell) cell[i][j]).getCharacter() instanceof Explorer){
    					Button b=new Button();
    					b.setPrefSize(60, 60);
        				BackgroundImage bImage = new BackgroundImage(Explorer, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
    					
        				Background backGround = new Background(bImage);
    					b.setBackground(backGround);
    					map.add(b,j,15-i);
    					int x=i;
    					int y=j;
    					b.setOnAction(new EventHandler<ActionEvent>(){
    						public void handle(ActionEvent event) {
    								h.setTarget(((CharacterCell) cell[x][y]).getCharacter());
    						}
    						
    					});
    				}
    				if(((CharacterCell) cell[i][j]).getCharacter() instanceof Fighter){
    					Button b=new Button();
    					b.setPrefSize(60, 60);
        				BackgroundImage bImage = new BackgroundImage(Fighter, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
    					
        				Background backGround = new Background(bImage);
    					b.setBackground(backGround);
    					map.add(b,j,15-i);
    					int x=i;
    					int y=j;
    					b.setOnAction(new EventHandler<ActionEvent>(){
    						public void handle(ActionEvent event) {
    								h.setTarget(((CharacterCell) cell[x][y]).getCharacter());
    						}
    						
    					});
    				}
    			}else{
    			if(cell[i][j] instanceof CollectibleCell && ((CollectibleCell) cell[i][j]).getCollectible()!=null && cell[i][j].isVisible() ){
    				if(((CollectibleCell) cell[i][j]).getCollectible() instanceof Vaccine){
    					Button b=new Button();
    					b.setPrefSize(60, 60);
        				BackgroundImage bImage = new BackgroundImage(Vaccine, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
    					
        				Background backGround = new Background(bImage);
    					b.setBackground(backGround);
    					map.add(b,j,15-i);
    				}
    				if(((CollectibleCell) cell[i][j]).getCollectible() instanceof Supply){
    					Button b=new Button();
    					b.setPrefSize(60, 60);
        				BackgroundImage bImage = new BackgroundImage(Supply, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
    					
        				Background backGround = new Background(bImage);
    					b.setBackground(backGround);
    					map.add(b,j,15-i);
    				}
    			}else{
    				Button b=new Button();
					b.setPrefSize(60, 60);
    				BackgroundImage bImage = new BackgroundImage(empty, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
					
    				Background backGround = new Background(bImage);
					b.setBackground(backGround);
					map.add(b,j,15-i);
					b.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event) {
								h.setTarget(null);
						}
						
					});
    			}
    			
    		}
    		}
    		}
    	
    	Button Help = new Button("help");
    	Help.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Helpwindow.display();
			}
    	});
    	map.add(Help, 15, 1);
    	
    	map.add(new Button(h.getName()),0,17);
    	map.add(new ProgressBar(h.getCurrentHp()/(double)h.getMaxHp()),0,18);
    	map.add(new Button("HP="+h.getCurrentHp()),1,17);
    	map.add(new Button("Actions "),2,17);
    	map.add(new Button(""+h.getActionsAvailable()),3,17);
    	map.add(new Button("attack DMG"),4,17);
    	map.add(new Button(""+h.getAttackDmg()),5,17);
    	map.add(new Button("Vaccines"),6,17);
    	map.add(new Button(""+h.getVaccineInventory().size()),7,17);
    	map.add(new Button("Supplies"),8,17);
    	map.add(new Button(""+h.getSupplyInventory().size()),9,17);
    	if(h.getTarget()!=null){	
    	map.add(new Button(h.getTarget().getName()),15,16);
        map.add(new ProgressBar(h.getTarget().getCurrentHp()/(double)h.getTarget().getMaxHp()),15,17);
        map.add(new Button("HP="+h.getTarget().getCurrentHp()),13,16);
    	}else{
    		map.add(new Button("Target's HP"),15,16);
            map.add(new ProgressBar(0.0),15,17);
            map.add(new Button("HP="+0),14,16);
    	}
    	
    	
    	BackgroundImage bImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(map.getHeight(), map.getWidth()
    			, true, true, true, false));
    	Background back = new Background(bImage);
    	
    	
    	map.setBackground(back);
    	map.setAlignment(Pos.CENTER);
        
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
    
//	@Override
//    public void handle(Event keyEvent) {
//    	System.out.println("x");
//        if (keyEvent.getCode() == KeyCode.W) {
//        	try {
//				h.move(model.characters.Direction.UP);
//			} catch (NotEnoughActionsException e) {
//				// TODO Auto-generated catch block
//		    	System.out.println("xu");
//
//			} catch (MovementException e) {
//				// TODO Auto-generated catch block
//		    	System.out.println("xu1");
//
//			}
//        }
//        if (keyEvent.getCode() == KeyCode.S) {
//            try {
//				h.move(model.characters.Direction.DOWN);
//			} catch (NotEnoughActionsException e) {
//				// TODO Auto-generated catch block
//			} catch (MovementException e) {
//				// TODO Auto-generated catch block
//			}
//        }
//        if (keyEvent.getCode() == KeyCode.D) {
//            try {
//				h.move(model.characters.Direction.RIGHT);
//			} catch (NotEnoughActionsException e) {
//				// TODO Auto-generated catch block
//			} catch (MovementException e) {
//				// TODO Auto-generated catch block
//			}
//        }
//        if (keyEvent.getCode() == KeyCode.A) {
//            try {
//				h.move(model.characters.Direction.LEFT);
//			} catch (NotEnoughActionsException e) {
//				// TODO Auto-generated catch block
//			} catch (MovementException e) {
//				// TODO Auto-generated catch block
//			}
//        }
//        
//    }
//
//   
//   	
    }


