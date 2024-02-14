import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;

public class AdivinarNumero {

    public static boolean estadoAdivinarNumero = false;

    public static int puntaje = 0;

    public static void adivinarNumero() {


        do {
            try {

                StringBuilder mensaje;

                mensaje = new StringBuilder("  ");

                nivelPollito();

            }catch (InputMismatchException e){

                JOptionPane.showMessageDialog(
                        null, "ERROR, Ingrese una opcion valida", "ERROR",JOptionPane.WARNING_MESSAGE);

            }catch (Exception e){

                JOptionPane.showMessageDialog(null,"ERROR: "+ e.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
            }

        }while(!estadoAdivinarNumero);

}

        public static void nivelPollito() {


            Random random = new Random();
            int numeroUsuario = 0;
            int numAleatorio;
            int intentos = 1;
            int intentosExagerados = 0;
            StringBuilder mensaje;
            boolean estadoIntentos = false;
            int nivelJugador = 0;


            numAleatorio = random.nextInt(10) + 1;

            mensaje = new StringBuilder("NIVEL FACIL\n");

            mensaje.append("Adivina un numero del 1 al 10\n\n");

            inicio:
            while (!estadoIntentos){

                intentosExagerados++;

                intentos = Integer.parseInt(JOptionPane.showInputDialog(
                        mensaje.append("\n¿CUantos intentos necesitas?\n")));

                if (intentos <= 0){

                    JOptionPane.showMessageDialog(null,mensaje.append("El numero debe ser mayor a cero"));
                }

                if (intentosExagerados >= 3 && intentos > 4){
                    JOptionPane.showMessageDialog(
                            null,mensaje.append("\nEl maximo de intentos es 4\n"));
                }

                if(intentos > 3 && intentosExagerados < 3){
                    JOptionPane.showMessageDialog(
                            null,mensaje.append("\nUiichhh no, muchos\n\n"));
                    continue inicio;
                }
                if (intentos <= 4 && intentos != 0){
                    estadoIntentos = true;
                }

            }

            mensaje = new StringBuilder("Haz dicho: " + intentos + " intentos\n" );

            for (int i = 0 ; i < intentos ; ++i ){

                numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                        mensaje.append("¿cual es el numero?\n")));
                mensaje.append(numeroUsuario).append("\n");

                nivelJugador++;


                if (numeroUsuario == numAleatorio){
                    JOptionPane.showMessageDialog(
        null,mensaje.append("\n¡¡¡FELICITACIONES!!! haz adivinado el numero\n"
                         + "El numero era: " + numAleatorio ));

                    if (nivelJugador == 1){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nOhhhh lo lograste a la primera, nivel de jugador: PROFETA\n"));
                        puntaje = 1000;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador < 4){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nPor lo menos no gastaste todos los intentos, nivel del jugador: SUERTUDO\n"));
                        puntaje = 500;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador == 4){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nQue de buenas, nivel del jugador: AREPERO\n"));

                        puntaje = 300;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }

                    JOptionPane.showMessageDialog(null,mensaje.append("tu puntaje es: " + puntaje));

                    nivelPollo();
                }
            }

            if (numAleatorio != numeroUsuario){
                JOptionPane.showMessageDialog(
                        null,mensaje.append("\nHaz perdido el juego, el numero era: "+ numAleatorio));
            }

