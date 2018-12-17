package controller;

public final class GameController {
	
	private static final GameController INSTANCE = new GameController();
	private War1 warI;
	private War2 warII;
	private Jogo jogo;
	
	private GameController() 
	{
		//TODO
		jogo = new Jogo();
		jogo.criarMapa();
	}
	
	public static GameController getInstance() 
	{
		return INSTANCE;
	}
	
	public Jogo getJogo() 
	{
		return jogo;
	}
}
