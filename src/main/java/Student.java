public class Student {

  private String Name;
  private int Age;
  private String Nazwisko;
  private String DataUrodzenia;

  public Student(String name, int age, String nazwisko, String dataUrodzenia) {
    Name = name;
    Age = age;
    Nazwisko = nazwisko;
    DataUrodzenia = dataUrodzenia;
  }

  public String GetName() {
    return Name;
  }

  public int GetAge() {
    return Age;
  }

  public String GetNazwisko() {
    return Nazwisko;
  }

  public String GetDataUrodzenia() {
    return DataUrodzenia;
  }

  public String ToString() {
    return Name + " " + Nazwisko + " "+ Integer.toString(Age) + " "+ DataUrodzenia;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4)
      return new Student("Parse Error", -1, "", "");
    return new Student(data[0], Integer.parseInt(data[2]), data[1], data[3]);

  }
}