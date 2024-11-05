package org.project.body.client_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.vehicle_support.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddClientDialog extends JFrame {

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

    public AddClientDialog(JFrame frame) {
        Insets insets = new Insets(5, 30, 5, 30);

        JDialog add = new JDialog(frame, "Nowy    Klient", true);

        JLabel labelManufacturer = new JLabel("Podaj   dane   Klienta:", SwingConstants.CENTER);
        labelManufacturer.setFont(new Font("Verdana", Font.PLAIN, 20));

        JLabel emptyLabel = new JLabel("                       ");
        emptyLabel.setFont(new Font("Verdana", Font.PLAIN, 20));


        JTextField name = new JTextField("Imię", 18);
        textFieldConfig(name);
        name.setToolTipText("marka");

        JTextField surname = new JTextField("Nazwisko", 18);
        textFieldConfig(surname);
        surname.setToolTipText("model");

        JTextField pesel = new JTextField("PESEL", 18);
        textFieldConfig(pesel);
        pesel.setToolTipText("kolor");

        JTextField address = new JTextField("Adres", 18);
        textFieldConfig(address);
        address.setToolTipText("rok produkcji");

        JTextField telephoneNumber = new JTextField("Numer telefonu", 18);
        textFieldConfig(telephoneNumber);
        telephoneNumber.setToolTipText("pojemość silnika");


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
                car.setManufacturer(name.getText());
                car.setModel(surname.getText());
                car.setBodyColor(pesel.getText());
                car.setProductionYear(Integer.parseInt(address.getText()));
                car.setEngineCcm(Integer.parseInt(telephoneNumber.getText()));


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
        add.add(name, gbc);

        gbc.gridy = 3;
        add.add(name, gbc);

        gbc.gridy = 4;
        add.add(surname, gbc);

        gbc.gridy = 5;
        add.add(pesel, gbc);

        gbc.gridy = 6;
        add.add(address, gbc);

        gbc.gridy = 7;
        add.add(telephoneNumber, gbc);

        gbc.gridy = 8;
        add.add(emptyLabel1, gbc);

        gbc.gridy = 9;
        add.add(close, gbc);

        gbc.gridy = 10;
        add.add(saveButton, gbc);

        add.getContentPane().setBackground(new Color(240, 248, 255));
        add.setLocationRelativeTo(null);
        add.setVisible(true);

    }
}
