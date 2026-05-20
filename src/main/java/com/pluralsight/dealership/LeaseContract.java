package com.pluralsight.dealership;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String name, String email, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(dateOfContract, name, email, vehicleSold);
        this.expectedEndingValue = expectedEndingValue * .50;
        this.leaseFee = vehicleSold.getPrice() * .07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double total = getVehicleSold().getPrice();

        return (total - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double amount = getTotalPrice();

        double interest = .04;
        int months = 36;

        double monthlyPayment = interest / 12;

        return (amount * monthlyPayment / (1 - Math.pow(1 + monthlyPayment, -months)));
    }
}
