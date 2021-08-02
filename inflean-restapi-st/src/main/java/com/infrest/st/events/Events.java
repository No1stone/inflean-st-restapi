package com.infrest.st.events;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
@Entity
public class Events {
	
	@Id @GeneratedValue
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
	@Enumerated(EnumType.STRING)
	private EventStatus eventSatus;

}
