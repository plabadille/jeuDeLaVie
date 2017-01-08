/**
 * A class for representing every constants needed by the game.
 * The main constructor build the game with default constants.
 * The others constructors are here to let the user set up the constants or some constants himself
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-03
 */

package model.gameEngine;

public class GameConstants {

    //Default settings:
    //sea constants
    private static final int SEA_WIDTH = 20;
    private static final int SEA_LENGTH = 30;
    private static final int SEA_NUMBER_SARDINE = 20;
    private static final int SEA_NUMBER_SHARK = 6;
    //sardine constants
    private static final int SARDINE_DEATH_AGE = 10;
    private static final int SARDINE_SPAWN_AGE = 5;
    private static final int SARDINE_SPAWN_RATIO = 2;
    //shark constants
    private static final int SHARK_DEATH_AGE = 10;
    private static final int SHARK_STARVING_TIME = 3;
    private static final int SHARK_SPAWN_AGE = 5;
    private static final int SHARK_SPAWN_RATIO = 1;
    private static final int SHARK_IS_TEENAGER = 3;
    private static final int SHARK_IS_ADULT = 6;
    

    private int seaWidth;
    private int seaLenght;
    private int seaSardineNumber;
    private int seaSharkNumber;
    private int sardineDeathAge;
    private int sardineSpawnAge;
    private int sardineSpawnRatio;
    private int sharkDeathAge;
    private int sharkStarvingTime;
    private int sharkSpawnAge;
    private int sharkSpawnRatio;
    private int sharkIsTeenager;
    private int sharkIsAdult;
    
    /**
     * Default constructor using the default constants
     */
    //Default constructor:
    public GameConstants() {
        //sea default constants
        this.seaWidth = SEA_WIDTH;
        this.seaLenght = SEA_LENGTH;
        this.seaSardineNumber = SEA_NUMBER_SARDINE;
        this.seaSharkNumber = SEA_NUMBER_SHARK;
        //sardine default constants
        this.sardineDeathAge = SARDINE_DEATH_AGE;
        this.sharkStarvingTime = SHARK_STARVING_TIME;
        this.sardineSpawnAge = SARDINE_SPAWN_AGE;
        this.sardineSpawnRatio = SARDINE_SPAWN_RATIO;
        //shark default constants
        this.sharkDeathAge = SHARK_DEATH_AGE;
        this.sharkSpawnAge = SHARK_SPAWN_AGE;
        this.sharkSpawnRatio = SHARK_SPAWN_RATIO;
        this.sharkIsTeenager = SHARK_IS_TEENAGER;
        this.sharkIsAdult = SHARK_IS_ADULT;
    }
    
    /**
     * Constructor using constants choose by the user
     * @param seaWidth <int> width of the sea
     * @param seaLenght <int> lenght of the sea
     * @param seaSardineNumber <int> initial number of sardine in the sea
     * @param seaSharkNumber <int> initial number of shark in the sea
     * @param sardineDeathAge <int> death age of sardine
     * @param sardineSpawnAge <int> reproduction age of sardine
     * @param sardineSpawnRatio <int> delay to reproduce of sardine
     * @param sharkDeathAge <int> death age of shark
     * @param sharkStarvingTime <int> number of cycle a shark can survive without eating
     * @param sharkSpawnAge <int> reproduction age of shark
     * @param sharkSpawnRatio <int> delay to reproduce of shark
     * @param sharkIsTeenager <int> age when a child shark became Teenager (alter hunting strategy)
     * @param sharkIsAdult <int> age when a teenager shark became Adult (alter hunting strategy)
     */
    public GameConstants(int seaWidth, int seaLenght, int seaSardineNumber, int seaSharkNumber, int sardineDeathAge, int sardineSpawnAge, int sardineSpawnRatio, int sharkDeathAge, int sharkStarvingTime, int sharkSpawnAge, int sharkSpawnRatio, int sharkIsTeenager, int sharkIsAdult) {
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
        this.sharkStarvingTime = sharkStarvingTime;
        this.sharkSpawnAge = sharkSpawnAge;
        this.sharkSpawnRatio = sharkSpawnRatio;
        this.sharkIsTeenager = sharkIsTeenager;
        this.sharkIsAdult = sharkIsAdult;

    }

