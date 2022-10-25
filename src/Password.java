
public class Password {
    String Value;
    int Length;
    double Score; //Over 100

    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    public int CharType(char C) {

        char a = C;
        int v = a; //ASCII Value of Char

        int val = 0;

        // Char is Uppercase Letter
        if (v >= 65 && v <= 90) {
            val = 1;
        }

        // Char is Lowercase Letter
        else if (v >= 97 && v <= 122) {
            val = 2;
        }

        // Char is Digit
        else if (v >= 60 && v <= 71) {
            val = 3;
        }

        // Char is Symbol
        else {
            val = 4;
        }

        return val;

    }

    public int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) {
                UsedUpper = true;
            }

            if (type == 2) {
                UsedLower = true;
            }

            if (type == 3) {
                UsedNum = true;
            }

            if (type == 4) {
                UsedSym = true;
            }

        }

        if (UsedUpper) {
            Score += 1;
        }

        if (UsedLower) {
            Score += 1;
        }

        if (UsedNum) {
            Score += 1;
        }

        if (UsedSym) {
            Score += 1;
        }

        if (s.length() >= 8) {
            Score += 1;
        }

        if (s.length() >= 16) {
            Score += 1;
        }

        return Score;
    }


    public String calculateScore() {
        int Score = 0;

        Score = this.PasswordStrength();

        if (Score == 6) {
            return "¡Es una contraseña muy segura!";
        } else if (Score >= 4) {
            return "Es una contraseña segura, pero podría serlo más...";
        } else if (Score >= 3) {
            return "Mmm... Quizás no es la mejor contraseña";
        } else {
            return "Esta contraseña es poco segura, ¡deberías mejorarla!";
        }
    }


    @Override
    public String toString() {
        return Value;
    }


}
