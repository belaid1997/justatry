package com.example.date.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class DateTimeController {
	
	@Autowired
	ArticleRepository art;

    @PostMapping("/date")
    public void date(@RequestParam("date") 
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        // ...
    }

    @PostMapping("/local-date")
    public void localDate(@RequestParam("localDate") 
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        // ...
    }

    @PostMapping("/local-date-time")
    public void dateTime(@RequestParam("localDateTime") 
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        // ...
    }
    @GetMapping("/getallwithdatetimebefore")
	public List<Article> getAllWithDatetimeBefore(
			@RequestParam("datetime") @DateTimeFormat(pattern="yyyy-MM-dd") Date datetime){
    	return art.findAllWithCreationDateTimeBefore(datetime);
    }
    @GetMapping("/getalldate")
	public List<Article> getAlldate(
			@RequestParam("datetime") @DateTimeFormat(pattern="yyyy-MM-dd") Date datetime){
    	return art.findAllByPublicationDate(datetime);
    }
    
    @GetMapping("/getalldates")
   	public List<Article> getAlldates(){
       	return art.findAll();
       }
    
    @RequestMapping(value="/app",method = RequestMethod.GET)
	public List<Article> listApp() {
		return art.findAll();
	}
    
}
