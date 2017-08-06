package db;

public interface DbHandler {
	
	
	public void addSolution(SokobanSolution sol);
	
	public String getSolution(String levelID);

}
