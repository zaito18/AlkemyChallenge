package com.example.challengev2.Repository;

import com.example.challengev2.Model.Actor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;


@Repository
public class ActorRepositoryImpl implements ActorRepository{

     private final SessionFactory sessionFactory;

        @Autowired
        public ActorRepositoryImpl(SessionFactory sessionFactory){
       this.sessionFactory=sessionFactory;
    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Actor> findAllByFilter(MultiValueMap<String,String> params) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Actor.class);
        if(params.containsKey("name")){
           cr.add(Restrictions.eq("name",params.getFirst("name")));
        }
        if(params.containsKey("age")){
            cr.add(Restrictions.eq("age",params.getFirst("age")));
        }
        if(params.containsKey("movies")){
            cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            cr.createCriteria("listOfMovies").add(Restrictions.eq("idMovie",Long.parseLong(Objects.requireNonNull(params.getFirst("movies")))));
        }
        return cr.list();
    }

    @Override
    public void saveActor(Actor actor) {
        sessionFactory.getCurrentSession().save(actor);
    }

    @Override
    public void deleteActorById(String id) {

        Actor actor = findOneActorById(Long.parseLong(id));
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Actor a WHERE a.idActor = "+ actor.getIdActor());
        query.executeUpdate();
        sessionFactory.close();

    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Actor> findAll() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Actor.class);
        return cr.list();
    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Actor> findActorById(Long id) {
            Criteria cr =    sessionFactory.getCurrentSession().createCriteria(Actor.class).add(Restrictions.eq("id",id));
            return cr.list();

    }

    @Override
    public Actor findOneActorById(Long idActor) {
        return sessionFactory.getCurrentSession().find(Actor.class,idActor);
    }


}
