package org.project.body.car_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.vehicle_support.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddCarDialog extends JFrame {

    public static void textFieldConfig(JTextField field) {
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public AddCarDialog(JFrame frame) {
        Insets insets = new Insets(5, 30, 5, 30);

        JDialog add = new JDialog(frame, "Nowy    Pojazd", true);

        JLabel labelManufacturer = new JLabel("Podaj   dane   pojazdu:", SwingConstants.CENTER);
        labelManufacturer.setFont(new Font("Verdana", Font.PLAIN, 20));

        JLabel emptyLabel = new JLabel("                       ");
        emptyLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

        JTextField manufacturer = new JTextField("marka", 18);
        textFieldConfig(manufacturer);
        manufacturer.setToolTipText("marka");

        JTextField model = new JTextField("model", 18);
        textFieldConfig(model);
        model.setToolTipText("model");

        JTextField color = new JTextField("Kolor", 18);
        textFieldConfig(color);
        color.setToolTipText("kolor");

        JTextField productionYear = new JTextField("rok produkcji", 18);
        textFieldConfig(productionYear);
        productionYear.setToolTipText("rok produkcji");

        JTextField engineCcm = new JTextField("Pojemość silnika", 18);
        textFieldConfig(engineCcm);
        engineCcm.setToolTipText("pojemość silnika");

        JTextField bodyType = new JTextField("Rodzaj nadwozia", 18);
        textFieldConfig(bodyType);
        bodyType.setToolTipText("rodzaj nadwozia");

        JTextField plateNum = new JTextField("Numer rejestracyjny", 18);
        textFieldConfig(plateNum);
        plateNum.setToolTipText("Numer rejestracyjny");

        JTextField vinNumber = new JTextField("Numer VIN", 18);
        textFieldConfig(vinNumber);
        vinNumber.setToolTipText("Numer VIN");

        JTextField buyPrice = new JTextField("Cena zakupu", 18);
        textFieldConfig(buyPrice);
        buyPrice.setToolTipText("cena zakupu");

        JTextField insuranceDate = new JTextField("Data ważności polisy OC", 18);
        textFieldConfig(insuranceDate);
        insuranceDate.setToolTipText("Data ważności polisy OC");

        JTextField techInspectDate = new JTextField("Data ważności przeglądu", 18);
        textFieldConfig(techInspectDate);
        techInspectDate.setToolTipText("Data ważności przeglądu");

        JLabel emptyLabel1 = new JLabel("                       ");
        emptyLabel1.setFont(new Font("Verdana", Font.PLAIN, 20));


        JButton close = new JButton("Anuluj");
        close.setMargin(insets);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.setVisible(false);
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
                car.setInsuranceTime(insuranceDate.getText());
                car.setTechInspectionDate(techInspectDate.getText());

                CarDatabaseConnection myDatabase = new CarDatabaseConnection();
                myDatabase.carDbSave(car);

                close.setEnabled(false);

                JButton exitButton = new JButton("Zamknij");
                exitButton.setMargin(insets);
                exitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        add.setVisible(false);
                    }
                });
                add.add(exitButton);
            }


        });


        add.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        add.setSize(300, 500);

        gbc.gridy = 0;
        add.add(labelManufacturer, gbc);

        gbc.gridy = 1;
        add.add(emptyLabel, gbc);

        gbc.gridy = 2;
        add.add(manufacturer, gbc);

        gbc.gridy = 3;
        add.add(manufacturer, gbc);

        gbc.gridy = 4;
        add.add(model, gbc);

        gbc.gridy = 5;
        add.add(color, gbc);

        gbc.gridy = 6;
        add.add(productionYear, gbc);

        gbc.gridy = 7;
        add.add(engineCcm, gbc);

        gbc.gridy = 8;
        add.add(bodyType, gbc);

        gbc.gridy = 9;
        add.add(plateNum, gbc);

        gbc.gridy = 10;
        add.add(vinNumber, gbc);

        gbc.gridy = 11;
        add.add(buyPrice, gbc);

        gbc.gridy = 12;
        add.add(insuranceDate, gbc);

        gbc.gridy = 13;
        add.add(techInspectDate, gbc);

        gbc.gridy = 14;
        add.add(emptyLabel1, gbc);

        gbc.gridy = 15;
        add.add(close, gbc);

        gbc.gridy = 16;
        add.add(saveButton, gbc);

        add.getContentPane().setBackground(new Color(240, 248, 255));
        add.setLocationRelativeTo(null);
        add.setVisible(true);

    }
}
