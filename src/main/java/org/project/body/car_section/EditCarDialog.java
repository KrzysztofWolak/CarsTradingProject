package org.project.body.car_section;

import org.project.database_connection.CarDatabaseConnection;
import org.project.vehicle_support.Car;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static org.project.body.car_section.AddCarDialog.textFieldConfig;

public class EditCarDialog {


    private String carToEditNumPlate = null;

    public EditCarDialog(JFrame frame) {


        Insets insets = new Insets(5, 30, 5, 30);

        JDialog edit = new JDialog(frame, "Edycja   pojazdu", true);
        edit.setBackground(new Color(2, 7,5));


        JLabel labelTitle = new JLabel("Wybierz    pojazd    z    tabeli:", SwingConstants.CENTER);
        labelTitle.setFont(new Font("Verdana", Font.PLAIN, 28));

        JLabel emptyLabel = new JLabel("                       ");
        emptyLabel.setFont(new Font("Verdana", Font.PLAIN, 20));


        CarDatabaseConnection carDatabaseConnection = new CarDatabaseConnection();
        List<Car> carsList = carDatabaseConnection.carDbLoad();

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

        JTable table = new JTable(tableData, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.blue);

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(500,200));


        JLabel emptyLabel2 = new JLabel("                                ");
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

        JLabel emptyLabel1 = new JLabel("                       ");
        emptyLabel1.setFont(new Font("Verdana", Font.PLAIN, 20));

        JButton delete = new JButton("Usuń z bazy");
        delete.setMargin(insets);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDatabaseConnection.carDbDelete(carToEditNumPlate);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        edit,
                        "Czy na pewno chcesz usunąć pojazd z bazy?",
                        "Potwierdź",
                        JOptionPane.YES_NO_OPTION
                );
                switch (result) {
                    case JOptionPane.YES_NO_OPTION :
                        carDatabaseConnection.carDbDelete(carToEditNumPlate);
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                }
            }
        });


        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                carToEditNumPlate = tableData[table.getSelectedRow()][2];
                table.setEnabled(false);
                table.setBackground(Color.GRAY);
                Car carToEdit = carDatabaseConnection.carDbLoadAtPlateNum(carToEditNumPlate);
                System.out.println(carToEdit.getManufacturer());
                manufacturer.setText(carToEdit.getManufacturer());
                model.setText(carToEdit.getModel());
                color.setText(carToEdit.getBodyColor());
                productionYear.setText(String.valueOf(carToEdit.getProductionYear()));
                engineCcm.setText(String.valueOf(carToEdit.getEngineCcm()));
                bodyType.setText(carToEdit.getBodyType());
                plateNum.setText(carToEdit.getPlateNumber());
                vinNumber.setText(carToEdit.getVinNumber());
                buyPrice.setText(String.valueOf(carToEdit.getBuyPrice()));

                delete.setVisible(true);
            }
        });


        JButton close = new JButton("Anuluj");
        close.setMargin(insets);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                table.setEnabled(true);
                table.setBackground(Color.WHITE);

            }
        });

        JButton exitButton = new JButton("Zamknij");
        exitButton.setMargin(insets);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.setVisible(false);
            }
        });


        JButton saveButton = new JButton("Zapisz zmiany");
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
                myDatabase.carDbUpdate(car, carToEditNumPlate);

                close.setEnabled(false);
               exitButton.setVisible(true);

            }
        });


        edit.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        edit.setSize(500, 500);




        gbc.gridy = 1;
        edit.add(labelTitle, gbc);

        gbc.gridy = 2;
        edit.add(emptyLabel, gbc);

        gbc.gridy = 3;
        edit.add(pane,gbc);
        edit.add(editButton,gbc);

        gbc.gridy = 4;
        edit.add(emptyLabel2, gbc);

        gbc.gridy = 5;
        edit.add(manufacturer, gbc);

        gbc.gridy = 6;
        edit.add(model, gbc);

        gbc.gridy = 7;
        edit.add(color, gbc);

        gbc.gridy = 8;
        edit.add(productionYear, gbc);

        gbc.gridy = 9;
        edit.add(engineCcm, gbc);

        gbc.gridy = 10;
        edit.add(bodyType, gbc);

        gbc.gridy = 11;
        edit.add(plateNum, gbc);

        gbc.gridy = 12;
        edit.add(vinNumber, gbc);

        gbc.gridy = 13;
        edit.add(buyPrice, gbc);

        gbc.gridy = 14;
        edit.add(emptyLabel1, gbc);

        gbc.gridy = 15;
        edit.add(close, gbc);

        gbc.gridy = 16;
        delete.setVisible(false);
        edit.add(delete,gbc);

        gbc.gridy = 17;
        edit.add(saveButton,gbc);

        gbc.gridy = 18;
        exitButton.setVisible(false);
        edit.add(exitButton,gbc);

        edit.setLocationRelativeTo(frame);
        edit.getContentPane().setBackground(new Color(240,248,255));
        edit.setSize(800,700);
        edit.setVisible(true);
    }
}