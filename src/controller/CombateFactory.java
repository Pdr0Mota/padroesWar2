package controller;

public class CombateFactory {
	
	CombateController war;
	
	public CombateFactory(int version) 
	{
		if(version==1) 
		{
			war = new CombateController();
		}
		else if(version==2) 
		{
			war = new CombateController2();
		}
	}
	
	public CombateController getControl() 
	{
		return war;
	}
}
