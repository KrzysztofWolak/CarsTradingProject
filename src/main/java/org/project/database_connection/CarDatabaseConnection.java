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

import javax.swing.*;
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


        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Car carCheck = (Car) session.createQuery("FROM Car WHERE plateNumber = :plateNumber")
                    .setParameter("plateNumber", car.getPlateNumber()).uniqueResult();;
            if (carCheck == null) {
                session.save(car);
                System.out.println("Car saved");
            } else {
                //JOptionPane.showInputDialog(null,"Objekt o takim nr rej. istnieje",JOptionPane.PLAIN_MESSAGE);
                System.out.println("Nie zapisano");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


    }

    public List<Car> carDbLoad() {
        Session session = null;
        List carsList = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Car ";
            Query query = session.createQuery(hql);
            carsList = query.list();
            transaction.commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Cars loaded");
        return carsList;

    }

    public Car carDbLoadAtPlateNum(String plateNum) {
        Session session = null;
        Car car = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Car WHERE plateNumber = :plateNumber";

            Query query = session.createQuery(hql);
            query.setParameter("plateNumber", plateNum);
            List result = query.list();

            if (result.size() > 0) car = (Car) result.get(0);

        transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Car loaded: " + car.getManufacturer());
        return car;

    }

    public void carDbUpdate(Car newCar, String numPlate) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

         Car car1 = (Car) session.createQuery("FROM Car WHERE plateNumber = :plateNumber")
                 .setParameter("plateNumber", numPlate)
                 .uniqueResult();
         car1.changeCarParameter(car1,newCar);
            session.update(car1);
            transaction.commit();

            System.out.println("New model: " + car1.getModel());
            System.out.println("New year: " + car1.getProductionYear());  

        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        } finally {
            if(session != null) session.close();
        }
    }

    public void carDbDelete(String numPlate) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Car car1 = (Car) session.createQuery("FROM Car WHERE plateNumber = :plateNumber")
                    .setParameter("plateNumber", numPlate).uniqueResult();

            session.delete(car1);
            transaction.commit();



        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        } finally {
            if(session != null) session.close();
        }
    }

}
