import java.util.Scanner;

public class GestioCotxe {
    private static Scanner lector = new Scanner(System.in);

    public static int triarMarca(String marca[][], int respCotxe){
        System.out.println("----------------------------------");
        System.out.println("Llista de marques que tenim disponibles");
        for (int i = 0; i < marca.length; i++) {
            System.out.println(
                i +" " +"|Marca: " +marca[i][1]);
            System.out.println("");
        }
        //PREGUNTEM QUIN MODEL ENS INTERESSA EN CONCRET
        System.out.println("----------------------------------");
        System.out.println("Quina marca t'interessa?");
        respCotxe=lector.nextInt();
        //MOSTREM EL MODEL SELECCIONAT
        System.out.println("----------------------------------");
        System.out.println("Has seleccionat la marca --> " +marca[respCotxe][1]);
        System.out.println("----------------------------------");
        return respCotxe;
    }

    public static int triarModel(String model[][],int respModel, int respCotxe){
                //SOLICITEM INFROMACIÓ RESPECTE EL VEHICLE
        System.out.println("----------------------------------");
        System.out.println("Llista dels models");
        //TRANSFORMACIO RESPOSTA A TIPUS STRING PER TAL DE PODER MOSTRAR ELS VEHICLES QUE PERTANYEN AL GRUP INDICAT
        String buscarModel=Integer.toString(respCotxe);
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length; j++) {
                if (model[i][j].equals(buscarModel)) {
                System.out.println(
                    +i +"|Model: " +model[i][1] +"\n"
                    +" |Preu: " +model[i][3]);
                    System.out.println("");
                }
            }

        }
        System.out.println("----------------------------------");
        System.out.println("Quin model t'interessa");
        respModel=lector.nextInt();
        lector.nextLine();

        System.out.println("----------------------------------");
        System.out.println("Has seleccionat el model --> " +model[respModel][1]);
        System.out.println("----------------------------------");
        return respModel;
    }

    public static String[][] afegirMarca(String marca[][]){
        System.out.println("----------------------------------");
        //LLISTEM TOTES LES MARQU2ES ACTUALS
        for (int i = 0; i < marca.length; i++) {
            for (int j = 0; j < marca[i].length-1; j++) {
                System.out.print(i +" | Marca --> " +marca[i][1]);
            }
            System.out.println();
        }

        //GURADEM VALOR DEL NOU ARRAY I L'OMPLIM
        String[][] marcaNov= new String [marca.length +1][marca[0].length];
        marcaNov=GestioArrays.copiarArrayMarca(marca, marcaNov);

        //GUARDEM EL VALOR INSERIT PER L'USUARI DINS
        System.out.println("----------------------------------");
        System.out.println("Escriu la nova marca");
        System.out.println("----------------------------------");
        marcaNov[marcaNov.length-1][1]=lector.nextLine();
        System.out.println("----------------------------------");
        marca=marcaNov;
        //LLISTEM TOTES LES MARQUES PER TAL DE MOSTRAR LA NOVA QUE ACABEM DE CREAR
        for (int i = 0; i < marca.length; i++) {
            for (int j = 0; j < marca[i].length-1; j++) {
                System.out.print(i +" | Marca --> " +marca[i][1]);
            }
            System.out.println();
        }
        return marca;
    }

    public static String[][] modificarMarca(String[][] marca){
        //LLISTEM MARQUES
        System.out.println("----------------------------------");
        for (int i = 0; i < marca.length; i++) {
            for (int j = 0; j < marca[i].length-1; j++) {
                System.out.print(i +" | Marca --> " +marca[i][1]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
        System.out.println("Quina marca vols modificar?");
        System.out.println("----------------------------------");
        int marcaModificar=lector.nextInt();
        lector.nextLine();
        System.out.println("----------------------------------");
        System.out.println("Escriu el nou nom de la marca");
        marca[marcaModificar][1]=lector.nextLine();
        System.out.println("----------------------------------");
        //LLISTEM TOTES LES MARQUES
        for (int i = 0; i < marca.length; i++) {
            for (int j = 0; j < marca[i].length-1; j++) {
                System.out.print(i +" | Marca --> " +marca[i][1]);
            }
            System.out.println();
        }
        return marca;
    }

    public static String[][] afegirModel(String model[][]){
        //LLISTEM TOTs ELS MODELS ACTUALS
        System.out.println("----------------------------------");
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length-2; j++) {
                System.out.print(model[i][0] +" | Model --> " +model[i][1]);
            }
            System.out.println();
        }
        
        //GURADEM VALOR DEL NOU ARRAY I L'OMPLIM
        String[][] modelNov= new String [model.length +1][model[0].length];
        modelNov=GestioArrays.copiarArrayModel(model, modelNov);
        //GUARDEM EL VALOR INSERIT PER L'USUARI DINS
        System.out.println("----------------------------------");
        System.out.println("Escriu el grup");
        System.out.println("----------------------------------");
        modelNov[modelNov.length-1][0]=lector.nextLine();
        System.out.println("----------------------------------");
        System.out.println("Escriu el nou model");
        System.out.println("----------------------------------");
        modelNov[modelNov.length-1][1]=lector.nextLine();
        System.out.println("----------------------------------");
        System.out.println("Escriu el número de bastidor");
        System.out.println("----------------------------------");
        modelNov[modelNov.length-1][2]=lector.nextLine();
        System.out.println("----------------------------------");
        System.out.println("Escriu el preu");
        System.out.println("----------------------------------");
        modelNov[modelNov.length-1][3]=lector.nextLine();
        model=modelNov;
        return model;
    }

    public static String[][] modificarModel(String model[][]){
        System.out.println("Tria quin model vols modificar");
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length-2; j++) {
                System.out.print(model[i][0] +" | Model --> " +model[i][1]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        int modelModificació=lector.nextInt();
        System.out.println("Quin grup vols que estigui");
        lector.nextLine();
        model[modelModificació][0]=lector.nextLine();
        System.out.println("Quin és el nou model");
        model[modelModificació][1]=lector.nextLine();
        System.out.println("Quin és el número de bastidor");
        model[modelModificació][2]=lector.nextLine();
        System.out.println("Quin és el preu");
        model[modelModificació][3]=lector.nextLine();
        System.out.println("----------------------------------");
        System.out.println("Nova llista models");
        System.out.println("----------------------------------");
        
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length-2; j++) {
                System.out.print( i +" | Grup --> " +model[i][0] +" | Model --> " +model[i][1]);
            }
            System.out.println();
        }
        return model;
    }
    public static String[][] generarFacturaUR(String factura[][], int respModel, String DNIclient){
        String [][] facturaAux = new String[factura.length +1][factura[0].length];
        for (int i = 0; i < factura.length; i++) {
            for (int j = 0; j < facturaAux[i].length; j++) {
                facturaAux[i][j]=factura[i][j];
            }
        }
        //INCREMENTEM L'ID DE LA FACTURA PER TAL DE QUE TINGUI EL SEU ID PROPI
        int assignarModel=(Integer.parseInt(factura[factura.length-1][0])+1);
        String respostaModel=String.valueOf(respModel);
        facturaAux[facturaAux.length-1][0]=String.valueOf(assignarModel);
        facturaAux[facturaAux.length-1][1]=DNIclient;
        facturaAux[facturaAux.length-1][2]=respostaModel;
        factura=facturaAux;
        return factura;
    }

}
