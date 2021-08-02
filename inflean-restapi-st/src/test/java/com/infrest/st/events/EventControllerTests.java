package com.infrest.st.events;

import static org.mockito.Mockito.mockitoSession;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	EventRepository	EventRepository;	
	
	@Test
	public void createEvent() throws Exception {
		Events event = Events.builder()
				.name("String")
				.description("Resp API Development with Spring")
				.beginEnrollmentDatetime(null)
				.closeEnrollmentDatetime(null)
				.beginEventDateTime(null)
				.endEventdateTime(null)
				.basePrice(100)
				.maxPrice(200)
				.limitOfenrollment(100)
				.locatin("asdjasd")
				.build();
		event.setId(10);
		Mockito.when(EventRepository.save(event).thenRetrun(event));
		
		mockMvc.perform(post("/api/events/")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaTypes.HAL_JSON)
				.content(objectMapper.writeValueAsString(event)))
		.andDo(print())
		.andExpect(status().isCreated())
		.andExpect((ResultMatcher) jsonPath("id").exists());
		
	}
}
