
package bibliotecamusica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryManager {
    
    public static String CreateProducer(String artist_name, String sex, String nationality, String residence_city, String instagram, String facebook, String youtube, String resident_advisor, String soundcloud, String mixcloud, String bandcamp, String beatport){
        Producer new_producer = new Producer (artist_name, sex, nationality, residence_city,instagram, facebook,youtube, resident_advisor, soundcloud, mixcloud, bandcamp, beatport);
        DBManager.ChangeDB(new_producer.insertDB());
        
        Logger.LoggerFiller("Se ha creado el perfil del productor/a " + "'" + artist_name + "'", "Información");
        return "El/la productor/a " + "'" + artist_name + "'" + " se ha creado correctamente.\n" ;
        

    }
    
    public static String DeleteProducer (String artist_name){
        DBManager.ChangeDB("DELETE FROM producers WHERE Name LIKE '%" + artist_name + "%';");
        
        Logger.LoggerFiller("Se ha eliminado el perfil del productor/a " + "'" + artist_name + "'" + " de la base de datos.", "Información");
        return "El/la productor/a " + "'" + artist_name + "'" + "se ha elimnado correctamente.\n" ;
    }
    
    public static String ConsultProducerName (String artist_name){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM producers WHERE Name LIKE '%" + artist_name + "%';");
            
            while (results.next()){
                query += "-Nombre: " + results.getString("Name") + "\n-Sexo: " + results.getString("Sex") + "\n-Nacionalidad: "  +  results.getString("Nationality") + "\n-Ciudad de residencia: " + results.getString("Residence city") + "\n-Perfil de Instagram: " + results.getString("Instagram") + "\n-Perfil de Facebook: " + results.getString("Facebook") + "\n-Perfil de YouTube: " + results.getString("Youtube") + "\n-Perfil de RA: " + results.getString("Resident advisor") + "\n-Perfil de SoundCloud: " + results.getString("Soundcloud") + "\n-Perfil de Mixcloud: " + results.getString("Mixcloud") + "\n-Perfil de Bandcamp: " + results.getString("Bandcamp") + "\n-Perfil de Beatport: " + results.getString("Beatport") + "\n";
            }
            Logger.LoggerFiller("Se ha consultado el perfil de " + "'" + artist_name + "'", "Información");

            DBManager.CloseDB();
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
     public static String ModifyProducer (int idProducer, String artist_name, char sex, String nationality, String residence_city){
        
        DBManager.ChangeDB("UPDATE producers SET Name = '" + artist_name + "', Sex = '" + sex + "', Nationality = '" + nationality + "', Residence city =  '" + residence_city+ "' WHERE ID = " + idProducer + ";");
        return "El/la productor/a " + artist_name + " se ha modificado correctamente." ;
    }
    
    
 public static String ShowAllProducers (){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM producers;");
            
            while (results.next()){
                query += "===============================\n" + "[ID del perfil: #" + results.getString("ID") + "] " + "\n-Nombre: " + results.getString("Name") + "\n-Sexo: " + results.getString("Sex") +  "\n-Nacionalidad: " +  results.getString("Nationality") + "\n-Ciudad de residencia: " + results.getString("Residence city") + "\n-Perfil de Instagram: " + results.getString("Instagram") + "\n-Perfil de Facebook: " + results.getString("Facebook") + "\n-Perfil de YouTube: " + results.getString("Youtube") + "\n-Perfil de RA: " + results.getString("Resident advisor") + "\n-Perfil de SoundCloud: " + results.getString("Soundcloud") + "\n-Perfil de Mixcloud: " + results.getString("Mixcloud") + "\n-Perfil de Bandcamp: " + results.getString("Bandcamp") + "\n-Perfil de Beatport: " + results.getString("Beatport") + "\n===============================\n";
            }
            DBManager.conn.close();
            return query;
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return null;
    }
 
    public static String HowManyProducers (){
        String query ="";

        try {
            ResultSet results = DBManager.CheckDB("SELECT count (*) FROM producers;");
            
            while (results.next()){
                query += "Hay: " + results.getInt(1) + " productores/as en tu biblioteca.\n";
            }
            
        DBManager.conn.close();
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
    public static Integer SearchProducerID (String artist_name){
        int query =0;
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT ID FROM producers WHERE Name LIKE '%" + artist_name +"%';");
            
            while (results.next()){
                query = results.getInt("ID");
            }
            
        DBManager.conn.close();
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
    public static String ConsultProducerSex (String sex){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM producers WHERE Sex = '" + sex + "';");
            
            while (results.next()){
                query += "===============================\n" + "[ID del perfil: #" + results.getString("ID") + "] " + "\n-Nombre: " + results.getString("Name") + "\n-Sexo: " + results.getString("Sex") +  "\n-Nacionalidad: " +  results.getString("Nationality") + "\n-Ciudad de residencia: " + results.getString("Residence city") + "\n-Perfil de Instagram: " + results.getString("Instagram") + "\n-Perfil de Facebook: " + results.getString("Facebook") + "\n-Perfil de YouTube: " + results.getString("Youtube") + "\n-Perfil de RA: " + results.getString("Resident advisor") + "\n-Perfil de SoundCloud: " + results.getString("Soundcloud") + "\n-Perfil de Mixcloud: " + results.getString("Mixcloud") + "\n-Perfil de Bandcamp: " + results.getString("Bandcamp") + "\n-Perfil de Beatport: " + results.getString("Beatport") + "\n===============================\n";
            }
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query + "\n";
    }
    
    public static String CreateTrack(int idProducer,String track_name, String album, String genre,  String subgenre, String key, int bpm, String duration, String launch, String label){
        Track new_track = new Track (track_name, album, genre, subgenre, key, bpm, duration, launch, label);
        DBManager.ChangeDB(new_track.insertDB(idProducer));
        
        Logger.LoggerFiller("Se ha creado el tema " + "'" + track_name + "'", "Información");
        return "El track " + "'" + track_name + "'" + " se ha creado correctamente.";
    }
    
    public static String DeleteTrack (String track_name){
        DBManager.ChangeDB("DELETE FROM tracks WHERE Title LIKE '%" + track_name + "%';");
        
        Logger.LoggerFiller("Se ha eliminado el tema " + "'" + track_name + "'" + "de la base de datos.", "Información");
        return "El track " + "'" + track_name + "'" + " se ha elimnado correctamente." ;
    }

    public static String ConsulTrackName (String track_name){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM tracks  WHERE Title LIKE '" + track_name + "';");
            
            while (results.next()){
                query += "===============================\n" + "[Track ID: #-Nombre: " + results.getString("ID") + "]" + "\n-Título: " + results.getString("Title") + "\n-Álbum: " + results.getString("Album") + "\n-Género: "  +  results.getString("Genre") + "\n-Subgénero: " + results.getString("Subgenre") + "\n-Clave armónica: " + results.getString("Key") + "\n-BPM: " + results.getString("bpm") + "\n-Duración: " + results.getString("Duration") + " min." + "\n-Lanzamiento: " + results.getString("Launch") + "\n-Sello: " + results.getString("Label");
            }
            
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
    public static String ModifyTrack(String track_name, String genre, String subgenre,String key, int bpm, String duration, String launch){
        DBManager.ChangeDB("UPDATE tracks SET Title = '" + track_name + "', Genre = '" + genre + "', Subgenre = '" + subgenre + "Key =  '" + key + "', bpm = " + bpm + ", Duration = '" + duration + "', Launch = '" + launch + "' WHERE Title LIKE '%" + track_name + "%';");
        return "El track " + "'" + track_name + "'" + " se ha modificado correctamente." ;
    }
    
    public static String ConsulTrackGenre (String genre){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM tracks WHERE Genre LIKE '%" + genre + "%';");
            
            while (results.next()){
                query += "===============================\n" + "[Track ID: #: " + results.getString("ID") + "]" + "\n-Título: " + results.getString("Title") + "\n-Álbum: " + results.getString("Album") + "\n-Género: "  +  results.getString("Genre") + "\n-Subgénero: " + results.getString("Subgenre") + "\n-Clave armónica: " + results.getString("Key") + "\n-BPM: " + results.getString("bpm") + "\n-Duración: " + results.getString("Duration") + " min." + "\n-Lanzamiento: " + results.getString("Launch") + "\n-Sello: " + results.getString("Label") + "\n";
            }
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
    public static String ConsulTrackSubgenre (String genre, String subgenre){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM tracks WHERE Genre LIKE '%" + genre + "%' AND Subgenre LIKE '%" + subgenre + "%';");
            
            while (results.next()){
                query += "===============================\n" + "[Track ID: #: " + results.getString("ID") + "]" + "\n-Título: " + results.getString("Title") + "\n-Álbum: " + results.getString("Album") + "\n-Género: "  +  results.getString("Genre") + "\n-Subgénero: " + results.getString("Subgenre") + "\n-Clave armónica: " + results.getString("Key") + "\n-BPM: " + results.getString("bpm") + "\n-Duración: " + results.getString("Duration") + " min." + "\n-Lanzamiento: " + results.getString("Launch") + "\n-Sello: " + results.getString("Label") + "\n";
            }
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
    public static String ConsulTrackBPMRange(int bpm1, int bpm2){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM tracks WHERE bpm BETWEEN " + bpm1 + " AND " + bpm2 + ";");
            
            while (results.next()){
                query += "===============================\n" + "[Track ID: #: " + results.getString("ID") + "]" + "\n-Título: " + results.getString("Title") + "\n-Álbum: " + results.getString("Album") + "\n-Género: "  +  results.getString("Genre") + "\n-Subgénero: " + results.getString("Subgenre") + "\n-Clave armónica: " + results.getString("Key") + "\n-BPM: " + results.getString("bpm") + "\n-Duración: " + results.getString("Duration") + " min." + "\n-Lanzamiento: " + results.getString("Launch") + "\n-Sello: " + results.getString("Label") + "\n";            
            }
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }

    public static String ShowAllTraks() {
        String query = "";

        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM tracks;");

            while (results.next()) {
                query += "===============================\n" + "[Track ID: #: " + results.getString("ID") + "]" + "\n-Título: " + results.getString("Title") + "\n-Álbum: " + results.getString("Album") + "\n-Género: "  +  results.getString("Genre") + "\n-Subgénero: " + results.getString("Subgenre") + "\n-Clave armónica: " + results.getString("Key") + "\n-BPM: " + results.getString("bpm") + "\n-Duración: " + results.getString("Duration") + " min." + "\n-Lanzamiento: " + results.getString("Launch") + "\n-Sello: " + results.getString("Label") + "\n";
            }

            DBManager.CloseDB();
            return query;
            
        } catch (SQLException error) {
            
            Logger.LoggerFiller(error.getMessage(), "Error");
            return null;
        }
    }
    
    public static String HowManyTracks(){
        String query ="";

        try {
            ResultSet results = DBManager.CheckDB("SELECT count (*) FROM tracks;");
            
            while (results.next()){
                query += "Hay: " + results.getInt(1) + " tracks en tu biblioteca.\n";
            }
            
        DBManager.conn.close();
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
    public static String HowManyTrackgenre (String genre){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT count (*) FROM tracks WHERE genre LIKE '%" + genre + "%';");
            
            while (results.next()){
                query += "Hay: " + results.getInt(1) + " temas de " +  genre + " en tu biblioteca.\n";
            }
            
        DBManager.conn.close();
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
    
     public static String ConsulTrackLabel(String label){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT * FROM tracks WHERE Label LIKE '%" + label + "%';");
            
            while (results.next()){
                query += "===============================\n" + "[Track ID: #: " + results.getString("ID") + "]" + "\n-Título: " + results.getString("Title") + "\n-Álbum: " + results.getString("Album") + "\n-Género: "  +  results.getString("Genre") + "\n-Subgénero: " + results.getString("Subgenre") + "\n-Clave armónica: " + results.getString("Key") + "\n-BPM: " + results.getString("bpm") + "\n-Duración: " + results.getString("Duration") + " min." + "\n-Lanzamiento: " + results.getString("Launch") + "\n-Sello: " + results.getString("Label") + "\n";
            }
        
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return query;
    }
     
    public static String ShowAllLabels(){
        String query ="";
        
        try {
            ResultSet results = DBManager.CheckDB("SELECT Label FROM tracks GROUP BY Label;");
            
            while (results.next()){
                query += results.getString("Label") + "\n";
            }
            
        DBManager.conn.close();
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
        return "Estos son los sellos que tienes hasta ahora: \n" +query;
    }

}