package org.project.body.car_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.vehicle_support.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarListDialog extends JFrame {


    public CarListDialog (JFrame frame) {




        CarDatabaseConnection carDatabaseConnection = new CarDatabaseConnection();
        List<Car> carsList = carDatabaseConnection.carDbLoad();

        JDialog carList = new JDialog(frame, "Lista   pojazdów", true);
        String [] columnNames = {"Marka","Model","Numer rejestracyjny","Typ Nadwozia","Kolor", "Numer VIN"};
        String [][] tableData = new String[carsList.size()][columnNames.length ];

        for (int i = 0; i < carsList.size() ; i++) {
            Car car = new Car();
            car.carLoadToTable(car, carsList.get(i));
            tableData [i][0] = car.getManufacturer();
            tableData [i][1] = car.getModel();
            tableData [i][2] = car.getPlateNumber();
            tableData [i][3] = car.getBodyType();
            tableData [i][4] = car.getBodyColor();
            tableData [i][5] = car.getVinNumber();

        }
        JLabel empty = new JLabel("____________________", SwingConstants.CENTER);
        empty.setFont(new Font("Verdana", Font.PLAIN, 30));
        JLabel title = new JLabel("Twoje pojazdy:", SwingConstants.CENTER);
       title.setFont(new Font("Verdana", Font.PLAIN, 30));

        JTable table = new JTable(tableData, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.blue);

        JButton edit = new JButton("Edit");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getNumPlate = tableData[table.getSelectedRow()][2];
                System.out.println(getNumPlate);
                Car carToEdit = carDatabaseConnection.carDbLoadAtPlateNum(getNumPlate);
                System.out.println(carToEdit.getManufacturer());

            }
        });

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(500,100));

        carList.add(edit);
        carList.add(empty);
        carList.add(title);
        carList.add(pane);
        carList.pack();
        carList.setLocationRelativeTo(frame);
        carList.setLayout(new FlowLayout());
        carList.setSize(600,500);
        carList.setVisible(true);

    }
}
