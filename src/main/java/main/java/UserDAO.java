package main.java;

import java.util.List;

public interface UserDAO {

    void create(User user);

    User getuserByID(int id);

    List<User> getUsersByRole(Role role);

    List<User> getEveryone();

    void updatePersonById(User user);

    void deleteUser(User user);

}
