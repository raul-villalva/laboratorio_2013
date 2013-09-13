package juegos.estrategia.ia;


import juegos.estrategia.PlanetWars;

public class DistanceIA extends AbstractIA {
	
	private DynamicStrategy dynamicStrategy = new DefaultStrategy();

	public void makeAMove(PlanetWars pw) {	
		this.dynamicStrategy.makeAMove(pw);
	}

	@Override
	public DynamicStrategy getStrategy() {
		// TODO Auto-generated method stub
		return dynamicStrategy;
	}

	@Override
	public void setStrategy(DynamicStrategy ds) {
		// TODO Auto-generated method stub
		this.dynamicStrategy = ds;
	}

}
