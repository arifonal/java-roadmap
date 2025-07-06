package gorev1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/** dosyadan tam sayıları okuyup ekrana basar */
public class ReadIntegers {

    public static void main(String[] args) {
        String fileName = "sayilar.bin";

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            System.out.print("Okunan sayılar: ");
            while (in.available() > 0)
                System.out.print(in.readInt() + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
