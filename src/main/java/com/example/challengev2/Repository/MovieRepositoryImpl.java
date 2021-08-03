package com.example.challengev2.Repository;

import com.example.challengev2.Model.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;


import java.util.List;
import java.util.Objects;

@Repository
public class MovieRepositoryImpl implements MovieRepository{


    private Session session;

    @Autowired
    public MovieRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Movie> findAllByFilter(MultiValueMap<String, String> params) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Movie.class);
        if(params.containsKey("name")){
            cr.add(Restrictions.eq("title",params.getFirst("name")));
        }
        if(params.containsKey("genre")) {
            cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            cr.createCriteria("listOfGenre").add(Restrictions.eq("idGenre", Long.parseLong(Objects.requireNonNull(params.getFirst("genre")))));
        }
         if(params.containsKey("order")){
             // System.out.println("hola");
            cr.addOrder(Order.asc("creationDate"));
         // }
         // else
          //    System.out.println("hello");
            //  cr.addOrder(Order.desc("creation_date"));

      }
        return cr.list();
    }


    @Override
    public Movie saveMovie(Movie movie) {
        sessionFactory.getCurrentSession().save(movie);
        return movie;
    }

    @Override
    public void deleteMovieById(Long id) {

    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Movie> findAll() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Movie.class);
        return cr.list();
    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Movie> findMovieById(Long id) {
        Criteria cr =    sessionFactory.getCurrentSession().createCriteria(Movie.class).add(Restrictions.eq("id",id));
        return cr.list();

    }

}

