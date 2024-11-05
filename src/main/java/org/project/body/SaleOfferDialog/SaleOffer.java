package org.project.body.SaleOfferDialog;

import org.project.database_connection.CarDatabaseConnection;
import org.project.document_creator.PdfMaker;
import org.project.vehicle_support.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class SaleOffer {
    private String carToEditNumPlate = null;
    public SaleOffer(JFrame frame) {


        CarDatabaseConnection carDatabaseConnection = new CarDatabaseConnection();
        List<Car> carsList = carDatabaseConnection.carDbLoad();

        JDialog saleOfferDialog = new JDialog(frame, "Lista   pojazdów", true);
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
        JLabel title = new JLabel("Wybierz   pojazd: ", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 30));

        JTable table = new JTable(tableData, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.blue);

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(450,300));

        JTextField price = new JTextField("Podaj cenę w 'EURO'",14);
        price.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                price.setText("");
                price.setToolTipText("Cena w walucie 'EURO'");
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

        JButton close = new JButton("Zamknij");
        close.setVisible(false);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                saleOfferDialog.setVisible(false);

            }
        });

        JButton saleOfferGen = new JButton("GENERUJ OFERTĘ PDF");
        saleOfferGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setEnabled(false);
                table.setBackground(Color.GRAY);
                close.setVisible(true);
                CarDatabaseConnection connection = new CarDatabaseConnection();
                carToEditNumPlate = tableData[table.getSelectedRow()][2];
                Car car = connection.carDbLoadAtPlateNum(carToEditNumPlate);
                PdfMaker dg = new PdfMaker();
                try {
                    dg.createSaleOffer(car, price.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        saleOfferDialog.add(empty);
        saleOfferDialog.add(title);
        saleOfferDialog.add(pane);
        saleOfferDialog.add(price);
        saleOfferDialog.add(saleOfferGen);
        saleOfferDialog.add(close);
        saleOfferDialog.getContentPane().setBackground(new Color(240,248,255));
        saleOfferDialog.setLayout(new FlowLayout());
        saleOfferDialog.setSize(550,650);
        saleOfferDialog.setLocationRelativeTo(null);
        saleOfferDialog.setVisible(true);


    }
}
