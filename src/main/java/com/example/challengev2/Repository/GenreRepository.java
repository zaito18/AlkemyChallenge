package com.example.challengev2.Repository;

import com.example.challengev2.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
