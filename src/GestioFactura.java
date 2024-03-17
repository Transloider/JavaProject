import java.util.Scanner;

public class GestioFactura {
    private static Scanner lector = new Scanner(System.in);

    public static void llistarFactura(String[][] factura){
        System.out.println("----------------------------------");
        System.out.println("Llistat de totes les factures");
        //LLISTEM TOT EL QUE HI HA  A FACTURES
        for (int i = 0; i < factura.length; i++) {
                System.out.println(
                    "|ID -->" +factura[i][0] +"\n"
                    +"|DNI Client -->" +factura[i][1] +"\n"
                    +"|Model -->" +factura[i][2] +"\n"
                );
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

    public static void llistarUsuariConcret(String[][]factura, String[][] model, String[][] client) {
        System.out.println("De quin usuari vols obtenir la seva factura");
        //LLISTEM ELS USUARIS
        for (int i = 0; i < client.length; i++) {
            System.out.println(
                "Nom:" + client[i][0] +" " +
                "Cognom: " + client[i][1] +" " +
                "DNI: " + client[i][2] +" ");
        }
        //CONSULTEM DNI DE LA FACTURA
        String respUsuariFactura=lector.nextLine();
        //RECORREM ARRAY FINS A TROBAR EL DNI
        for (int i = 0; i < factura.length; i++) {
                if (factura[i][1].equals(respUsuariFactura)) { //QUAN EL TROBEM REALITZARA AIXÒ
                    String posicioModel=factura[i][2];
                    int posicioModelInt=Integer.parseInt(posicioModel);
                    System.out.println("Factures de usuari");
                    System.out.println(
                        "----------------------------------" +"\n"
                        +"ID Factura --> " +factura[i][0] +"\n"
                        +" " +"\n"
                        +"DNI usuari --> " +factura[i][1] +"\n"
                        +"Model --> " +model[posicioModelInt][1] +"\n"
                        +"----------------------------------"

                    );
                    System.out.println("");
                }
        }
    }

    public static void llistarUsuariID(String factura[][], String model[][]) {
        //LLISTEM LES FACTURES
        for (int i = 0; i < factura.length; i++) {   
            System.out.println("Factures de usuari");
            System.out.println(
                "----------------------------------" +"\n"
                +"ID Factura --> " +factura[i][0] +"\n"
                +"----------------------------------"

            );
            System.out.println("");
        }
        System.out.println("----------------------------------");
        System.out.println("Quina ID de factura vols llistar?");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        String respostaIDFactura=lector.nextLine();
        System.out.println("----------------------------------");
        for (int i = 0; i < factura.length; i++) {
            if (factura[i][0].equals(respostaIDFactura)) {
                String posicioModel=factura[i][2];
                int posicioModelInt=Integer.parseInt(posicioModel);
                System.out.println(
                        "ID Factura --> " +factura[i][0] +"\n"
                        +" " +"\n"
                        +"DNI usuari --> " +factura[i][1] +"\n"
                        +"Model --> " +model[posicioModelInt][1] +"\n"
                );
            }
        }
        System.out.println("----------------------------------");
    }

}
