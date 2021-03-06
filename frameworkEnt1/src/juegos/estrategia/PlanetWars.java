// Contestants do not need to worry about anything in this file. This is just
// helper code that does the boring stuff for you, so you can focus on the
// interesting stuff. That being said, you're welcome to change anything in
// this file if you know what you're doing.
package juegos.estrategia;

import java.util.*;
import java.io.*;


public class PlanetWars {
	// Constructs a PlanetWars object instance, given a string containing a
	// description of a game state.
	ArrayList<String> bufOps= new ArrayList<String>();
	public PlanetWars(String gameStateString) {
		planets = new ArrayList<Planet>();
		fleets = new ArrayList<Fleet>();
		parseGameState(gameStateString);
	}

	// Returns the number of planets. Planets are numbered starting with 0.
	public int numPlanets() {
		return planets.size();
	}

	// Returns the planet with the given planet_id. There are NumPlanets()
	// planets. They are numbered starting at 0.
	public Planet getPlanet(int planetID) {
		return planets.get(planetID);
	}

	// Returns the number of fleets.
	public int numFleets() {
		return fleets.size();
	}

	// Returns the fleet with the given fleet_id. Fleets are numbered starting
	// with 0. There are NumFleets() fleets. fleet_id's are not consistent from
	// one turn to the next.
	public Fleet getFleet(int fleetID) {
		return fleets.get(fleetID);
	}

	// Returns a list of all the planets.
	public List<Planet> planets() {
		return planets;
	}

	// Return a list of all the planets owned by the current player. By
	// convention, the current player is always player number 1.
	public List<Planet> myPlanets() {
		List<Planet> r = new ArrayList<Planet>();
		for (Planet p : planets) {
			if (p.owner() == 1) {
				r.add(p);
			}
		}
		return r;
	}
	// Return a list of all the planets owned by the current player. By
	// convention, the current player is always player number 1.
	public Planet[] getMyPlanets() {
		List<Planet> myplanets = this.myPlanets();
		Planet[] result = new Planet[myplanets.size()];
		int i = 0;
		for (Planet p : myplanets) {
			result[i] = p;
			i++;
		}
		return result;
	}
	// Return a list of all neutral planets.
	public List<Planet> neutralPlanets() {
		List<Planet> r = new ArrayList<Planet>();
		for (Planet p : planets) {
			if (p.owner() == 0) {
				r.add(p);
			}
		}
		return r;
	}

	// Return a list of all the planets owned by rival players. This excludes
	// planets owned by the current player, as well as neutral planets.
	public List<Planet> enemyPlanets() {
		List<Planet> r = new ArrayList<Planet>();
		for (Planet p : planets) {
			if (p.owner() >= 2) {
				r.add(p);
			}
		}
		return r;
	}

	// Return a list of all the planets that are not owned by the current
	// player. This includes all enemy planets and neutral planets.
	public List<Planet> notMyPlanets() {
		List<Planet> r = new ArrayList<Planet>();
		for (Planet p : planets) {
			if (p.owner() != 1) {
				r.add(p);
			}
		}
		return r;
	}

	// Return a list of all the planets that are not owned by the current
	// player. This includes all enemy planets and neutral planets.
	public Planet[] getNotMyPlanets() {
		List<Planet> planetsNot = this.notMyPlanets();
		Planet[] result = new Planet[planetsNot.size()];
		int i = 0;
		for (Planet p : planetsNot) {
			result[i] = p;
			i++;
		}
		return result;
	}

	// Return a list of all the fleets owned by the current player.
	public List<Fleet> myFleets() {
		List<Fleet> r = new ArrayList<Fleet>();
		for (Fleet f : fleets) {
			if (f.owner() == 1) {
				r.add(f);
			}
		}
		return r;
	}

	// Returns the distance between two planets, rounded up to the next highest
	// integer. This is the number of discrete time steps it takes to get
	// between the two planets.
	public int distance(int sourcePlanet, int destinationPlanet) {
		Planet source = planets.get(sourcePlanet);
		Planet destination = planets.get(destinationPlanet);
		double dx = source.x() - destination.x();
		double dy = source.y() - destination.y();
		return (int) Math.ceil(Math.sqrt(dx * dx + dy * dy));
	}

	// Returns the distance between two planets, rounded up to the next highest
	// integer. This is the number of discrete time steps it takes to get
	// between the two planets.
	public int distance(Planet source, Planet destination) {
		double dx = source.x() - destination.x();
		double dy = source.y() - destination.y();
		return (int) Math.ceil(Math.sqrt(dx * dx + dy * dy));
	}

	// Sends an order to the game engine. An order is composed of a source
	// planet number, a destination planet number, and a number of ships. A
	// few things to keep in mind:
	// * you can issue many orders per turn if you like.
	// * the planets are numbered starting at zero, not one.
	// * you must own the source planet. If you break this rule, the game
	// engine kicks your bot out of the game instantly.
	// * you can't move more ships than are currently on the source planet.
	// * the ships will take a few turns to reach their destination. Travel
	// is not instant. See the Distance() function for more info.
	public void issueOrder(int sourcePlanet, int destinationPlanet, int numShips) {
		bufOps.add("" + sourcePlanet + " " + destinationPlanet + " "
				+ numShips);
	}

