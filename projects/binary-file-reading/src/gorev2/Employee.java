package gorev2;

import java.util.Date;

public class Employee extends Person {
    private static final long serialVersionUID = 1L;

    public String employeeId;

    public Employee(String name, int age, Date birthDate, String employeeId) {
        super(name, age, birthDate);
        this.employeeId = employeeId;
    }
}
