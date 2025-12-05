package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

public class MyFile {
    private File mifile = null;
    
    void setFile(String direccion){
        mifile = new File(direccion);
    }
    
    void info(){
        if (mifile.exists()){
            System.out.println("\nNombre: " + mifile.getName() + 
                                "\nPath: " + mifile.getPath() +
                                "\nAbsoluta: " + mifile.getAbsolutePath() +
                                "\nBytes: " + mifile.length() +
                                "\nModificado en : " + new Date(mifile.lastModified()) + 
                                "\nPadre: " + mifile.getAbsoluteFile().getParentFile().getName());
            if (mifile.isFile()){
                System.out.println("Es una archivo!");
            }else if(mifile.isDirectory()){
                System.out.println("Es un folder!");
            }
            System.out.println("-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-");
        } else {
            System.out.println("No existe!");
        }
    }

    boolean crearFile() throws IOException {
        return mifile.createNewFile();
    }

    boolean crearFolder() {
        return mifile.mkdirs();
    }

    boolean borrar(String folderPath) {
        File folder = new File(folderPath);  

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    borrar(file.getPath());
                }
            }
        }
        return folder.delete();  
    }
    
    void dir(){
        if (mifile.isDirectory()){
            System.out.println("Directorio de : " + mifile.getAbsolutePath());
            System.out.println("");
            int cArchi = 0 , cdir = 0 , tbytes = 0;
            for (File child : mifile.listFiles()){
                if (!child.isHidden()){
                    Date ult = new Date(child.lastModified());
                    System.out.print(ult + "\t ");
                    if (child.isDirectory()){
                        cdir++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        cArchi++;
                        tbytes += child.length();
                        System.out.print("    \t" + child.length() + "\t");
                    }
                    System.out.println(child.getName());
                }
            }
            System.out.println(cArchi + " archivos\t" + tbytes + " bytes");
            System.out.println(cdir + " dirs\t");
        }
    }

    private void tree(File dir, String tab){
        if (dir.isDirectory()){
            System.out.println(tab + dir.getName());
            for (File child : dir.listFiles()) {
                if (!child.isHidden()){
                    tree(child, tab + " -- ");
                }
            }
        }
    }
    
    void tree(){
        tree(mifile, " - ");
    }

    void reescribirArchivo(String texto) throws IOException {
        try (FileWriter writer = new FileWriter(mifile, false)) {
            writer.write(texto);
        }
    }

    void anadirTexto(String texto) throws IOException {
        try (FileWriter writer = new FileWriter(mifile, true)) {
            writer.write(texto);
        }
    }

    void leerFileReader() throws IOException {
        try (FileReader leer = new FileReader(mifile)) {
            int caracter;
            while ((caracter = leer.read()) != -1) {
                System.out.print((char) caracter);
            }
            System.out.println();
        }
    }

    void leerBufferedReader() throws IOException {
        try (BufferedReader leer2 = new BufferedReader(new FileReader(mifile))) {
            String linea;
            while ((linea = leer2.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}