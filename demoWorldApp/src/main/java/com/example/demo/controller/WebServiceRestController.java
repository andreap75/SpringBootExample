package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;

@RestController
public class WebServiceRestController {
	
	@Autowired
	CountryRepository countryRep;
	
	@Autowired
	CityRepository cityRep;
	
	@RequestMapping(value= "getListCity", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<City> getListCity(){
		List<City> findAll = cityRep.findAll();
		return findAll;
	}
	
	@RequestMapping(value= "countries", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public Country getCountryById(@RequestBody Country co) {
		Country newCountry = new Country();
		newCountry.setName(co.getName());
		Country country = countryRep.save(newCountry);
		return country;
	}
	
	@RequestMapping(value= "cities/{countryId}", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public City getCitiesById(@PathVariable("countryId") Integer countryId, @RequestBody City ci) {
		City newCity = new City();
		Country co = countryRep.findById(countryId).get();
		newCity.setName(ci.getName());
		newCity.setCountry(co);
		City city = cityRep.save(newCity);
		return city;
	}
	
	@RequestMapping(value= "getListCountry", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Country> getListCountry(){
		List<Country> findAll = countryRep.findAll(Sort.by("name"));
		return findAll;
	}
	
	@GetMapping("City/{id}")
	@CrossOrigin(origins = "*")
	public City getCountryById(@PathVariable("id") Integer id) {
		City country = cityRep.findById(id).get();
		return country;
	}
	
	
	@RequestMapping(value= "getListCity/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<City> getListCity(@PathVariable("id") Integer id){
		Country findById = countryRep.findById(id).get();
		List<City> findAll = cityRep.findByCountry(findById);
		return findAll;
	}

}
