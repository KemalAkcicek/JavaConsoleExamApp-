package online.exam;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Teacher.questions.put("Türkiyenin başkenti", "Ankara");
		Teacher.questions.put("3*4", "12");
		Teacher.questions.put("İstanbulun plaka kodu", "34");
		Teacher.questions.put("İstanbulun Fethi tarihi ", "1453");

		showMenu();

		Student.studentRecords.put("admin", "12345");
		Teacher.teacherRecords.put("adminTeacher", "12345");

		boolean sonuc = false;

		while (!sonuc) {
			int secim = scan.nextInt();

			switch (secim) {
			case 1: {
				teacherMenu();
				break;
			}
			case 2: {
				studentMenu();
				break;
			}
			case 3: {
				System.out.println("Çıkış yapılıyor......");
				sonuc = true;
				break;
			}
			default: {
				System.out.println("Hatali giris yaptınız lütfen tekrar deneyin");

				showMenu();
			}
			}

		}

	}

	private static void showMenu() {
		System.out.println("Online Sinav Uygulamasina Hosgeldiniz: ");
		System.out.println("Öğretmen için 1 e basiniz: ");
		System.out.println("Öğrenci için 2 e basiniz: ");
		System.out.println("Çıkış yapmak için 3 e basiniz...");

	}

	public static void studentMenu() {

		boolean continune = true;

		while (continune) {
			System.out.println("Öğrenci sistemine hoşgeldiniz");
			System.out.println("Kayıt olmak için 1 e basiniz: ");
			System.out.println("Giriş yapmak için 2 e basiniz");
			System.out.println("Çıkış yapmak için 3 e basiniz");
			int ogrenciSecim = scan.nextInt();

			if (ogrenciSecim == 1) {

				Person s1 = Student.signup("Öğrenci");

			} else if (ogrenciSecim == 2) {
				Person.login("Öğrenci");
			} else if (ogrenciSecim == 3) {
				System.out.println("Çıkış yapılıyor.....");
				continune = false;
			} else {
				System.out.println("Hatali bir tuşlama yaptınız...");

			}

		}

	}

	public static void teacherMenu() {

		boolean contiune = true;

		while (contiune) {
			System.out.println("Öğretmen sistemine hoşgeldiniz");
			System.out.println("Kayıt olmak için 1 e basiniz: ");
			System.out.println("Giriş yapmak için 2 e basiniz");
			System.out.println("Çıkış yapmak için 3 e basiniz");
			int ogretmenSecim = scan.nextInt();

			if (ogretmenSecim == 1) {
				Student.signup("Öğretmen");

			} else if (ogretmenSecim == 2) {
				Student.login("Öğretmen");
			} else if (ogretmenSecim == 3) {
				System.out.println("Çıkış yapılıyor.....");
				contiune = false;

			} else {
				System.out.println("Hatali bir tuşlama yaptınız...");
			}

		}
	}

}
