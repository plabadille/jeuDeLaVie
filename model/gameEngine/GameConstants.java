package model.gameEngine;

//This class handle all the constants needed to run the game. 
//The main constructor build the game with the static final under there, if you want to change the default settings, change them.
//The other constructor are here to let the user to set up the constants by himself.
public class GameConstants {
	
	//Default settings:
		//sea constants
		private static final int SEA_WIDTH = 70;
		private static final int SEA_LENGTH = 100;
		private static final int SEA_NUMBER_SARDINE = 20;
		private static final int SEAR_NUMBER_SHARK = 6;
		//sardine constants
		private static final int SARDINE_DEATH_AGE = 10;
		private static final int SARDINE_SPAWN_AGE = 5;
		private static final int SARDINE_SPAWN_RATIO = 2;
		//shark constants
		private static final int SHARK_DEATH_AGE = 10;
		private static final int SHARK_SPAWN_AGE = 5;
		private static final int SHARK_SPAWN_RATIO = 1;
	
	private int seaWidth;
	private int seaLenght;
	private int seaSardineNumber;
	private int seaSharkNumber;
	private int sardineDeathAge;
	private int sardineSpawnAge;
	private int sardineSpawnRatio;
	private int sharkDeathAge;
	private int sharkSpawnAge;
	private int sharkSpawnRatio;
	
	//Default constructor:
	public GameConstants() {
		//sea default constants
		this.seaWidth = SEA_WIDTH;
		this.seaLenght = SEA_LENGTH;
		this.seaSardineNumber = SEA_NUMBER_SARDINE;
		this.seaSharkNumber = SEAR_NUMBER_SHARK;
		//sardine default constants
		this.sardineDeathAge = SARDINE_DEATH_AGE;
		this.sardineSpawnAge = SARDINE_SPAWN_AGE;
		this.sardineSpawnRatio = SARDINE_SPAWN_RATIO;
		//shark default constants
		this.sharkDeathAge = SHARK_DEATH_AGE;
		this.sharkSpawnAge = SHARK_SPAWN_AGE;
		this.sharkSpawnRatio = SHARK_SPAWN_RATIO;
	}
	
	//Constructor using client info:
	public GameConstants(int seaWidth, int seaLenght, int seaSardineNumber, int seaSharkNumber, int sardineDeathAge, int sardineSpawnAge, int sardineSpawnRatio, int sharkDeathAge, int sharkSpawnAge, int sharkSpawnRatio) {
		//sea default constants
		this.seaWidth = seaWidth;
		this.seaLenght = seaLenght;
		this.seaSardineNumber = seaSardineNumber;
		this.seaSharkNumber = seaSharkNumber;
		//sardine default constants
		this.sardineDeathAge = sardineDeathAge;
		this.sardineSpawnAge = sardineSpawnAge;
		this.sardineSpawnRatio = sardineSpawnRatio;
		//shark default constants
		this.sharkDeathAge = sharkDeathAge;
		this.sharkSpawnAge = sharkDeathAge;
		this.sharkSpawnRatio = sharkSpawnRatio;
	}
	
	//Constructors using partials client info:
	public GameConstants(int seaSardineNumber, int seaSharkNumber, int sardineDeathAge, int sardineSpawnAge, int sardineSpawnRatio, int sharkDeathAge, int sharkSpawnAge, int sharkSpawnRatio) {
		this(SEA_WIDTH, SEA_LENGTH, seaSardineNumber, seaSharkNumber, sardineDeathAge, sardineSpawnAge, sardineSpawnRatio, sharkDeathAge, sharkSpawnAge, sharkSpawnRatio);
	}
	
	public GameConstants(int seaSardineNumber, int seaSharkNumber) {
		this(SEA_WIDTH, SEA_LENGTH, seaSardineNumber, seaSharkNumber, SARDINE_DEATH_AGE, SARDINE_SPAWN_AGE, SARDINE_SPAWN_RATIO, SHARK_DEATH_AGE, SHARK_SPAWN_AGE, SHARK_SPAWN_RATIO);
	}
	
	//getter and setter:
	public int getSeaWidth() {
		return seaWidth;
	}

	public void setSeaWidth(int seaWidth) {
		this.seaWidth = seaWidth;
	}

	public int getSeaLenght() {
		return seaLenght;
	}

	public void setSeaLenght(int seaLenght) {
		this.seaLenght = seaLenght;
	}

	public int getSeaSardineNumber() {
		return seaSardineNumber;
	}

	public void setSeaSardineNumber(int seaSardineNumber) {
		this.seaSardineNumber = seaSardineNumber;
	}

	public int getSeaSharkNumber() {
		return seaSharkNumber;
	}

	public void setSeaSharkNumber(int seaSharkNumber) {
		this.seaSharkNumber = seaSharkNumber;
	}

	public int getSardineDeathAge() {
		return sardineDeathAge;
	}

	public void setSardineDeathAge(int sardineDeathAge) {
		this.sardineDeathAge = sardineDeathAge;
	}

	public int getSardineSpawnAge() {
		return sardineSpawnAge;
	}

	public void setSardineSpawnAge(int sardineSpawnAge) {
		this.sardineSpawnAge = sardineSpawnAge;
	}

	public int getSardineSpawnRatio() {
		return sardineSpawnRatio;
	}

	public void setSardineSpawnRatio(int sardineSpawnRatio) {
		this.sardineSpawnRatio = sardineSpawnRatio;
	}

	public int getSharkDeathAge() {
		return sharkDeathAge;
	}

	public void setSharkDeathAge(int sharkDeathAge) {
		this.sharkDeathAge = sharkDeathAge;
	}

	public int getSharkSpawnAge() {
		return sharkSpawnAge;
	}

	public void setSharkSpawnAge(int sharkSpawnAge) {
		this.sharkSpawnAge = sharkSpawnAge;
	}

	public int getSharkSpawnRatio() {
		return sharkSpawnRatio;
	}

	public void setSharkSpawnRatio(int sharkSpawnRatio) {
		this.sharkSpawnRatio = sharkSpawnRatio;
	}
	
}
