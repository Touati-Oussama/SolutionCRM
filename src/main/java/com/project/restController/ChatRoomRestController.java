package com.project.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.InboxConversation;
import com.project.entities.Projet;
import com.project.entities.User;
import com.project.repos.ConversationRepository;
import com.project.request.ProjetModel;
import com.project.response.JSONResponse;
import com.project.services.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/rooms")
public class ChatRoomRestController {

	@Autowired
	UserService userService;
	
	@Autowired
	ConversationRepository conversationRepository;
	
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(conversationRepository.findAll());
	}
	
	@RequestMapping(path="add",method = RequestMethod.POST)
	public ResponseEntity<?>add(@RequestParam String societe){
		List<User> customers = userService.findBySocieteName(societe);
		List<User> teams = userService.getAllStaffs();
		InboxConversation conversation = new InboxConversation();
		conversation.setSubject(societe);
		List <User> participants = new ArrayList<User>();
		participants.addAll(teams);
		participants.addAll(customers);
		conversation.setParticipants(participants);
		
		return ResponseEntity.ok(conversationRepository.save(conversation));
	}
}
