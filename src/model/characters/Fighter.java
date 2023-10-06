package model.characters;

import exceptions.*;

public class Fighter extends Hero{
	public Fighter(String name, int maxHp, int attackDmg, int maxActions){
		super(name, maxHp, attackDmg, maxActions);
	}
	
	public void attack() throws InvalidTargetException , NotEnoughActionsException {
		if(this.isSpecialAction()){
			super.attack();
		}else{
			if(this.getActionsAvailable()<=0){
				throw new NotEnoughActionsException ("Not enough actions available");
			}else{
				super.attack();
				this.setActionsAvailable(this.getActionsAvailable()-1);
			}
		}
		
	}

}
