package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IdAlreadyExist extends RuntimeException{

	public IdAlreadyExist(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
