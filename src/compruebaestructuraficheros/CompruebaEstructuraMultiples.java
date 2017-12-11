/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compruebaestructuraficheros;

import static compruebaestructuraficheros.EstructuraFicheros.writeZipFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompruebaEstructuraMultiples {

    private static ArrayList<String> readListofFilesFromFile(String path) throws FileNotFoundException, IOException {

        ArrayList<String> result = new ArrayList<>();
        if ((new File(path)).exists()) {

            FileReader in = new FileReader(path);
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }

    private static boolean compruebaEstructura(String path, String practica) {

        File folder = new File(path);
        try {
            ArrayList<String> ficheros = readListofFilesFromFile(System.getProperty("user.dir") + "/" + practica);
            System.out.println("---------------------------------------------------");
            System.out.println(path);
            boolean correcta = true;
            File f;
            for (int i = 0; i < ficheros.size(); i++) {
                try {
                    f = new File(path + ficheros.get(i));
                    Path path1 = Paths.get(path + ficheros.get(i));

                    if (f.exists()) {
                        if (!f.getCanonicalFile().toPath().toRealPath(NOFOLLOW_LINKS).toString().equals(f.toString())) {
                            if ((path + ficheros.get(i)).contains(".")) {
//                                System.out.println("Falta fichero " + ficheros.get(i));
//                                return false;
                            } else {
//                                System.out.println("Falta carpeta " + ficheros.get(i));
//                                return false;
                            }
                        }

                    }
                    if (!f.exists()) {
                        if ((path + ficheros.get(i)).contains(".")) {
                            System.out.println("Falta fichero " + ficheros.get(i));
                            return false;
                        } else {
                            System.out.println("Falta carpeta " + ficheros.get(i));
                            return false;
                        }
                    }
                } catch (IOException ex) {
                    if ((path + ficheros.get(i)).contains(".")) {
                        System.out.println("Falta fichero " + ficheros.get(i));
                        return false;
                    } else {
                        System.out.println("Falta carpeta " + ficheros.get(i));
                        return false;
                    }
                }
            }

            return true;
        } catch (IOException ex) {
            Logger.getLogger(EstructuraFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }


    
    private static void compruebaCompilan(String path){
    
    
    
    
    
    
    
    
    }
    
    

public static void main(String args[]) {
         
         String mainpath = "/home/jonathan/Escritorio/Dropbox/Docencia/Programacion_Orientada_A_Objetos/2016-17/Entregas";
         String practica = "20162017practicas1011.txt";
         
         File maindir = new File(mainpath);
         
         int contadorEstructuraCorrecta =0;
         int contadorPracticas = 0;
         
         for(File f:maindir.listFiles()){
             if(f.isDirectory()){
             if(compruebaEstructura(f.getAbsolutePath(),practica)){
                 contadorEstructuraCorrecta++;
             }
             contadorPracticas++;
             }
         }
         
         
         System.out.println(contadorEstructuraCorrecta + " practicas con la estructura correcta de " + contadorPracticas);
         
         
         
         
         
     }
    
    

}
