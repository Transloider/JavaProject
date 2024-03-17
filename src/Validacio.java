public class Validacio {
        private final static String DNI_Validator= "^([0-9]{8})([A-Z])$";
        private final static String nom_Validator= "^[A-Z][a-z]{2,14}$";

        public static boolean DNI_Validator(String DNI){
            return DNI.matches(DNI_Validator);
        }
        public static boolean nom_Validator(String nom){
            return nom.matches(nom_Validator);
        }
}
