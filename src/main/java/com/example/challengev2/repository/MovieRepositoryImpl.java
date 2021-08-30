package com.example.challengev2.repository;

import com.example.challengev2.model.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

@Repository
public class MovieRepositoryImpl implements MovieRepository{


    private final SessionFactory sessionFactory;
    private final EntityManager entityManager;

    @Autowired
    public MovieRepositoryImpl(EntityManagerFactory sessionFactory, EntityManager entityManager){
        this.sessionFactory=sessionFactory.unwrap(SessionFactory.class);
        this.entityManager = entityManager;
    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Movie> findAllByFilter(MultiValueMap<String, String> params) {
        Criteria cri = sessionFactory.openSession().createCriteria(Movie.class);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> cr = cb.createQuery(Movie.class);
        Root<Movie> root = cr.from(Movie.class);
        if(params.containsKey("name")) {
            cr.select(root).where(cb.like(root.get("title"), params.getFirst("name")));
        }
        if(params.containsKey("order")){
            if(params.get("order").contains("ASC")){
                cr.select(root).orderBy(cb.asc(root.get("creationDate")));
            }
            if(params.get("order").contains("DESC")){
                cr.select(root).orderBy(cb.desc(root.get("creationDate")));
            }
        }
        if(params.containsKey("genre")){
            cri.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            cri.createCriteria("listOfGenre").add(Restrictions.eq("idGenre", Long.parseLong(Objects.requireNonNull(params.getFirst("genre")))));
            return cri.list();
        }
        return entityManager.createQuery(cr).getResultList();
        }

    @Override
    public void saveMovie(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        Movie movie = findOneMovieById(id);
        entityManager.remove(movie);
    }

    @Override
    public Movie findOneMovieById(Long id) {
        return entityManager.find(Movie.class,id);
    }


    @Override
    public List<Movie> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        Root<Movie> movie = cq.from(Movie.class);
        cq.select(movie);
        return entityManager.createQuery(cq).getResultList();
    }

}

