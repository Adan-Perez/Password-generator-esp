public class Alphabet {

    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    public static final String LOWERSPANISH_LETTER = "ñ";
    public static final String UPPERSPANISH_LETTER = "Ñ";

    private StringBuilder pool;


    public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncluded, boolean lowerSpanishIncluded, boolean upperSpanishIncluded) {

        pool = new StringBuilder();

        if (uppercaseIncluded) {
            pool.append(UPPERCASE_LETTERS);
        }

        if (lowercaseIncluded) {
            pool.append(LOWERCASE_LETTERS);
        }

        if (numbersIncluded) {
            pool.append(NUMBERS);
        }

        if (specialCharactersIncluded) {
            pool.append(SYMBOLS);
        }

        if (lowerSpanishIncluded) {
            pool.append(LOWERSPANISH_LETTER);
        }

        if (upperSpanishIncluded) {
            pool.append(UPPERSPANISH_LETTER);
        }

    }

    public String getAlphabet() {
        return pool.toString();
    }

}
