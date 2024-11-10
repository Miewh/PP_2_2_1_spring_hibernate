package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {
    private SessionFactory sessionFactory;
    @Autowired
    CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User listCars(String model, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE car.model = :model AND car.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return (User) query.uniqueResult();
    }

}
