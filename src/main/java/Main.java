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

class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    while (true) {

      int pos = 0;
      System.out.println("0. Wyjscie");
      System.out.println("1. Dodawanie studenta");
      System.out.println("2. Wyswieltanie studentow");

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
        default:

          break;

      }

    }
  }

  public static void dodajStudenta() {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Podaj imie studenta: ");
    String imie = myObj.nextLine();
    System.out.println("Podaj nazwisko studenta: ");
    String nazwisko = myObj.nextLine();
    System.out.println("Podaj wiek studenta: ");
    int wiek = myObj.nextInt();
    try {
      Service s = new Service();
      s.addStudent(new Student(imie, wiek, nazwisko));
    } catch (IOException e) {

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
}