import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    /**
     * Método principal da aplicação
     * @param args
     * @throws Exception
     * 
     * <p>
     * A classe App é utilizada para representar a aplicação principal
     *   Nela, é possível criar uma conta bancária, depositar e sacar valores
     *  Para isso, é necessário informar o número da conta, o nome do titular, o CPF do titular e o saldo inicial
     * </p>
     * 
     */
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var conta = new ContaBancaria();
        System.out.println("Bem-vindo ao Banco do Brasil \n \n Escollha uma opção: \n 1 - Criar conta \n 2 - Sacar \n 3 - Depositar \n 4 - Sair");
        var opcao = 0;
         do{
             opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                try {
                    System.out.println("Digite o número da conta: ");
                    var numero_conta = scanner.next();
                    System.out.println("Digite o nome do titular: ");
                    var nome_titular = scanner.next();
                    System.out.println("Digite o CPF do titular: ");
                    var cpf_titular = scanner.next();
                    System.out.println("Digite o saldo inicial: ");
                    var saldo = scanner.nextDouble();
                    conta.criar_conta(numero_conta, nome_titular, cpf_titular, saldo);
                } catch (InputMismatchException e) {
                    System.err.println("Erro ao criar conta! Verifique os dados informados.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                }
                break;
                case 2:
                    if(conta.cpf_titular == null){

                        System.out.println("Conta não criada!");
                        break;
                    }else{
                        System.out.println("Digite o valor a ser sacado: ");
                        var valor = scanner.nextDouble();
                        conta.sacar(valor);
                        
                    }
                    break;
                case 3:
                if(conta.cpf_titular == null){
                    System.out.println("Conta não criada!");
                    break;
                }else{
                    System.out.println("Digite o valor a ser depositado: ");
                    var valor = scanner.nextDouble();
                    conta.depositar(valor);
                 
                    break;
                }
                case 4:
                    System.out.println("Saindo...");
                    break;
                    
            }





         }while(opcao != 4);
         scanner.close();
    }
}
