package com.pluralsight.repositories;

import com.pluralsight.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer>
{
    // Spring Data derived query — used by getByUserName() and getIdByUsername()
    User findByUsername(String username);

    boolean existsByUsername(String username);

    // --- Compatibility methods matching the original interface ---

    default List<User> getAll()
    {
        return findAll();
    }

    default User getUserById(int userId)
    {
        return findById(userId).orElse(null);
    }

    default User getByUserName(String username)
    {
        return findByUsername(username);
    }

    default int getIdByUsername(String username)
    {
        User user = findByUsername(username);
        return user != null ? user.getId() : -1;
    }

    default User create(User user)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return save(user);
    }

    default boolean exists(String username)
    {
        return existsByUsername(username);
    }
}
