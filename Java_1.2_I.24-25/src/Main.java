import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double RUBLES_PER_YUAN = 11.91;   // курс покупки
        Scanner input = new Scanner(System.in);

        int yuan;        // сумма денег в китайских юанях
        double rubles;   // сумма денег в российских рублях

        System.out.println("Напишите кол-во юаней:");
        yuan = input.nextInt();

        int lastDigit = yuan % 10;
        int lastTwoDigits = yuan % 100;  // Проверка последних двух цифр

        String cn_yuan;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            cn_yuan = "юаней";  // Исключение для чисел от 11 до 19
        } else if (lastDigit == 1) {
            cn_yuan = "юань";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            cn_yuan = "юаня";
        } else {
            cn_yuan = "юаней";
        }

        rubles = RUBLES_PER_YUAN * yuan;
        int result = (int) Math.ceil(rubles);

        lastDigit = result % 10;
        lastTwoDigits = result % 100;

        String ru_rubles;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            ru_rubles = "рублей";  // Исключение для чисел от 11 до 19
        } else if (lastDigit == 1) {
            ru_rubles = "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            ru_rubles = "рубля";
        } else {
            ru_rubles = "рублей";
        }

        System.out.println(yuan + " " + cn_yuan + " = " + result + " " + ru_rubles);
    }
}
