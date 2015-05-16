package DAOS;

import DTOS.DiasDTO;
import DTOS.EventoDiaDTO;
import DTOS.InterfazCalendarioDTO;
import DTOS.MesDTO;
import Herramientas.CargadorDatos;
import Herramientas.EnlaceDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alangonzalez
 */
public class CalendarioDAO {

    private EnlaceDB enlace;
    private CargadorDatos cargador;

    public CalendarioDAO() {
        enlace = new EnlaceDB();
        cargador = new CargadorDatos();
    }

    /**
     * ALAN GOZANLEZ INTERFAZ CALENDARIO WEB esta es la funcion desencadenadora
     * del calendario
     *
     * @param anio
     * @return
     */
    public InterfazCalendarioDTO calendarioAnual(int anio) {
        InterfazCalendarioDTO calendarioAnual = new InterfazCalendarioDTO();
        calendarioAnual.setAnioNumero(anio);

        Vector meses = new Vector();

        for (int m = 1; m < 13; m++) {
            MesDTO mes = new MesDTO();
            mes.setNombreMes(this.nombreMes(m));
            mes.setNumeroMes(m);
            mes.setNumeroDiaInicio(this.diaInicioMes(anio, m));
            meses.add(mes);

            int numeroMaximoDias = this.numeroMaximoDiasMes(m, anio);
            Vector diasMes = new Vector();
            for (int d = 1; d < numeroMaximoDias + 1; d++) {
                DiasDTO dia = new DiasDTO();
                dia.setDia(d);
                diasMes.add(dia);
                String fechaSQL = anio + "-" + mes.getNumeroMes() + "-" + d;
                dia.setFechaSQL(fechaSQL);
                dia.setFechaEspanol(this.fechaEsp(anio, m, d));
            }
            mes.setDias(diasMes);

        }

        calendarioAnual.setMesesAnio(meses);

        return calendarioAnual;
    }

    /**
     * ALAN GONZALEZ DEVUELVE EL NOMBRE EN ESPAÑOL DE UN MES
     *
     * @param numeroMes
     * @return
     */
    public String nombreMes(int numeroMes) {
        String nombreCalendario = new String();
        switch (numeroMes) {
            case 1:
                nombreCalendario = "Enero";
                break;
            case 2:
                nombreCalendario = "Febrero";
                break;
            case 3:
                nombreCalendario = "Marzo";
                break;
            case 4:
                nombreCalendario = "Abril";
                break;
            case 5:
                nombreCalendario = "Mayo";
                break;
            case 6:
                nombreCalendario = "Junio";
                break;
            case 7:
                nombreCalendario = "Julio";
                break;
            case 8:
                nombreCalendario = "Agosto";
                break;
            case 9:
                nombreCalendario = "Septiembre";
                break;
            case 10:
                nombreCalendario = "Octubre";
                break;
            case 11:
                nombreCalendario = "Noviembre";
                break;
            case 12:
                nombreCalendario = "Diciembre";
                break;
        }
        return nombreCalendario;
    }

