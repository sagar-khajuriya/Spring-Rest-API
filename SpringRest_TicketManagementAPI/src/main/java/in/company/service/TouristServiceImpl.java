package in.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.company.dao.ITouristRepo;
import in.company.exception.TouristNotFoundException;
import in.company.model.Tourist;
@Service
public class TouristServiceImpl implements ITouristService {

	@Autowired
	private ITouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		Tourist save = repo.save(tourist);
		return "Tourist saved with id : "+save.getTId();
	}

	@Override
	public Tourist fetchTouristById(Integer tId) {
		// TODO Auto-generated method stub
		return repo.findById(tId).orElseThrow(()->new TouristNotFoundException("Tourist not found for entered id "+tId));
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String updateTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		Optional<Tourist> optional = repo.findById(tourist.getTId());
		if(optional.isPresent()) {
			repo.save(tourist);
			return "Tourist with Id "+tourist.getTId()+" updated";
		}else {
			throw new TouristNotFoundException("Tourist does not exist for id : "+tourist.getTId());
		}
	}

	@Override
	public String updateTouristBudgetById(Integer id, Float hikePercentage) {
		// TODO Auto-generated method stub
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercentage/100)));
			repo.save(tourist);
			return "Tourist Budget is updated for Id "+tourist.getTId();
		}else {
			throw new TouristNotFoundException("Tourist not found for id "+id);
		} 
		
	}

	@Override
	public String deleteTouristById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Tourist with id "+id+" deleted";
		}else {
			throw new TouristNotFoundException("Tourist not found for id "+id);
		}
		
	}

}
