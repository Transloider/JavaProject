import java.util.Scanner;

public class Index {
    /**
     * @Transloider
     * Aquest és l'index
     * @param args
     */
    public static void main(String[] args) {

        String[][] client = {
            { "roger", "surroca", "435642D" },
            { "yasser", "Zuaki", "2413132S"} ,
            { "sergi", "ailuaguas", "243543K" },
            };
        String[][] factura = { //"ID DE LA FACTURA" "DNI D'USUARI" "MODEL DE COTXE"
            { "1", "435642D","2"},
            { "2", "435642D","1"},
            { "3", "2413132S","8"},

        };
        String[][] model= {
            { "0","Mercedes Benz Classe E","3881BMG", "30000"},
            { "0","Mercedes Benz Classe G","6130DKG", "35000"},
            { "0","Mercedes GLA","6130DKG", "45000"},
            { "1","BMW Serie 3","6130DKG", "65000"},
            { "1","BMW X1","34523JG", "57000"},
            { "1","BMW i4","32512KG", "38000"},
            { "2","Audi A1","9579DKG", "46000"},
            { "2","Audi A2","0932DKG", "42000"},
            { "2","Audi A3","3627DKG", "39000"},
            { "3","Citroën Picasso","0932MBH", "20000", },
            { "3","Citroën C3","6075DNF", "25000"} ,
            { "3","Citroën C4 X","5843CNJ", "45000"},
        };
        String[][] marca= {
            { "0","Mercedes"},
            { "1","BMW"} ,
            { "2","Audi"},
            { "3","Citroën"},
        };
        //INICIEM SCANNER
        Scanner lector= new Scanner(System.in);
        //Inici del blucle
        String DNIclient="";
        int respBenvinguda=4;
        //AQUEST CAMP ES INSERIT PERQUÈ EN EL CAS QUE L'USUARI NO SIGUI NOU HO PODRE SAPIGUER A L'HORA DE REALITZAR LA FACTURA
        int nouUsuari=0;
        int respostaPreg=0;
        //ASSIGNEM AQUEST PARÀMETRE PER ASSEGURAR QUE A L'HORA DE GENERAR LA FACTURA COM A MÍNIM HI HAGI UN COTXE
        int respCotxe=100, respModel=0;
        //
        //AQUESTA VARIABLE ÉS SIMPLEMENT PK AIXÍ M'EN PUC ASSEGURAR QUE A L'HORA DE REALITZAR LA FACTURA, L'USUARI ESTIGUI LOGEJAT
        int habilitarFactura=0;
        do{
            do {
            //CREACIÓ DEL PRIMER MENÚ  
            /**
             * @param Mostrem el menú inicial
             */
            Menus.menuInicial();
            respostaPreg=lector.nextInt();
            lector.nextLine();
            //OMPLIM LA INFORMACIÓ DE L'USUARI 
            switch (respostaPreg) {
                case 1:
                //MENU OPCIONS
                Menus.menuUsuaris();
                respBenvinguda=lector.nextInt();
                lector.nextLine();
                /**
                 * @param Inicialitzem el menu d'opcions d'usuari
                 * 
                 * 
                 */
                    switch (respBenvinguda) {
                        case 1://EN EL CAS QUE L'USUARI ES VULGUI REGISTRAR PER PRIMERA VEGADA
                                //INGRESSEM EL NOM I COGNOM DE L'USUARI
                                client=GestioClients.afegirClient(client, DNIclient, lector);
                                //EN CAS QUE AQUEST VALOR SIGUI 1 A L'HORA DE GENERAR LA FACTURA PODRÉ VALORAR SI L'USUARI HA CREAT O INICIAT SESSIÓ
                                nouUsuari=1;
                                habilitarFactura=1;
                            break;
                        
                        
                        case 2: //USUARI JA TINGUI UN COMPTE
                                /**
                                 * @param Inici sessio usuari ja registrat
                                 */
                                DNIclient=GestioClients.afegirClientRegistrat(client, DNIclient);
                                habilitarFactura=1;
                            break;
                        
                        case 3: //MODIFICACIÓ D'USUARIS
                            /**
                             * @param modificació usuaris
                             */
                            GestioClients.modificarUsuaris(client);
                        break;
                        case 4: //LLISTEM TOTS ELS USUARIS
                            /**
                             * Llistem tots els usuaris
                             */
                            GestioClients.llistarUsuaris(client);
                        break;
                        default:
                                System.out.println("Introdueix un valor vàlid");
                                respBenvinguda=4;
                        break;
                        }
                    break;

                case 2://SELECCIO DE COTXE
                if (habilitarFactura==1) {
                        /**
                         *  @param PRIMER MOSTREM ELS MODELS DISPONIBLES ACTUALMENT
                         */
                        respCotxe=GestioCotxe.triarMarca(marca, respCotxe);
                        respModel=GestioCotxe.triarModel(model, respModel, respCotxe);

                    } else {
                        System.out.println("----------------------------------");
                        System.out.println("Primer has de seleccionar l'usuari!");
                    }
                    break;
                

                case 3: /** @param PERSONALITZACIO DE MARCA O MODEL */
                    //PREGUNTA DE SI QUÈ ES VOL FER AFEGIR O ELIMINAR
                    Menus.menuVehicles();
                    int respostaMod=lector.nextInt();
                    lector.nextLine();
                    switch (respostaMod) {

                        case 1: //AFEGIR LA NOVA MARCA
                            marca=GestioCotxe.afegirMarca(marca);
                        break;
                        case 2: //MODIFICAR MARCA
                            marca=GestioCotxe.modificarMarca(marca);
                        break;
                        case 3: //AFEGIM ELS MODELS
                            model=GestioCotxe.afegirModel(model);
                        break;
                        case 4: //MODIFICAR MODEL EN CONCRET
                            model=GestioCotxe.modificarModel(model);
                        break;
                        case 5: //TORNAR AL MENÚ INICIAL
                            System.out.println("----------------------------------");
                            System.out.println("Tornant al menú inicial..");
                            System.out.println("----------------------------------");
                        break;
                  default: //OPCIÓ PER DEFECTE
                            System.out.println("El valor inserit no és correcte");
                            break;
                    } break;

                case 4: /** @param GENEREM LA FACTURA */
                    Menus.menuFactures();
                    int respostaFactura=lector.nextInt();
                    switch (respostaFactura) {
                        case 1: //GUARDEM LA FACTURA DE L'USUARI
                            if (habilitarFactura==1) {
                                if (respCotxe!=100) {
                                    if (nouUsuari==1) { //EN EL CAS QUE L'USUARI INICI SESSIÓ

                                        //RECOPILACIÓ D'INFORMACIÓ
                                        Menus.facturaTotalUNR(client, marca, model, respCotxe, respModel);

                                        //EMMAGATZAMEM FACTURA
                                        factura=GestioArrays.generarFactura(factura, respModel, DNIclient, client);

                                        //RESTAUREM VALORS PER DEFECTE
                                        habilitarFactura=0;
                                        respCotxe=100;
                                        nouUsuari=0;
                                    } else {     //EN CAS QUE USUARI JA TINGUI LA SESSIÓ INICIADA

                                        //RECOPILACIÓ D'INFORMACIÓ
                                        Menus.facturaTotalUNR(client, marca, model, respCotxe, respModel);

                                        //EMMAGATZAMEM FACTURA
                                        factura=GestioArrays.generarFacturaUR(factura, respModel, DNIclient);

                                        //RESTAUREM VALORS PER DEFECTE
                                        habilitarFactura=0;
                                        respCotxe=100;
                                    }
                                } else { //RESTRICCIÓ QUE MODEL ESTIGUI SELECCIONAT
                                    System.out.println("Has de seleccionar el model que vols!");
                                }
                            }else { //RESTRICCIÓ QUE USUARI ESTIGUI SELECCIONAT
                                System.out.println("Primer has de seleccionar l'usuari!");
                            }
                        break;

                        case 2: /** @param Llistem totes les factures existents */
                            GestioFactura.llistarFactura(factura);
                        break;

                        case 3: /** @param LLISTEM USUARI EN CONCRET */
                            GestioFactura.llistarUsuariConcret(factura,model,client);
                        break;

                        case 4: /** @param LLISTEM FACTURA EN CONCRET MITJANÇANT LA SEVA ID */
                            GestioFactura.llistarUsuariID(factura,model);
                        break;
                        
                        default:
                            System.out.println("Siusplau introdueix un valor vàlid!");
                        break;
                    }
                break;
                case 0: /** @param FINALITZAR EL PROGRAMA */
                    System.out.println("Fins un altre!");
                break;
                default://EN CAS QUE EN EL MENÚ INICIAL ESCRIBIM ALGUNA COSA MALAMENT
                    System.out.println("Siusplau, introdueix un valor vàlid dels que se t'indica anteriorment");
                    
                break;
                } 
                //TANQUEM EL PRIMER BUCLE
            } while (respostaPreg != 0);
            //TQUEM EL SEGON BUCLE
        } while (respostaPreg !=0);
        lector.close();
    }
}