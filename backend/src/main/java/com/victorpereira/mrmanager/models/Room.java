package com.victorpereira.mrmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="mettingroom")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="date", nullable=false)
	private String date;
	
	@Column(name="startHour", nullable=false)
	private String startHour;
	
	@Column(name="endHour", nullable=false)
	private String endHour;
}
