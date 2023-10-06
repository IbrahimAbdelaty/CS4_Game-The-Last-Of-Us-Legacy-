package model.collectibles;

import java.util.*;

import exceptions.NoAvailableResourcesException;
import model.characters.*;
import model.world.*;
import static engine.Game.map;

public class Supply implements Collectible {
public Supply(){
	
}

public void pickUp(Hero h) {
		h.getSupplyInventory().add(this);
}

public void use(Hero h) throws NoAvailableResourcesException {
	if(h.getSupplyInventory().size() <=0){
		throw new NoAvailableResourcesException("no vaccines available");
	}
	ArrayList<Supply> SupplyArray=h.getSupplyInventory();
		SupplyArray.remove(this);
	}
}
