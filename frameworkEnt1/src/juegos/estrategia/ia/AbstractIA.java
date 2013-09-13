package juegos.estrategia.ia;

import juegos.estrategia.PlanetWars;

public abstract class AbstractIA {
	
	//*public Strategy
	public abstract DynamicStrategy getStrategy();
	public abstract void setStrategy(DynamicStrategy  ds);
	
	public abstract void makeAMove(PlanetWars pw);
}
