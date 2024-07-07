package org.project.body.car_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.date_class.DateClass;
import org.project.vehicle_support.Car;

import javax.management.monitor.Monitor;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

public class DatesDialog {
    public DatesDialog(JDialog dialog) {

        JDialog datesDialog = new JDialog(dialog);

        CarDatabaseConnection carDatabaseConnection = new CarDatabaseConnection();
        List<Car> carsList = carDatabaseConnection.carDbLoad();

        String[] columnNames = {"Marka", "Model", "Numer rejestracyjny", "Data ważności polisy", "Dni do końca polisy", "Data badania technicznego", "Dni do nast. badania"};
        String[][] tableData = new String[carsList.size()][columnNames.length];

        for (int i = 0; i < carsList.size(); i++) {
            Car car = new Car();
            car.carLoadToTable(car, carsList.get(i));
            tableData[i][0] = car.getManufacturer();
            tableData[i][1] = car.getModel();
            tableData[i][2] = car.getPlateNumber();
            tableData[i][3] = car.getInsuranceTime();
            tableData[i][4] = String.valueOf(DateClass.insuranceDataRemaining(car));
            tableData[i][5] = car.getTechInspectionDate();
            tableData[i][6] = String.valueOf(DateClass.techInspectionDataRemaining(car));
        }

            JLabel empty = new JLabel("-------------------------------------------------", SwingConstants.CENTER);
            empty.setFont(new Font("Verdana", Font.PLAIN, 30));
            JLabel title = new JLabel("Ważne  daty:", SwingConstants.CENTER);
            title.setFont(new Font("Verdana", Font.PLAIN, 35));

            JTable table = new JTable(tableData, columnNames);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            TableColumnModel tcm = table.getColumnModel();
            tcm.getColumn(0).setMinWidth(80);
            tcm.getColumn(1).setMinWidth(80);
            tcm.getColumn(2).setMinWidth(120);
            tcm.getColumn(3).setMinWidth(100);
            tcm.getColumn(4).setMinWidth(130);
            tcm.getColumn(5).setMinWidth(100);
            tcm.getColumn(6).setMinWidth(130);


            table.setShowHorizontalLines(true);
            table.setGridColor(Color.blue);
            JScrollPane pane = new JScrollPane(table);
            pane.setPreferredSize(new Dimension(900, 300));

            datesDialog.add(title);
            datesDialog.add(empty);
            datesDialog.add(pane);
            datesDialog.pack();
            datesDialog.getContentPane().setBackground(new Color(240, 248, 255));
            datesDialog.setLayout(new FlowLayout());
            datesDialog.setSize(1050, 500);
            datesDialog.setLocationRelativeTo(null);
            datesDialog.setVisible(true);

        }
    }