            JOptionPane.showMessageDialog(
                    null,mensaje.append("\nJuego terminado, hasta la proxima!!!\n"));
        }
        public static void nivelPollo(){

            Random random = new Random();
            int numeroUsuario = 0;
            int numAleatorio;
            int intentos = 1;
            int intentosExagerados = 0;
            StringBuilder mensaje;
            boolean estadoIntentos = false;

            int nivelJugador = 0;

            mensaje = new StringBuilder("NIVEL NORMAL\n");

            numAleatorio = random.nextInt(20) + 1;

            mensaje.append("Adivina un numero del 1 al 20\n\n");

            inicio:
            while (!estadoIntentos){
                intentosExagerados++;

                intentos = Integer.parseInt(JOptionPane.showInputDialog(
                        mensaje.append("¿CUantos intentos necesitas?\n")));

                if (intentos <= 0){

                    JOptionPane.showMessageDialog(null,mensaje.append("El numero debe ser mayor a cero"));
                }

                if (intentosExagerados >= 3 && intentos > 7){
                    JOptionPane.showMessageDialog(
                            null,mensaje.append("\nEl maximo de intentos es 7\n"));
                }

                if(intentos > 7 && intentosExagerados < 3){
                    JOptionPane.showMessageDialog(
                            null,mensaje.append("\nUiichhh no, muchos\n\n"));
                    continue inicio;
                }
                if (intentos <= 7 && intentos != 0){
                    estadoIntentos = true;
                }
            }

            mensaje.append("Haz dicho: " + intentos + " intentos\n" );

            for (int i = 0 ; i < intentos ; ++i ){

                numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                        mensaje.append("¿cual es el numero?\n")));
                mensaje.append(numeroUsuario).append("\n");

                nivelJugador++;

                if (numeroUsuario == numAleatorio){
                    JOptionPane.showMessageDialog
                            (null,mensaje.append
                                    ("\n¡¡¡FELICITACIONES!!! haz adivinado el numero\n"
                                            + "El numero era: " + numAleatorio));

                    if (nivelJugador == 1){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nIncreible lo lograste a la rapido, nivel de jugador: APOSTOL\n"));
                        puntaje = 2000;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador < 7){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nPor lo menos no gastaste todos los intentos, nivel del jugador: AREPERO II\n"));
                        puntaje = 1000;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador == 7){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nQue de buenas, nivel del jugador: BERRIONDO\n"));

                        puntaje = 500;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    nivelGallo();
                }

            }

            if (numAleatorio != numeroUsuario){
                JOptionPane.showMessageDialog(
    null,mensaje.append("\nHaz perdido el juego, el numero era: "+ numAleatorio));
            }

            JOptionPane.showMessageDialog(
                    null,mensaje.append("\nJuego terminado, hasta la proxima!!!\n"));

        }

        public static void nivelGallo(){

            Random random = new Random();
            int numeroUsuario = 0;
            int numAleatorio;
            int intentos = 1;
            int intentosExagerados = 0;
            StringBuilder mensaje;
            boolean estadoIntentos = false;
            int nivelJugador = 0;

            mensaje = new StringBuilder("NIVEL DIFICIL\n");

            numAleatorio = random.nextInt(30) + 1;

            mensaje.append("Adivina un numero del 1 al 30\n\n");

            inicio:
            while (!estadoIntentos){
                intentosExagerados++;

                intentos = Integer.parseInt(JOptionPane.showInputDialog(
                        mensaje.append("¿CUantos intentos necesitas?\n")));

                if (intentos <= 0){

                    JOptionPane.showMessageDialog(null,mensaje.append("El numero debe ser mayor a cero"));
                }

                if (intentosExagerados >= 3 && intentos > 10){
                    JOptionPane.showMessageDialog(
                            null,mensaje.append("\nEl maximo de intentos es 10\n"));
                }

                if(intentos > 10 && intentosExagerados < 3){
                    JOptionPane.showMessageDialog(
                            null,mensaje.append("\nUiichhh no, muchos\n\n"));
                    continue inicio;
                }
                if (intentos <= 10 && intentos != 0){
                    estadoIntentos = true;
                }
            }

            mensaje.append("Haz dicho: " + intentos + " intentos\n" );

            for (int i = 0 ; i < intentos ; ++i ){

                nivelJugador++;

                numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                        mensaje.append("¿cual es el numero?\n")));
                mensaje.append(numeroUsuario).append("\n");

                if (numeroUsuario == numAleatorio){
                    JOptionPane.showMessageDialog
                            (null,mensaje.append
                                    ("\n¡¡¡FELICITACIONES!!! haz adivinado el numero\n"
                                            + "El numero era: " + numAleatorio));

                    if (nivelJugador == 1){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("Ohhhh lo lograste a la primera, nivel de jugador: GLORIFICADO"));

                        puntaje = 3000;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador < 10){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("Por lo menos no gastaste todos los intentos, nivel del jugador: BUEN@N"));
                        puntaje = 1000;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador == 10){

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("Que de buenas, nivel del jugador: AREPERO MAXIMO"));

                        puntaje = 800;

                        JOptionPane.showMessageDialog(null,mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (puntaje < 6000){

                        JOptionPane.showMessageDialog(
            null,mensaje.append("\nDebes repetir el juego, tu puntaje no alcanza para rescatarlo\n"));
                        nivelGallo();
                    }
                    if (puntaje >= 6000){

                        JOptionPane.showMessageDialog(null,"\nHAZ RESCATADO EL JUEGO\n"+
                                "( ͡° ͜ʖ ͡°)");


                    }
                }
            }

            if (numAleatorio != numeroUsuario){
                JOptionPane.showMessageDialog(
                        null,mensaje.append("\nHaz perdido el juego, el numero era: "+ numAleatorio));
            }
            JOptionPane.showMessageDialog(
                    null,mensaje.append("\nJuego terminado, hasta la proxima!!!\n"));

            estadoAdivinarNumero = true;
        }


}





