package model.characters;


import java.awt.Point;
import java.util.*;

import javafx.scene.Node;
import engine.Game;
import exceptions.*;
import model.collectibles.*;
import model.world.*;
import static engine.Game.map;
import static engine.Game.heroes;
import static engine.Game.availableHeroes;


public abstract class Hero extends Character {
private int actionsAvailable;
private int maxActions;
private boolean specialAction=false;
private ArrayList<Vaccine> vaccineInventory=new ArrayList<>();
private ArrayList<Supply> supplyInventory=new ArrayList<>();
  public Hero(String name, int maxHp, int attackDmg, int maxActions){
	  super(name, maxHp, attackDmg);
	  this.maxActions=maxActions;
	  actionsAvailable=maxActions;
  }
  
  
public int getActionsAvailable() {
	return actionsAvailable;
}

public void setActionsAvailable(int actionsAvailable) {
	this.actionsAvailable = actionsAvailable;
}

public int getMaxActions() {
	return maxActions; 
}

public ArrayList<Vaccine> getVaccineInventory() {
	return vaccineInventory;
}

public ArrayList<Supply> getSupplyInventory() {
	return supplyInventory;
}

public boolean isSpecialAction() {
	return specialAction;
}
public void cure()throws InvalidTargetException , NoAvailableResourcesException,NotEnoughActionsException{
	if(this.getLocation()==null){
		this.setLocation(this.getTarget().getLocation());
	}
	
	if(this.getTarget()==null){
		throw new InvalidTargetException("Invalid Target, empty cell");
	}
	
	if(Math.abs(this.getTarget().getLocation().getX()-this.getLocation().getX())>1 | Math.abs(this.getTarget().getLocation().getY()-this.getLocation().getY())>1 ){
		throw new InvalidTargetException("Invalid Target");
	}
	
	if (this.getTarget() instanceof Hero){
		throw new InvalidTargetException("cannot cure Hero");
		}
	
	if (this.vaccineInventory.size()==0){
		throw new NoAvailableResourcesException("no vaccines available");
	}
	
	if(this.actionsAvailable==0){
		throw new NotEnoughActionsException("No action points available");
	}
	
	
	this.setActionsAvailable(getActionsAvailable()-1);
	Game.zombies.remove(this.getTarget());
	Hero h1 = availableHeroes.get(((int)(Math.random()*availableHeroes.size())));
	availableHeroes.remove(h1);
	h1.setLocation(this.getTarget().getLocation());;
	map[this.getTarget().getLocation().x][this.getTarget().getLocation().y]=new CharacterCell(h1);
	heroes.add(h1);
	h1.Visibility();
	this.setTarget(null);
	this.vaccineInventory.remove(0);
	
	
	
}
public void setSpecialAction(boolean specialAction) {
	this.specialAction = specialAction;
}


public void attack() throws InvalidTargetException , NotEnoughActionsException {
	if(this.getTarget()==null){
		throw new InvalidTargetException("Invalid Target, empty cell");
	}
	if(Math.abs(this.getTarget().getLocation().getX()-this.getLocation().getX())>1 || Math.abs(this.getTarget().getLocation().getY()-this.getLocation().getY())>1 ){
		throw new InvalidTargetException("Invalid Target");
	}
	if(this.getTarget()==null ){
		throw new InvalidTargetException("Cannot attack empty cell");
	}
	if(this.getTarget().getLocation().getX()>14 || this.getTarget().getLocation().getX()<0 || this.getTarget().getLocation().getY()>14 || this.getTarget().getLocation().getY()<0){
		throw new InvalidTargetException("Target out of bound");
	}

	
	if (this.getTarget() instanceof Hero){
		throw new InvalidTargetException("cannot attack Hero");
	}
	
		super.attack();
	
}

public void Visibility(){
	int x=(int)this.getLocation().getX();
	int y=(int)this.getLocation().getY();
	map[x][y].setVisible(true);
	if(x<14){
		if(map[x+1][y]==null){
			map[x+1][y]=new CharacterCell(null);
		}
		map[x+1][y].setVisible(true);
		if(y<14){
			if(map[x+1][y+1]==null){
				map[x+1][y+1]=new CharacterCell(null);
			}
			map[x+1][y+1].setVisible(true);
		}
		if(y>0){
			if(map[x+1][y-1]==null){
				map[x+1][y-1]=new CharacterCell(null);
			}
			map[x+1][y-1].setVisible(true);
		}
	}
	if(x>0){
		if(map[x-1][y]==null){
			map[x-1][y]=new CharacterCell(null);
		}
		map[x-1][y].setVisible(true);
		if(y<14){
			if(map[x-1][y+1]==null){
				map[x-1][y+1]=new CharacterCell(null);
			}
			map[x-1][y+1].setVisible(true);
		}
		if(y>0){
			if(map[x-1][y-1]==null){
				map[x-1][y-1]=new CharacterCell(null);
			}
			map[x-1][y-1].setVisible(true);
		}
	}
	if(y<14){
		if(map[x][y+1]==null){
			map[x][y+1]=new CharacterCell(null);
		}
		map[x][y+1].setVisible(true);
	}
	if(y>0){
		if(map[x][y-1]==null){
			map[x][y-1]=new CharacterCell(null);
		}
		map[x][y-1].setVisible(true);
	}
}

public void move(Direction d) throws NotEnoughActionsException , MovementException {
	if(this.actionsAvailable<=0){
		throw new NotEnoughActionsException("Not enought actions available");
	}
	int x = (int)this.getLocation().getX();
	int y = (int)this.getLocation().getY();
	switch(d){
	case UP:
		if(x<14){
			if(map[x+1][y] instanceof CharacterCell && ((CharacterCell) map[x+1][y]).getCharacter() != null){
				throw new MovementException("Cannot move in an occupied cell");
			}
			//update old map cell
			map [x][y]= new CharacterCell(null);
			//update character's location
			Point p = new Point(x+1,y);
			this.setLocation(p);
			//update new map cell and check if it is a collectible
			if(map [x+1][y] instanceof CollectibleCell && (((CollectibleCell) map [x+1][y]).getCollectible())!= null ){
				(((CollectibleCell) map [x+1][y]).getCollectible()).pickUp(this);
				map [x+1][y]= new CharacterCell(this);
			}
			//check if new cell trap
			else if(map [x+1][y] instanceof TrapCell){
				int trapdmg=((TrapCell) map [x+1][y]).getTrapDamage();
				this.setCurrentHp(this.getCurrentHp()-trapdmg);
				map [x+1][y]= new CharacterCell(this);
			}else{
				map [x+1][y]= new CharacterCell(this);
			}
		}else{
			throw new MovementException("Invalid Move");
		}
		break;
	case DOWN:
		if(x>0){
			if(map[x-1][y] instanceof CharacterCell && ((CharacterCell) map[x-1][y]).getCharacter() != null){
				throw new MovementException("Cannot move in an occupied cell");
			}
			map [x][y]= new CharacterCell(null);
			Point p = new Point(x-1,y);
			this.setLocation(p);
			if(map [x-1][y] instanceof CollectibleCell && (((CollectibleCell) map [x-1][y]).getCollectible())!= null){
				(((CollectibleCell) map [x-1][y]).getCollectible()).pickUp(this);
				map [x-1][y]= new CharacterCell(this);
			}else if(map [x-1][y] instanceof TrapCell){
				int trapdmg=((TrapCell) map [x-1][y]).getTrapDamage();
				this.setCurrentHp(this.getCurrentHp()-trapdmg);
				map [x-1][y]= new CharacterCell(this);
			}else{
				map [x-1][y]= new CharacterCell(this);
			}
		}else{
			throw new MovementException("Invalid Move"); 
		}
		break;
	case RIGHT:
		if(y<14){
			if(map[x][y+1] instanceof CharacterCell && ((CharacterCell) map[x][y+1]).getCharacter() != null){
				throw new MovementException("Cannot move in an occupied cell");
			}
			map [x][y]= new CharacterCell(null);
			Point p = new Point(x,y+1);
			this.setLocation(p);
			if(map [x][y+1] instanceof CollectibleCell && (((CollectibleCell) map [x][y+1]).getCollectible())!= null){
				(((CollectibleCell) map [x][y+1]).getCollectible()).pickUp(this);
				map [x][y+1]= new CharacterCell(this);
			}else if(map [x][y+1] instanceof TrapCell){
				int trapdmg=((TrapCell) map [x][y+1]).getTrapDamage();
				this.setCurrentHp(this.getCurrentHp()-trapdmg);
				map [x][y+1]= new CharacterCell(this);
			}else{
			map [x][y+1]= new CharacterCell(this);
			}
		}else{
			throw new MovementException("Invalid Move");
		}
		break;
	case LEFT:
		if(y>0){
			if(map[x][y-1] instanceof CharacterCell && ((CharacterCell) map[x][y-1]).getCharacter() != null){
				throw new MovementException("Cannot move in an occupied cell");
			}
			map [x][y]= new CharacterCell(null);
			Point p = new Point(x,y-1);
			this.setLocation(p);
			if(map [x][y-1] instanceof CollectibleCell && (((CollectibleCell) map [x][y-1]).getCollectible())!= null){
				(((CollectibleCell) map [x][y-1]).getCollectible()).pickUp(this);
				map [x][y-1]= new CharacterCell(this);
			}else if(map [x][y-1] instanceof TrapCell){
				int trapdmg=((TrapCell) map [x][y-1]).getTrapDamage();
				this.setCurrentHp(this.getCurrentHp()-trapdmg);
				map [x][y-1]= new CharacterCell(this);
			}else{
			map [x][y-1]= new CharacterCell(this);
			}
		}else{
			throw new MovementException("Invalid Move");
		}
		break;
		}
	if(this.getCurrentHp()<=0){
		this.onCharacterDeath();
	}else{
		this.Visibility();
	}
	this.actionsAvailable--;
	}

public void useSpecial() throws NoAvailableResourcesException , InvalidTargetException{
	if(this.supplyInventory.size()<1){
		throw new NoAvailableResourcesException("Not enough supplies");
	}
	this.setSpecialAction(true);
	this.supplyInventory.remove(0);
}
public void onCharacterDeath(){
	heroes.remove(this); 
	super.onCharacterDeath();
	}



}
