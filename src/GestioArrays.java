/**
 * @author Roger Surroca
 * @version 1
 */
public class GestioArrays {
    // Client
    public static String[][] copiarArray(String client[][], String personaNov[][]) {
        for (int i = 0; i < client.length; i++) {
            for (int j = 0; j < client[i].length; j++) {
                personaNov[i][j] = client[i][j];
            }
        }
        return personaNov;
    }

    // Cotxes
    /**
     * Copeim les dues marques
     * @param marca
     * @param marcaNov
     * @return
     */
    public static String[][] copiarArrayMarca(String marca[][], String marcaNov[][]) {
        for (int i = 0; i < marca.length; i++) {
            for (int j = 0; j < marca[i].length; j++) {
                marcaNov[i][j] = marca[i][j];
            }
        }
        return marcaNov;
    }
    /**
     * Copiem els dos models
     * @param model 
     * @param modelNov
     * @return
     */
    public static String[][] copiarArrayModel(String model[][], String modelNov[][]) {
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length; j++) {
                modelNov[i][j] = model[i][j];
            }
        }
        return modelNov;
    }

    // Factura
    /**
     * Generem l'array auxiliar i l'incrementem usuari logejat
     * @param factura
     * @param respModel
     * @param DNIclient
     * @return
     */
    public static String[][] generarFactura(String factura[][], int respModel, String DNIclient, String client[][]) {
        String[][] facturaAux = new String[factura.length + 1][factura[0].length];
        for (int i = 0; i < factura.length; i++) {
            for (int j = 0; j < facturaAux[i].length; j++) {
                facturaAux[i][j] = factura[i][j];
            }
        }
        // INCREMENTEM L'ID DE LA FACTURA PER TAL DE QUE TINGUI EL SEU ID PROPI
        int incrementFactura = (Integer.parseInt(factura[factura.length - 1][0]) + 1);
        String assignarModel = String.valueOf(respModel);
        facturaAux[facturaAux.length - 1][0] = String.valueOf(incrementFactura);
        facturaAux[facturaAux.length - 1][1] = client[client.length -1][2];
        facturaAux[facturaAux.length - 1][2] = assignarModel;
        factura = facturaAux;
        return factura;
    }
    /**
     * Usuari no logejat
     * @param factura
     * @param respModel
     * @param DNIclient
     * @return
     */
    public static String[][] generarFacturaUR(String factura[][], int respModel, String DNIclient) {
        String[][] facturaAux = new String[factura.length + 1][factura[0].length];
        for (int i = 0; i < factura.length; i++) {
            for (int j = 0; j < facturaAux[i].length; j++) {
                facturaAux[i][j] = factura[i][j];
            }
        }
        // INCREMENTEM L'ID DE LA FACTURA PER TAL DE QUE TINGUI EL SEU ID PROPI
        int assignarModel = (Integer.parseInt(factura[factura.length - 1][0]) + 1);
        String respostaModel = String.valueOf(respModel);
        facturaAux[facturaAux.length - 1][0] = String.valueOf(assignarModel);
        facturaAux[facturaAux.length - 1][1] = DNIclient;
        facturaAux[facturaAux.length - 1][2] = respostaModel;
        factura = facturaAux;
        return factura;
    }
}
