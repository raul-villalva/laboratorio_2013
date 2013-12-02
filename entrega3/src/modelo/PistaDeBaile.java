package modelo;

import java.util.ArrayList;

import anotaciones.RemoteBot;
import anotaciones.Robots;

@RemoteBot(conf = "config/conf.properties")
public class PistaDeBaile {
	
	private ArrayList<Robot> robots = new ArrayList<Robot>();

	@Robots
	public ArrayList<Robot> getRobots() {
		return robots;
	}

	/**
	 * @param robots the robots to set
	 */
	public void setRobots(ArrayList<Robot> robots) {
		this.robots = robots;
	}

}
