package model.characters;

//import static engine.Game.heroes;
import static engine.Game.zombies;
import static engine.Game.map;

import java.awt.Point;

import model.world.CharacterCell;
//import model.world.CollectibleCell;
//import model.world.TrapCell;
//import exceptions.GameActionException;
import exceptions.InvalidTargetException;
//import exceptions.MovementException;
import exceptions.NotEnoughActionsException;
public class Zombie extends Character {
	static int ZOMBIES_COUNT = 1;
	public Zombie(){
		super("Zombie " + ZOMBIES_COUNT, 40, 10);
		ZOMBIES_COUNT++;
	}
	
	public void attack() throws InvalidTargetException , NotEnoughActionsException {
		
			boolean attack=false;
			for(int i = -1 ; i<2 && !attack;i++){
				for(int j = -1 ; j<2 && !attack; j++){
					if((int) (this.getLocation().getX()+i)<map.length && (int) (this.getLocation().getX()+i)>=0 && (int) (this.getLocation().getY()+j)<map[(int) (this.getLocation().getX()+i)].length && (int) (this.getLocation().getY()+j)>=0 ){
						if(map [(int) (this.getLocation().getX()+i)][(int) (this.getLocation().getY()+j)] instanceof CharacterCell){
							if(((CharacterCell) map [(int) (this.getLocation().getX()+i)][(int) (this.getLocation().getY()+j)]).getCharacter() instanceof Hero  && ((CharacterCell) map [(int) (this.getLocation().getX()+i)][(int) (this.getLocation().getY()+j)]).getCharacter() != null){
								Hero h = (Hero) ((CharacterCell) map [(int) (this.getLocation().getX()+i)][(int) (this.getLocation().getY()+j)]).getCharacter();
								this.setTarget(h);
								super.attack();
								attack=true;
							}
						}
					}
				}
		}
	}
	
	public void onCharacterDeath(){
		int i = 0;
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
			if(i==1){
				break;
			}
		}
		zombies.remove(this);
		super.onCharacterDeath();
		}
	
	
	

}
