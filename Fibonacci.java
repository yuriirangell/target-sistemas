import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int num, a = 0, b = 1, c = 0;
        boolean pertence = false;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número para verificar se pertence à sequência de Fibonacci: ");
        num = input.nextInt();

        if (num == 0) {
            System.out.println("O número " + num + " pertence à sequência de Fibonacci.");
            return;
        }

        while (c < num) {
            c = a + b;
            a = b;
            b = c;

            if (c == num) {
                pertence = true;
                break;
            }
        }

        if (pertence) {
            System.out.println("O número " + num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + num + " não pertence à sequência de Fibonacci.");
        }
    }
}