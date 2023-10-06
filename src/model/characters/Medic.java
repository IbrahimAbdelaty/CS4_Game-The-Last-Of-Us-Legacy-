package model.characters;

import exceptions.*;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

public class Medic extends Hero{
	public Medic(String name, int maxHp, int attackDmg, int maxActions){
		super(name,maxHp,attackDmg,maxActions);
	}
	
	public void attack() throws InvalidTargetException , NotEnoughActionsException {
		if(this.getActionsAvailable()<=0){
			throw new NotEnoughActionsException ("Not enough actions available");
		}else{
			super.attack();
			this.setActionsAvailable(this.getActionsAvailable()-1);
		}
	}
	 
public void useSpecial() throws NoAvailableResourcesException, InvalidTargetException{
	if(this.getTarget()==null){
		throw new InvalidTargetException("Invalid Target, empty cell");
	}
	if (this.getTarget() instanceof Zombie){
		throw new InvalidTargetException("cannot heal Zombie");
	}
	if(Math.abs(this.getTarget().getLocation().getX()-this.getLocation().getX())>1 | Math.abs(this.getTarget().getLocation().getY()-this.getLocation().getY())>1 ){
		throw new InvalidTargetException("Invalid Target");
	}
	super.useSpecial();
	this.getTarget().setCurrentHp(this.getTarget().getMaxHp());
}

}
