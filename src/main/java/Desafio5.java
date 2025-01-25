import java.util.Scanner;

public class Desafio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //entrada da string
        System.out.println("Digite uma palavra para inverter: ");
        String original = scanner.nextLine();

        //inicializa a string invertida como vazia
        String invertida = "";

        //percorre a string original
        for (int i = original.length() - 1; i >= 0; i--) {
            invertida += original.charAt(i);
        }

        //exibe o resultado
        System.out.println("Palavra invertida: " + invertida);

        scanner.close();
    }
}
