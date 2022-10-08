package com.stackroute.userservice.repository;
import com.stackroute.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


    @Query("{'email' : ?0}")
    User findByEmail(String email);

    @Query("{'email' : ?0}")
    void deleteByEmail(String email);
//    boolean existByEmail(String email);

    @Query("{'email':?1}")
    User updateByEmail(String email,User user);

}

