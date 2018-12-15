package Controller;

public class War2 implements Game{
	private String version = "War 2";
	private int PlayerNumber;
	public War2() {
		
	}
	
	public War2(int i) {
		PlayerNumber = i;
	}
	
	public String getVersion() {
		return version;
	}

	@Override
	public void setPlayers(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPlayers() {
		// TODO Auto-generated method stub
		return 0;
	}
}
