package com.example.MyAccountantBackEnd.repository;


import com.example.MyAccountantBackEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
;import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.email=:email")
    User findByEmailId(@Param("email") String email);

    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
