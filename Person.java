
package odev;

import java.util.GregorianCalendar;

class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Class: Person, Name: " + name;
    }
}
class Student extends Person {
    public static final String FRESHMAN = "Freshman";
    public static final String SOPHOMORE = "Sophomore";
    public static final String JUNIOR = "Junior";
    public static final String SENIOR = "Senior";

    private String classStatus;

    public Student(String name, String address, String phoneNumber,
                   String emailAddress, String classStatus) {
        super(name, address, phoneNumber, emailAddress);
        this.classStatus = classStatus;
    }

    @Override
    public String toString() {
        return "Class: Student, Name: " + getName();
    }
}
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH) + 1;
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
class Employee extends Person {
    private String office;
    private double salary;
    private MyDate dateHired;

    public Employee(String name, String address, String phoneNumber,
                    String emailAddress, String office, double salary,
                    MyDate dateHired) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Class: Employee, Name: " + getName();
    }
}
class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber,
                   String emailAddress, String office, double salary,
                   MyDate dateHired, String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Class: Faculty, Name: " + getName();
    }
}
class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber,
                 String emailAddress, String office, double salary,
                 MyDate dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Class: Staff, Name: " + getName();
    }
}

 class TestProgram {
    public static void main(String[] args) {
        Person person = new Person(
                "Ahmet", "Kahramanmaras", "05551111111", "ahmet@example.com");

        Student student = new Student(
                "Ayse", "Ankara", "05552222222", "ayse@example.com",
                Student.SOPHOMORE);

        Employee employee = new Employee(
                "Mehmet", "Istanbul", "05553333333", "mehmet@example.com",
                "Office 101", 30000, new MyDate(2024, 5, 10));

        Faculty faculty = new Faculty(
                "Zeynep", "Izmir", "05554444444", "zeynep@example.com",
                "Office 202", 45000, new MyDate(2022, 9, 1),
                "09:00-12:00", "Professor");

        Staff staff = new Staff(
                "Ali", "Bursa", "05555555555", "ali@example.com",
                "Office 303", 28000, new MyDate(2023, 3, 15),
                "Secretary");

        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
        System.out.println(staff.toString());
    }
}

