import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;

public class AdivinarNumero {

    public static boolean estadoAdivinarNumero = false;

    public static int puntaje = 0;

    public static int bonus = 0;
    public static int acumulacionPuntaje = 0;

    public static void adivinarNumero() {


        do {
            try {

                int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desee:\n\n"
                        + "1. JUgar Adivina el Numero\n"
                        + "2. Salir"));

                switch (menu){

                    case 1:

                        nivelHuevo();
                        break;

                    case 2:

                        estadoAdivinarNumero = true;
                        break;

                    default:

                        throw new IllegalArgumentException("Ingrese SOLO los numeros que estan en el menu");
                }

            } catch (InputMismatchException e) {

                JOptionPane.showMessageDialog(
                        null, "ERROR, Ingrese una opcion valida", "ERROR", JOptionPane.WARNING_MESSAGE);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
            }

        } while (!estadoAdivinarNumero);

    }
    public static void nivelHuevo() {


        Random random = new Random();
        int numeroUsuario = 0;
        int numAleatorio;
        int intentos = 1;
        int intentosExagerados = 0;
        StringBuilder mensaje;
        boolean estadoIntentos = false;
        int nivelJugador = 0;


        numAleatorio = random.nextInt(10) + 1;

        mensaje = new StringBuilder("NIVEL HUEVO\n");

        mensaje.append("Adivina un numero del 1 al 10\n\n");

        inicio:
        while (!estadoIntentos) {

            intentosExagerados++;

            intentos = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.append("\n¿CUantos intentos necesitas? Si eliges un intento ganaras muchos puntos\n")));

            if (intentos <= 0) {

                JOptionPane.showMessageDialog(null, mensaje.append("El numero debe ser mayor a cero"));
            }

            if (intentosExagerados >= 3 && intentos > 5) {
                JOptionPane.showMessageDialog(
                        null, mensaje.append("\nEl maximo de intentos es 5\n"));
            }

            if (intentos > 5 && intentosExagerados < 3) {
                JOptionPane.showMessageDialog(
                        null, mensaje.append("\nUiichhh no, muchos\n\n"));
                continue inicio;
            }
            if (intentos <= 5 && intentos != 0) {
                estadoIntentos = true;
            }

        }

        mensaje = new StringBuilder("NIVEL HUEVO\n");
        mensaje.append("Adivina un numero del 1 al 10\n");
        mensaje.append("Haz dicho: " + intentos + " intentos\n");
        mensaje.append(" (っ◕‿◕)っ\n");



        for (int i = 0; i < intentos; ++i) {

            numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.append("¿cual es el numero?")));
            mensaje.append(" " + numeroUsuario).append("\n");

            if (numeroUsuario > 0 && numeroUsuario <= 10) {

                nivelJugador++;

                if (numeroUsuario != numAleatorio) {
                    JOptionPane.showMessageDialog(null, mensaje.append("\nNo es el numero jajaja\n"));
                }

                if (numeroUsuario == numAleatorio) {
                    JOptionPane.showMessageDialog(
                            null, mensaje.append("\n¡¡¡FELICITACIONES!!! haz adivinado el numero\n"
                                    + "El numero era: " + numAleatorio));

                    if (intentos == 1){

                        bonus = 1000;

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nComo adivinaste eligiendo 1 intento ganas 1000 puntos adicionales\n"));
                    }

                    if (nivelJugador == 1) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nOhhhh lo lograste a la primera, nivel de jugador: PROFETA\n"));
                        puntaje += 1000;

                        JOptionPane.showMessageDialog(null, mensaje.append("Su puntaje en este nivel es: " + puntaje));
                    }
                    if (nivelJugador > 1 && nivelJugador < 5) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nPor lo menos no gastaste todos los intentos, nivel del jugador: SUERTUDO\n"));
                        puntaje += 500;

                        JOptionPane.showMessageDialog(null, mensaje.append("Su puntaje en este nivel es: " + puntaje));
                    }
                    if (nivelJugador == 5) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nQue de buenas, nivel del jugador: AREPERO\n"));

                        puntaje += 300;

                        JOptionPane.showMessageDialog(null, mensaje.append("\nSu puntaje en este nivel es: " + puntaje + "\n"));
                        JOptionPane.showMessageDialog(null,mensaje.append("Bonus por 1 intento\n: " + bonus));
                    }

                    acumulacionPuntaje = puntaje + bonus;
                    JOptionPane.showMessageDialog(null, mensaje.append("\nPUNTAJE ACUMULADO: " + acumulacionPuntaje));

                    nivelPollo();
                    return;
                }

            } else {

                JOptionPane.showMessageDialog(
    null, "Ingrese un numero entre 1 y 10, igual cuenta como intento " +
                                "por no estar concentrad@", "CONCENTRATE!!!",JOptionPane.WARNING_MESSAGE);

            }

        }

        if (numAleatorio != numeroUsuario) {
            JOptionPane.showMessageDialog(
                    null, mensaje.append("\nHaz perdido el juego, el numero era: " + numAleatorio));

            JOptionPane.showMessageDialog(
                    null, mensaje.append("\nJuego terminado, hasta la proxima!!!\n"));
            nivelHuevo();
        }
    }

    public static void nivelPollo() {

        Random random = new Random();
        int numeroUsuario = 0;
        int numAleatorio;
        int intentos = 1;
        int intentosExagerados = 0;
        StringBuilder mensaje;
        boolean estadoIntentos = false;

        int nivelJugador = 0;

        mensaje = new StringBuilder("NIVEL POLLO\n");

        numAleatorio = random.nextInt(20) + 1;

        mensaje.append("Adivina un numero del 1 al 20\n\n");

        inicio:
        while (!estadoIntentos) {
            intentosExagerados++;

            intentos = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.append("¿CUantos intentos necesitas? Si eliges 1 ganaras muchisimos puntos guer@\n")));

            if (intentos <= 0) {

                JOptionPane.showMessageDialog(null, mensaje.append("El numero debe ser mayor a cero"));
            }

            if (intentosExagerados >= 3 && intentos > 10) {
                JOptionPane.showMessageDialog(
                        null, mensaje.append("\nEl maximo de intentos es 10\n"));
            }

            if (intentos > 10 && intentosExagerados < 3) {
                JOptionPane.showMessageDialog(
                        null, mensaje.append("\nUiichhh no, muchos\n\n"));
                continue inicio;
            }
            if (intentos <= 10 && intentos != 0) {
                estadoIntentos = true;
            }
        }

        mensaje = new StringBuilder("NIVEL POLLO\n");
        mensaje.append("Adivina un numero del 1 al 20\n");
        mensaje.append("Haz dicho: " + intentos + " intentos\n");
        mensaje.append("Puntaje acumulado: " + acumulacionPuntaje);
        mensaje.append("╰（￣▽￣）\n");

        for (int i = 0; i < intentos; ++i) {

//            //limpiador de pantalla luego de 4 intentos
//            if (i > 4){
//
//                mensaje = new StringBuilder("Haz dicho: " + intentos + " intentos\n");
//
//            }

            numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.append("¿cual es el numero?")));
            mensaje.append(" " + numeroUsuario).append("\n");

            if (numeroUsuario > 0 && numeroUsuario <= 20) {

                nivelJugador++;

                if (numeroUsuario != numAleatorio) {
                    JOptionPane.showMessageDialog(null, mensaje.append("\nNo es el numero jajaja\n"));
                }

                if (numeroUsuario == numAleatorio) {
                    JOptionPane.showMessageDialog(
                            null, mensaje.append("\n¡¡¡FELICITACIONES!!! haz adivinado el numero\n"
                                    + "El numero era: " + numAleatorio));


                    if (intentos == 1){

                        bonus += 3000;

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nComo adivinaste con 1 intento ganas 3000 puntos adicionales\n"));
                    }

                    if (nivelJugador == 1) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nOhhhh lo lograste a la primera, nivel de jugador: APOSTOL\n"));
                        puntaje += 3000;

                        JOptionPane.showMessageDialog(null, mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador > 1 && nivelJugador < 7) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nPor lo menos no gastaste todos los intentos, nivel del jugador: BUENIN\n"));
                        puntaje += 1000;

                        JOptionPane.showMessageDialog(null, mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador == 7) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nQue de buenas, nivel del jugador: AREPERO NIVEL II\n"));

                        puntaje += 500;

                        JOptionPane.showMessageDialog(null, mensaje.append("\nSu puntaje en este nivel es: " + puntaje + "\n"));
                        JOptionPane.showMessageDialog(null,mensaje.append("Bonus por 1 intento\n: " + bonus));
                    }

                    acumulacionPuntaje = puntaje + bonus;
                    JOptionPane.showMessageDialog(null, mensaje.append("\nPUNTAJE ACUMULADO: " + acumulacionPuntaje));

                    nivelGallo();
                    return;
                }

            } else {

                JOptionPane.showMessageDialog(
                        null, "Ingrese un numero entre 1 y 20, igual cuenta como intento " +
                                "por no estar concentrad@", "CONCENTRATE!!!",JOptionPane.WARNING_MESSAGE);
            }

        }

        if (numAleatorio != numeroUsuario) {
            JOptionPane.showMessageDialog(
                    null, mensaje.append("\nHaz perdido el juego, el numero era: " + numAleatorio));

            JOptionPane.showMessageDialog(
                    null, mensaje.append("\nJuego terminado, hasta la proxima!!!\n"));
            nivelHuevo();
        }
    }

    public static void nivelGallo() {

        Random random = new Random();
        int numeroUsuario = 0;
        int numAleatorio;
        int intentos = 1;
        int intentosExagerados = 0;
        StringBuilder mensaje;
        boolean estadoIntentos = false;
        int nivelJugador = 0;

        mensaje = new StringBuilder("NIVEL GALLO\n");

        numAleatorio = random.nextInt(30) + 1;

        mensaje.append("Adivina un numero del 1 al 30\n\n");

        inicio:
        while (!estadoIntentos) {
            intentosExagerados++;

            intentos = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.append("\n¿CUantos intentos necesitas? Si eliges 1 puedes ganar REGERO de puntos\n")));

            if (intentos <= 0) {

                JOptionPane.showMessageDialog(null, mensaje.append("El numero debe ser mayor a cero"));
            }

            if (intentosExagerados >= 3 && intentos > 12) {
                JOptionPane.showMessageDialog(
                        null, mensaje.append("\nEl maximo de intentos es 12\n"));
            }

            if (intentos > 12 && intentosExagerados < 3) {
                JOptionPane.showMessageDialog(
                        null, mensaje.append("\nUiichhh no, muchos\n\n"));
                continue inicio;
            }
            if (intentos <= 12 && intentos != 0) {
                estadoIntentos = true;
            }
        }

        mensaje = new StringBuilder("NIVEL GALLO\n");
        mensaje.append("Adivina un numero del 1 al 30\n");
        mensaje.append("Haz dicho: " + intentos + " intentos\n");
        mensaje.append("Puntaje acumulado: " + acumulacionPuntaje);
        mensaje.append("\\(”▔□▔)/\\(”▔□▔)/\\(”▔□▔)/\n");

        for (int i = 0; i < intentos; ++i) {

            //limpiador de pantalla luego de 4 intentos
//            if (i > 4){
//
//                mensaje = new StringBuilder("Haz dicho: " + intentos + " intentos\n");
//
//            }
            numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.append("¿cual es el numero?")));
            mensaje.append(" " + numeroUsuario).append("\n");


            if (numeroUsuario > 0 && numeroUsuario <= 30) {

                nivelJugador++;

                if (numeroUsuario != numAleatorio) {
                    JOptionPane.showMessageDialog(null, mensaje.append("No es el numero jajaja"));
                }

                if (numeroUsuario == numAleatorio) {
                    JOptionPane.showMessageDialog(
                            null, mensaje.append("\n¡¡¡FELICITACIONES!!! haz adivinado el numero\n"
                                    + "El numero era: " + numAleatorio));

                    if (intentos == 1){

                        puntaje += 5000;

                        JOptionPane.showMessageDialog(
                                null,mensaje.append("\nComo adivinaste a la primera ganas 5000 puntos adicionales\n"));
                    }

                    if (nivelJugador == 1) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nOhhhh lo lograste a la primera, nivel de jugador: GLORIFICADO\n"));
                        puntaje += 5000;

                        JOptionPane.showMessageDialog(null, mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador > 1 && nivelJugador < 10) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nPor lo menos no gastaste todos los intentos, nivel del jugador: PROTEGIDO\n"));
                        puntaje += 2000;

                        JOptionPane.showMessageDialog(null, mensaje.append("Su puntaje es: " + puntaje));
                    }
                    if (nivelJugador == 10) {

                        JOptionPane.showMessageDialog(
                                null, mensaje.append("\nQue de buenas, nivel del jugador: AREPERO NIVEL III\n"));

                        puntaje += 1000;

                        JOptionPane.showMessageDialog(null, mensaje.append("\nSu puntaje es: " + puntaje + "\n"));
                    }

                    JOptionPane.showMessageDialog(null, mensaje.append("\nSu puntaje en este nivel es: " + puntaje + "\n"));
                    JOptionPane.showMessageDialog(null,mensaje.append("Bonus por 1 intento\n: " + bonus));


                acumulacionPuntaje = puntaje + bonus;
                JOptionPane.showMessageDialog(null, mensaje.append("\nPUNTAJE ACUMULADO: " + acumulacionPuntaje));

                JOptionPane.showMessageDialog(null,mensaje = new StringBuilder("\nHAS RESCATADO EL JUEGO\n"


                    + "     .\".\".\".                            \n" +
                            "         (`       `)               _.-=-.     \n" +
                            "          '._.--.-;             .-`  -'  '.   \n" +
                            "         .-'`.o )  \\           /  .-_.--'  `\\ \n" +
                            "        `;---) \\    ;         /  / ;' _-_.-' `\n" +
                            "          `;\"`  ;    \\        ; .  .'   _-' \\ \n" +
                            "           (    )    |        |  / .-.-'    -`\n" +
                            "            '-.-'     \\       | .' ` '.-'-\\`  \n" +
                            "             /_./\\_.|\\_\\      ;  ' .'-'.-.    \n" +
                            "             /         '-._    \\` /  _;-,     \n" +
                            "            |         .-=-.;-._ \\  -'-,       \n" +
                            "            \\        /      `\";`-`,-\"`)       \n" +
                            "             \\       \\     '-- `\\.\\           \n" +
                            "              '.      '._ '-- '--'/           \n" +
                            "                `-._     `'----'`;            \n" +
                            "                    `\"\"\"--.____,/             \n" +
                            "                           \\\\  \\              \n" +
                            "                           // /`              \n" +
                            "                       ___// /__              \n" +
                            "             FAM     (`(`(---\"-`)             "));

                    if(acumulacionPuntaje >= 9000){
                        JOptionPane.showMessageDialog(
            null,"OHHH! ALCANZASTE UN PUNTAJE MUY ALTO EN EL JUEGO, puedes ver la figura secreta:\n"
                        + "                                 /T /I                     \n" +
                                        "                                   / |/ | .-~/                \n" +
                                        "                               T\\ Y  I  |/  /  _              \n" +
                                        "              /T               | \\I  |  I  Y.-~/              \n" +
                                        "             I l   /I       T\\ |  |  l  |  T  /               \n" +
                                        "          T\\ |  \\ Y l  /T   | \\I  l   \\ `  l Y                \n" +
                                        "      __  | \\l   \\l  \\I l __l  l   \\   `  _. |                \n" +
                                        "      \\ ~-l  `\\   `\\  \\  \\\\ ~\\  \\   `. .-~   |                \n" +
                                        "       \\   ~-. \"-.  `  \\  ^._ ^. \"-.  /  \\   |                \n" +
                                        "     .--~-._  ~-  `  _  ~-_.-\"-.\" ._ /._ .\" ./                \n" +
                                        "      >--.  ~-.   ._  ~>-\"    \"\\\\   7   7   ]                 \n" +
                                        "     ^.___~\"--._    ~-{  .-~ .  `\\ Y . /    |                 \n" +
                                        "      <__ ~\"-.  ~       /_/   \\   \\I  Y   : |                 \n" +
                                        "        ^-.__           ~(_/   \\   >._:   | l______           \n" +
                                        "            ^--.,___.-~\"  /_/   !  `-.~\"--l_ /     ~\"-.       \n" +
                                        "                   (_/ .  ~(   /'     \"~\"--,Y   -=b-. _)      \n" +
                                        "                    (_/ .  \\  :           / l      c\"~o \\     \n" +
                                        "                     \\ /    `.    .     .^   \\_.-~\"~--.  )    \n" +
                                        "                      (_/ .   `  /     /       !       )/     \n" +
                                        "                       / / _.   '.   .':      /        '      \n" +
                                        "                       ~(_/ .   /    _  `  .-<_               \n" +
                                        "                         /_/ . ' .-~\" `.  / \\  \\          ,z=.\n" +
                                        "                         ~( /   '  :   | K   \"-.~-.______//   \n" +
                                        "                           \"-,.    l   I/ \\_    __{--->._(==. \n" +
                                        "                            //(     \\  <    ~\"~\"     //       \n" +
                                        "                           /' /\\     \\  \\     ,v=.  ((        \n" +
                                        "                         .^. / /\\     \"  }__ //===-  `        \n" +
                                        "                        / / ' '  \"-.,__ {---(==-              \n" +
                                        "                      .^ '       :  T  ~\"   ll     -Row       \n" +
                                        "                     / .  .  . : | :!        \\\\               \n" +
                                        "                    (_/  /   | | j-\"          ~^              \n" +
                                        "                      ~-<_(_.^-~\"                             ");

                    }
                    return;
                }

            } else {

                JOptionPane.showMessageDialog(
                        null, "Ingrese un numero entre 1 y 30, igual cuenta como intento " +
                                "por no estar concentrad@", "CONCENTRATE!!!",JOptionPane.WARNING_MESSAGE);
            }

        }

        if (numAleatorio != numeroUsuario) {
            JOptionPane.showMessageDialog(
                    null, mensaje.append("\nHaz perdido el juego, el numero era: " + numAleatorio));

            JOptionPane.showMessageDialog(
                    null, mensaje.append("\nJuego terminado, hasta la proxima!!!\n"));
            nivelHuevo();
        }
    }

}



