import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;

public class JugarJueguitos extends AdivinarNumero {

    public static boolean estado = false;

    public static void main(String[] args) {


       do {

           try{

               int menu = Integer.parseInt(JOptionPane.showInputDialog
                       ("Ingrese el numero del juego que desea jugar:\n\n"
                       + "1. Adivina el numero\n"
                       + "2. Salir"));

               switch (menu){

                   case 1:

                       adivinarNumero();
                       break;

                   case 2:

                       estado = true;
                       break;

                   default:

                       throw new IllegalArgumentException("Ingrese un numero valido");
               }

           }catch (InputMismatchException e){

               JOptionPane.showMessageDialog(
   null, "ERROR, Ingrese una opcion valida", "ERROR",JOptionPane.WARNING_MESSAGE);

           }catch (Exception e){

               JOptionPane.showMessageDialog(null,"ERROR: "+ e.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
           }

       }while (!estado);
    }

}