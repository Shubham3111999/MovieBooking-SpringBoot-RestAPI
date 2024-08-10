package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class Controller {
	
	@Autowired
	MovieServiceInterface service;
	
	@GetMapping("/movies")
	public List<Movie> getListOfMovies() {
		return service.getListOfMovies();
	} 
	
	@PostMapping("/movie")
	public void addMovieToList(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new RuntimeException("RequestBody Validation Fail");
		}
		service.addMovieToList(movie);
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		return service.getMovieById(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateMovieById(@Valid @RequestBody Movie topic,@PathVariable String id) {
		service.updateMovieById(topic, id);
	}
	
	@DeleteMapping("/movie/{id}")
	public void deleteMovieById(@PathVariable String id) {
		service.deleteMovie(id);
	}
}
