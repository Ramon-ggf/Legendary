
package bibliotecamusica;

public class Producer {
   
    public String artist_name,sex, nationality, residence_city,instagram, facebook, youtube, resident_advisor, soundcloud, mixcloud, bandcamp, beatport;

    
    public Producer (String artist_name, String sex, String nationality, String residence_city, String instagram, String facebook, String youtube, String resident_advisor, String soundcloud, String mixcloud, String bandcamp, String beatport){

        this.artist_name = artist_name;
        this.sex = sex;
        this.nationality = nationality;
        this.residence_city = residence_city;
        this.instagram = instagram;
        this.facebook = facebook;
        this.youtube = youtube;
        this.resident_advisor = resident_advisor;
        this.soundcloud = soundcloud;
        this.mixcloud = mixcloud;
        this.bandcamp = bandcamp;
        this.beatport = beatport;
    }
    
    public String insertDB (){
        return "INSERT INTO producers VALUES (NULL, '" + this.artist_name + "', '" + this.sex + "', '" +  this.nationality + "', '" + this.residence_city + "', '" + this.instagram + "', '" + this.facebook + "', '" + this.youtube + "', '" + this.resident_advisor + "', '" + this.soundcloud + "', '" + this.mixcloud + "', '" + this.bandcamp + "', '" + this.beatport + "');";
    }
    
    @Override
        public String toString (){
            return "Productor/a: " + this.artist_name + "\n" + "Sexo: " + this.sex + "\n" + "Nacionalidad: " + this.nationality + "\n" + "Ciudad de residencia: " + this.residence_city;
        }
}
