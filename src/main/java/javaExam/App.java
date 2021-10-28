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

		ArrayList<SinhVien> top10 = getTop10Students(listSV);

		// 1. lấy ra 10 người điểm cao nhất
		System.out.println("Top 10 Sinh Viên điểm cao nhất:");
		for (int i = 0; i < top10.size(); i++) {
			System.out.println(top10.get(i));
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
			if (sinhVien.getTongDiem() > 4.5) {
				count++;
			}
		}
		
		System.out.println("Tổng sinh viên đạt: " + count);
		double dat = Math.round((count / (float) n) * 100 * 100.0) / 100.0;
		System.out.println("Tỷ lệ sinh viên đạt: " + dat + "%" );
		
		// Không đạt
		System.out.println("Tổng sinh viên không đạt: " + (n - count));
		System.out.println("Tỷ lệ sinh viên không đạt: " + (100 - dat) + "%" );
		
		// Thống kê
		int sum = 0;
		int sumKha = 0;
		int sumTrungBinh = 0;
		for (int i = 0; i < n; i++) {
			if( 8 <= listSV.get(i).getTongDiem() ) {
				sum ++;
			} else if (listSV.get(i).getTongDiem() >= 6.5) {
				sumKha++;
			} else if (listSV.get(i).getTongDiem() >= 4.5) {
				sumTrungBinh++;
			}
		}
		
		// Sinh viên giỏi
		System.out.println("Tổng sinh viên giỏi: " + sum);
		double gioi = Math.round((sum / (float) n) * 100 * 100.0) / 100.0;
		System.out.println("Tỷ lệ sinh viên giỏi: " + gioi + "%" );
		
		// Sinh viên khá
		System.out.println("Tổng sinh viên khá: " + sum);
		double kha = Math.round((sumKha / (float) n) * 100 * 100.0) / 100.0;
		System.out.println("Tỷ lệ sinh viên khá: " + kha + "%" );
		
		// Sinh viên trung bình
		System.out.println("Tổng sinh viên trunng bình: " + sum);
		double trunhBinh = Math.round((sumTrungBinh / (float) n) * 100 * 100.0) / 100.0;
		System.out.println("Tỷ lệ sinh viên trung bình: " + trunhBinh + "%" );
	}
	
	 public static ArrayList<SinhVien> generateSVs(int n) {
		 ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();

			for (int i = 0; i < n; i++) {
				listSV.add(SinhVien.generateSV());

			}
			return listSV;
	 }
	 
	 public static ArrayList<SinhVien> getTop10Students(ArrayList<SinhVien> listSV) {
		 int n = listSV.size();
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
			ArrayList<SinhVien> result = new ArrayList<SinhVien>();
			System.out.println("Top 10 Sinh Viên điểm cao nhất:");
			for (int i = 0; i < 10; i++) {
				result.add(listSV.get(i));
			}
			return result;
	 }
}