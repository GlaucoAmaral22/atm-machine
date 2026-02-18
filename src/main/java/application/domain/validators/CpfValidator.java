package application.domain.validators;

public class CpfValidator {

    private static final int CPF_LENGTH = 11;

    public static boolean isValid(String cpf) {
        if (cpf == null) return false;

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() < CPF_LENGTH) return false;

        int firstDV = calculateDv(cpf.substring(0, 9), 10);

        if ((cpf.charAt(9) - '0') != firstDV) return false;

        int secondDV = calculateDv(cpf.substring(0, 10), 11);

        return (cpf.charAt(10) - '0') == secondDV;
    }

    private static int calculateDv(String cpf, int initialWeight) {
        int sum = 0;

        for (int i = 0; i < cpf.length(); i++) {
            int number = cpf.charAt(i) - '0';
            sum += initialWeight * number;
            initialWeight -= 1;
        }

        int remainder = sum % 11;

        int dv = 11 - remainder;

        return (dv == 10) ? 0 : dv;
    }
}
