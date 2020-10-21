import java.util.Scanner;

public class Scanners {

    // SCANNERS FOR INPUTS
    public static void InputCheck() {

        String str;
        int intgr = 0;
        float flt = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string");
        str = in.nextLine();
        System.out.println("You Entered string " + str);

        System.out.println("Enter a integer");
        intgr = in.nextInt();
        System.out.println("You Entered integer " + intgr);

        System.out.println("Enter a decimal");
        flt = in.nextFloat();
        System.out.println("You Entered float " + flt);

        in.close();
    }

    // Validate input number
    // If the entry is not a number the entry will be requested again
    public static void validateInputIsNumber() {

        Scanner input = new Scanner(System.in); // Crear objecto Scanner
        int number = 0;

        boolean isNumber = false;

        do {
            System.out.print("Enter data: ");

            // Validar que sea un numero. 'has' devuelve true o false
            isNumber = input.hasNextInt();

            if (isNumber) { // if(isNumber) == if(isNumber == true)
                number = input.nextInt();
            } else {
                System.out.print("Your input is not a number, try again.\n");
                input.next(); // Limpiar el valor de "input" para que el loop no siga
                              // corrienda.                 
            }
        } while (!(isNumber)); // Si isNumber no es true sigue corriendo.

        System.out.println("Your number is " + number);
        input.close();// Cerrar el objeto input
    }

}