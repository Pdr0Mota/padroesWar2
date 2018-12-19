package controller;

public final class GameController {
	
	private static final GameController INSTANCE = new GameController();
	private int version;
	private Jogo jogo;
	
	private GameController() {
		
	}
	
	public static GameController getInstance() 
	{
		return INSTANCE;
	}
	
	public Jogo getJogo() 
	{
		return jogo;
	}
	
	public int getVersion() {
		return version;
	}

	public void newGame(String mapPath) {
		// TODO Auto-generated method stub
		jogo = new Jogo();	
		jogo.criarMapa(mapPath);
	}
	
	public void setJogadores(String[] cores) {
		for (int i = 0; i < cores.length;i++) {
			jogo.addJogador(cores[i]);
		}
	}
	
	
	
	public void iniciarJogo() throws Exception {
		jogo.rodadaInicial();
	}
	
}
