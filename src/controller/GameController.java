package controller;

public final class GameController {
	
	private static final GameController INSTANCE = new GameController();
	private War1 warI;
	private War2 warII;
	
	private GameController() 
	{
		//TODO
	}
	
	public static GameController getInstance() 
	{
		return INSTANCE;
	}
}
