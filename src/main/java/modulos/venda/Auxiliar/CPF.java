package modulos.venda.Auxiliar;

public class CPF {
    public static String formatarCPF(String cpf) {

        cpf = cpf.replaceAll("[^\\d]", "");


        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public static boolean validarCPF(String cpf) {
        return cpf.matches("^\\d{11}$");
    }
}
