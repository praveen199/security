package com.spring.boot.security.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.boot.security.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query("select t from Token t inner join User u on t.user.id = u.id where u.id = ?1 and (t.expired = false or t.revoked = false)")
  List<Token> findAllValidTokenByUser(Integer id);

  Optional<Token> findByToken(String token);
}
