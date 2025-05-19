package org.dreamy.dreamjournal.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(nativeQuery = true,
            value = "SELECT COUNT(*)>1 FROM users WHERE email = :email AND (oauth_provider = :providerOrPwd OR password = :providerOrPwd)")
    boolean existsByEmailAndOauthProvider(@Param("email") String email,
                                          @Param("providerOrPwd") String providerOrPwd);

    @Query(nativeQuery = true,
            value = "SELECT * FROM users WHERE email = :email AND  password = :providerOrPwd")
    Optional<User> findByEmailAndOauthProvider(@Param("email") String email,
                                               @Param("providerOrPwd") String providerOrPwd);
}
