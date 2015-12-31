/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persist.common.exception.mail;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

/**
 *
 * @author Henry Coral
 */
@Stateless
public class MessageSender {

    @Resource(name = "mail/aduana")
    private Session mailSession;
    /**
     * Direcciones de correo electr�nico a quienes va dirigido el mensaje.
     */
    protected List<Address> to = new ArrayList<Address>();
    /**
     * Direcciones de correo electr�nico a quienes va dirigido como copia el
     * mensaje.
     */
    protected List<Address> cc = new ArrayList<Address>();
    /**
     * Direcciones de correo electr�nico a quienes va dirigido como copia oculta
     * el mensaje.
     */
    protected List<Address> bcc = new ArrayList<Address>();
    /**
     * Direcci�n de correo electr�nico desde la cual se env�a el correo.
     */
    protected String from = "mapalacios235@gmail.com";
    /**
     * Asunto del correo electr�nico.
     */
    protected String subject;
    
    public void init() {
        this.bcc = new ArrayList<Address>();
        this.to = new ArrayList<Address>();
        this.cc = new ArrayList<Address>();
        this.subject = "";
        
    }

    /**
     * M�todo a ser implementado por las clases hijas que contiene la l�gica de
     * env�o del mensaje.
     *
     * @param mailMessage Mensaje a ser enviado.
     */
    @Asynchronous
    public void send(MailMessage mailMessage) {
        try {
            InitialContext ctx = new InitialContext();  
            Session session = (Session) ctx.lookup("mail/veterinaria");  
            
            Message simpleMessage = new MimeMessage(session);
            if (!this.to.isEmpty()) {
                simpleMessage.addRecipients(Message.RecipientType.TO, this.getTo());
            }
            if (!this.cc.isEmpty()) {
                simpleMessage.addRecipients(Message.RecipientType.CC, this.getTo());
            }
            if (!this.bcc.isEmpty()) {
                simpleMessage.addRecipients(Message.RecipientType.BCC, this.getTo());
            }
            simpleMessage.setSubject(mailMessage.getAsunto());
            simpleMessage.setText(mailMessage.getMensaje());
            simpleMessage.setFrom(new InternetAddress(this.from));
            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            System.err.println("Error en la preparacion o envio del mail..: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception v) {
            System.err.println(v.getMessage());
        }
    }

    /**
     * Asigna los destinatarios del mensaje.
     *
     * @param to Arreglo de direcciones de destinatarios.
     */
    public void setTo(String[] to) {
        this.to.clear();
        this.bcc.clear();
        this.cc.clear();
        for (String addressTo : to) {
            this.addAddress(Message.RecipientType.TO, addressTo);
        }
    }

    /**
     * Asigna un destinatario al mensaje.
     *
     * @param to Direcci�n del destinatario.
     */
    public void setTo(String to) {
        this.to.clear();
        this.bcc.clear();
        this.cc.clear();
        this.addAddress(Message.RecipientType.TO, to);
    }

    /**
     * Agrega un destinatario al mensaje.
     *
     * @param to Direcci�n del destinatario.
     */
    public void addTo(String to) {
        this.addAddress(Message.RecipientType.TO, to);
    }
    
    /**
     * Agrega un destinatario al mensaje.
     *
     * @param to Direcci�n del destinatario.
     */
    public void addBcc(String to) {
        this.addAddress(Message.RecipientType.BCC, to);
    }

    /**
     * Asigna el remitente del mensaje.
     *
     * @param from Direcci�n del remitente.
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Asigna el asunto del mensaje.
     *
     * @param subject Asunto del mensaje.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Session getMailSession() {
        return mailSession;
    }

    public Address[] getTo() {
        return (Address[]) this.to.toArray(new Address[to.size()]);
    }

    private void addAddress(Message.RecipientType rt, String address) {
        try {
            if (Message.RecipientType.TO.equals(rt)) {
                to.add(new InternetAddress(address));
            } else if (Message.RecipientType.CC.equals(rt)) {
                cc.add(new InternetAddress(address));
            } else {
                bcc.add(new InternetAddress(address));
            }
        } catch (AddressException ae) {
            System.err.println("Error al agregar la dirección: " + address + ", " + ae.getMessage());
        }
    }
}
