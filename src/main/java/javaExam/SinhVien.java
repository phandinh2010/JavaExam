package javaExam;

import java.util.ArrayList;
import java.util.Random;

public class SinhVien {
	String Name, Email;
	int ID;
	double bonus, report, app, LT;
	double tongDiem;

	

	public SinhVien(String name, String email, int iD, double bonus, double report, double app, double lT,
			double tongDiem) {
		super();
		Name = name;
		Email = email;
		ID = iD;
		this.bonus = bonus;
		this.report = report;
		this.app = app;
		LT = lT;
		this.tongDiem = tongDiem;
	}

	public SinhVien() {

	}

	public static SinhVien generateSV() {
		SinhVien sv = new SinhVien();
		Random rand = new Random();
		sv.ID = 10000000 + rand.nextInt(1000000);
		sv.Name = "SV" + rand.nextInt(100) + 1;
		sv.Email = sv.getName() + "@gmail.com";
		sv.bonus = rand.nextInt(10);
		sv.report = rand.nextInt(10);
		sv.app = rand.nextInt(10);
		sv.LT = Math.floor(Math.random() * (10 - 0) + 1);
		tinhDiem(sv);
		return sv;
	}

	public static void tinhDiem(SinhVien sv) {		
		sv.tongDiem = sv.getBonus() * 0.1 + sv.getReport() * 0.3 + sv.getApp() * 0.15 + sv.getLT() * 0.45;
		if (sv.tongDiem - (int) sv.tongDiem >= 0.5) {
			sv.tongDiem = Math.ceil(sv.tongDiem);
		} else if (sv.tongDiem - (int) sv.tongDiem >= 0.25) {
			sv.tongDiem = Math.ceil(sv.tongDiem) - 0.5;
		} else {
			sv.tongDiem = Math.floor(sv.tongDiem);
		}
	}

	
	
//	@Override
//	public String toString() {
//		return "SinhVien [Name=" + Name + ", Email=" + Email + ", ID=" + ID + ", bonus=" + bonus + ", report=" + report
//				+ ", app=" + app + ", LT=" + LT + "]";
//	}
	

	public String getName() {
		return Name;
	}

	@Override
	public String toString() {
		return "SinhVien [Name=" + Name + ", Email=" + Email + ", ID=" + ID + ", bonus=" + bonus + ", report=" + report
				+ ", app=" + app + ", LT=" + LT + ", tongDiem=" + tongDiem + "]";
	}

	public double getTongDiem() {
		return tongDiem;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getReport() {
		return report;
	}

	public void setReport(double report) {
		this.report = report;
	}

	public double getApp() {
		return app;
	}

	public void setApp(double app) {
		this.app = app;
	}

	public double getLT() {
		return LT;
	}

	public void setLT(double lT) {
		LT = lT;
	}

}
