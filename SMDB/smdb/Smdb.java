package smdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class Smdb {

    public static void main(String[] args) {
        String htmlContent = fetchDatabaseAsHtml();
        sendEmail(htmlContent);
    }

    private static String fetchDatabaseAsHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<h2>Database Report</h2>");
        html.append("<table border='1'><tr><th>ID</th><th>Name</th></tr>");

        try (Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=INV_Management;encrypt=true;trustServerCertificate=true;", "sa", "P@ssword@321");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name FROM USERS")) {

            while (rs.next()) {
                html.append("<tr>")
                    .append("<td>").append(rs.getInt("id")).append("</td>")
                    .append("<td>").append(rs.getString("name")).append("</td>")
                    .append("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        html.append("</table>");
        return html.toString();
    }

    private static void sendEmail(String htmlContent) {
        final String username = "naanthandaleoleo@gmail.com";
        final String password = "hmrfxgpnlrfdzdeb"; // No spaces

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("suriyamadhan46@gmail.com"));
            message.setSubject("Database Report");

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(htmlContent, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email sent.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
