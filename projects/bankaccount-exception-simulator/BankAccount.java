import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;

/**
 * Basit banka hesabı modeli.
 */
public class BankAccount {

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    /** Para yatırma */
    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Tutar negatif olamaz: " + amount);
        }
        balance += amount;
        System.out.printf("İşlem: Deposit %.1f  -> Başarılı%n", amount);
    }

    /** Para çekme */
    public void withdraw(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Tutar negatif olamaz: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    String.format("Bakiye yetersiz! İstenen: %.1f, Mevcut: %.1f", amount, balance));
        }
        balance -= amount;
        System.out.printf("İşlem: Withdraw %.1f -> Başarılı%n", amount);
    }

    /* ★ Opsiyonel: Hesaplar arası transfer */
    public void transferTo(BankAccount other, double amount)
            throws NegativeAmountException, InsufficientBalanceException {
        withdraw(amount);   // kontroller burada yapılır
        other.deposit(amount);
    }
}
