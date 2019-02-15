package com.team.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.stock.dbservice.classes.Quote;
import com.team.stock.dbservice.classes.Quotes;
import com.team.stock.dbservice.repository.QuoetsRepository;

@RestController
@RequestMapping("/rest/db")
public class DbserviceResource {
	@Autowired
	private QuoetsRepository _QuoetsRepository;
	
	//http://localhost:7000/rest/db/ggg
	@GetMapping("/{username}")
	public List<String>getQuoetsByUserName(@PathVariable("username")
	final String username){
		return _QuoetsRepository.findByusername(username)
		.stream()
		.map(Quote::getQuote)
		.collect(Collectors.toList());
	}
	@PostMapping("/add")
	public List<String>add(@RequestBody final Quotes _Quotes){
		System.out.println(_Quotes.getQuotes());
		_Quotes.getQuotes()
		.stream()
		.map(Quote->new Quote(_Quotes.getUserName(),Quote))
		.forEach(Quote->_QuoetsRepository.save(Quote));
		return getQuoetsByUserName(_Quotes.getUserName());
		//return null;
	}
	
}
