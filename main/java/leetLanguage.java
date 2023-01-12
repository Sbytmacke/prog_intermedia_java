import java.util.Scanner;

public class leetLanguage {
    public static void main(String[] args) {

        // String miCadena = String.valueOf(miCaracter);//char to string
        System.out.println("Introduce el texto a traducir en LEET (1337):");
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        StringBuilder textoFinalLEET = new StringBuilder();

        String letrasConvirteLEET = "LREASbTBgo";
        String alfabetoLEET = "1234567890";

        for (int i = 0; i < entrada.length(); i++) {
            if (verificarPosibleConversion(entrada, i)) {
                // En caso de que se pueda convertir
                for (int j = 0; j < letrasConvirteLEET.length(); j++) {
                    if (entrada.charAt(i) == letrasConvirteLEET.charAt(j)) {
                        textoFinalLEET.append(alfabetoLEET.charAt(j));
                        break;
                    }
                }
            } else {
                // En caso de no posible conversión asignamos la letra normal
                textoFinalLEET.append(entrada.charAt(i));
            }
        }
        textoFinalLEET.toString();
        System.out.println("Tu código LEET (1337) es: " + textoFinalLEET);
    }

    public static Boolean verificarPosibleConversion(String palabraParaConvertir, int indiceLetra) {
        String letrasConvirteLEET = "LREASbTBgo";

        for (int i = 0; i < letrasConvirteLEET.length(); i++) {
            if (palabraParaConvertir.charAt(indiceLetra) == letrasConvirteLEET.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}


