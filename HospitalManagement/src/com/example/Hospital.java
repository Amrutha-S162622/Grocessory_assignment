package com.example;

import java.util.Scanner;

public class Hospital {

    Scanner sc = new Scanner(System.in);

    Patient[] patients = new Patient[100];
    Doctor[] doctors = new Doctor[100];
    Appointment[] appointments = new Appointment[100];
    Bill[] bills = new Bill[100];

    int patientCount = 0;
    int doctorCount = 0;
    int appointmentCount = 0;
    int billCount = 0;
    
    public void registerPatient() {

        try {

            System.out.println("\n------ Patient Registration ------");

            System.out.print("Enter Patient ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            // Duplicate ID Checking
            for (int i = 0; i < patientCount; i++) {

                if (patients[i].getId() == id) {
                    throw new DuplicatePatientException("Patient ID Already Exists.");
                }

            }

            System.out.print("Enter Name : ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }

            System.out.print("Enter Age : ");
            int age = sc.nextInt();
            sc.nextLine();

            if (age <= 0 || age > 120) {
                throw new InvalidAgeException("Invalid Age.");
            }

            System.out.print("Enter Gender : ");
            String gender = sc.nextLine();

            System.out.print("Enter Phone : ");
            String phone = sc.nextLine();

            if (phone.length() != 10) {
                throw new InvalidPhoneNumberException("Phone must contain 10 digits.");
            }

            System.out.print("Enter Disease : ");
            String disease = sc.nextLine();

            System.out.print("Premium Patient (true/false) : ");
            boolean premium = sc.nextBoolean();

            patients[patientCount++] =
                    new Patient(id, name, age, gender,
                            phone, disease, premium);

            System.out.println("\nPatient Registered Successfully.");

        }

        catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    
    public void addDoctor() {

        try {

            System.out.println("\n------ Doctor Registration ------");

            System.out.print("Enter Doctor ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < doctorCount; i++) {

                if (doctors[i].getId() == id) {
                    throw new RuntimeException("Doctor ID Already Exists.");
                }

            }

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Age : ");
            int age = sc.nextInt();
            sc.nextLine();

            if (age <= 25) {
                throw new InvalidAgeException("Doctor age should be above 25.");
            }

            System.out.print("Enter Gender : ");
            String gender = sc.nextLine();

            System.out.print("Enter Phone : ");
            String phone = sc.nextLine();

            if (phone.length() != 10) {
                throw new InvalidPhoneNumberException("Invalid Phone Number.");
            }

            System.out.print("Enter Specialization : ");
            String specialization = sc.nextLine();

            System.out.print("Consultation Fee : ");
            double fee = sc.nextDouble();

            if (fee <= 0) {
                throw new RuntimeException("Invalid Fee.");
            }

            System.out.print("Experience : ");
            int exp = sc.nextInt();

            doctors[doctorCount++] =
                    new Doctor(id, name, age,
                            gender, phone,
                            specialization,
                            fee,
                            exp);

            System.out.println("\nDoctor Added Successfully.");

        }

        catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    
    public void searchPatient() {

        System.out.print("Enter Patient Name : ");

        sc.nextLine();

        String search = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < patientCount; i++) {

            if (patients[i].getName()
                    .toLowerCase()
                    .contains(search.toLowerCase())) {

                patients[i].displayDetails();

                found = true;

            }

        }

        if (!found)

            System.out.println("Patient Not Found.");

    }
    
    public void searchDoctor() {

        System.out.print("Enter Specialization : ");

        sc.nextLine();

        String sp = sc.nextLine();

        boolean found = false;

        for (Doctor doctor : doctors) {

            if (doctor == null)
                break;

            if (doctor.getSpecialization()
                    .equalsIgnoreCase(sp)) {

                doctor.displayDetails();

                found = true;

            }

        }

        if (!found)

            System.out.println("Doctor Not Found.");

    }
    
    public void displayPatients() {

        if (patientCount == 0) {

            System.out.println("No Patients.");

            return;

        }

        for (Patient patient : patients) {

            if (patient == null)
                break;

            patient.displayDetails();

        }

    }
    
    public void displayDoctors() {

        if (doctorCount == 0) {

            System.out.println("No Doctors.");

            return;

        }

        for (Doctor doctor : doctors) {

            if (doctor == null)
                break;

            doctor.displayDetails();

        }

    }
    
    public void bookAppointment() {

        try {

            System.out.println("\n------ Book Appointment ------");

            System.out.print("Enter Appointment ID : ");
            int appointmentId = sc.nextInt();

            System.out.print("Enter Patient ID : ");
            int patientId = sc.nextInt();

            System.out.print("Enter Doctor ID : ");
            int doctorId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Appointment Date (dd-mm-yyyy): ");
            String date = sc.nextLine().trim();

            bookAppointment(appointmentId, patientId, doctorId, date);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    
    public void bookAppointment(int appointmentId,
	           	int patientId,
	            int doctorId,
	            String date)
	throws DoctorUnavailableException,
		InvalidAppointmentException {
	
		boolean patientFound = false;
		boolean doctorFound = false;
		
		for (int i = 0; i < patientCount; i++) {
		
			if (patients[i].getId() == patientId) {
				patientFound = true;
				break;
			}
		
		}
	
		if (!patientFound) {
			throw new InvalidAppointmentException("Patient Not Found.");
		}
		
		int count = 0;
		
		for (int i = 0; i < doctorCount; i++) {
		
			if (doctors[i].getId() == doctorId) {
				doctorFound = true;
			}
			
		}
		
		if (!doctorFound)
			throw new InvalidAppointmentException("Doctor Not Found.");
		
		for (int i = 0; i < appointmentCount; i++) {
		
			if (appointments[i].getDoctorId() == doctorId &&
			appointments[i].getStatus().equalsIgnoreCase("Booked")) {
			
				count++;
			}
		
		}
		
		if (count >= 5)
			throw new DoctorUnavailableException("Doctor is fully booked.");
		
		appointments[appointmentCount++] =
			new Appointment(appointmentId,
			    patientId,
			    doctorId,
			    date,
			    "Booked");
		
		System.out.println("Appointment Booked Successfully.");
		
	}
    public void cancelAppointment() {

        System.out.print("Enter Appointment ID : ");

        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i].getAppointmentId() == id) {

                appointments[i].setStatus("Cancelled");

                found = true;

                System.out.println("Appointment Cancelled.");

                break;

            }

        }

        if (!found)

            System.out.println("Appointment Not Found.");

    }
    public void displayAppointments() {

        if (appointmentCount == 0) {

            System.out.println("No Appointments.");

            return;

        }

        for (Appointment appointment : appointments) {

            if (appointment == null)
                break;

            appointment.displayAppointment();

        }

    }
    public void generateBill() {

        try {

            System.out.println("\n------ Generate Bill ------");

            System.out.print("Bill ID : ");
            int billId = sc.nextInt();

            System.out.print("Patient ID : ");
            int patientId = sc.nextInt();

            System.out.print("Consultation Fee : ");
            double consultationFee = sc.nextDouble();

            System.out.print("Medicine Charge : ");
            double medicineCharge = sc.nextDouble();

            System.out.print("Lab Charge : ");
            double labCharge = sc.nextDouble();

            double total =
                    consultationFee
                            + medicineCharge
                            + labCharge;

            double discount = 0;

            for (int i = 0; i < patientCount; i++) {

                if (patients[i].getId() == patientId) {

                    if (patients[i].getAge() >= 60)

                        discount = total * 0.10;

                    if (patients[i].isPremiumPatient())

                        discount = total * 0.15;

                }

            }

            total -= discount;

            bills[billCount++] =
                    new Bill(billId,
                            patientId,
                            consultationFee,
                            medicineCharge,
                            labCharge,
                            discount,
                            total);

            System.out.println("Bill Generated Successfully.");
            System.out.println("Total Bill : ₹" + total);

        }

        catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    public void displayBills() {

        if (billCount == 0) {

            System.out.println("No Bills Generated.");

            return;

        }

        for (Bill bill : bills) {

            if (bill == null)
                break;

            bill.displayBill();

        }

    }
    public void reports() {

        System.out.println("\n========= REPORT =========");

        System.out.println("Total Patients      : " + patientCount);

        System.out.println("Total Doctors       : " + doctorCount);

        System.out.println("Total Appointments  : " + appointmentCount);

        System.out.println("Total Bills         : " + billCount);

        double revenue = 0;

        for (int i = 0; i < billCount; i++) {

            revenue += bills[i].getTotalAmount();

        }

        System.out.println("Hospital Revenue : ₹" + revenue);

    }

}