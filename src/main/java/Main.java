/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    Service s = new Service();
    while (true) {

      int pos = 0;
      System.out.println("0. Wyjscie");
      System.out.println("1. Dodawanie studenta");
      System.out.println("2. Wyswieltanie studentow");
      System.out.println("3. Znajdz studentow");

      pos = myObj.nextInt();

      switch (pos) {
        case 0:
          System.exit(00);
        case 1:
          dodajStudenta();
          break;
        case 2:
          zobaczStudentow();
          break;
        case 3:
          System.out.println("Podaj imie studenta");
          String imie = myObj.next();
          Student stud = s.findStudentByName(imie);
          System.out.println(stud.ToString());
          break;
        default:

          break;

      }

    }
  }

  public static void dodajStudenta() {
    Service s = new Service();
    Scanner myObj = new Scanner(System.in);
    System.out.println("Podaj imie studenta: ");
    String imie = myObj.nextLine();
    System.out.println("Podaj nazwisko studenta: ");
    String nazwisko = myObj.nextLine();
    System.out.println("Podaj wiek studenta: ");
    int wiek = myObj.nextInt();
    System.out.println("Podaj date urodzenia (w formacie DD-MM-RRRR): ");
    String dataUrodzenia = myObj.nextLine();
    dataUrodzenia = myObj.nextLine();
    if (validateDate(dataUrodzenia)) {
      try {

        s.addStudent(new Student(imie, wiek, nazwisko, dataUrodzenia));
      } catch (IOException e) {

      }
    } else {
      System.out.println("data nieprawidlowa");
    }

  }

  public static void zobaczStudentow() {
    try {
      Service s = new Service();

      var students = s.getStudents();
      for (Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {

    }
  }

  public static Boolean validateDate(String date) {
    Pattern pattern = Pattern.compile("^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$",
        Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(date);
    return matcher.find();
  }
}