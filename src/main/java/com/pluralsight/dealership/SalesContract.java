package com.pluralsight.dealership;

public class SalesContract extends Contract {
    private boolean financed;

    public SalesContract(String dateOfContract, String name, String email, Vehicle vehicleSold, boolean financed) {
        super(dateOfContract, name, email, vehicleSold);
        this.financed = financed;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicleSold().getPrice();
        double salesTax = vehiclePrice * 0.05;
        double recordingFee = 100.00;
        double processingFee;

        if (vehiclePrice < 10000) {
            processingFee = 295.00;
        } else {
            processingFee = 495.00;
        }

        return vehiclePrice + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financed) {
            return 0;
        }

        double basePrice = getVehicleSold().getPrice();
        double interestRate;
        int months;

        if (basePrice >= 10000) {
            interestRate = 0.0425; // 4.25%
            months = 48;
        } else {
            interestRate = 0.0525; // 5.25%
            months = 24;
        }
        double monthlyRate = interestRate / 12;
        return (getTotalPrice() * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}