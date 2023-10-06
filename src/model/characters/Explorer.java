package model.characters;

import static engine.Game.map;
import model.world.CharacterCell;
import exceptions.*;

public class Explorer extends Hero{
	public Explorer(String name, int maxHp, int attackDmg, int maxActions){
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
	
	public void useSpecial() throws NoAvailableResourcesException , InvalidTargetException{
		super.useSpecial();
		for (int i =0 ; i<map.length;i++){
			for(int j = 0 ; j<map[i].length;j++){
				map[i][j].setVisible(true);
			}
		}
	}

}
