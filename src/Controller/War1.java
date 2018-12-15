package Controller;

public class War1 implements Game{
	private String version = "War 1";
	private int PlayerNumber;
	public War1() {
		
	}
	
	public War1(int i) {
		PlayerNumber = i;
	}
	public String getVersion(){
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
