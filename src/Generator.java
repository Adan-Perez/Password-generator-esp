import java.util.Scanner;
// Compruebe que está usando el File Encoding necesario para poder visualizar los caracteres como "Ñ" en consola

public class Generator {

    Alphabet alphabet;

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym, boolean IncludeUpperSpa, boolean IncludeLowerSpa) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym, IncludeUpperSpa, IncludeLowerSpa);
    }

    public Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder();

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;


        for (int i = 0; i < length; i++) {

            int index = (int) (Math.random() * range) + min;

            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());

    }

    public static void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;
        boolean IncludeUpperSpa = false;
        boolean IncludeLowerSpa = false;
        String input;
        final Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Para generar la contraseña aleatoria debes responder con Si o No \n");

        while (true) {
            System.out.println("¿Desea usar Minúsculas \"abcd...\" ? ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("si")) {
                IncludeLower = true;
            } else {
                if (!input.equals("no")) {
                    PasswordRequestError();
                    break;
                }
            }

            System.out.println("¿Desea usar Mayúsculas \"ABCD...\" ? ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("si")) {
                IncludeUpper = true;
            } else {
                if (!input.equals("no")) {
                    PasswordRequestError();
                    break;
                }
            }

            System.out.println("¿Desea usar números \"0123...\" ? ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("si")) {
                IncludeNum = true;
            } else {
                if (!input.equals("no")) {
                    PasswordRequestError();
                    break;
                }
            }

            System.out.println("¿Desea usar Símbolos \"!@#$...\" ? ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("si")) {
                IncludeSym = true;
            } else {
                if (!input.equals("no")) {
                    PasswordRequestError();
                    break;
                }
            }


            System.out.println("¿Desea utilizar el carácter minúscula \"ñ\" ? ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("si")) {
                IncludeLowerSpa = true;
            } else {
                if (!input.equals("no")) {
                    PasswordRequestError();
                    break;
                }
            }

            System.out.println("¿Desea utilizar el carácter mayúscula \"Ñ\" ? ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("si")) {
                IncludeUpperSpa = true;
            } else {
                if (!input.equals("no")) {
                    PasswordRequestError();
                    break;
                }
            }

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym && !IncludeLowerSpa && !IncludeUpperSpa) {
                System.out.println("No has seleccionado ningún carácter para la contraseña");
                break;
            }

            System.out.println("¡Perfecto! Introduce la longitud de la contraseña: ");
            int length = sc.nextInt();

            final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym, IncludeUpperSpa, IncludeLowerSpa);


            final Password UserPass = generator.GeneratePassword(length);

            System.out.println("Tu contraseña es: " + UserPass);

            sc.close();
            break;
        }
    }

    public static void PasswordRequestError() {
        System.out.println("¡Has puesto algo mal! Inténtalo de nuevo \n");
    }

    public static void checkPassword() {
        String input;
        final Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduce tu contraseña para validar:");
        input = sc.nextLine();

        final Password password = new Password(input);

        System.out.println(password.calculateScore());

        sc.close();
    }

    public static void printUsefulInfo() {
        System.out.println();
        System.out.println("Use mínimo 8 caracteres o más si se permite.");
        System.out.println("Incluya mayúsculas, minúsculas, símbolos, números si se permite.");
        System.out.println("Genere contraseñas aleatorias donde sea factible.");
        System.out.println("Evite utilizar la misma contraseña en diferentes cuentas.");
        System.out.println("Evite la repetición de caracteres, patrones de teclado, palabras de diccionario, secuencias de letras o números, nombres de usuario, nombres de familiares o mascotas, e información biográfica (por ejemplo: números de identificación, nombres o fechas).");
        System.out.println("Evite usar información que los amigos y/o conocidos del usuario puedan saber que está asociada con el usuario.");
        System.out.println("No utilice contraseñas que consistan en su totalidad en cualquier combinación simple de los componentes débiles antes mencionados.");
        System.out.println("Espero que esta información sea de utilidad :)");
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("Pulsa 1 - Generador de contraseña");
        System.out.println("Pulsa 2 - Validación de contraseña");
        System.out.println("Pulsa 3 - Información útil");
        System.out.println("Pulsa 4 - Salir");
        System.out.print("Selecciona: ");
    }

    public static void main(String[] args) {
        String input;
        final Scanner sc = new Scanner(System.in);
        System.out.println("||========== Bienvenido/a al Generador de Contraseñas! ==========||");
        printMenu();
        label:
        while (sc.hasNextLine()) {

            input = sc.nextLine();

            switch (input) {
                case "1":
                    requestPassword();
                    break;
                case "2":
                    checkPassword();
                    break;
                case "3":
                    printUsefulInfo();
                    printMenu();
                    break;
                case "4":
                    System.out.println("Cerrando programa...");
                    break label;
                default:
                    System.out.println("Por favor, selecciona otra opción.");
                    printMenu();
                    break;
            }
        }
        sc.close();
    }


}
