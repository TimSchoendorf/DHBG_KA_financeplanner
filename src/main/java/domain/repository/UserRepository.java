package domain.repository;

import domain.entity.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    // Find all users stored in the database
    List<UserEntity> findAll();

    // Find a user by their email address
    Optional<UserEntity> findByEmail(String vEmail);

    // Create a new user in the database
    UserEntity create(UserEntity entity) throws Exception;

    // Update an existing user in the database
    UserEntity update(UserEntity entity) throws Exception;

    // Delete a user from the database using their email address
    void deleteByEmail(String vEmail);
}
