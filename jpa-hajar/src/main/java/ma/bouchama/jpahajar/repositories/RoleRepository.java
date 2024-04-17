package ma.bouchama.jpahajar.repositories;

import ma.bouchama.jpahajar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.bouchama.jpahajar.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);

}
