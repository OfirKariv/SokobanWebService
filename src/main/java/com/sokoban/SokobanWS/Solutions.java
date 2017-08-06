package com.sokoban.SokobanWS;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import db.DbHandler;
import db.DbSolutionHandler;
import db.SokobanSolution;


@Path("solutions")
public class Solutions {
	
	private DbHandler dbHandler = new DbSolutionHandler();
	
	
	//Get information
	/** This functions is used to get the solution by using levelID (level name).
	 * 
	 * @param levelID
	 * @return solution
	 */
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("{levelID}")
    public String getSolution(@PathParam("levelID") String levelID) {
		return dbHandler.getSolution(levelID);
    }
	
	/**
	 * 
	 * This functions is used to insert data into database by using this pattrent:
	 * http://*************?levelID="name_of_level"&soultion="the_solution"
	 * @param levelID
	 * @param solution
	 */
	@GET  
	@Consumes(MediaType.TEXT_PLAIN)
    public void addSolution(@QueryParam("levelID") String levelID, @QueryParam("solution") String solution) {
		SokobanSolution sol = new SokobanSolution(levelID, solution);
        dbHandler.addSolution(sol);
    }
}