    /**
     * ALAN GONZALEZ DEVUELE EL NUMERO MAXIMO DE DIAS QUE TIENE EL MES DE UN AÑO
     * DETERMINADO
     *
     * @param numeroMes
     * @param numeroAnio
     * @return
     */
    public int numeroMaximoDiasMes(int numeroMes, int numeroAnio) {
        int numeroDiasMes = 0;

        //Calendar cal = new GregorianCalendar(numeroAnio, Calendar.JULY, 1);
        //numeroDiasMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        switch (numeroMes) {
            case 1:
                Calendar cal1 = new GregorianCalendar(numeroAnio, Calendar.JANUARY, 1);
                numeroDiasMes = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 2:
                Calendar cal2 = new GregorianCalendar(numeroAnio, Calendar.FEBRUARY, 1);
                numeroDiasMes = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 3:
                Calendar cal3 = new GregorianCalendar(numeroAnio, Calendar.MARCH, 1);
                numeroDiasMes = cal3.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 4:
                Calendar cal4 = new GregorianCalendar(numeroAnio, Calendar.APRIL, 1);
                numeroDiasMes = cal4.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 5:
                Calendar cal5 = new GregorianCalendar(numeroAnio, Calendar.MAY, 1);
                numeroDiasMes = cal5.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 6:
                Calendar cal6 = new GregorianCalendar(numeroAnio, Calendar.JUNE, 1);
                numeroDiasMes = cal6.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 7:
                Calendar cal7 = new GregorianCalendar(numeroAnio, Calendar.JULY, 1);
                numeroDiasMes = cal7.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 8:
                Calendar cal8 = new GregorianCalendar(numeroAnio, Calendar.AUGUST, 1);
                numeroDiasMes = cal8.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 9:
                Calendar cal9 = new GregorianCalendar(numeroAnio, Calendar.SEPTEMBER, 1);
                numeroDiasMes = cal9.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 10:
                Calendar cal10 = new GregorianCalendar(numeroAnio, Calendar.OCTOBER, 1);
                numeroDiasMes = cal10.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 11:
                Calendar cal11 = new GregorianCalendar(numeroAnio, Calendar.NOVEMBER, 1);
                numeroDiasMes = cal11.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
            case 12:
                Calendar cal12 = new GregorianCalendar(numeroAnio, Calendar.DECEMBER, 1);
                numeroDiasMes = cal12.getActualMaximum(Calendar.DAY_OF_MONTH);
                break;
        }
        return numeroDiasMes;
    }

    /**
     * ALAN GONZALEZ METODO PARA DEVOLVER EL DIA EXACTO DE INICIO DE CADA MES
     *
     * @param numeroMes
     * @return
     */
    public int diaInicioMes(int numeroAnio, int numeroMes) {
        int diaInicioMes = 0;
        String dateString = String.format("%d-%d-%d", numeroAnio, numeroMes, 1);
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
            String diaDeLaSemana = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
            diaInicioMes = this.numeroDia(diaDeLaSemana);
        } catch (ParseException ex) {
            Logger.getLogger(CalendarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diaInicioMes;
    }

    /**
     * ALAN GONZALEZ NOMBRE DIA FECHA
     *
     * @param anio
     * @param mes
     * @param dia
     * @return
     */
    public String nombreDiaEspanolxfecha(int anio, int mes, int dia) {
        String diaString = new String();
        String dateString = String.format("%d-%d-%d", anio, mes, dia);
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
            diaString = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
            diaString = this.nombreDiaEspanol(diaString);
        } catch (ParseException ex) {
            Logger.getLogger(CalendarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diaString;
    }

    /**
     * ALAN GONZALEZ TRADUCE DE INGLES A ESPANOL EL NOMBRE DE UN DIA CAMBIAR EL
     * TIPO DE DATO A UN DTO PARA LLEVAR TEXTO (NOMBRE DEL DIA ) Y NUMERO
     * RELATIVO
     *
     * @param ingles
     * @return
     */
    public String nombreDiaEspanol(String inglesDia) {
        String nombreEspanol = new String();
        if (inglesDia.equals("Monday")) {
            nombreEspanol = "Lunes";
        } else if (inglesDia.equals("Tuesday")) {
            nombreEspanol = "Martes";
        } else if (inglesDia.equals("Wednesday")) {
            nombreEspanol = "Miercoles";
        } else if (inglesDia.equals("Thursday")) {
            nombreEspanol = "Jueves";
        } else if (inglesDia.equals("Friday")) {
            nombreEspanol = "Viernes";
        } else if (inglesDia.equals("Saturday")) {
            nombreEspanol = "Sabado";
        } else if (inglesDia.equals("Sunday")) {
            nombreEspanol = "Domingo";
        }
        return nombreEspanol;
    }

    /**
     * alan gonzalez metodo que asigna una posicion numerica a cada dia con el
     * nombre del dia En ingles ejemplo Sunday = 0
     *
     * @param inglesDia
     * @return
     */
    public int numeroDia(String inglesDia) {
        //String nombreEspanol = new String();
        int numeroDia = 0;
        if (inglesDia.equals("Monday")) {
            numeroDia = 1;
        } else if (inglesDia.equals("Tuesday")) {
            numeroDia = 2;
        } else if (inglesDia.equals("Wednesday")) {
            numeroDia = 3;
        } else if (inglesDia.equals("Thursday")) {
            numeroDia = 4;
        } else if (inglesDia.equals("Friday")) {
            numeroDia = 5;
        } else if (inglesDia.equals("Saturday")) {
            numeroDia = 6;
        } else if (inglesDia.equals("Sunday")) {
            numeroDia = 0;
        }
        return numeroDia;
    }

    /**
     * ALAN GONZALEZ ESTE METODO GENERA UNA FECHA EN ESPAÑOL LEGIBLE AL USUARIO
     *
     * @param fechaSQL
     * @return
     */
    public String fechaEspanol(String fechaSQL) {
        String fechaEspanol = new String();
        StringTokenizer tokens = new StringTokenizer(fechaSQL, "-");

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
        }
        return fechaEspanol;
    }

    /**
     * ALAN METODO PARA REALIZAR FECHA EN ESPAÑOL
     *
     * @param anio
     * @param mes
     * @param dia
     * @return
     */
    public String fechaEsp(int anio, int mes, int dia) {
        String fechaEspanol = new String();
        fechaEspanol += this.nombreDiaEspanolxfecha(anio, mes, dia); // Lunes // martes
        fechaEspanol += " " + dia;
        fechaEspanol += "  De " + this.nombreMes(mes);
        fechaEspanol += "  Del " + anio;
        return fechaEspanol;
    }

    //  AQUI FINALIZA EL MOTOR DE CALENDARIO LIBRE DE SQL
    //  INICIO EL MOTOR DE DATOS DEL CALENDARIO DEMO
    // UNICAMENTE REGISTRO DE  EVENTOS 
    /**
     * ALAN reg
     *
     * @param titulo
     * @param descripcion
     */
    public void registroEventos(String titulo, String descripcion, String fecha) {

        String sql = "";

        sql += "  INSERT INTO eventos_calendario SET";
        sql += " eventos_calendario.titulo ='" + titulo + "', eventos_calendario.descripcion ='" + descripcion + "', eventos_calendario.fecha = '" + fecha + "';";
        enlace.openDatabase();
        enlace.execute(sql);
        enlace.closeDatabase();
    }

    /**
     * ALAN GONZALEZ Vector con todos los registros de eventos de un dia 
     *
     * @param fecha
     * @return
     */
    public Vector regstrosDia(String fecha) {
        Vector v = new Vector();
        String sql  = "  SELECT * FROM eventos_calendario WHERE eventos_calendario.fecha = '"+fecha+"' ";
        enlace.openDatabase();
        
        ResultSet rst = enlace.executeQuery(sql);
        
        try {
            while(rst.next()){
                EventoDiaDTO evt = new EventoDiaDTO();
                evt = cargador.eventoDiaDTO(rst);
                v.add(evt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalendarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CalendarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        enlace.closeDatabase();
        
        return v;
    }
    
    
    /**
     * alan gonzalez 
     * ejemplo de llamada a un procedimiento almacenado
     *  obteniendo un resultSet
     */
//    public void llamadaProcedimiento(){
//    
//    enlace.openDatabase();
//    String sql = " call minutaje;";
//    ResultSet rst = enlace.executeQuery(sql);
//        try {
//            if(rst.next()){
//                System.out.println("minutaje = " + rst.getString("minutaje"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CalendarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            rst.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CalendarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      enlace.closeDatabase();
//    }
}
