package Herramientas;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailMotor {

    //  ESTE EMAIL QUE SE UTILIZARA COMO USUARIO DURANTE LA AUTENTIFICACION SMTP
    String EMAIL = "programacion2@pare.com.mx";
    //String EMAIL = "developer.alan89@gmail.com"; 
    // El password del correo dedicado al sistema 
    private static final String PASSWORD = "pare170315";  //"adminsys";
    // El servidor smtp 
    private static final String SERVIDOR = "mail.pare.com.mx";
    // Transpor Layer security activado
    private static final String STARTTLS = "true";
    // El puerto de envio de correos del servidor de correos  
    private static final String PUERTO = "587";
    // Autentificacion del servidor activada 
    private static final String AUTH = "true";
    // VARIABLE DE SESION EMAIL
    private Session session;

    public MailMotor() {
        Properties props = new Properties();
        //--> Nombre del host de correo, es smtp.gmail.com  
        props.setProperty("mail.smtp.host", SERVIDOR);
        // TLS si está disponible  
        props.setProperty("mail.smtp.starttls.enable", STARTTLS);
        // Puerto de gmail para envio de correos  
        props.setProperty("mail.smtp.port", PUERTO);
        // Nombre del usuario  
        props.setProperty("mail.smtp.user", EMAIL);
        // Si requiere o no usuario y password para conectarse.  
        props.setProperty("mail.smtp.auth", AUTH);
        // Se inicia una nueva sesion  
        session = Session.getDefaultInstance(props);
    }

    /**
     * ALAN GONZALEZ LE ENVIAL AL CLIENTE << MAIL REGISTRADO >> SU CLAVE
     * @param destinoRegistrado
     * @param asunto
     * @param mensaje 
     */
    public void mailRegistroCliente(String destinoRegistrado, String asunto, String mensaje) {
        try {

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(destinoRegistrado));
            mimeMessage.setSubject(asunto);
            mimeMessage.setText(mensaje);
            mimeMessage.setFrom(new InternetAddress("programacion2@pare.com.mx"));
            Transport t = session.getTransport("smtp");
            t.connect(EMAIL, PASSWORD);
            t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            t.close();

        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
