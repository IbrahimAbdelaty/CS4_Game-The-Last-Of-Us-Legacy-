package model.collectibles;

import static engine.Game.availableHeroes;
import static engine.Game.heroes;
import static engine.Game.map;

import java.awt.Point;
import java.util.*;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import model.characters.*;
import model.world.CharacterCell;

public class Vaccine implements Collectible {
	public Vaccine(){
		
	}

	public void pickUp(Hero h) {
			h.getVaccineInventory().add(this);
	}
	
	public void use(Hero h) throws InvalidTargetException, NoAvailableResourcesException, NotEnoughActionsException {
		
		
		h.cure();
		
	}	
	
}
