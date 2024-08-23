public class SaldoInvalidoException extends Exception {

    // Construtor padrão
    public SaldoInvalidoException(String message) {
        super(message);
    }

    // Construtor que aceita uma causa (outra exceção)
    public SaldoInvalidoException(Throwable cause) {
        super(cause);
    }

    static double formatarSaldo(double saldo) throws SaldoInvalidoException {
        if (saldo < 0) {
            throw new SaldoInvalidoException("Saldo inválido! O saldo não pode ser negativo.");
        }
        return saldo;
    }
    
}
