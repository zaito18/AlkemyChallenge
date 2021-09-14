package com.example.challengev2.repository;

import com.example.challengev2.model.Character;
import com.example.challengev2.util.exception.VoidParameterException;
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
public class CharacterRepositoryImpl implements CharacterRepository {

        private final EntityManager entityManager;
        private final SessionFactory sessionFactory;

        @Autowired
        public CharacterRepositoryImpl(EntityManager entityManager, EntityManagerFactory sessionFactory){
             this.entityManager=entityManager;
            this.sessionFactory=sessionFactory.unwrap(SessionFactory.class);
    }

    @SuppressWarnings({"deprecation","unchecked"})
    @Override
    public List<Character> findAllByFilter(MultiValueMap<String,String> params) {
        Criteria cri = sessionFactory.openSession().createCriteria(Character.class);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Character> cr = cb.createQuery(Character.class);
        Root<Character> root = cr.from(Character.class);
        if(params.containsKey("name") && Objects.equals(params.getFirst("name"), "")){
            throw  new VoidParameterException("the parameter name is incomplete");
        }
        else if(params.containsKey("name")){
            cr.select(root).where(cb.like(root.get("name"), params.getFirst("name")));
        }
        if(params.containsKey("age") && Objects.equals(params.getFirst("age"), "")){
            throw  new VoidParameterException("the parameter age is incomplete");
        }
        else if(params.containsKey("age")){
            cr.select(root).where(cb.equal(root.get("age"),Integer.parseInt(Objects.requireNonNull(params.getFirst("age")))));
        }
        else   if(params.containsKey("movies") && Objects.equals(params.getFirst("movies"), "")){
            throw  new VoidParameterException("the parameter movies is incomplete");
        }
        else if(params.containsKey("movies")){
            cri.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            cri.createCriteria("listOfMovies").add(Restrictions.eq("idMovie",Long.parseLong(Objects.requireNonNull(params.getFirst("movies")))));
            return cri.list();
        }
        return entityManager.createQuery(cr).getResultList();
    }

   @Override
    public void save(Character character) {
        entityManager.persist(character);
    }

    @Override
    public void delete(Character character) {
        entityManager.remove(character);
    }

    @Override
    public List<Character> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Character> cq = cb.createQuery(Character.class);
        Root<Character> actor = cq.from(Character.class);
        cq.select(actor);
        return entityManager.createQuery(cq).getResultList();
        }

    @Override
    public Character getCharacterById(Long idCharacter) {
        return entityManager.find(Character.class,idCharacter);
    }

}
