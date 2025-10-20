import java.util.Objects;

public class Human implements Comparable<Human> {
    private String fName;    // Имя
    private String lName;    // Фамилия
    private int age;         // Возраст

    public Human(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    // Геттеры
    public String getfName() { return fName; }
    public String getlName() { return lName; }
    public int getAge() { return age; }

    // Сеттеры
    public void setfName(String fName) { this.fName = fName; }
    public void setlName(String lName) { this.lName = lName; }
    public void setAge(int age) { this.age = age; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(fName, human.fName) &&
                Objects.equals(lName, human.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, lName, age);
    }

    @Override
    public int compareTo(Human o) {
        int rez;
        if (this.equals(o))
            return 0;
        rez = fName.compareToIgnoreCase(o.getfName());
        if (rez != 0)
            return rez;
        rez = lName.compareToIgnoreCase(o.getlName());
        if (rez != 0)
            return rez;
        else
            return age - o.getAge();
    }

    @Override
    public String toString() {
        return fName + " " + lName + " (" + age + " лет)";
    }
}