import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        String file = "src/transactions.txt";   // dosya proje kökünde

        /* try-with-resources → dosya otomatik kapanır */
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                line = line.split("#")[0].trim();   // '#' sonrası yorum sil
                if (line.isEmpty()) continue;       // boş satır geç

                String[] parts = line.split("\\s+");
                char   op   = parts[0].charAt(0);   // D veya W
                double amt  = Double.parseDouble(parts[1]);

                switch (op) {
                    case 'D': case 'd':
                        account.deposit(amt);
                        break;
                    case 'W': case 'w':
                        account.withdraw(amt);
                        break;
                    default:
                        System.out.println("Bilinmeyen komut: " + op);
                }
            }

        } catch (NegativeAmountException e) {
            System.out.println("Hata: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Hata: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Beklenmeyen hata: " + e.getMessage());
        } finally {
            System.out.println("Güncel bakiye: " + account.getBalance() + " ₺");
        }
    }
}
