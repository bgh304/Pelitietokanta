package fi.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface User2Repository extends CrudRepository<User2, Long> {
	User2 findByUsername(String username);
}