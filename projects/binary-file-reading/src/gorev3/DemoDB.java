package gorev3;

import java.io.IOException;
import java.util.List;

public class DemoDB {

    public static void main(String[] args) {

        try (EmployeeDB db = new EmployeeDB("emp.db")) {

            db.add(new EmployeeRec(1, "Ali",     8500));
            db.add(new EmployeeRec(2, "Ayse",    9200));
            db.add(new EmployeeRec(3, "Mehmet",  7800));

            System.out.println("--- İlk Kayıtlar ---");
            print(db.list());

            db.updateSalary(2, 10000);

            System.out.println("\n--- Zam Sonrası ---");
            print(db.list());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(List<EmployeeRec> list) {
        for (EmployeeRec e : list)
            System.out.printf("ID:%-2d Name:%-20s Salary:%.1f%n",
                    e.id, e.name, e.salary);
    }
}
