package ma.bouchama.jpahajar.service;

import ma.bouchama.jpahajar.entities.Role;
import ma.bouchama.jpahajar.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String userName, String password);



}

