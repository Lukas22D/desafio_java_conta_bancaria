/**
 *  <h1>Conta Bancária</h1>
 *
 * <p>
 * A classe ContaBancaria é utilizada para representar uma conta bancária
 * Para isso, ela possui os seguintes atributos:
 * <ul>
 * <li>@param numero_conta: inteiro que representa o número da conta</li>
 * <li>@param nome_titular: string que representa o nome do titular da conta</li>
 * <li>@param cpf_titular: string que representa o CPF do titular da conta</li>
 * <li>@param saldo: double que representa o saldo da conta</li>
 * </ul>
 * </p>
 */

public class ContaBancaria {
    public String numero_conta;
    public String nome_titular;
    public String cpf_titular;
    public double saldo;

    /**
     * Construtor da classe ContaBancaria
     * Inicializa os atributos da classe com valores padrão
     */
    public ContaBancaria() {
        this.numero_conta = null;
        this.nome_titular = null;
        this.cpf_titular = null;
        this.saldo = 0;
    }
    /**
     * Método que cria uma conta bancária
     * @param numero_conta
     * @param nome_titular
     * @param cpf_titular
     * @param saldo
     */

    public void criar_conta(String numero_conta, String nome_titular, String cpf_titular, double saldo) {
        this.numero_conta = numero_conta;
        this.nome_titular = nome_titular;
        this.cpf_titular = cpf_titular;
        this.saldo = saldo;
    }

    /**
     * Método que realiza um depósito na conta bancária
     * 
     * @param valor: double que representa o valor a ser depositado
     */
    public void depositar(double valor) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso! Novo saldo: " + this.saldo);
        
    }

    public double validator_saldo(double saldo_atual, double saida) throws SaldoInvalidoException {
        if ((saldo_atual - saida) < 0) {
            throw new SaldoInvalidoException("Saldo inválido! O saldo não pode ser negativo.");
        }
        return (saldo_atual - saida);
    }

    /**
     * Método que realiza um saque na conta bancária
     * 
     * @param valor: double que representa o valor a ser sacado
     */
    public void sacar(double valor) {
        try{
            this.saldo = validator_saldo(this.saldo, valor);
            System.out.println("Saque realizado com sucesso! Novo saldo: " + this.saldo);
        }catch(SaldoInvalidoException e){
            System.err.println(e.getMessage());
        }
    }



}
