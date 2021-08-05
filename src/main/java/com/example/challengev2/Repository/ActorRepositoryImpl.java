package com.example.challengev2.Repository;

import com.example.challengev2.Model.Actor;
import com.example.challengev2.Model.Movie;
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;


@Repository
public class ActorRepositoryImpl implements ActorRepository{

        private final EntityManager entityManager;
        private final SessionFactory sessionFactory;

        @Autowired
        public ActorRepositoryImpl(EntityManager entityManager,EntityManagerFactory sessionFactory){
             this.entityManager=entityManager;
            this.sessionFactory=sessionFactory.unwrap(SessionFactory.class);
    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Actor> findAllByFilter(MultiValueMap<String,String> params) {
        Criteria cri = sessionFactory.openSession().createCriteria(Actor.class);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Actor> cr = cb.createQuery(Actor.class);
        Root<Actor> root = cr.from(Actor.class);
        if(params.containsKey("name")){
            cr.select(root).where(cb.like(root.get("name"), params.getFirst("name")));
        }
        if(params.containsKey("age")){
            cr.select(root).where(cb.like(root.get("age"), params.getFirst("age")));
        }
        if(params.containsKey("movies")){
            cri.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            cri.createCriteria("listOfMovies").add(Restrictions.eq("idMovie",Long.parseLong(Objects.requireNonNull(params.getFirst("movies")))));
            return cri.list();
        }
        return entityManager.createQuery(cr).getResultList();

    }

   @Override
    public void saveActor(Actor actor) {
        entityManager.persist(actor);
    }

    @Override
    public void deleteActorById(Long id) {
        Actor actor = findOneActorById(id);
        entityManager.remove(actor);
    }


    @Override
    public List<Actor> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> actor = cq.from(Actor.class);
        return entityManager.createQuery(cq).getResultList();
        }

    @Override
    public Actor findActorById(Long id) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
            Root<Actor> actor = cq.from(Actor.class);
            cq.select(actor);
            cq.where(cb.equal(actor.get("idActor"),id));
            return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public Actor findOneActorById(Long idActor) {
        return entityManager.find(Actor.class,idActor);
    }

}
