package org.project.database_connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.project.vehicle_support.Car;

import java.util.List;

public class CarDatabaseConnection {

    private SessionFactory sessionFactory;
    public CarDatabaseConnection() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
    }

    public void carDbSave(Car car) {

        Session session = null;


        try{
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        }catch (Exception e){
        e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Car saved");

    }

    public List carDbLoad () {
        Session session = null;
        List carsList = null;

        try{
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Car ";
            Query query = session.createQuery(hql);
            carsList = query.list();
            transaction.commit();


        }catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Cars load");
  return carsList;

    }
}
