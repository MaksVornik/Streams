package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1");
        System.out.println("////////////////////////////////////");

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(12);
        list1.add(2);
        list1.add(7);
        System.out.println(returnFirstList(list1));

        //Task 2
        System.out.println("////////////////////////////////////");
        System.out.println("Task 2");
        System.out.println("////////////////////////////////////");
        List<String> names = Arrays.asList("john", "Arya", "Sansa", "Ann");
        System.out.println(returnSecondList(names));
        System.out.println("////////////////////////////////////");
        //Task 3
        System.out.println("Task 3");
        System.out.println("////////////////////////////////////");
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Maks", 16));
        persons.add(new Person("Slava", 25));
        persons.add(new Person("Oleg", 19));
        System.out.println(returnThirdList(persons));
        System.out.println("////////////////////////////////////");
        System.out.println("Task 4");
        System.out.println("////////////////////////////////////");
        List<String> stringsFour = new ArrayList<>();
        stringsFour.add("Maks");
        stringsFour.add("Slava");
        stringsFour.add("Nikita");
        stringsFour.add("Maks");
        stringsFour.add("Anton");
        stringsFour.add("Anton");
        System.out.println(returnFourthList(stringsFour));
        System.out.println("////////////////////////////////////");
        System.out.println("Task 5");
        System.out.println("////////////////////////////////////");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nikola", 10.1));
        students.add(new Student("Slavik", 8.4));
        students.add(new Student("Maksim", 6.6));
        students.add(new Student("Alex", 9.2));
        System.out.println(returnFifthList(students));
        System.out.println("////////////////////////////////////");
        System.out.println("Task 6");
        System.out.println("////////////////////////////////////");
        List<String> stringsOfSixthTask = new ArrayList<>();
        stringsOfSixthTask.add("baby");
        stringsOfSixthTask.add("sosi");


        System.out.println(returnSixthList(stringsOfSixthTask));


    }

    //1. Написать метод, который будет принимать на вход список целых чисел и возвращать новый список, в котором каждый элемент будет умножен на 2.
    public static List<Integer> returnFirstList(List<Integer> integers) {
        List<Integer> integers2 = integers.stream().map(el -> el * 2).collect(Collectors.toList());
        return integers2;
    }

    //2. Написать метод, который будет принимать на вход список строк и возвращать новый список, в котором будут только те строки, которые начинаются с буквы "A".
    public static List<String> returnSecondList(List<String> strings) {
        List<String> strings2 = strings.stream().filter(el -> el.startsWith("A")).collect(Collectors.toList());
        return strings2;
    }

    //3. Написать метод, который будет принимать на вход список объектов класса Person, который имеет поля name (String) и age (int),
    // и возвращать новый список объектов класса Person, в котором будут только те объекты, у которых возраст больше 18.
    public static List<Person> returnThirdList(List<Person> persons) {
        List<Person> persons2 = persons.stream().filter(el -> el.getAge() > 18).collect(Collectors.toList());
        return persons2;
    }

    //4. Написать метод, который будет принимать на вход список строк и возвращать новый список, в котором будут только уникальные строки (без повторений).
    public static List<String> returnFourthList(List<String> strings) {
        List<String> strings2 = strings.stream().distinct().collect(Collectors.toList());
        return strings2;
    }

    //5. Написать метод, который будет принимать на вход список объектов класса Student,
    // который имеет поля name (String) и grade (int), и возвращать средний балл по всем студентам в списке.
    public static double returnFifthList(List<Student> students) {
        return students.stream().mapToDouble(Student::getGrade).average().orElse(0.0);
    }

    //6.Написать метод, который будет принимать на вход список строк и возвращать новый список, в котором будут только уникальные символы из этих слов.
    public static List<Character> returnSixthList(List<String> strings) {
        List<Character> stringsTwo = new ArrayList<>();

        stringsTwo = strings.stream().flatMap(el -> el.chars().mapToObj(e -> (char) e)).distinct().collect(Collectors.toList());

        return stringsTwo;
    }


}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}