package localhost.maven.mvc.test.web.dao;

import localhost.maven.mvc.test.web.model.Hello;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class HelloDaoImpl implements HelloDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Hello h) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(h);
        tx.commit();
        session.close();
    }

    @Override
    public List<Hello> list() {
        //need to set session configure otherwise nullpointexception
        /*Session session = this.sessionFactory.openSession();
        List<Hello> helloList = session.createQuery("from hello").list();
        session.close();
        return helloList;*/

        //Session session = this.sessionFactory.openSession();
        //logger.info("list :: ");
        TypedQuery<Hello> helloList = this.sessionFactory.getCurrentSession().createQuery("from Hello");
        return helloList.getResultList();


    }
}
