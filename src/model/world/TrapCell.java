package model.world;
import java.util.*;

public class TrapCell extends Cell {
	
	Random rand = new Random();
	private int trapDamage = (rand.nextInt(3)+1)*10; //https://www.educative.io/answers/how-to-generate-random-numbers-in-java
	
	public TrapCell () {
		super();
	}

	public int getTrapDamage() {
		return trapDamage;
	}
	
	
	
	
	

}
