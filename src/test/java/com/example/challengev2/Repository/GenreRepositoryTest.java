package com.example.challengev2.Repository;

import com.example.challengev2.Model.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.*;

import javax.transaction.Transactional;

@DataJpaTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @Rollback
    @Transactional
    public void thatAGenreCanBePersisted() {
        Genre genre1 = givenAGenre("Terror", "www.img.com/terror");
        whenSaveTheGenre(genre1);
        verifyTheGenreName(genre1.getIdGenre());
    }

    private void verifyTheGenreName(Long idGenre) {
        assertThat(idGenre).isGreaterThan(0);
    }

    private void whenSaveTheGenre(Genre genre1) {
        genreRepository.save(genre1);
    }

    private Genre givenAGenre(String genre, String urlImage) {
        Genre newGenre = new Genre();
        newGenre.setName(genre);
        newGenre.setUrlImage(urlImage);
        return newGenre;
    }

}