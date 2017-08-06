package db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="Solutions")
public class SokobanSolution {
	
	
	@Id
	private String levelID;
	private String solution;

	public String getName() {
		return levelID;
	}
	public void setName(String levelID) {
		this.levelID = levelID;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public SokobanSolution(String levelID, String solution) {
		super();
		this.levelID = levelID;
		this.solution = solution;
		
		printValues();
	}
	
	public void printValues()
	{
		
		System.out.println("Sokoban solution -  LevelID: " + this.levelID + " soultion: " + solution);

		
	}
	public SokobanSolution() {}
}
	
	


