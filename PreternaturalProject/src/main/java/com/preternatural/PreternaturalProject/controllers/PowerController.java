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
	
	@GetMapping("/all")
	public ResponseEntity<List<Power>> getAllPowers() {
		return new ResponseEntity<>(powerService.getAllPowers(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{requestId}")
	public ResponseEntity<Power> getPowerById(@PathVariable int requestId) {
		return new ResponseEntity<>(powerService.getPowerById(requestId), HttpStatus.OK);
	}
	
	@GetMapping("/getByName/{requestName}")
	public ResponseEntity<Power> getPowerByName(@PathVariable String requestName) {
		return new ResponseEntity<>(powerService.getPowerByName(requestName), HttpStatus.OK);
	}
	
	@GetMapping("/getByStage/{requestStageName}")
	public ResponseEntity<List<Power>> getPowersByStage(@PathVariable String requestStageName) {
		Stage stage = stageService.findStageByName(requestStageName);
		return new ResponseEntity<>(powerService.getPowersByStage(stage), HttpStatus.OK);
	}
	
	@PostMapping(value = "/delete/{requestName}")
	@Transactional
	public void deletePowerByName(@PathVariable String requestName) {
		powerService.deletePowerByName(requestName);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Power> createPower(@RequestBody String powerString) {
		
		JSONObject json = new JSONObject(powerString);
		Power pow = new Power();
		
		if (json != null) {
			
			pow.setName(json.getString("Name"));
			pow.setDescription(json.getString("Description"));
			pow.setPicture(json.getString("Picture"));
			
			Stage stage = stageService.findStageByName(json.getString("Stage"));
			pow.setStage(stage);
			
			powerService.createPower(pow);
		}
		
		return new ResponseEntity<Power>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public void updatePower(@RequestBody String powerString) {
		
		JSONObject json = new JSONObject(powerString);
		Power pow = powerService.getPowerById(json.getInt("ID"));
		
		if (json != null) {
			
			pow.setName(json.getString("Name"));
			pow.setDescription(json.getString("Description"));
			pow.setPicture(json.getString("Picture"));	
			
			Stage stage = stageService.findStageByName(json.getString("Stage"));
			pow.setStage(stage);
			
			powerService.updatePower(pow);
		}	
	}	
}