	// Sends an order to the game engine. An order is composed of a source
	// planet number, a destination planet number, and a number of ships. A
	// few things to keep in mind:
	// * you can issue many orders per turn if you like.
	// * the planets are numbered starting at zero, not one.
	// * you must own the source planet. If you break this rule, the game
	// engine kicks your bot out of the game instantly.
	// * you can't move more ships than are currently on the source planet.
	// * the ships will take a few turns to reach their destination. Travel
	// is not instant. See the Distance() function for more info. 
	
	public void IssueOrder(Planet source, Planet dest, int numShips) {
		bufOps.add("" + source.planetID() + " " + dest.planetID() + " "
				+ numShips);
	
	}

	// Sends the game engine a message to let it know that we're done sending
	// orders. This signifies the end of our turn.
	public void finishTurn() {
		System.out.println(bufOps.size());
		System.out.flush();
		for (String op : bufOps) {
			System.out.println(op);
			System.out.flush();
		}
		System.out.println("go");
		System.out.flush();
	}

	// Returns true if the named player owns at least one planet or fleet.
	// Otherwise, the player is deemed to be dead and false is returned.
	public boolean isAlive(int playerID) {
		for (Planet p : planets) {
			if (p.owner() == playerID) {
				return true;
			}
		}
		for (Fleet f : fleets) {
			if (f.owner() == playerID) {
				return true;
			}
		}
		return false;
	}

	// If the game is not yet over (ie: at least two players have planets or
	// fleets remaining), returns -1. If the game is over (ie: only one player
	// is left) then that player's number is returned. If there are no
	// remaining players, then the game is a draw and 0 is returned.
	public int winner() {
		Set<Integer> remainingPlayers = new TreeSet<Integer>();
		for (Planet p : planets) {
			remainingPlayers.add(p.owner());
		}
		for (Fleet f : fleets) {
			remainingPlayers.add(f.owner());
		}
		switch (remainingPlayers.size()) {
		case 0:
			return 0;
		case 1:
			return ((Integer) remainingPlayers.toArray()[0]).intValue();
		default:
			return -1;
		}
	}

	// Returns the number of ships that the current player has, either located
	// on planets or in flight.
	public int numShips(int playerID) {
		int numShips = 0;
		for (Planet p : planets) {
			if (p.owner() == playerID) {
				numShips += p.numShips();
			}
		}
		for (Fleet f : fleets) {
			if (f.owner() == playerID) {
				numShips += f.numShips();
			}
		}
		return numShips;
	}

	// Returns the production of the given player.
	public int production(int playerID) {
		int prod = 0;
		for (Planet p : planets) {
			if (p.owner() == playerID) {
				prod += p.growthRate();
			}
		}
		return prod;
	}

	// Parses a game state from a string. On success, returns 1. On failure,
	// returns 0.
	private int parseGameState(String s) {
		planets.clear();
		fleets.clear();
		int planetID = 0;
		String[] lines = s.split("\n");
		for (int i = 0; i < lines.length; ++i) {
			String line = lines[i];
			int commentBegin = line.indexOf('#');
			if (commentBegin >= 0) {
				line = line.substring(0, commentBegin);
			}
			if (line.trim().length() == 0) {
				continue;
			}
			String[] tokens = line.split(" ");
			if (tokens.length == 0) {
				continue;
			}
			if (tokens[0].equals("P")) {
				if (tokens.length != 6) {
					return 0;
				}
				double x = Double.parseDouble(tokens[1]);
				double y = Double.parseDouble(tokens[2]);
				int owner = Integer.parseInt(tokens[3]);
				int numShips = Integer.parseInt(tokens[4]);
				int growthRate = Integer.parseInt(tokens[5]);
				Planet p = new Planet(planetID++, owner, numShips, growthRate,
						x, y);
				planets.add(p);
			} else if (tokens[0].equals("F")) {
				if (tokens.length != 7) {
					return 0;
				}
				int owner = Integer.parseInt(tokens[1]);
				int numShips = Integer.parseInt(tokens[2]);
				int source = Integer.parseInt(tokens[3]);
				int destination = Integer.parseInt(tokens[4]);
				int totalTripLength = Integer.parseInt(tokens[5]);
				int turnsRemaining = Integer.parseInt(tokens[6]);
				Fleet f = new Fleet(owner, numShips, source, destination,
						totalTripLength, turnsRemaining);
				fleets.add(f);
			} else {
				return 0;
			}
		}
		return 1;
	}

	// Loads a map from a text file. The text file contains a description of
	// the starting state of a game. See the project wiki for a description of
	// the file format. It should be called the Planet Wars Point-in-Time
	// format. On success, return 1. On failure, returns 0.
	private int loadMapFromFile(String mapFilename) {
		String s = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(mapFilename));
			int c;
			while ((c = in.read()) >= 0) {
				s += (char) c;
			}
		} catch (Exception e) {
			return 0;
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				// Fucked.
			}
		}
		return parseGameState(s);
	}

	// Store all the planets and fleets. OMG we wouldn't wanna lose all the
	// planets and fleets, would we!?
	private ArrayList<Planet> planets;
	private ArrayList<Fleet> fleets;


}
