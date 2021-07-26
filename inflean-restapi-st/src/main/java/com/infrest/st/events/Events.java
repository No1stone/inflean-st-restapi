package com.infrest.st.events;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Events {
	private Integer id;
	private String name;
	private String description;
	private LocalDateTime closeEnrollmentDatetime;
	private LocalDateTime beginEnrollmentDatetime;
	private LocalDateTime beginEventDateTime;
	private LocalDateTime endEventdateTime;
	private String locatin;
	private int basePrice;
	private int maxPrice;
	private int limitOfenrollment;
	private boolean offline;
	private boolean free;
	private EventStatus eventSatus;

}
