import java.util.Scanner;

public class ex1 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] valores = new int[5];
        float media = 0;
        
	    for (int i = 0; i < 5; i++) {
            System.out.print("Digite um valor inteiro:");
            valores[i] = leitor.nextInt();
            media += valores[i];

        }
        System.out.println("Media = " + media / 5);
    }
}

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