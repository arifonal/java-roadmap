package gorev2;

import java.io.*;
import java.util.Date;

/** Employee nesnesini dosyaya yazar ve geri okur */
public class SerializeDemo {

    public static void main(String[] args) {

        Employee emp = new Employee("Ayşe", 28, new Date(), "EMP01");
        String fileName = "emp.bin";

        // --- Yaz ---
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(emp);
            System.out.println("Employee '" + fileName + "' dosyasına yazıldı.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- Oku ---
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            Employee read = (Employee) in.readObject();

            System.out.println("\n--- Diskten Okunan Nesne ---");
            System.out.println("Name : " + read.name);
            System.out.println("Age  : " + read.age);
            System.out.println("Birth: " + read.birthDate);
            System.out.println("ID   : " + read.employeeId);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
