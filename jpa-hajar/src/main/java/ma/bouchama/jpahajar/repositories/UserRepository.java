package ma.bouchama.jpahajar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.bouchama.jpahajar.entities.User;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,String> {
    User findByusername(String userName);


}
