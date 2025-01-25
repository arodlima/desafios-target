import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //solicitar o número ao usuário
        System.out.println("Digite um número para verificar se pertence à sequência de Fibonacci: ");
        int number= scanner.nextInt();

        if (belongFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
        }
        scanner.close();
    }

    // método para verificar se um número pertence à sequência de Fibonacci
    public static boolean belongFibonacci(int number) {
        int a = 0, b = 1;

        while (a <= number) {
            if (a == number) {
                return true; //o número pertence
            }
            // atualiza os valores de Fibonacci
            int next = a + b;
            a = b;
            b = next;
        }
        return false; //o número não pertence
    }
}
