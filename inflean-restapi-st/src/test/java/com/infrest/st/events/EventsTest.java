package com.infrest.st.events;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class EventsTest {

	@Test
	public void builder() {
		Events event = Events.builder()
				.name("inf Spring RestAPI")
				.description("description")
				.build();
		assertThat(event).isNotNull();
	}
	
	@Test
	public void javaBean() {
		Events event = new Events();
		String name = "Event";
		String Desc = "Sptring";
		event.setName(name);
		event.setDescription(Desc);
		
		assertThat(event.getName()).isEqualTo(name);
		assertThat(event.getDescription()).isEqualTo(Desc);
		
	}
}
