package org.project.body.car_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.vehicle_support.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import static org.project.body.car_section.AddCarDialog.textFieldConfig;

public class EditCarDialog {

    public EditCarDialog(JFrame frame) {
        Insets insets = new Insets(5, 30, 5, 30);

        JDialog edit = new JDialog(frame, "Nowy    Pojazd", true);

        JLabel labelManufacturer = new JLabel("Wybierz    pojazd    z    listy:", SwingConstants.CENTER);
        labelManufacturer.setFont(new Font("Verdana", Font.PLAIN, 20));

        JLabel emptyLabel = new JLabel("                       ");
        emptyLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

        CarDatabaseConnection carDatabaseConnection = new CarDatabaseConnection();
        List<Car> carsList = carDatabaseConnection.carDbLoad();










        JTextField manufacturer = new JTextField("marka", 18);
        textFieldConfig(manufacturer);


        JTextField model = new JTextField("model", 18);
        textFieldConfig(model);


        JTextField color = new JTextField("Kolor", 18);
        textFieldConfig(color);

        JTextField productionYear = new JTextField("rok produkcji", 18);
        textFieldConfig(productionYear);

        JTextField engineCcm = new JTextField("Pojemość silnika", 18);
        textFieldConfig(engineCcm);

        JTextField bodyType = new JTextField("Rodzaj nadwozia", 18);
        textFieldConfig(bodyType);

        JTextField plateNum = new JTextField("Numer rejestracyjny", 18);
        textFieldConfig(plateNum);

        JTextField vinNumber = new JTextField("Numer VIN", 18);
        textFieldConfig(vinNumber);

        JTextField buyPrice = new JTextField("Cena zakupu", 18);
        textFieldConfig(buyPrice);

        JLabel emptyLabel1 = new JLabel("                       ");
        emptyLabel1.setFont(new Font("Verdana", Font.PLAIN, 20));


        JButton close = new JButton("Anuluj");
        close.setMargin(insets);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.setVisible(false);
            }
        });

        JButton saveButton = new JButton("Zapisz");
        saveButton.setMargin(insets);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = new Car();
                car.setManufacturer(manufacturer.getText());
                car.setModel(model.getText());
                car.setBodyColor(color.getText());
                car.setProductionYear(Integer.parseInt(productionYear.getText()));
                car.setEngineCcm(Integer.parseInt(engineCcm.getText()));
                car.setBodyType(bodyType.getText());
                car.setPlateNumber(plateNum.getText());
                car.setVinNumber(vinNumber.getText());
                car.setBuyPrice(Double.parseDouble(buyPrice.getText()));

                CarDatabaseConnection myDatabase = new CarDatabaseConnection();
                myDatabase.carDbSave(car);

                close.setEnabled(false);

                JButton exitButton = new JButton("Zamknij");
                exitButton.setMargin(insets);
                exitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        edit.setVisible(false);
                    }
                });
                edit.add(exitButton);
            }
        });




        edit.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        edit.setSize(500, 500);

        gbc.gridy = 0;
        edit.add(labelManufacturer, gbc);

        gbc.gridy = 1;
        edit.add(emptyLabel, gbc);

        gbc.gridy = 2;
        edit.add(manufacturer, gbc);

        gbc.gridy = 3;
        edit.add(manufacturer, gbc);

        gbc.gridy = 4;
        edit.add(model, gbc);

        gbc.gridy = 5;
        edit.add(color, gbc);

        gbc.gridy = 6;
        edit.add(productionYear, gbc);

        gbc.gridy = 7;
        edit.add(engineCcm, gbc);

        gbc.gridy = 8;
        edit.add(bodyType, gbc);

        gbc.gridy = 9;
        edit.add(plateNum, gbc);

        gbc.gridy = 10;
        edit.add(vinNumber, gbc);

        gbc.gridy = 11;
        edit.add(buyPrice, gbc);

        gbc.gridy = 12;
        edit.add(emptyLabel1, gbc);

        gbc.gridy = 13;
        edit.add(close, gbc);

        gbc.gridy = 14;
        edit.add(saveButton, gbc);

        edit.setLocationRelativeTo(null);
        edit.setVisible(true);




    }
}
