package in.company.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.company.model.Tourist;
import in.company.service.ITouristService;

@RestController
@RequestMapping("/api/tourist/")
public class TouristController {
	
	@Autowired
	private ITouristService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		String registerTourist = service.registerTourist(tourist);
		return new ResponseEntity<String>(registerTourist,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Tourist> fetchTouristDetailsById(@PathVariable Integer id){
		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Tourist>> fetchAllTourist(){
		List<Tourist> list = service.fetchAllTourist();
		return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateTouristByDetails(@RequestBody Tourist tourist){
		String updateTourist = service.updateTourist(tourist);
		return new ResponseEntity<String>(updateTourist,HttpStatus.OK);
	}
	
	@PatchMapping("/modifyById/{id}/{hikePer}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable Integer id,@PathVariable Float hikePer){
		String budgetById = service.updateTouristBudgetById(id, hikePer);
		return new ResponseEntity<String>(budgetById,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable Integer id){
		String deleteTouristById = service.deleteTouristById(id);
		return new ResponseEntity<String>(deleteTouristById,HttpStatus.OK);
	}
	
}
