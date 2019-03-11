package com.preternatural.PreternaturalProject.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preternatural.PreternaturalProject.models.Power;
import com.preternatural.PreternaturalProject.models.Stage;
import com.preternatural.PreternaturalProject.services.PowerService;
import com.preternatural.PreternaturalProject.services.StageService;

@RestController
@CrossOrigin
@RequestMapping("/powers")
public class PowerController {

	private PowerService powerService;
	private StageService stageService;
	
	@Autowired
	private void setPowerService(PowerService powerService) {
		this.powerService = powerService;
	}
	
	@Autowired 
	private void setStageService(StageService stageService) {
		this.stageService = stageService;
	}
	
	/*
	 * This method calls the getAllPowers method from powerService to get all 
	 * powers from the database whenever a GET request is made to this endpoint. 
	 * If it's successful, it returns a list of all powers in the database along 
	 * with a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/powers/all
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Power>> getAllPowers() {
		return new ResponseEntity<>(powerService.getAllPowers(), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a int (obtained from the URL path) and passes it to
	 * another function which searches the database for a Power with an ID that 
	 * matches that int whenever a GET request is made to this endpoint. If it's
	 * successful, it returns the Power along with a status code of 200.  
	 * 
	 * ENDPOINT: localhost:8085/powers/getById/Power ID
	 */
	@GetMapping("/getById/{requestId}")
	public ResponseEntity<Power> getPowerById(@PathVariable int requestId) {
		return new ResponseEntity<>(powerService.getPowerById(requestId), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path) and passes it to
	 * another function which searches the database for a Power with a name that 
	 * matches that String whenever a GET request is made to this endpoint. If it's
	 * successful, it returns the Power along with a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/powers/getByName/Power Name
	 */
	@GetMapping("/getByName/{requestName}")
	public ResponseEntity<Power> getPowerByName(@PathVariable String requestName) {
		return new ResponseEntity<>(powerService.getPowerByName(requestName), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path) and passes it to
	 * another function which searches the database for Powers with a Stage that 
	 * matches that String whenever a GET request is made to this endpoint. If it's
	 * successful, it returns all Powers with that Stage and status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/powers/getByStage/Stage Name
	 */
	@GetMapping("/getByStage/{requestStageName}")
	public ResponseEntity<List<Power>> getPowersByStage(@PathVariable String requestStageName) {
		Stage stage = stageService.findStageByName(requestStageName);
		return new ResponseEntity<>(powerService.getPowersByStage(stage), HttpStatus.OK);
	}
	
	/*
	 * This method takes in a String (obtained from the URL path) and passes it to 
	 * another function which searches the database for a Power with a name that 
	 * matches that String whenever a POST request is made to this endpoint. If it's 
	 * successful, it deletes that Power from the database. 
	 * 
	 * ENDPOINT: localhost:8085/powers/delete/Power Name
	 */
	@PostMapping(value = "/delete/{requestName}")
	@Transactional
	public void deletePowerByName(@PathVariable String requestName) {
		powerService.deletePowerByName(requestName);
	}
	
	/*
	 * This method take in a String (in JSON format) from the Request Body, creates a 
	 * JSON Object using that String and then uses the information from the JSON Object
	 * to add a new Power to the database whenever a POST request is made to this 
	 * endpoint. If it's successful, it returns a status code of 200.
	 * 
	 * ENDPOINT: localhost:8085/powers/create
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<Power> createPower(@RequestBody String powerString) {
		
		// takes in powerString from the Request Body
		// and creates a JSON Object called json
		JSONObject json = new JSONObject(powerString);
		
		// creates a new instance of the Power class
		Power pow = new Power();
		
		if (json != null) {
			
			// gets the value of "Name" key from json and 
			// sets it to be the name of the new Power. 
			pow.setName(json.getString("Name"));
			
			// gets the value of "Description" key from json and
			// sets it to be the description of the new Power. 
			pow.setDescription(json.getString("Description"));
			
			// gets the value of "Picture" key from json and 
			// sets it to be the picture of the new Power. 
			pow.setPicture(json.getString("Picture"));
			
			// gets the value of "Stage" key from json and passes it to another 
			// function which searches the database for a Stage that matches. 
			Stage stage = stageService.findStageByName(json.getString("Stage"));
			
			// sets the Stage of the new Power to be equal to be that Stage. 
			pow.setStage(stage);
			
			// calls the createPower function from powerService, passes in 
			// Power pow and creates a new Power in the database. 
			powerService.createPower(pow);
		}
		
		// returns a status code of 200. 
		return new ResponseEntity<Power>(HttpStatus.OK);
	}
	
	/*
	 * This method take in a String (in JSON format) from the Request Body, creates a 
	 * JSON Object using that String and then uses the information from the JSON Object
	 * to select a Power and update its details whenever a PUT request is made to this 
	 * endpoint. 
	 * 
	 * ENDPOINT: localhost:8085/powers/update
	 */
	@PutMapping(value = "/update")
	public void updatePower(@RequestBody String powerString) {
		
		// takes in powerString from the Request Body, and creates
		// a JSON Object called json
		JSONObject json = new JSONObject(powerString);
		
		// gets the value of "ID" key from json and uses it to select 
		// the Power with that ID and set it equal to Power pow. 
		Power pow = powerService.getPowerById(json.getInt("Power ID"));
		
		if (json != null) {
			
			// gets the value of "Name" key from json and
			// sets it to be the Power's name. 
			pow.setName(json.getString("Name"));
			
			// gets the value of "Description" key from json and 
			// sets it to be the Power's description. 
			pow.setDescription(json.getString("Description"));
			pow.setPicture(json.getString("Picture"));	
			
			// gets the value of "Stage" key from json and passes it to another 
			// function that searches the database for a Stage that matches. 
			Stage stage = stageService.findStageByName(json.getString("Stage"));
			
			// sets the Stage of the Power to be equal to that Stage. 
			pow.setStage(stage);
			
			// calls the updatePower function from powerService, passes in
			// Power pow and updates the Power in the database. 
			powerService.updatePower(pow);
		}	
	}	
}
