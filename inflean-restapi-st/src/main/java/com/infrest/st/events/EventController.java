package com.infrest.st.events;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {
	
	@Autowired
	private final EventRepository eventRepository;
	
	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@PostMapping
	public ResponseEntity createEvent(@RequestBody Events event) throws Exception {
		Events newEvents = this.eventRepository.save(event);
		
		URI createUri = linkTo(EventController.class).slash(newEvents.getId()).toUri();
			return ResponseEntity.created(createUri).body(event);
	}

}
