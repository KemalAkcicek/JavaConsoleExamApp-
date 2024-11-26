package online.exam;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student extends Person {
	static int puan = 0;
	private String studentClass;
	static LinkedHashMap<String, String> trueAnswer = new LinkedHashMap<String, String>();
	static LinkedHashMap<String, String> falseAnswer = new LinkedHashMap<String, String>();

	static LinkedHashMap<String, String> studentRecords = new LinkedHashMap<String, String>();

	public Student(String name, String surname, String kullaniciAdi, String sifre, String studentClass) {
		super(name, surname, kullaniciAdi, sifre);
		this.studentClass = studentClass;
		studentRecords.put(kullaniciAdi, sifre);

	}

	public Student() {

	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	@Override
	public String toString() {
		return super.toString() + "Student [studentClass=" + studentClass + "]";
	}

	public void studentFeature() {
		System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
		System.out.println("1-Sınavlara giriş:");
		System.out.println("2-Sınav sonucunu görüntüleme:");
		System.out.println("3-Çıkış yap");
		int secim = scan.nextInt();

		if (secim == 1) {
			loginExam();
		} else if (secim == 2) {
			result();

		} else if (secim == 3) {
			System.out.println("Çıkış yapılıyor");
		} else {
			System.out.println("Hatalı tuşlama yaptınız: ");
			studentFeature();
		}

	}

	private void result() {
		System.out.println("Sınav sonucunuz: " + puan);
		System.out.println("Yanlış cevaplarınız: ");
		for (Map.Entry<String, String> temp : falseAnswer.entrySet()) {
			System.out.print("Doğru cevap: " + temp.getKey());
			System.out.println("Sizin verdiğiniz cevap: " + temp.getValue());

		}
		System.out.println("Doğru cevaplarınız: ");
		for (Map.Entry<String, String> temp : trueAnswer.entrySet()) {
			System.out.println(temp.getKey());
		}
		studentFeature();

	}

	public void loginExam() {
		scan.nextLine();
		System.out.println("Sınav süresi 20 dk'dır, Başarılar dileriz.....");
		System.out.println("Soruların cevaplar veriken doğru yazın,yazım yanlışı olan kelimeler kabul edilmeyecek");

		int i = 1;

		int eklenecekPuan = 100 / Teacher.questions.size();
		for (Map.Entry<String, String> temp : Teacher.questions.entrySet()) {

			System.out.println(i + " inci soru:" + temp.getKey());
			String answer = scan.nextLine();
			i++;

			if (temp.getValue().contains(answer)) {
				trueAnswer.put(temp.getValue(), answer);
				puan += eklenecekPuan;
			} else {
				falseAnswer.put(temp.getValue(), answer);
			}

		}
		System.out.println("Sınav sonucunun= " + puan);
		studentFeature();

	}

}
