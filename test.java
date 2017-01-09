import model.gameEngine.*;

public class test {
	public static void main(String[] args){
		//GameConstants Constructor:
		//- Default constructor:
		//-- GameConstants()
		
		//- Custom constructor:
		//-- GameConstants(int seaWidth, int seaLenght, int seaSardineNumber, int seaSharkNumber, int sardineDeathAge, int sardineSpawnAge, int sardineSpawnRatio, int sharkDeathAge, int sharkStarvingTime, int sharkSpawnAge, int sharkSpawnRatio, int sharkIsTeenager, int sharkIsAdult)
		
		//- Partial custom constructor:
		//-- GameConstants(int seaSardineNumber, int seaSharkNumber, int sardineDeathAge, int sardineSpawnAge, int sardineSpawnRatio, int sharkDeathAge, int sharkStarvingTime, int sharkSpawnAge, int sharkSpawnRatio, int sharkIsTeenager ,int sharkIsAdult)		
		//-- GameConstants(int seaSardineNumber, int seaSharkNumber, int seaWidth, int seaLenght)
		//-- GameConstants(int seaSardineNumber, int seaSharkNumber)

		GameConstants gc = new GameConstants();
		
		LifeGame game = new LifeGame(gc);
		System.out.println("\n===============================================\n");
		System.out.println("The game start");
		System.out.println("\n===============================================\n");
	
		game.quickRunGame();		
	}
}
