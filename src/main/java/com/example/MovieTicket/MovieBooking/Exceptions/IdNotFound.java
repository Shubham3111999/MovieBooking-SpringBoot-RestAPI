package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IdNotFound extends RuntimeException{

	public IdNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
