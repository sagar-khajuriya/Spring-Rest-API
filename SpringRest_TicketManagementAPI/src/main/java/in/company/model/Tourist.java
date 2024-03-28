package in.company.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tourist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tId;
	private String name;
	private String packageType;
	private Float budget;
	
}
