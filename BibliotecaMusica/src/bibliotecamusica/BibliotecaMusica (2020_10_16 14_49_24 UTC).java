
package bibliotecamusica;

import java.util.Scanner;

public class BibliotecaMusica {
    
    static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        while (true){
            Println ("Gestión biblioteca de música" + "\n" + "¿A qué quieres acceder?");
            Println ("[1] Productores/as");
            Println ("[2] Temas");
            Println ("[3] Sellos");
            Println ("[4] Salir");
            Println ("Escoge una opción: ");
            
            byte opcion = Byte.parseByte(sc.nextLine());
            
            if (opcion == 1){
                Println("\nProductores/as:\n" + "¿Qué quieres hacer?");
                Println ("\t[1] Crear el perfil de un productor/a.");
                Println ("\t[2] Eliminar el perfil de un productor/a.");
                Println ("\t[3] Modificar perfil de un productor/a.");
                Println ("\t[4] Consultar productores por nombre.");
                Println ("\t[5] Obtener los perfiles de los productores por sexo.");
                Println ("\t[6] Mostrar todos los perfiles de los productores.");
                Println ("\t[7] Mostrar cuántos productores/as hay en la biblioteca.");
                Println ("\t[8] Salir");
                
                Println ("\tEscoge una opción: ");
                opcion = Byte.parseByte(sc.nextLine());
                
                switch (opcion){
                    case 1:
                        Println(
                            LibraryManager.CreateProducer(
                                Input("Nombre: "),
                                Input("Sexo (Hombre, Mujer, No binario): "),
                                Input("Nacionalidad: "),
                                Input("Ciudad de residencia: "),
                                Input("Perfil de Instagram: "),
                                Input("Perfil de Facebook: "),
                                Input("Perfil de YouTube: "),
                                Input("Perfil de Resident Advisor: "),
                                Input("Perfil de Soundcloud: "),
                                Input("Perfil de Mixcloud: "),
                                Input("Perfil de Bandcamp: "),
                                Input("Perfil de Beatport: ")
                            ));
                        break;
                    case 2:
                        Println(LibraryManager.DeleteProducer(Input("Dime el nombre del productor/a que quieres eliminar: ")));
                        break;
                    case 3:
                       Println(
                            LibraryManager.ModifyProducer(
                                LibraryManager.SearchProducerID(Input("Nombre del productor/a que quieres modificar: ")),
                                Input("Nuevo nombre del productor/a: "),
                                Input("Nuevo sexo del productor/a: ").charAt(0),
                                Input("Nueva nacionalidad del productor/a: "),
                                Input("Nueva ciudad de residencia del productor/a: ")
                            ));
                        break;
                    case 4:
                        Println(LibraryManager.ConsultProducerName(Input("Dime el nombre del productor/a que quieres consultar: ")));
                        break;
                    case 5: 
                        Println(LibraryManager.ConsultProducerSex(Input("Dime el sexo de los productrores que quieres obtener (Hombre, Mujer, No binario): ")));
                        break;
                    case 6:
                        Println(LibraryManager.ShowAllProducers());
                        break;
                    case 7:
                         Println(LibraryManager.HowManyProducers());
                         break;
                    case 8:
                        Println("¡Hasta pronto!");
                        System.exit(0);
                        break;
                }

            }else if (opcion == 2){
                Println ("\nTemas:\n" + "¿Qué quieres hacer?");
                Println ("\t[1] Crear un nuevo tema.");
                Println ("\t[2] Eliminar un tema.");
                Println ("\t[3] Modificar un tema.");
                Println ("\t[4] Consultar track por título.");
                Println ("\t[5] Obtener temas por género.");
                Println ("\t[6] Obtener temas por subgénero.");
                Println ("\t[7] Obtener temas por rango de bpm.");
                Println ("\t[8] Mostrar todos los temas de la biblioteca.");
                Println ("\t[9] Mostrar cuántos temas hay en la biblioteca");
                Println ("\t[10] Mostrar cuántos temas hay en la biblioteca por género.");
                Println ("\t[11] salir.");

                Println ("Escoge una opción: ");
                opcion = Byte.parseByte(sc.nextLine());
                
                switch (opcion){
                    case 1:
                        
                        Println(
                            LibraryManager.CreateTrack(
                                LibraryManager.SearchProducerID(Input("Nombre del productor: ")),
                                Input("Título: "),
                                Input("Album: "),
                                Input("Género: "),
                                Input("Subgénero: "),
                                Input("Clave armónica(##A/B): "),
                                Integer.parseInt(Input("Velocidad (bpm): ")),
                                Input("Duración (en minutos): "),
                                Input("Fecha de lanzamiento: "),
                                Input("Sello: ")
                            ));
                        break;
                    case 2:
                        Println(LibraryManager.DeleteTrack(Input("Título del tema que quieres eliminar: ")));
                        break;
                    case 3:
                        Println(LibraryManager.ModifyTrack(
                                Input("Título del tema que quieres modificar: "),
                                Input("Nuevo género al que pertenece: "),
                                Input("Nuevo subgénero al que pertenece: "),
                                Input ("Nueva clave armónica: "),
                                Integer.parseInt(Input("Nueva velocidad:")),
                                Input("Nueva duración: "),
                                Input ("Nueva fecha de lanzamiento: ")
                            ));
                        break;
                    case 4:
                        Println(LibraryManager.ConsulTrackName(Input("Título del tema que quieres consultar: ")));
                        break;
                    case 5:
                        Println(LibraryManager.ConsulTrackGenre(Input("Género de los temas que quieres obtener: ")));
                        break;
                    case 6:
                        Println(
                            LibraryManager.ConsulTrackSubgenre(
                                Input("Género de los temas que quieres obtener: "),
                                Input ("Subgénero de los temas que quieres obtener: ")
                            ));
                        break;
                    case 7:
                        Println(
                            LibraryManager.ConsulTrackBPMRange(
                                Integer.parseInt(Input("Velocidad mínima: ")),
                                Integer.parseInt(Input("Valocidad máxima: "))
                                ));
                        break;
                    case 8:
                        Println(LibraryManager.ShowAllTraks());
                        break;
                    case 9:
                        Println(LibraryManager.HowManyTracks());
                        break;
                    case 10:
                        Println(LibraryManager.HowManyTrackgenre(Input("Género de los temas cuya cantidad quieres saber: ")));
                        break;
                    case 11:
                        Println("¡Hasta pronto!");
                        System.exit(0);
                        break;
                }
            }else if (opcion == 3){
                Println ("\nSellos:\n" + "¿Qué quieres hacer?");
                Println ("\t[1] Consultar los temas de un sello.");
                Println ("\t[2] Mostrar todos los sellos de la biblioteca.");
                Println ("\t[3] Salir.");
                
                Println ("\nEscoge una opción: ");
                opcion = Byte.parseByte(sc.nextLine());
                
                switch (opcion){
                    case 1:
                        Println(LibraryManager.ConsulTrackLabel(Input("Nombre del sello que quieres consultar: ")));
                        break;
                    case 2: 
                        Println(LibraryManager.ShowAllLabels());
                        break;
                    case 3:
                        Println("¡Hasta pronto!");
                        System.exit(0);
                        break;
                }

            }else if (opcion == 4){
                Println("¡Hasta pronto!");
                System.exit(0);
                
            }else
                Println("Lo siento, esa opción no está disponible, vuelve a elegir. ");
        }
    }
    public static String Input (String entrada){
        System.out.println (entrada);
        return sc.nextLine();
    }
    
    public static void Println (String entrada){
        System.out.println (entrada);
    }
}
