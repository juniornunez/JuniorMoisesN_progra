package archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileTest {

    public static void main(String[] args) {
        MyFile file = new MyFile();
        String path = "";
        Scanner lea = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("Escoja una opcion.");
            System.out.println("\n1 - Set Archivo/Folder");
            System.out.println("2 - Ver Informacion");
            System.out.println("3 - Crear un Archivo");
            System.out.println("4 - Crear un Folder");
            System.out.println("5 - Borrar");
            System.out.println("6 - DIR");
            System.out.println("7 - Tree");
            System.out.println("8 - Reescribir Archivo");
            System.out.println("9 - Anadir Texto al Archivo");
            System.out.println("10 - Leer Archivo (File)");
            System.out.println("11 - Leer Archivo (Buffered)");
            System.out.println("12 - Salir");

            try {
                int op = lea.nextInt();

                if (op == 1) {
                    System.out.println("\n  -     SET ARCHIVO/ FOLDER     -");
                    String direc = lea.next();
                    file.setFile(direc);
                    path = direc;
                }

                if (op == 2) {
                    System.out.println("\n -      VER INFORMACION         -");
                    file.info();
                }
                if (op == 3) {
                    System.out.println("\n -      CREAR ARCHIVO           -");
                    if (file.crearFile()) {
                        System.out.println("Archivo creado!");
                    } else {
                        System.out.println("Archivo no creado!");
                    }
                }
                if (op == 4) {
                    System.out.println("\n -      CREAR FOLDER            -");
                    if (file.crearFolder()) {
                        System.out.println("Folder creado!");
                    } else {
                        System.out.println("Folder no creado!");
                    }
                }
                if (op == 5) {
                    System.out.println("-          BORRAR                  -");
                    if (file.borrar(path)) {
                        System.out.println("Se borro!");
                    } else {
                        System.out.println("No se borro!");
                    }
                }
                if (op == 6) {
                    System.out.println("-       DIR         -");
                    file.dir();
                }
                if (op == 7) {
                    System.out.println("-       TREE         ");
                    file.tree();
                }
                if (op == 8) {
                    System.out.println("\nIngrese el texto a reescribir en el archivo:");
                    String texto = lea.next();
                    file.reescribirArchivo(texto);
                }
                if (op == 9) {
                    System.out.println("\nIngrese el texto a anadir al archivo:");
                    String texto = lea.next();
                    file.anadirTexto(texto);
                }
                if (op == 10) {
                    file.leerFileReader();
                }
                if (op == 11) {
                    file.leerBufferedReader();
                }
                if (op == 12) {
                    System.exit(0);
                }

            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opcion valida!");
                lea.next();
            } catch (NullPointerException e) {
                System.out.println("Favor seleccionar opcion 1 !");
            } catch (IOException e) {
                System.out.println("ERROR" + e.getMessage());
            }
        }
    }
}