package in.company.service;

import java.util.List;

import in.company.model.Tourist;

public interface ITouristService {

	public String registerTourist(Tourist tourist);

	public Tourist fetchTouristById(Integer tId);

	public List<Tourist> fetchAllTourist();

	public String updateTourist(Tourist tourist);

	public String updateTouristBudgetById(Integer id, Float hikeAmt);

	public String deleteTouristById(Integer id);

}
