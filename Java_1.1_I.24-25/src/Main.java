import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double RUBLES_PER_YUAN = 11.91;   // курс покупки
        Scanner input = new Scanner(System.in);
        
        int yuan;        // сумма денег в китайских юанях
        double rubles;   // сумма денег в российских рублях
        
        System.out.println("Write the amount of yuan: ");
        yuan = input.nextInt();
        
        rubles = RUBLES_PER_YUAN * yuan;
        int result = (int)Math.ceil(rubles);
        
        System.out.println("The amount of rubles for " + yuan + " yuan is " + result + " rubles.");
    }
}
