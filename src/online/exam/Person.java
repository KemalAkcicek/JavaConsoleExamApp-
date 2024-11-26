package online.exam;

import java.util.Scanner;

class Person {

	static Scanner scan = new Scanner(System.in);

	private String name;
	private String surname;
	private String kullaniciAdi;
	private String sifre;

	public Person() {

	}

	public Person(String name, String surname, String kullaniciAdi, String sifre) {

		this.name = name;
		this.surname = surname;
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	@Override
	public String toString() {
		return "Signup [name=" + name + ", surname=" + surname + ", kullaniciAdi=" + kullaniciAdi + ", sifre=" + sifre
				+ "]";
	}

	public static Person signup(String role) {
		
		System.out.println(role + "Kayıt ekranına hoşgeldiniz.....");
		System.out.println("Adinizi giriniz: ");
		String sName = scan.nextLine();
		System.out.println("Soyadiniz giriniz:");
		String sSurname = scan.nextLine();
		System.out.println("Kullanici adınızı giriniz:");
		String sKullaniciAdi = scan.nextLine();
		System.out.println("Şifreniniz giriniz:");
		String sSifre = scan.nextLine();

		if (role.equals("Öğrenci")) {
			System.out.println("Sınıfını giriniz:");
			String sinif = scan.nextLine();
			Student newStudent = new Student(sName, sSurname, sKullaniciAdi, sSifre, sinif);
			Main.studentMenu();
			return newStudent;

		} else if (role.equals("Öğretmen")) {
			System.out.println("Branşınızı giriniz:");
			String brans = scan.nextLine();
			Teacher newTeacher = new Teacher(sName, sSurname, sKullaniciAdi, sSifre, brans);
			Main.teacherMenu();
			return newTeacher;

		} else
			return null;

	}

	public static void login(String role) {

		System.out.println("Giriş ekranına hoşgeldiniz...");
		System.out.println("Kullanici adını giriniz: ");
		String kullaniciAdi = scan.nextLine();
		System.out.println("Parolayi giriniz:");
		String parola = scan.nextLine();

		if (role.equals("Öğrenci")) {
			boolean kullanici = Student.studentRecords.containsKey(kullaniciAdi);
			boolean sifre = Student.studentRecords.containsValue(parola);

			if (kullanici && sifre) {
				System.out.println("Başarıyla giriş yapıldı");
				Student s1 = new Student();
				s1.studentFeature();

			} else {
				System.out.println("Kullanici adi veya parola yanlıştır...");
				login("Öğrenci");
			}

		} else if (role.equals("Öğretmen")) {
			boolean kullanici = Teacher.teacherRecords.containsKey(kullaniciAdi);
			boolean sifre = Teacher.teacherRecords.containsValue(parola);

			if (kullanici && sifre) {
				System.out.println("Başarıyla giriş yapıldı");
				Teacher t1 = new Teacher();
				t1.teacherFeature();

			} else {
				System.out.println("Kullanici adi veya parola yanlıştır...");
				login("Öğretmen");
			}

		} else
			System.out.println("Hatalı tuşlama yaptınız....");

	}

}
