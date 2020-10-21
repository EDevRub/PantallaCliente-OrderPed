/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edunaldo
 */
public class DateUtils {

    private static SimpleDateFormat formatter;

    static {
        formatter = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
    }

    public static Date transformDate(String raw_date) {
        
        try {
            return formatter.parse(raw_date);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static String tranformString(Date raw_date) {
        return formatter.format(raw_date);
    }

}
