import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;

public class Salvado {

    public static boolean estado = false;
    public static int puntaje = 0;
    public static int acumulacionPuntaje = 0;
    public static int bonus = 0;

    public static void salvado(){

        do {

            try{

                int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion valida:\n\n"
                            + "1. Jugar Salvado\n"
                            + "2. Salir"));

                switch (menu){

                    case 1:

                        nivelBalbuceo();

                    case 2:

                        estado = true;
                        break;

                    default:

                        throw new IllegalArgumentException("Ingrese solo las opciones del menu");
                }

            }catch (InputMismatchException e){

                JOptionPane.showMessageDialog(null,
            "INGRESE UN VALOR VALIDO","ERROR VALOR INVALIDO",JOptionPane.WARNING_MESSAGE);

            }catch (Exception e){

                JOptionPane.showMessageDialog(null,
            "ERROR: " + e.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
            }

        }while (!estado);
    }

    private static void nivelBalbuceo() {

        // Array de palabras para adivinar
        String[] palabras = {
                "casa", "perro", "gato", "mesa", "sol",
                "flor", "pato", "tren", "silla", "leche",
                "arbol", "manzana", "lapiz", "libro", "pelota",
                "juego", "nariz", "ojo", "zapato", "camino",
                "piedra", "puerta", "hoja", "taza", "luz",
                "abeja", "abejorro", "alma", "alma", "cola",
                "cielo", "cama", "arena", "boton", "puente",
                "mar", "lago", "madera", "agua", "mesada",
                "viento", "nieve", "tambor", "tigre", "tijera",
                "tigre", "ventana", "mantequilla", "espejo", "peluca",
                "biblia", "perdon", "esposa", "hija", "ala"
        };

//         Elegir una palabra aleatoria del array
//    String palabra = palabras[(int)(Math.random() * palabras.length)];

//        Otra forma de elegir una palabra aleatoria del array

        Random random = new Random();

        int palabraAleatoria = random.nextInt(palabras.length);

        String palabra = palabras[palabraAleatoria];

        // Crear un array de caracteres para representar la palabra oculta
        char[] palabraOculta = new char[palabra.length()];
        for(int i = 0; i < palabraOculta.length; i++){
            palabraOculta[i] = '*';
        }

        // Contador de intentos restantes, intentos sera igual al doble de letras
        int intentos = palabra.length() * 2;
        while (intentos > 0) {
            // Pedir al usuario que ingrese una letra
            String letraUsuario = JOptionPane.showInputDialog(null,
            "Adivina la palabra: " + new String(palabraOculta) + "\nTienes "
                    + intentos + " intentos restantes.\nIngresa una letra:");

            // Validar que el usuario haya ingresado solo una letra
            if (letraUsuario.length() != 1) {
                JOptionPane.showMessageDialog(null, "Ingresa una sola letra.");
                continue; // Saltar al siguiente ciclo
            }

            // Obtener la letra ingresada por el usuario
            char letra = letraUsuario.charAt(0);
            boolean letraEncontrada = false;

            // Verificar si la letra está en la palabra y actualizar la palabra oculta
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraOculta[i] = letra;
                    letraEncontrada = true;
                }
            }

            // Decrementar el contador de intentos si la letra no se encontró en la palabra
            if (!letraEncontrada) {
                intentos--;
                JOptionPane.showMessageDialog(null, "Letra incorrecta. Intenta de nuevo.");
            } else if (new String(palabraOculta).equals(palabra)) {
                // Mostrar mensaje de victoria si el usuario adivinó la palabra
                JOptionPane.showMessageDialog(null,
                        "¡Felicidades! Has adivinado la palabra: " + palabra);

                //puntuacion de acuerdo al numero de intentos
                if(intentos == 1){


                }

                break; // Salir del bucle while
            }
        }

        // Mostrar mensaje de derrota si el usuario se quedó sin intentos
        if (intentos == 0) {
            JOptionPane.showMessageDialog(
                    null, "¡Oh no! Te has quedado sin intentos. La palabra era: " + palabra);
        }
    }
    }


