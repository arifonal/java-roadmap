package gorev1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/** 5 adet tam sayıyı ikili dosyaya yazar */
public class WriteIntegers {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 32767};
        String fileName = "sayilar.bin";

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            for (int n : numbers) out.writeInt(n);
            System.out.println("Dizi '" + fileName + "' dosyasına yazıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
