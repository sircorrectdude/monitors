package com.evodat.webapp.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;


public class WiesnEmailServlet extends HttpServlet {


    String protocol = "imap";
    String host = "wp12312692.mail.server-he.de";
    String port = "993";
    String userName = "wp12312692-resauto";
    String password = "%2022Wiesn!$";

    /**
     * Returns a Properties object which is configured for a POP3/IMAP server
     *
     * @param protocol either "imap" or "pop3"
     * @param host
     * @param port
     * @return a Properties object
     */
    private Properties getServerProperties(String protocol, String host,
                                           String port) {
        Properties properties = new Properties();

        // server setting
        properties.put(String.format("mail.%s.host", protocol), host);
        properties.put(String.format("mail.%s.port", protocol), port);

        // SSL setting
        properties.put("mail.imap.ssl.protocols", "TLSv1.2");
        properties.setProperty(
                String.format("mail.%s.socketFactory.class", protocol),
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty(
                String.format("mail.%s.socketFactory.fallback", protocol),
                "false");
        properties.setProperty(
                String.format("mail.%s.socketFactory.port", protocol),
                String.valueOf(port));

        return properties;
    }

    /**
     * Downloads new messages and fetches details for each message.
     *
     * @return
     */
    public List<List<String>> downloadEmails(Date since) {
        Properties properties = getServerProperties(protocol, host, port);
        Session session = Session.getDefaultInstance(properties);

        try {
            // connects to the message store
            Store store = session.getStore(protocol);
            store.connect(userName, password);

            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            // fetches new messages from server
            Message[] messages = folderInbox.getMessages();

            List<List<String>> dataLines = new ArrayList<>();

            for (int i = 0; i < messages.length; i++) {
                List<String> dataLine = new ArrayList<String>();

                Message msg = messages[i];
                Address[] fromAddress = msg.getFrom();
                String from = fromAddress[0].toString();
                String subject = msg.getSubject();
                String toList = parseAddresses(msg
                        .getRecipients(RecipientType.TO));
                String ccList = parseAddresses(msg
                        .getRecipients(RecipientType.CC));
                String sentDate = msg.getSentDate().toString();
                if (null != since) {
                    try {
                        if (since.after(new SimpleDateFormat("EE MMM dd HH:mm:ss zzzz yyyy", Locale.US).parse(sentDate))) {
                            continue;
                        }
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
                String contentType = msg.getContentType();
                String messageContent = "";

                if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
                    try {
                        Object content = msg.getContent();
                        if (content != null) {
                            messageContent = content.toString();
                        }
                    } catch (Exception ex) {
                        messageContent = "[Error downloading content]";
                        ex.printStackTrace();
                    }
                }

                // print out details of each message
                System.out.println("Message #" + (i + 1) + ":");
                dataLine.add(String.valueOf(i + 1));
//                System.out.println("\t From: " + from);
//                dataLine.add(from);
//                System.out.println("\t To: " + toList);
//                dataLine.add(toList);
//                System.out.println("\t CC: " + ccList);
//                dataLine.add(ccList);
//                System.out.println("\t Subject: " + subject);
                dataLine.add(subject);
//                System.out.println("\t Sent Date: " + sentDate);
                dataLine.add(sentDate);
//                System.out.println("\t Message: " + messageContent);

                dataLine.add(extract("Anfrage::", messageContent));
                dataLine.add(extract("Personen::", messageContent));
                dataLine.add(extract("Datum::", messageContent));
                dataLine.add(extract("Privat-geschaeftlich:", messageContent));
                dataLine.add(extract("Firma::", messageContent));
                dataLine.add(extract("Anrede:", messageContent));
                dataLine.add(extract("Vorname::", messageContent));
                dataLine.add(extract("Nachname::", messageContent));
                dataLine.add(extract("E-Mail::", messageContent));
                dataLine.add(extract("Telefon::", messageContent));
                dataLine.add(extractBem("Bemerkung::", messageContent));
                dataLine.add(extract("Abg:", messageContent));
                dataLine.add(extract("Datenschutz:", messageContent));
                dataLines.add(dataLine);
            }
            // disconnect
            folderInbox.close(false);
            store.close();
            return dataLines;
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider for protocol: " + protocol);
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store");
            ex.printStackTrace();
        }
        return null;
    }

    private String extract(String term, String messageContent) {
        Pattern pattern = Pattern.compile(".*" + term + "\\s*([^\\n]*)\\n.*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(messageContent);
        if (matcher.matches()) {
            String group = matcher.group(1);
            group = group.replaceAll("\n", "").replaceAll("\r\n", "").replaceAll("\r", "");
//            System.out.println("\t "+term+": " + group);
            return group;
        }
        return "";
    }

    public String extractBem(String term, String messageContent) {
        Pattern pattern = Pattern.compile(".*" + term + "\\s*([^(> Abg)].*)> Abg:.*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(messageContent);
        if (matcher.matches()) {
            String group = matcher.group(1);
            group = group.replaceAll("\n", "").replaceAll("\r\n", "").replaceAll("\r", "");
            System.out.println("\t " + term + ": " + group);
            return group;
        }
        return "";
    }

    /**
     * Returns a list of addresses in String format separated by comma
     *
     * @param address an array of Address objects
     * @return a string represents a list of addresses
     */
    private String parseAddresses(Address[] address) {
        String listAddress = "";

        if (address != null) {
            for (int i = 0; i < address.length; i++) {
                listAddress += address[i].toString() + ", ";
            }
        }
        if (listAddress.length() > 1) {
            listAddress = listAddress.substring(0, listAddress.length() - 2);
        }

        return listAddress;
    }


    public String convertToCSV(List<String> data) {
        StringBuffer line = new StringBuffer();
        for (String str : data) {
            line.append(str).append(",");
        }
        return line.toString();
//        return data.stream()
//                .map(this::escapeSpecialCharacters)
////                .map()
//                .collect(Collectors.joining(","));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        Date since = null;
        String from_timestamp = req.getParameter("from");
        if (null != from_timestamp) {
            try {
                since = new SimpleDateFormat("yyyyMMddhhmmss").parse(from_timestamp);
            } catch (ParseException e) {
                resp.setHeader("Content-type", "text/plain");
                out.write("invalid timestamp: " + from_timestamp);
                out.write("timestamp format is: yyyyMMddhhmmss " + from_timestamp);
            }
        }
//        downloadEmails(protocol, host, port, userName, password).stream()
//                .map(this::convertToCSV)
//                .forEach(System.out::println);

        List<List<String>> lines = downloadEmails(since);

        StringBuffer buffer = new StringBuffer();

        for (List<String> list : lines) {
            for (String s : list) {
                buffer.append(s);
                buffer.append(";");
            }
            buffer.append("\n");
        }
        String csv = buffer.toString();
        resp.setHeader("Content-Type", "text/csv");
        String filename ="emaildata";
        if(from_timestamp != null){
            filename = filename+"_von_"+from_timestamp;
        }
        filename = filename+"_bis_"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        resp.setHeader("Content-Disposition", "attachment;filename=\"" + filename + ".csv\"");
        resp.setCharacterEncoding("UTF-8");
        out.write(csv);
        out.flush();
        out.close();

    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

}
