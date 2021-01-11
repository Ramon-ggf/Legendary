
package bibliotecamusica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;

public class Logger {
    static String FilePath = "Registro.txt";
    
    public static void LoggerFiller (String info, String kind){
        String line = new Timestamp (System.currentTimeMillis()) + " - " + kind + " --> " + info + "\r\n";
        
        try{
            File fichero = new File(Logger.FilePath);
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(line);

            bw.close();
            fw.close();
        } catch (Exception error) {
           Logger.LoggerFiller(error.getMessage(), "Critico");
        }
    }
}
