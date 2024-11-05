package org.project.body.car_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.vehicle_support.Car;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarsListDialog extends JFrame {


    public CarsListDialog(JFrame frame) {

        CarDatabaseConnection carDatabaseConnection = new CarDatabaseConnection();
        List<Car> carsList = carDatabaseConnection.carDbLoad();

        JDialog carList = new JDialog(frame, "Lista   pojazdów", true);
        String[] columnNames = {"Marka", "Model", "Numer rejestracyjny", "Typ Nadwozia", "Kolor", "Numer VIN"};
        String[][] tableData = new String[carsList.size()][columnNames.length];

        for (int i = 0; i < carsList.size(); i++) {
            Car car = new Car();
            car.carLoadToTable(car, carsList.get(i));
            tableData[i][0] = car.getManufacturer();
            tableData[i][1] = car.getModel();
            tableData[i][2] = car.getPlateNumber();
            tableData[i][3] = car.getBodyType();
            tableData[i][4] = car.getBodyColor();
            tableData[i][5] = car.getVinNumber();

        }
        JLabel empty = new JLabel("-------------------------------------------------", SwingConstants.CENTER);
        empty.setFont(new Font("Verdana", Font.PLAIN, 30));
        JLabel title = new JLabel("Twoje   pojazdy:", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 35));

        JTable table = new JTable(tableData, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(0).setMinWidth(100);
        tcm.getColumn(1).setMinWidth(100);
        tcm.getColumn(2).setMinWidth(150);
        tcm.getColumn(3).setMinWidth(100);
        tcm.getColumn(4).setMinWidth(100);
        tcm.getColumn(5).setMinWidth(200);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.blue);

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(750, 300));


        JButton dates = new JButton("SPRAWDŹ TERMINY POLISY I PRZEGLĄDU");
        dates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatesDialog datesDialog = new DatesDialog(carList);
            }
        });


        carList.add(title);
        carList.add(empty);
        carList.add(pane);
        carList.add(dates);
        carList.pack();
        carList.getContentPane().setBackground(new Color(240, 248, 255));
        carList.setLayout(new FlowLayout());
        carList.setSize(950, 700);
        carList.setLocationRelativeTo(null);
        carList.setVisible(true);

    }
}
