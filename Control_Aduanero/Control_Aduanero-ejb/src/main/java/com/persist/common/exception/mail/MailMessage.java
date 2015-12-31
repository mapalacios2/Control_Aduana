/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persist.common.exception.mail;

import java.io.Serializable;

/**
 *
 * @author Henry Coral
 */
public class MailMessage implements Serializable {

    /**
     * La constante serialVersionUID respresenta .
     */
    private static final long serialVersionUID = -7494867783508203619L;
    /**
     * La propiedad asunto que representa a Asunto.
     */
    private String asunto;
    /**
     * La propiedad mensaje que representa a Mensaje.
     */
    private String mensaje;

    /**
     * Obtiene el asunto se relaciona con la columna .
     *
     * @return el asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Asigna asunto, se relaciona con la columna .
     *
     * @param asunto el valor a ser asignado a asunto
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Obtiene el mensaje se relaciona con la columna .
     *
     * @return el mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Asigna mensaje, se relaciona con la columna .
     *
     * @param mensaje el valor a ser asignado a mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
