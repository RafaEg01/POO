import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nome = new String[3];
        int[] idade = new int[3];

        for (int i = 0; i < 3; i++) {
            nome[i] = scan.next();
            idade[i] = scan.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Nome: " + nome[i] + " - Idade: " + idade[i]);
        }

    }

}