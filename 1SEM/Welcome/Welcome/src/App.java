import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        System.out.println("Informe seu nome de usuário, e sua idade respectivamente: ");
        
        String nome = sc1.nextLine();
        int idade = sc1.nextInt();

        System.out.println("Informe agora seu email: ");
        String email = sc2.nextLine();

    System.out.println("nome: "+ nome + " email: "+email+ " idade: "+idade );

    }
}
