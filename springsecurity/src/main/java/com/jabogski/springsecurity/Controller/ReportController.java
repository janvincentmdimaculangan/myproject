package com.jabogski.springsecurity.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jabogski.springsecurity.Exception.ResourceNotFoundException;
import com.jabogski.springsecurity.model.Group;

import com.jabogski.springsecurity.repository.GroupRepository;
import javax.validation.Valid;


@RestController
public class ReportController {
	
	
	@Autowired
	private GroupRepository groupRepository;
	
	
	@GetMapping("/report")
	public ResponseEntity<List<Group>>getAllGroup(){
		List<Group> groups = (List<Group>) groupRepository.findAll();
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
		
	}
	
	@GetMapping("/report/{id}")
	public ResponseEntity<Group> getGroupById(@PathVariable(value = "id") Long groupId)
			throws ResourceNotFoundException {
		Group groups = groupRepository.findById(groupId)
				.orElseThrow(() -> new ResourceNotFoundException("Report not found for this id :: " + groupId));
		return ResponseEntity.ok().body(groups);
	}
	
	@PostMapping("/add")
	public Group createReport(@Valid @RequestBody Group group) {
		return groupRepository.save(group);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Group> updateReport(@PathVariable(value = "id") Long reportId,
			@Valid @RequestBody Group reportDetails) throws ResourceNotFoundException {
		Group group = groupRepository.findById(reportId)
				.orElseThrow(() -> new ResourceNotFoundException("Report not found for this id :: " + reportId));

		group.setTicketnumber(reportDetails.getTicketnumber());
		group.setStorenumaber(reportDetails.getStorenumaber());
		group.setStorename(reportDetails.getStorename());
		group.setStatus(reportDetails.getStatus());
		group.setRecomendation(reportDetails.getRecomendation());
		group.setEquipment(reportDetails.getEquipment());
		group.setDatereported(reportDetails.getDatereported());
		group.setIssue(reportDetails.getIssue());
		group.setDatefixed(reportDetails.getDatefixed());
		final Group updatedReport = groupRepository.save(group);
		return ResponseEntity.ok(updatedReport);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long reportId)
			throws ResourceNotFoundException {
		Group group = groupRepository.findById(reportId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + reportId));

		groupRepository.delete(group);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
