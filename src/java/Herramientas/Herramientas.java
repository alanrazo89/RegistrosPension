package Herramientas;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RandomStringUtils;

// org/apache/commons/collections/map/ReferenceMap
/**
 *
 * @author AlanGR
 */
public class Herramientas {

    /**
     * ALAN GONZALEZ - METODO QUE VALIDA SI UNA PALABRA ES UN PALINDROMO Y
     * DEVUELVE UNA VARIABLE DE TIPO BOLEANO
     *
     * @param palabra
     * @return
     */
    public Boolean palindromoCheck(String palabra) {
        Boolean bo = new Boolean(null);
        String palabraReves = "";
        for (int x = palabra.length() - 1; x >= 0; x--) {
            palabraReves = palabraReves + palabra.charAt(x);
        }
        if (palabraReves.equals(palabra)) {
            bo = true;
        } else {
            bo = false;
        }
        return bo;
    }

    /**
     * ALAN GONZALEZ simple metodo para generar un vector con anios en cuenta
     * regresiva se usa para crear combos dinamicos y no estar editando el jsp
     *
     * @return
     */
    public Vector aniosCombo() {
        Vector anios = new Vector();
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        // cargando de años el vector del combi dinamico
        int aux = 0;
        for (aux = año; aux >= 1950; aux--) {
            anios.add(aux);
        }
        return anios;
    }

    /**
     * ALAN GONZALEZ Simple Metodo para crear combos con dias
     *
     * @return
     */
    public Vector diasCombo() {
        Vector dias = new Vector();
        int aux = 1;
        for (aux = 1; aux <= 31; aux++) {
            int auxiliar = aux;
            dias.add(auxiliar);
        }
        System.out.println("DIAS EN EL VECTOR" + dias.size());
        return dias;
    }

    /**
     * Alan Gonzalez Metodo Para Encriptar cadena HASHING MD5
     *
     * @param cadenaOriginal
     * @return
     */
    public String encriptaMD5(String cadenaOriginal) {
        String cadenaEncriptada = new String();
        String md5 = null;
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(cadenaOriginal.getBytes(), 0, cadenaOriginal.length());
            //Converts message digest value in base 16 (hex) 
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }

    /**
     * ALAN GONZALEZ ESTE METODO SE UTILIZA PARA DESCOMPONER UNA CADENA EN UN
     * VECTOR QUE ALMACENA TODOS SUS CARACTERES
     *
     * @param cadena
     * @return
     */
    public Vector cadena_vector(String cadena) {
        Vector caracteres = new Vector();
        char[] car;
        car = cadena.toCharArray();
        int aux;
        for (aux = 0; aux < car.length; aux++) {
            caracteres.add(car[aux]);
        }
        return caracteres;
    }

    public String timeNow() {
        Calendar calendario = new GregorianCalendar();
        String time = new String();
        time = calendario.getTime().toString();
        return time;
    }

    /**
     * ALAN GONZALEZ METODO QUE DEVUELVE UNA CADENA ALFANUMERICA DE TAMAÑO
     * DETERMINADO EN EL PARAMETR HACE USO DE LIBRERIA APACHE COMONS LANG 3X
     *
     * @param tamaño
     * @return
     */
    public String cadenaAlfanumericaAleatoria(int tamaño) {
        String code = RandomStringUtils.randomAlphanumeric(tamaño);
        return code;
    }

    /**
     *
     * @param tamaño
     * @return
     */
    public String randomString(int tamaño) {
        String code = RandomStringUtils.randomAlphabetic(tamaño);
        return code;
    }

    /**
     * ALAN GONZALEZ METODO QUE DEVUELVE UN NUMERO ALEATORIO
     *
     * @param tamaño
     * @return
     */
    public int enteroAleatorio(int tamaño) {
        int aleatorio = 0;
        aleatorio = Integer.parseInt(RandomStringUtils.randomNumeric(tamaño));
        return aleatorio;
    }

    /**
     * ALAN GONZALEZ | METODO QUE DEVUELVE UNA STRING FORMATEADA EXPRESANDO UN
     * NUMERO
     *
     * @param x
     * @return
     */
    public String redondeaDecimales(double x) {
        String nFormateado = new String();
        DecimalFormat df = new DecimalFormat("0.00");
        nFormateado = df.format(x);
        return nFormateado;
    }

    /**
     * ALAN GONZALEZ REDONDENDEA UN DOUBLE Y LO DEJA CON UN NUMERO DETERMINADO
     * DE DECIMALES
     *
     * @param original
     * @param decimales
     * @return
     */
    public double dobleRedondeadoFormateado(double original, int decimales) {
        String nFormateado = new String();
        String concatDecimales = new String();
        for (int ct = 0; ct < decimales;) {
            concatDecimales += "0";
            ct++;
        }
        DecimalFormat df = new DecimalFormat("0." + concatDecimales);
        nFormateado = df.format(original);
        double dobleDato = Double.parseDouble(nFormateado);
        return dobleDato;
    }

