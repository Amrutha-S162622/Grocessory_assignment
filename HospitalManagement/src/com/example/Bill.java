package com.example;

public class Bill {

    private int billId;
    private int patientId;
    private double consultationFee;
    private double medicineCharge;
    private double labCharge;
    private double discount;
    private double totalAmount;

    public Bill() {

    }

    public Bill(int billId, int patientId,
                double consultationFee,
                double medicineCharge,
                double labCharge,
                double discount,
                double totalAmount) {

        this.billId = billId;
        this.patientId = patientId;
        this.consultationFee = consultationFee;
        this.medicineCharge = medicineCharge;
        this.labCharge = labCharge;
        this.discount = discount;
        this.totalAmount = totalAmount;
    }

   

    public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public double getMedicineCharge() {
		return medicineCharge;
	}

	public void setMedicineCharge(double medicineCharge) {
		this.medicineCharge = medicineCharge;
	}

	public double getLabCharge() {
		return labCharge;
	}

	public void setLabCharge(double labCharge) {
		this.labCharge = labCharge;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void displayBill() {

        System.out.println("--------------------------------");

        System.out.println("Bill ID          : " + billId);
        System.out.println("Patient ID       : " + patientId);
        System.out.println("Consultation Fee : " + consultationFee);
        System.out.println("Medicine Charge  : " + medicineCharge);
        System.out.println("Lab Charge       : " + labCharge);
        System.out.println("Discount         : " + discount);
        System.out.println("Total Amount     : " + totalAmount);

    }

}
