package com.summit.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summit.producer.MessageProducer;

@RestController
@RequestMapping("/message")
public class MessageResource {

	@Autowired
	private MessageProducer messageProducer;

	@PostMapping
	public ResponseEntity<?> createMessage(@RequestBody String message) {
		messageProducer.send( message );
		return ResponseEntity.ok().build();
	}
}