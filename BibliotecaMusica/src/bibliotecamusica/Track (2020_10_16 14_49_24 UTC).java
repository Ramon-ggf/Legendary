
package bibliotecamusica;

public class Track {
    
    public String track_name,genre, album, subgenre,key,duration,launch, label;
    public int bpm;
    
    public Track (String track_name, String album, String genre, String subgenre, String key, int bpm, String duration, String launch, String label){
    
        this.track_name = track_name;
        this.album = album;
        this.genre = genre;
        this.subgenre = subgenre;
        this.key = key;
        this.bpm = bpm;
        this.duration = duration;
        this.launch = launch;
        this.label = label;
}
    public String insertDB (int idProducer){
        return "INSERT INTO tracks VALUES (NULL, '" + this.track_name + "', '" + this.album + "', '" + this.genre + "','" + this.subgenre + "', '" + this.key + "', " + this.bpm + ", '" + this.duration + "', '" + this.launch + "', '" + this.label + "', "+idProducer+ ");";
    }
    
    @Override
        public String toString (){
            return "Tema: " + this.track_name + "\n" + "Estilo: " + this.genre + "\n" + "Subgénero: " + this.album ;
        }
}
