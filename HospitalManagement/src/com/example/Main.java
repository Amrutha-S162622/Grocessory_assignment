package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hospital hospital = new Hospital();

        int choice;

        do {

            System.out.println("\n=========================================");
            System.out.println("      HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("=========================================");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Search Patient");
            System.out.println("6. Search Doctor");
            System.out.println("7. Generate Bill");
            System.out.println("8. Display Patients");
            System.out.println("9. Display Doctors");
            System.out.println("10. Display Appointments");
            System.out.println("11. Display Bills");
            System.out.println("12. Reports");
            System.out.println("13. Exit");
            System.out.println("=========================================");

            System.out.print("Enter your choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hospital.registerPatient();
                    break;

                case 2:
                    hospital.addDoctor();
                    break;

                case 3:
                    hospital.bookAppointment();
                    break;

                case 4:
                    hospital.cancelAppointment();
                    break;

                case 5:
                    hospital.searchPatient();
                    break;

                case 6:
                    hospital.searchDoctor();
                    break;

                case 7:
                    hospital.generateBill();
                    break;

                case 8:
                    hospital.displayPatients();
                    break;

                case 9:
                    hospital.displayDoctors();
                    break;

                case 10:
                    hospital.displayAppointments();
                    break;

                case 11:
                    hospital.displayBills();
                    break;

                case 12:
                    System.out.println("\nThank You...");
                    System.out.println("Application Closed.");
                    break;

                default:       
                    System.out.println("Invalid Choice.");

            }

        } while (choice != 12
        		);

        sc.close();

    }

}