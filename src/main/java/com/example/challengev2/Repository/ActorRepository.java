package com.example.challengev2.Repository;

import com.example.challengev2.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    Optional<Actor> findByHistory(String history);

}
