package com.pluralsight.dealership;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {

    public void saveContract(Contract contract) {

        try {
            FileWriter fw = new FileWriter("contracts.csv", true);
            PrintWriter pw = new PrintWriter(fw);

            Vehicle v = contract.getVehicleSold();

            if (contract instanceof SalesContract) {

                SalesContract sale = (SalesContract) contract;

                pw.printf(
                        "SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f%n",

                        sale.getDateOfContract(),
                        sale.getName(),
                        sale.getEmail(),

                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice(),

                        sale.getTotalPrice(),
                        sale.getMonthlyPayment()
                );

            } else if (contract instanceof LeaseContract) {

                LeaseContract lease = (LeaseContract) contract;

                pw.printf(
                        "LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f%n",

                        lease.getDateOfContract(),
                        lease.getName(),
                        lease.getEmail(),

                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice(),

                        lease.getExpectedEndingValue(),
                        lease.getLeaseFee(),
                        lease.getTotalPrice(),
                        lease.getMonthlyPayment()
                );
            }

            pw.close();

        } catch (IOException e) {
            System.out.println("Error saving contract.");
        }
    }
}