public class Menus {
        public static void menuInicial(){
            System.out.println("----------------------------------");
            System.out.println("Benvingut! que vols realitzar?");
            System.out.println("1 --> Gestio usuaris");
            System.out.println("2 --> Selecció de Cotxe");
            System.out.println("3 --> Modificació de MARQUES/MODELS");
            System.out.println("4 --> Factura");
            System.out.println("0 --> Sortir");
            System.out.println("----------------------------------");
        }
        public static void menuUsuaris(){
            System.out.println("----------------------------------");
            System.out.println("Bones ets client habitual?");
            System.out.println("1 --> Afegir nou usuari" +"\n" +"2 --> Usuari existent" +"\n" +"3 --> Modificar usuari" +"\n" +"4 --> Llistar els usuaris");
            System.out.println("----------------------------------");
        }
        public static void menuVehicles(){
            System.out.println("----------------------------------");
            System.out.println("Què vol realitzar?");
            System.out.println("1 --> Afegir Marca");
            System.out.println("2 --> Modificar Marca");
            System.out.println("3 --> Afegir Model");
            System.out.println("4 --> Modificar Model");
            System.out.println("5 --> Tornar al menú Inicial");
            System.out.println("----------------------------------");
        }
        public static void menuFactures(){
            System.out.println("----------------------------------");
            System.out.println("Què vols realitzar?");
            System.out.println("1 --> Generar Factura");
            System.out.println("2 --> Llistar totes les factures");
            System.out.println("3 --> Llistar factures usuari en concret");
            System.out.println("4 --> Llistar factura en concret");
            System.out.println("----------------------------------");
        }
         //UNR --> usuari no registrat
        public static void facturaTotalUNR(String client[][], String marca[][], String model[][], int respCotxe, int respModel){
            System.out.println("----------------------------------");
            System.out.println("FACTURA TOTAL");
            System.out.println("DNI usuari --> " +client[client.length-1][2]);
            System.out.println("Vehicle seleccionat"+"\n"
                +" |Marca          -->"+marca[respCotxe][1] +"\n"
                +" |   Model       -->"+model[respModel][1] +"\n"
                +" |   N.Bastidor  -->"+model[respModel][2] +"\n"
                +" |   Preu        -->"+model[respModel][3] +"\n"
            );
            int sumacotxe=Integer.parseInt(model[respModel][3]);
            double total=((sumacotxe*0.21)+sumacotxe);
            System.out.println("Import Total: " +total);
            System.out.println("----------------------------------");
        }
        //UR --> usuari registrat
        public static void facturaTotalUR(String DNIclient, String marca[][], String model[][], int respCotxe, int respModel){
            System.out.println("----------------------------------");
            System.out.println("FACTURA TOTAL");
            System.out.println("DNI usuari --> " +DNIclient);
            System.out.println("Vehicle seleccionat" +"\n"

                +" |Marca          -->"+marca[respCotxe][1] +"\n"
                +" |   Model       -->"+model[respModel][1] +"\n"
                +" |   N.Bastidor  -->"+model[respModel][2] +"\n"
                +" |   Preu        -->"+model[respModel][3] +"\n"
            );
            //CALCUL IVA
            int sumacotxe=Integer.parseInt(model[respModel][3]);
            double total=((sumacotxe*0.21)+sumacotxe);
            System.out.println("Import Total: " +total);
            System.out.println("----------------------------------");
        }
        
}
