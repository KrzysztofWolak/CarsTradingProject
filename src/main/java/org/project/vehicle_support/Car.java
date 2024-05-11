package org.project.vehicle_support;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String manufacturer;
    private String model;
    private int productionYear;
    private int engineCcm;
    private String bodyColor;
    private String bodyType;
    private String plateNumber;
    private String vinNumber;
    private double buyPrice;
    private double expectedCosts;
    private double expectedProfit;

    public Car() {
    }


    public Car(String manufacturer, String model, int productionYear, int engineCcm,
               String bodyColor, String bodyType, String plateNumber, String vinNumber,
               double buyPrice, double expectedCosts, double expectedProfit) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.engineCcm = engineCcm;
        this.bodyColor = bodyColor;
        this.bodyType = bodyType;
        this.plateNumber = plateNumber;
        this.vinNumber = vinNumber;
        this.buyPrice = buyPrice;
        this.expectedCosts = expectedCosts;
        this.expectedProfit = expectedProfit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getEngineCcm() {
        return engineCcm;
    }

    public void setEngineCcm(int engineCcm) {
        this.engineCcm = engineCcm;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getExpectedCosts() {
        return expectedCosts;
    }

    public void setExpectedCosts(double expectedCosts) {
        this.expectedCosts = expectedCosts;
    }

    public double getExpectedProfit() {
        return expectedProfit;
    }

    public void setExpectedProfit(double expectedProfit) {
        this.expectedProfit = expectedProfit;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", engineCcm=" + engineCcm +
                ", bodyColor='" + bodyColor + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", buyPrice=" + buyPrice +
                ", expectedCosts=" + expectedCosts +
                ", expectedProfit=" + expectedProfit +
                '}';
    }
}
