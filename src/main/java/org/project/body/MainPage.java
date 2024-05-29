package org.project.body;

import org.project.body.car_section.AddCarDialog;
import org.project.body.car_section.CarListDialog;
import org.project.body.car_section.EditCarDialog;
import org.project.vehicle_support.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainPage extends JFrame{

    public MainPage() throws HeadlessException {
        JFrame frame = new JFrame("C a r s      T r a d i n g      H e l p e r");
        JMenuBar menuBar = new JMenuBar();
        JMenu carsMenu = new JMenu("Samochody");
        JMenuItem addCar = new JMenuItem("Nowy pojazd");
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddCarDialog addCarDialog = new AddCarDialog(frame);

            }
        });
        JMenuItem carlist = new JMenuItem("Twoja flota");
        carlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarListDialog carListDialog = new CarListDialog(frame);
            }
        });

        JMenuItem editCar = new JMenuItem("Edycja pojazdu");
        editCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditCarDialog editCarDialog = new EditCarDialog(frame);
            }
        });
        carsMenu.add(addCar);
        carsMenu.add(carlist);
        carsMenu.add(editCar);
        menuBar.add(carsMenu);

        JMenu clientsMenu = new JMenu("Klienci");
        JMenuItem addClient = new JMenuItem("Nowy klient");
        JMenuItem clientList = new JMenuItem("Lista Klientów");
        JMenuItem editClient = new JMenuItem("Edycja danych klienta");
        clientsMenu.add(addClient);
        clientsMenu.add(clientList);
        clientsMenu.add(editClient);
        menuBar.add(clientsMenu);

        JMenu contractorsMenu = new JMenu("Pozostali kontrahenci");

        JMenu dealers = new JMenu("Dealerzy");

        JMenuItem addDealers = new JMenuItem("Dodaj");
        JMenuItem dealersList = new JMenuItem("Lista");
        JMenuItem editDealers = new JMenuItem("Edytuj");
        dealers.add(addDealers);
        dealers.add(dealersList);
        dealers.add(editDealers);

        JMenu insuranceCompanies = new JMenu("Towarzystwa Ubezpieczeniowe");
        JMenuItem addInsuranceCompanies = new JMenuItem("Dodaj");
        JMenuItem insuranceCompaniesList = new JMenuItem("Lista");
        JMenuItem editInsuranceCompanies = new JMenuItem("Edytuj");
        insuranceCompanies.add(addInsuranceCompanies);
        insuranceCompanies.add(insuranceCompaniesList);
        insuranceCompanies.add(editInsuranceCompanies);


        JMenu services = new JMenu("Serwisy");
        JMenuItem addServices = new JMenuItem("Dodaj");
        JMenuItem servicesList = new JMenuItem("Lista");
        JMenuItem editServices = new JMenuItem("Edytuj");
        services.add(addServices);
        services.add(servicesList);
        services.add(editServices);



        JMenu vehicleInspectionStations = new JMenu("Stacje Kontroli Pojazdów");
        JMenuItem addVehicleInspectionStations = new JMenuItem("Dodaj");
        JMenuItem vehicleInspectionStationsList = new JMenuItem("Lista");
        JMenuItem editVehicleInspectionStations = new JMenuItem("Edytuj");
        vehicleInspectionStations.add(addVehicleInspectionStations);
        vehicleInspectionStations.add(vehicleInspectionStationsList);
        vehicleInspectionStations.add(editVehicleInspectionStations);


        contractorsMenu.add(dealers);
        contractorsMenu.add(insuranceCompanies);
        contractorsMenu.add(services);
        contractorsMenu.add(vehicleInspectionStations);
        menuBar.add(contractorsMenu);

        JMenu functions = new JMenu("Funkcje");

        JMenuItem salesOfferGen = new JMenuItem("Generuj ogłoszenie sprzedaży");
        functions.add(salesOfferGen);
        JMenu documents = new JMenu("Generuj dokumenty");
        JMenuItem vatInvoice = new JMenuItem("Faktura sprzedaży");
        JMenuItem costEstimate = new JMenuItem("Kosztorys");
        JMenuItem buyHistory = new JMenuItem("Historia zakupu");
        documents.add(vatInvoice);
        documents.add(costEstimate);
        documents.add(buyHistory);
        functions.add(documents);
        menuBar.add(functions);

        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Admin\\untitled2\\CarsTradingProject\\src\\main\\resources\\image\\bg.jpeg"));

        frame.setJMenuBar(menuBar);
        frame.setLayout(new FlowLayout());
        frame.setSize(1000,750);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(background);

        frame.setVisible(true);



    }
}