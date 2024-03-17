import java.util.Scanner;

public class GestioClients {
    private static Scanner lector = new Scanner(System.in);

        public static String[][] afegirClient(String client[][], String DNIclient, Scanner lector){
            String[][] personaNov = new String[client.length +1][client[0].length];
            boolean resposta=true;
            String nom,cognom;
            personaNov=GestioArrays.copiarArray(client, personaNov);

            System.out.println("----------------------------------");
            System.out.println("Bones! Insereix el teu nom");
            
            //Validador de NOM
            do {
                nom=lector.nextLine();
                resposta = Validacio.nom_Validator(nom);
                if (resposta==false) {
                    System.out.println("Introdueix un nom vàlid");
                }
            } while (resposta==false);
            personaNov[personaNov.length -1][0]=nom;

            System.out.println("Insereix el teu cognom");
            //Validador de COGNOM
            do {
                cognom=lector.nextLine();
                resposta = Validacio.nom_Validator(cognom);
                if (resposta==false) {
                System.out.println("Introdueix un cognom vàlid");
                }
            } while (resposta==false);
            personaNov[personaNov.length -1][1]=cognom;
            System.out.println("Insereix el teu DNI");
            resposta=true;
            //Validador de DNI
            do {
                DNIclient=lector.nextLine();
                resposta = Validacio.DNI_Validator(DNIclient);
                if (resposta==false) {
                    System.out.println("Introdueix un DNI vàlid");
                }
            } while (resposta==false);

            String DNIcopia="";
            do { //COMPROVEM QUE USUARI NO EXISTEIXI JA A LA TAULA QUE TENIM USUARIS JA REGISTRATS
                for (int i = 0; i < client.length; i++) {
                    if (client[i][2].equals(DNIclient)) {
                        System.out.println("Siusplau introdueix un dni el qual no s'hagi introdüit");
                        DNIcopia=DNIclient;
                        DNIclient=lector.nextLine();
                    }
                }
            } while (DNIcopia.equals(DNIclient));
            personaNov[personaNov.length -1][2]=DNIclient;
            System.out.println("----------------------------------");
            client=personaNov;
            return client;
        }
        public static String afegirClientRegistrat(String client[][], String DNIclient){
            System.out.println("----------------------------------");
            System.out.println("Benvingut!");
            boolean troba = false;

            while (!troba) {
                // MOSTREM USUARIS
                for (int i = 0; i < client.length; i++) {
                    System.out.println(
                            "Nom:" + client[i][0] + " " +
                            "Cognom: " + client[i][1] + " " +
                            "DNI: " + client[i][2] + " ");
                }
                System.out.println("Introdueix el teu DNI");
                DNIclient = lector.nextLine();
                System.out.println("----------------------------------");

                // COMPROVEM SI EL CLIENT EXISTEIX
                for (int i = 0; i < client.length; i++) {
                    if (client[i][2].equals(DNIclient)) {
                        troba = true;
                    }
                }

                if (!troba) { // MOSTRAR AIXÒ EN EL CAS QUE NO SIGUI CORRECTE  EL DNI
                    System.out.println("--> El DNI ha de ser existent <--");
                    System.out.println("----------------------------------");
                }
            }
            return DNIclient;
        }

        public static String[][] modificarUsuaris(String client[][]){
            //MOSTREM USUARIS
            for (int i = 0; i < client.length; i++) {
                System.out.println(
                    i +" |Nom:" + client[i][0] +" " +
                    i +" |Cognom: " + client[i][1] +" " +
                    i +" |DNI: " + client[i][2] +" ");
            }
            System.out.println("----------------------------------");
            System.out.println("Quin usuari vols modificar la seva informació");
            System.out.println("----------------------------------");
            int clientModificacio=lector.nextInt();
            lector.nextLine();
            System.out.println("----------------------------------");
            System.out.println("Usuari modificat");
            System.out.println("Modifica el nom");
            client[clientModificacio][0]=lector.nextLine();
            System.out.println("Modifica el cognom");
            client[clientModificacio][1]=lector.nextLine();
            System.out.println("Modifica el DNI");
            client[clientModificacio][2]=lector.nextLine();
            System.out.println("----------------------------------");
            //LLISTEM TOTS ELS USUARIS
            for (int i = 0; i < client.length; i++) {
                System.out.println(
                    "Nom:" + client[i][0] +" " +
                    "Cognom: " + client[i][1] +" " +
                    "DNI: " + client[i][2] +" ");
            }
            System.out.println("----------------------------------");
            return client;
        }

        public static void llistarUsuaris(String client[][]){
            System.out.println("Llistem tots els usuaris que tenim actualment");
            for (int i = 0; i < client.length; i++) {
                System.out.println(
                    "Nom:" + client[i][0] +" " +
                    "Cognom: " + client[i][1] +" " +
                    "DNI: " + client[i][2] +" ");
            }
            System.out.println("----------------------------------");
        }

}
