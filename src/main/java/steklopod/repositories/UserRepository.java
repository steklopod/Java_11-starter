package steklopod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import steklopod.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Iterable<User> findByLastName(String lastName);

}