    //Constructors using partials client info:  
    /**
     * Constructor using partials constants choose by the user and partial default constants
     * @param seaSardineNumber <int> initial number of sardine in the sea
     * @param seaSharkNumber <int> initial number of shark in the sea
     * @param sardineDeathAge <int> death age of sardine
     * @param sardineSpawnAge <int> reproduction age of sardine
     * @param sardineSpawnRatio <int> delay to reproduce of sardine
     * @param sharkDeathAge <int> death age of shark
     * @param sharkStarvingTime <int> number of cycle a shark can survive without eating
     * @param sharkSpawnAge <int> reproduction age of shark
     * @param sharkSpawnRatio <int> delay to reproduce of shark
     * @param sharkIsTeenager <int> age when a child shark became Teenager (alter hunting strategy)
     * @param sharkIsAdult <int> age when a teenager shark became Adult (alter hunting strategy)
     */
    public GameConstants(int seaSardineNumber, int seaSharkNumber, int sardineDeathAge, int sardineSpawnAge, int sardineSpawnRatio, int sharkDeathAge, int sharkStarvingTime, int sharkSpawnAge, int sharkSpawnRatio, int sharkIsTeenager ,int sharkIsAdult) {
        this(SEA_WIDTH, SEA_LENGTH, seaSardineNumber, seaSharkNumber, sardineDeathAge, sardineSpawnAge, sardineSpawnRatio, sharkDeathAge, sharkStarvingTime, sharkSpawnAge, sharkSpawnRatio, sharkIsTeenager, sharkIsAdult);
    }
    
    
    /**
     * Constructor using partials constants choose by the user and partial default constants
     * @param seaWidth <int> width of the sea
     * @param seaLenght <int> lenght of the sea
     * @param seaSardineNumber <int> initial number of sardine in the sea
     * @param seaSharkNumber <int> initial number of shark in the sea
     */
    public GameConstants(int seaSardineNumber, int seaSharkNumber, int seaWidth, int seaLenght) {
        this(seaWidth, seaLenght, seaSardineNumber, seaSharkNumber, SARDINE_DEATH_AGE, SARDINE_SPAWN_AGE, SARDINE_SPAWN_RATIO, SHARK_DEATH_AGE, SHARK_STARVING_TIME, SHARK_SPAWN_AGE, SHARK_SPAWN_RATIO, SHARK_IS_TEENAGER, SHARK_IS_ADULT);
    }
    
    /**
     * Constructor using partials constants choose by the user and partial default constants
     * @param seaSardineNumber <int> initial number of sardine in the sea
     * @param seaSharkNumber <int> initial number of shark in the sea
     */
    public GameConstants(int seaSardineNumber, int seaSharkNumber) {
        this(SEA_WIDTH, SEA_LENGTH, seaSardineNumber, seaSharkNumber, SARDINE_DEATH_AGE, SARDINE_SPAWN_AGE, SARDINE_SPAWN_RATIO, SHARK_DEATH_AGE, SHARK_STARVING_TIME, SHARK_SPAWN_AGE, SHARK_SPAWN_RATIO, SHARK_IS_TEENAGER, SHARK_IS_ADULT);
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

    public int getSharkIsAdult() {
        return sharkIsAdult;
    }

    public void setSharkIsAdult(int sharkIsAdult) {
        this.sharkIsAdult = sharkIsAdult;
    }

    public int getSharkIsTeenager() {
        return sharkIsTeenager;
    }

    public void setSharkIsTeenager(int sharkIsTeenager) {
        this.sharkIsTeenager = sharkIsTeenager;
    }

	public int getSharkStarvingTime() {
		return sharkStarvingTime;
	}

	public void setSharkStarvingTime(int sharkStarvingTime) {
		this.sharkStarvingTime = sharkStarvingTime;
	}

}
