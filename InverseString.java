import java.util.Scanner;

public class InverseString {

    public static void main(String[] args) {
        
        // Leitura da string a ser invertida
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a string a ser invertida: ");
        String original = sc.nextLine();
        sc.close();
        
        // Inversão dos caracteres
        String invertida = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            invertida += original.charAt(i);
        }
        
        // Impressão da string invertida
        System.out.println("String invertida: " + invertida);
    }
}
