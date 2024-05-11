package org.project.body.car_section;

import org.project.database_connection.MyDatabase;
import org.project.vehicle_support.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddCarDialog extends JFrame {
    public AddCarDialog (JFrame frame){

        JDialog add = new JDialog(frame, "Nowy Pojazd", true);

        JLabel Labelmanufacturer = new JLabel("Podaj dane pojazdu:", SwingConstants.CENTER);
        JTextField manufacturer = new JTextField("marka", 12);
       manufacturer.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
               manufacturer.setText("");
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


        JTextField model = new JTextField("model",12);
        model.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.setText("");
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



        JTextField color = new JTextField("Kolor", 12);
        color.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                color.setText("");
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

        JTextField productionYear = new JTextField("rok produkcji", 12);
        productionYear.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                productionYear.setText("");
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

        JTextField engineCcm = new JTextField("Pojemość silnika");
        engineCcm.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                engineCcm.setText("");
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

        JTextField bodyType = new JTextField("Rodzaj nadwozia");
        bodyType.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bodyType.setText("");
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


        JTextField plateNum = new JTextField("Numer rejestracyjny");
        plateNum.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                plateNum.setText("");
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


        JButton save = new JButton("Zapisz");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = new Car();
                car.setManufacturer(manufacturer.getText());
                car.setModel(model.getText());
                car.setBodyColor(color.getText());
                car.setProductionYear(Integer.parseInt(productionYear.getText()));
                MyDatabase myDatabase = new MyDatabase();
                myDatabase.carDbSave(car);
            }
        });


        JTextField vinNumber = new JTextField("Numer VIN");
        vinNumber.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vinNumber.setText("");
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

        JTextField buyPrice = new JTextField("Cena zakupu");
        buyPrice.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buyPrice.setText("");
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


        JTextField expectedCost = new JTextField("Zakładane koszty");
        expectedCost.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                expectedCost.setText("");
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

        JTextField sellValue = new JTextField("Wartość rynkowa");
        sellValue.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sellValue.setText("");
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

        JLabel expectedProfit = new JLabel("Spodziewany Zysk");

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = new Car();
               // double value = Double.parseDouble(sellValue.getText()) - Double.parseDouble(buyPrice.getText()) - Double.parseDouble(expectedCost.getText());
               // car.setExpectedProfit(value);
                car.setManufacturer(manufacturer.getText());
                car.setModel(model.getText());
                car.setBodyColor(color.getText());
                car.setProductionYear(Integer.parseInt(productionYear.getText()));
                car.setEngineCcm(Integer.parseInt(engineCcm.getText()));
                car.setBodyType(bodyType.getText());
                car.setPlateNumber(plateNum.getText());
                car.setVinNumber(vinNumber.getText());
                car.setBuyPrice(Double.parseDouble(buyPrice.getText()));
                car.setExpectedCosts(Double.parseDouble(expectedCost.getText()));
                car.setExpectedProfit(Double.parseDouble(expectedProfit.getText()));

               // expectedProfit.setText(""+ value);
                MyDatabase myDatabase = new MyDatabase();
                myDatabase.carDbSave(car);
            }
        });


        JButton close = new JButton("Anuluj");

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.setVisible(false);
            }
        });

        add.setLayout(new FlowLayout());
        add.setSize(500,500);
        add.add(Labelmanufacturer);
        add.add(manufacturer);
        add.add(model);
        add.add(color);
        add.add(productionYear);
        add.add(engineCcm);
        add.add(bodyType);
        add.add(plateNum);
        add.add(vinNumber);
        add.add(buyPrice);
        add.add(expectedCost);
        add.add(sellValue);
        add.add(close);
        add.add(save);
        add.add(expectedProfit);
        add.setLocationRelativeTo(null);
        add.setVisible(true);

    }
}
