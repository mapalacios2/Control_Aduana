/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.util;

/**
 *
 * @author Pancho
 */
public class GeneradorClaves {

    public static String NUMEROS = "0123456789";

    public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    
    public static String getClave() {
        return getClave(8);
    }

    public static String getClave(int length) {
        return getClave(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
    }

    public static String getClave(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }
        return pswd;
    }
}
