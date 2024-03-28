package in.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.company.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
