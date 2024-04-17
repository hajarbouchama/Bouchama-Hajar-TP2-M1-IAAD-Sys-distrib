package ma.bouchama.jpahajar.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.bouchama.jpahajar.entities.Role;
import ma.bouchama.jpahajar.entities.User;
import ma.bouchama.jpahajar.repositories.RoleRepository;
import ma.bouchama.jpahajar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByusername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
        }
        //userRepository.save(user)


    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findByusername(userName);
        if(user==null) throw new RuntimeException(("Bad credentials"));
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");

    }
}
