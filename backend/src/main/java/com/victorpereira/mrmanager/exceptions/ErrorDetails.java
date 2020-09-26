package com.victorpereira.mrmanager.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDetails {
	
	private Date timeStamp;
	
	private String message;
	
	private String details;
}
