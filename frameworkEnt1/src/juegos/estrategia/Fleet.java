package juegos.estrategia;
public class Fleet implements Comparable<Fleet>, Cloneable {
    // Initializes a fleet.
    public Fleet(int owner,
		 int numShips,
		 int sourcePlanet,
		 int destinationPlanet,
		 int totalTripLength,
		 int turnsRemaining) {
	this.owner = owner;
	this.numShips = numShips;
	this.sourcePlanet = sourcePlanet;
	this.destinationPlanet = destinationPlanet;
	this.totalTripLength = totalTripLength;
	this.turnsRemaining = turnsRemaining;
    }

    // Initializes a fleet.
    public Fleet(int owner,
		 int numShips) {
	this.owner = owner;
	this.numShips = numShips;
	this.sourcePlanet = -1;
	this.destinationPlanet = -1;
	this.totalTripLength = -1;
	this.turnsRemaining = -1;
    }

    // Accessors and simple modification functions. These should be mostly
    // self-explanatory.
    public int owner() {
	return owner;
    }

    public int numShips() {
	return numShips;
    }

    public int sourcePlanet() {
	return sourcePlanet;
    }

    public int destinationPlanet() {
	return destinationPlanet;
    }

    public int totalTripLength() {
	return totalTripLength;
    }

    public int turnsRemaining() {
	return turnsRemaining;
    }

    public void removeShips(int amount) {
	numShips -= amount;
    }

    // Subtracts one turn remaining. Call this function to make the fleet get
    // one turn closer to its destination.
    public void timeStep() {
	if (turnsRemaining > 0) {
	    --turnsRemaining;
	} else {
	    turnsRemaining = 0;
	}
    }


    private int owner;
    private int numShips;
    private int sourcePlanet;
    private int destinationPlanet;
    private int totalTripLength;
    private int turnsRemaining;
	
	private Fleet(Fleet _f) {
		owner = _f.owner;
		numShips = _f.numShips;
		sourcePlanet = _f.sourcePlanet;
		destinationPlanet = _f.destinationPlanet;
		totalTripLength = _f.totalTripLength;
		turnsRemaining = _f.turnsRemaining;
	}
	public Object clone() {
		return new Fleet(this);
	}

	@Override
	public int compareTo(Fleet o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
