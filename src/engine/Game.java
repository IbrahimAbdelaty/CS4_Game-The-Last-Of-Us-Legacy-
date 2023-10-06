package engine;

//import static engine.Game.map;
//import static engine.Game.zombies;

import java.awt.Point;
import java.io.*;
import java.util.*;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;
import model.characters.*;
import model.world.*;
import model.collectibles.*;

public class Game {
	public static ArrayList<Hero> availableHeroes=new ArrayList<>();
	public static ArrayList<Hero> heroes= new ArrayList<>();
	public static ArrayList<Zombie> zombies=new ArrayList<>();
	public static Cell [][] map=new Cell[15][15];
	
	public static void loadHeroes(String filePath) throws Exception{
		String line="";
		BufferedReader br = new BufferedReader(new FileReader(filePath)); //https://www.youtube.com/watch?v=-Aud0cDh-J8&t=538s&ab_channel=AlexLee
		while((line=br.readLine()) != null){
			String [] N = line.split(",");
			switch(N[1]){
			case "FIGH":
				availableHeroes.add(new Fighter(N[0],Integer.parseInt(N[2]),Integer.parseInt(N[4]),Integer.parseInt(N[3])));
			break;
			case "MED":
				availableHeroes.add(new Medic(N[0],Integer.parseInt(N[2]),Integer.parseInt(N[4]),Integer.parseInt(N[3])));
				break;
			case "EXP":
				availableHeroes.add(new Explorer(N[0],Integer.parseInt(N[2]),Integer.parseInt(N[4]),Integer.parseInt(N[3])));
				break;
			}
		}
	}
	
	public static void startGame(Hero h){
		
		//Initializing map
		for(int i = 0 ; i<15;i++){
			for(int j = 0 ; j<15;j++){
				map[i][j]=new CharacterCell(null);
			}
		}
		// putting hero in place
		map[0][0]=new CharacterCell(h);
		Point c = new Point(0,0);
		h.setLocation(c);
		heroes.add(h);
		availableHeroes.remove(h);
		
		int i = 0;
		// for adding vaccines
		while (true){
			int x=(int)(Math.random()*15);
			int y=(int)(Math.random()*15);
			if(map[x][y] instanceof CharacterCell && ((CharacterCell) map[x][y]).getCharacter()==null){
				map[x][y]=new CollectibleCell(new Vaccine());
				i++;
			}
			if(i>4){
				break;
			}
		}
		// for adding supplies
		i = 0;
		while (true){
			int x=(int)(Math.random()*15);
			int y=(int)(Math.random()*15);
			if(map[x][y] instanceof CharacterCell && ((CharacterCell) map[x][y]).getCharacter()==null){
				map[x][y]=new CollectibleCell(new Supply());
				i++;
			}
			if(i>4){
				break;
			}
		}
		//for adding trap cells
		i = 0;
		while (true){
			int x=(int)(Math.random()*15);
			int y=(int)(Math.random()*15);
			if(map[x][y] instanceof CharacterCell && ((CharacterCell) map[x][y]).getCharacter()==null){
				map[x][y]=new TrapCell();
				i++;
			}
			if(i>4){
				break;
			}
		}
		// adding zombies
		i = 0;
		while (true){
			int x=(int)(Math.random()*15);
			int y=(int)(Math.random()*15);
			if(map[x][y] instanceof CharacterCell && ((CharacterCell) map[x][y]).getCharacter()==null){
				Zombie z= new Zombie();
				Point p = new Point(x,y);
				z.setLocation(p);
				zombies.add(z);
				map[x][y]=new CharacterCell(z);
				i++;
			}
			if(i>9){
				break;
			}
		}
		h.Visibility();
		
	}
	
	public static boolean checkWin(){
		boolean noVaccinecells=true;
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				if(map[i][j] instanceof CollectibleCell){
					if(((CollectibleCell) map[i][j]).getCollectible() instanceof Vaccine && ((CollectibleCell) (map[i][j])).getCollectible()!=null){
						noVaccinecells=false;
					}
				}
			}
		}
		
		boolean allvaccinesused=true;
		for(int i = 0 ; i<heroes.size() ; i++){
			if(!((heroes.get(i).getVaccineInventory()).isEmpty())){
			allvaccinesused=false;
			}
		}
			
		if(allvaccinesused & noVaccinecells & heroes.size()>=5){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static boolean checkGameOver(){
		if(heroes.size()<=0){
			return true;
		}
		boolean noVaccinecells=true;
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				if(map[i][j] instanceof CollectibleCell){
					if(((CollectibleCell) map[i][j]).getCollectible() instanceof Vaccine && ((CollectibleCell) map[i][j]).getCollectible()!=null){
						noVaccinecells=false;
					}
				}
			}
		}
		boolean allvaccinesused=true;
		for(int i = 0 ; i<heroes.size() ; i++){
			if(heroes.get(i).getVaccineInventory().size()>0){
			allvaccinesused=false;
			}
		}
		if((allvaccinesused && noVaccinecells) | checkWin()){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void endTurn() throws InvalidTargetException , NotEnoughActionsException{
		for (int i =0 ; i<15;i++){
			for(int j = 0 ; j<15;j++){
				map[i][j].setVisible(false);
			}
		}
		
		//zombies attack
		for(int c = 0 ; c<zombies.size();c++){
			Zombie z = zombies.get(c);
			z.attack();
		}
		// adding zombies
		int i = 0;
		while (true){
			int x=(int)(Math.random()*15);
			int y=(int)(Math.random()*15);
			if(map[x][y] instanceof CharacterCell){
				if(((CharacterCell)map[x][y]).getCharacter()==null){
					Zombie z= new Zombie();
					Point p = new Point(x,y);
					z.setLocation(p);
					zombies.add(z);
					map[x][y]=new CharacterCell(z);
					i++;
				}
			}
			if(i==1){
				break;
			}
			
			
		}
		
		//all setting zombies target to null
		for(int c1 = 0 ; c1<zombies.size();c1++){
			Zombie z = zombies.get(c1);
			z.setTarget(null);
		}
		
		//set heroes attributes
		for(int i1 = 0 ;i1<heroes.size();i1++){
			heroes.get(i1).Visibility();
			heroes.get(i1).setActionsAvailable(heroes.get(i1).getMaxActions());
			heroes.get(i1).setSpecialAction(false);
			heroes.get(i1).setTarget(null);
		}
		
		
		
		
		
		
		
		
	}
	
}
	

