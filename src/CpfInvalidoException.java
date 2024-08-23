public class CpfInvalidoException extends Exception {

    // Construtor padrão
    public CpfInvalidoException(String message) {
        super(message);
    }

    // Construtor que aceita uma causa (outra exceção)
    public CpfInvalidoException(Throwable cause) {
        super(cause);
    }

    static String formatarCPF(String cpf) throws CpfInvalidoException {
        if (cpf.length() != 11) {
            throw new CpfInvalidoException("CPF inválido! O CPF deve conter 11 dígitos.");
        }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

}
