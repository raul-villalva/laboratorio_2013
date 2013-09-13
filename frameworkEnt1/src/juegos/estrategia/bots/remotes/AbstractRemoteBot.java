package juegos.estrategia.bots.remotes;

import juegos.estrategia.PlanetWars;
import juegos.estrategia.ia.AbstractIA;
import juegos.estrategia.ia.DefaultStrategy;

public abstract class AbstractRemoteBot {

	public abstract AbstractIA getAbstractIA();

	
	public void play() {
		String line = "";
		String message = "";
		int c;
		try {
			while ((c = System.in.read()) >= 0) {
				switch (c) {
				case '\n':
					if (line.equals("go")) {
						PlanetWars pw = new PlanetWars(message);
						getAbstractIA().makeAMove(pw);
						pw.finishTurn();
						message = "";
					} else {
						message += line + "\n";
					}
					line = "";
					break;
				default:
					line += (char) c;
					break;
				}
			}
		} catch (Exception e) {
			// Owned.
		}
	}
	
	public void ChangeStrategy(AbstractIA ai,String algo){
		if(algo == "default"){
			
			ai.setStrategy(new DefaultStrategy());
			
		}else if(algo =="cualquiera "){
			
		}
		
	}

}
