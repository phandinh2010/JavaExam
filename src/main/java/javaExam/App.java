package javaExam;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		int n;
		do {
			System.out.print("Nhập số sinh viên n (n >= 10): ");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			if (n < 10) {
				System.out.println("Vui lòng nhập n > 10");
			}
		} while (n < 10);

		
		ArrayList<SinhVien> listSV = generateSVs(n);

		// 5. in ra console danh sách sinh viên
		for (SinhVien sinhVien : listSV) {
			System.out.println(sinhVien);
		}

		// sắp xếp list sv theo thứ tự điểm tăng dần
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				if (listSV.get(j).getTongDiem() > listSV.get(i).getTongDiem()) {
					SinhVien sv = listSV.get(j);
					listSV.set(j, listSV.get(i));
					listSV.set(i, sv);
				}
			}
		}

		// 1. lấy ra 10 người điểm cao nhất
		System.out.println("Top 10 Sinh Viên điểm cao nhất:");
		for (int i = 0; i < 10; i++) {
			System.out.println(listSV.get(i));
		}

		// 2. lấy ra 10 người điểm thấp nhất
		System.out.println("Top 10 Sinh Viên điểm cao nhất:");
		for (int i = n - 1; i >= n - 10; i--) {
			System.out.println(listSV.get(i));
		}
		
		// Tổng sinh viên
		System.out.println("Tổng sinh viên: " + n);
		
		// Đạt
		int count = 0;
		for (SinhVien sinhVien : listSV) {
			if (sinhVien.getTongDiem() >4.5) {
				count++;
			}
		}
		
		System.out.println("Tổng sinh viên đạt: " + count);
		double dat = Math.round((count / (float) n) * 100 * 100.0) / 100.0;
		System.out.println("Tỷ lệ sinh viên điểm > 4.5: " + dat + "%" );
		
		// Không đạt
		System.out.println("Tổng sinh viên đạt: " + (n - count));
		System.out.println("Tỷ lệ sinh viên điểm > 4.5: " + (100 - dat) + "%" );
	}
	
	 public static ArrayList<SinhVien> generateSVs(int n) {
		 ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();

			for (int i = 0; i < n; i++) {
				listSV.add(SinhVien.generateSV());

			}
			return listSV;
	 }
}