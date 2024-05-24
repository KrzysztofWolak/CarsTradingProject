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

    public List<Car> carDbLoad () {
        Session session = null;
        List carsList = null;
        List titleList= null;

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
        System.out.println("Cars loaded");
  return carsList;

    }
    public  Car carDbLoadAtPlateNum (String plateNum) {
        Session session = null;
        Car car = null;

        try{
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Car WHERE plateNumber = :plateNumber";

            Query query = session.createQuery(hql);
            query.setParameter("plateNumber", plateNum);
            List result = query.list();
            transaction.commit();

            if (result.size() > 0) car = (Car)result.get(0);




        }catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Car loaded: " +car.getManufacturer());
        return car;

    }
}
