package gorev2;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public String name;
    public int    age;
    public Date   birthDate;

    public Person(String name, int age, Date birthDate) {
        this.name = name;
        this.age  = age;
        this.birthDate = birthDate;
    }
}
