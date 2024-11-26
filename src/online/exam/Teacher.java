package online.exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Teacher extends Person {
	static Scanner scan = new Scanner(System.in);

	private String brans;
	static LinkedHashMap<String, String> teacherRecords = new LinkedHashMap<String, String>();
	static LinkedHashMap<String, String> questions = new LinkedHashMap<String, String>();

	public Teacher() {

	}

	public Teacher(String name, String surname, String kullaniciAdi, String sifre, String brans) {
		super(name, surname, kullaniciAdi, sifre);
		this.brans = brans;
		teacherRecords.put(kullaniciAdi, sifre);

	}

	public String getBrans() {
		return brans;
	}

	public void setBrans(String brans) {
		this.brans = brans;
	}

	@Override
	public String toString() {
		return super.toString() + "Teacher [brans=" + brans + "]";
	}

	public void teacherFeature() {

		System.out.println("Yapmak istediğinizi işlemi seçiniz:");
		System.out.println("1-Soru Oluştur");
		System.out.println("2-Soruları Düzenle");
		System.out.println("3-Öğrenci Notlarını Görüntüle");
		System.out.println("4-Eklediğin soruları görmek için");
		System.out.println("5-Çıkış yap");
		int secim = scan.nextInt();
		if (secim == 1) {
			createExam();
		} else if (secim == 2) {
			editQuestions();
		} 
		else if(secim==3) {
			listStudents();
		}
		else if (secim == 4) {
			allQuestion();
			teacherFeature();
		} else if (secim == 5) {
			System.out.println("Çıkış yapılıyor");
		}
		else {
			System.out.println("Hatalı tuşlama yaptınız. Tekrar deneyin");
			teacherFeature();
		}

	}

	private void listStudents() {
		System.out.println("Öğrencinin puanı: "+Student.puan);
		System.out.println("Yanlış cevaplarınız: ");
		for (Map.Entry<String, String> temp : Student.falseAnswer.entrySet()) {
			System.out.print("Doğru cevap: " + temp.getKey());
			System.out.println("Sizin verdiğiniz cevap: " + temp.getValue());

		}
		System.out.println("Doğru cevaplarınız: ");
		for (Map.Entry<String, String> temp :Student.trueAnswer.entrySet()) {
			System.out.println(temp.getKey());
		}
		teacherFeature();
		
	}

	public void createExam() {

		System.out.println("Soru sayısı giriniz:");
		int valueQuestion = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < valueQuestion; i++) {
			System.out.println("Soruyu yaziniz: ");
			String question = scan.nextLine();
			System.out.println("Cevabı yaziniz:");
			String answer = scan.nextLine();
			questions.put(question, answer);
		}
		System.out.println("Sorular başarıyla oluşturuldu");
		teacherFeature();

	}

	public void allQuestion() {
		int i = 1;
		for (Map.Entry<String, String> temp : questions.entrySet()) {
			System.out.println(i + "'inci soru:" + temp.getKey() + " Cevabı: " + temp.getValue());
			i++;
		}

	}

	public void editQuestions() {
		System.out.println("1-Soruyu düzenle:");
		System.out.println("2-Soruyu sil: ");
		System.out.println("3-Soruyu ekle:");
		System.out.println("4-Çıkış yap:");
		int secim = scan.nextInt();

		if (secim == 1) {
			oneEditQuestion();

		} else if (secim == 2) {
			allQuestion();
			questionDelete();

		}

		else if (secim == 3) {
			createExam();

		} else if (secim == 4) {
			System.out.println("Çıkış yapılıyor...");
		} else {
			System.out.println("Hatalı tuşlama yaptınız....");
			teacherFeature();
		}
	}

	public void questionDelete() {

		System.out.println("Silmek istediğiniz sorunun numarısını yaziniz:");
		int secim = scan.nextInt();

		// Map yapısında silme işlemini index üzerinde yapamıyoruz bizde array list map
		// attıp bir yapı oluşturduk bu yapıyı index değerini key in ulaşup silme işlemi
		// yaptık
		List<Map.Entry<String, String>> entries = new ArrayList<>(questions.entrySet());

		if (secim >= 0 && secim <= questions.size()) {

			String keyToRemove = entries.get(secim - 1).getKey();
			questions.remove(keyToRemove);
			System.out.println("Güncellenmiş hali:");
			allQuestion();
			teacherFeature();

		} else {
			System.out.println("Hatalı tuşlama yaptınız.....");
			editQuestions();
		}

	}

	public void oneEditQuestion() {

		System.out.println("Düzenlemek istediğiniz soruyu numarısını seçiniz:");
		allQuestion();
		int secim = scan.nextInt();
		scan.nextLine();
		if (secim >= 0 && secim <= questions.size()) {

			List<Map.Entry<String, String>> entries = new ArrayList<>(questions.entrySet());
			System.out.println("Yeni soruyu yazınız");
			String newQuestion = scan.nextLine();
			System.out.println("Yeni sorunun cevabını yaziniz:");
			String newAnswer = scan.nextLine();

			String keyToRemove = entries.get(secim - 1).getKey();
			questions.remove(keyToRemove);

			questions.put(newQuestion, newAnswer);
			System.out.println("Düzenlenmiş hali:");
			allQuestion();
			teacherFeature();

		} else {
			System.out.println("Hatalı tuşlama yaptınız....");
			
		}
	}

}
