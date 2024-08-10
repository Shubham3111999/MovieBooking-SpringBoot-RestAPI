package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.communicator.RatingRestCommunicator;

@Service
public class MovieService implements MovieServiceInterface {
	@Autowired
	RatingRestCommunicator ratingRestCommunicator;
	
	List<Movie> list=new ArrayList<Movie>();
	HashMap<String,Movie> map=new HashMap<String, Movie>();

	@Override
	public List<Movie> getListOfMovies() {
		return list;
	}

	@Override
	public void addMovieToList(Movie movie) {
		if(map.containsKey(movie.getId())) {
			throw new IdAlreadyExist("Id Already Exist");
		}
		
		list.add(movie);
		map.put(movie.getId(), movie);
		
		Map<String, Long> movieRatingMap=new HashMap<>();
		movieRatingMap.put(movie.getId(), movie.getMovieRating());
		ratingRestCommunicator.addRating(movieRatingMap);
	}

	@Override
	public Movie getMovieById(String id) {
		if(!map.containsKey(id)) {
			throw new IdNotFound("Id Not Found");
		}
	
		Movie movie=map.get(id);
		
		Long updatedRating=ratingRestCommunicator.getRating(id);
		movie.setMovieRating(updatedRating);
		
		return movie;
	}

	@Override
	public void deleteMovie(String id) {
		if(!map.containsKey(id)) {
			throw new IdNotFound("Id Not Found");
		}
		
		Movie old=map.get(id);
		
		list.remove(old);
		map.remove(id);
		
		ratingRestCommunicator.deleteRating(id);
		
	}

	@Override
	public void updateMovieById(Movie movie, String id) {
		deleteMovie(id);
		movie.setId(id); //set id
		addMovieToList(movie);
		
		Map<String, Long> movieRatingMap=new HashMap<String, Long>();
		movieRatingMap.put(id, movie.getMovieRating());
		ratingRestCommunicator.updateRating(movieRatingMap);
	}


}
