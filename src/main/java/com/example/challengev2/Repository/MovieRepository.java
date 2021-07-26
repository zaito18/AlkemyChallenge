package com.example.challengev2.Repository;

import com.example.challengev2.Model.Genre;
import com.example.challengev2.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
