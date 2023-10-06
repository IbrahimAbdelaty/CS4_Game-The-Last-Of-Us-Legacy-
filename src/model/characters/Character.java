package model.characters;

import java.awt.*;
//import java.util.*;
import exceptions.*;
import static engine.Game.map;
import model.world.*;




public abstract class Character {
	private String name;
	private Point location;
	private int maxHp;
	private int currentHp;
	private int attackDmg;
	private Character target;
	public Character(String name, int maxHp, int attackDmg){
		this.name=name;
		this.maxHp=maxHp;
		this.attackDmg=attackDmg;
		currentHp = maxHp;
	}
	
	
	public String getName() {
		return name;
	}


	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}


	public int getMaxHp() {
		return maxHp;
	}


	public int getAttackDmg() {
		return attackDmg;
	}


	public int getCurrentHp() {
		return currentHp;
	}


	public void setCurrentHp(int currentHp) {
		if(currentHp < 0) 
			this.currentHp = 0;
		else if(currentHp > maxHp) 
			this.currentHp = maxHp;
		else 
			this.currentHp = currentHp;
	}
	


	public Character getTarget() {
		return target;
	}


	public void setTarget(Character target) {
		this.target = target;
	}
	
	public void onCharacterDeath(){
		for (int i =0 ; i<map.length;i++){
			for(int j = 0 ; j<map[i].length;j++){
			if(map[i][j] instanceof CharacterCell){
				if(((CharacterCell)map[i][j]).getCharacter()==this){
					map[i][j]=new CharacterCell(null);
					}
				}
			}
		}
	}
	
	public void defend(Character c){
		c.setCurrentHp(c.getCurrentHp()-(this.attackDmg/2));
	}
	
	public void attack() throws InvalidTargetException , NotEnoughActionsException{
			target.setCurrentHp(target.getCurrentHp()-this.attackDmg);
			target.defend(this);
			if(target.getCurrentHp()==0){
				target.onCharacterDeath();
				this.setTarget(null);
			}
			if(this.getCurrentHp()==0){
				this.onCharacterDeath();
				target.setTarget(null);
			}
		
	}


	

	
	
	
}