    /**
     * ALAN GONZALEZ VALIDA SI EXIXTE ALGUN CARACTER ILEGAL EN LA CADENA
     *
     * @param cadena
     * @param caracteres
     * @return
     */
    public boolean validaTexto(String cadena, Vector caracteres) {
        boolean flag = new Boolean(false);
        for (int ct = 0; ct < caracteres.size();) {
            String caracter = (String) caracteres.elementAt(ct);
            if (!cadena.contains(caracter)) {
                ct++;
            } else {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    /**
     * ALAN GONZALEZ VALIDACION DE UN DATO DE TIPO ENTERO
     *
     * @param cadena // * @return //
     */
//    public boolean validaEntero(String cadena) {
//        boolean flag = true;
//        try {
//            Integer.parseInt(cadena);
//        } catch (NumberFormatException | NullPointerException number) {
//            return false;
//        }
//        return flag;
//    }
    /**
     * ALAN GONZALEZ VALIDA SI LA CADENA PUEDE SER UN DOUBLE
     *
     * @param cadena
     * @return //
     */
//    public boolean validaDoubles(String cadena) {
//        boolean flag = true;
//        try {
//            Double.parseDouble(cadena);
//        } catch (NumberFormatException | NullPointerException number) {
//            return false;
//        }
//        return flag;
//    }
    /**
     * ALAN GONZALEZ ELIMINA LOS ESPACIOS DE UNA CADENA Y LA REGRESA
     *
     * @param original
     * @return
     */
    public String eliminaEspacios(String original) {
        original = original.replace(" ", "");
        return original.trim();
    }

    /**
     *
     * @param cadenaOriginal
     * @return
     */
    public String eliminaCaracteresNoValidos(String cadenaOriginal) {
        String cadenaLimpia = new String();
        Vector caracteresIlegales = new Vector();
        caracteresIlegales.add(',');
        caracteresIlegales.add('\'');
        caracteresIlegales.add('!');
        caracteresIlegales.add('"');
        caracteresIlegales.add('$');
        caracteresIlegales.add('%');
        caracteresIlegales.add('&');
        caracteresIlegales.add('/');
        caracteresIlegales.add(')');
        caracteresIlegales.add('=');
        caracteresIlegales.add('?');
        caracteresIlegales.add('¡');
        caracteresIlegales.add('¿');
        caracteresIlegales.add(' ');
        for (int ct = 0; ct < caracteresIlegales.size(); ct++) {
            cadenaOriginal.replace(caracteresIlegales.elementAt(ct).toString(), "");
        }
        cadenaLimpia = cadenaOriginal.trim();
        return cadenaLimpia;
    }

    /**
     * alan gonzalez metodo para la validacion de un objeto generico
     *
     * @param object
     * @return
     */
    public String validaEntrdaString(Object object) {
        String cadena = new String();

        if (object != null) {
            cadena = this.eliminaCaracteresNoValidos(object.toString());
        } else if (object == null) {
            cadena = "";
        }

        return cadena;
    }

    /**
     * ALAN GONZALEZ VALIDA ENTERO
     *
     * // * @param object // * @return //
     */
//    public int validaEntradaEntero(Object object) {
//        int dato = 0;
//        boolean bandera = new Boolean(null);
//        if (object != null) {
//            bandera = this.validaEntero(object.toString());
//            if (bandera == true) {
//                dato = Integer.parseInt(object.toString());
//            } else {
//                dato = 0;
//            }
//        } else if (object == null) {
//            dato = 0;
//        }
//        return dato;
//    }
    public Vector caracteresIlegales() {

        Vector caracteresIlegales = new Vector();
        caracteresIlegales.add(',');
        caracteresIlegales.add('\'');
        caracteresIlegales.add('\'');
        caracteresIlegales.add('!');
        caracteresIlegales.add('"');
        caracteresIlegales.add('$');
        caracteresIlegales.add('%');
        caracteresIlegales.add('&');
        caracteresIlegales.add('/');
        caracteresIlegales.add(')');
        caracteresIlegales.add('=');
        caracteresIlegales.add('?');
        caracteresIlegales.add('¡');
        caracteresIlegales.add('¿');
        //caracteresIlegales.add(' ');

        return caracteresIlegales;
    }

    /**
     * ALAN GONZALEZ DETECTA CARACTERES ILEGALES Y RETORNA UN BOOLEAN FALSE NO
     * TIENE TRUE SI TIENE CARACTERES ILEGALES
     *
     * @return
     */
    public boolean detectarCaracteres(String cadenaOriginal) {
        boolean b = new Boolean(null);
        Vector caracteresIlegales = this.caracteresIlegales();

        for (int x = 0; x < caracteresIlegales.size(); x++) {
            if (cadenaOriginal.contains(caracteresIlegales().elementAt(x).toString())) {
                b = true;
                System.out.println(x + "corto actividad al item");
                break; // reviento el ciclo y regreso el valor asignado
            } else {
                b = false;
            }
        }
        return b;
    }

    public void mensajePruebas(String cadena) {

        System.out.println("***************** MESANJES DE PRUEBA *******************");
        System.out.println(".");
        System.out.println(cadena);
        System.out.println(".");
        System.out.println("********************************************************");
    }

    /**
     * alan gonzalez anio actual
     *
     * @return
     */
    public int anioActual() {
        int anioActual = 0;

        //Calendar c = Calendar.getInstance();
        Calendar c = new GregorianCalendar();

        //dia = Integer.toString(c.get(Calendar.DATE));
        //mes = Integer.toString(c.get(Calendar.MONTH));
        anioActual = c.get(Calendar.YEAR);
        return anioActual;
    }

    
    /**
     * ALAN GONZALEZ VALIDA UN EMAIL 
     * @param mail
     * @return 
     */
    public Boolean validarMail(String mail) {
        Boolean b = new Boolean(null);

        Pattern Plantilla = null;
        Matcher Resultado = null;
        Plantilla = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");

        Resultado = Plantilla.matcher(mail);
        if (Resultado.find() == true) {
            b = true; // mail correcto
        } else {
            b=false;  // mail incorrecto
        }

        return b;
    }

}
