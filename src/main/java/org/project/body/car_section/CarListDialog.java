package org.project.body.car_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.vehicle_support.Car;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarListDialog extends JFrame {


    public CarListDialog (JFrame frame) {
        CarDatabaseConnection carDatabaseConnection = new CarDatabaseConnection();
        List<Car> carsList = carDatabaseConnection.carDbLoad();

        JDialog carList = new JDialog(frame, "Lista   pojazdów", true);
        System.out.println(carsList.size());
        String result = "";
        for (int i = 0; i < carsList.size() ; i++) {
            result = result + "   \n" + carsList.get(i).getManufacturer();
            System.out.println("Cars: " + result);
        }

        JTextArea carListArea = new JTextArea(30,30);
        carListArea.setText(result);
        System.out.println(result);

        carList.add(carListArea);
        carList.setLayout(new FlowLayout());
        carList.setSize(500,500);
        carList.setVisible(true);




        JTable table = new JTable();
    }
}
