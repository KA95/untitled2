package com.springapp.service;

import com.springapp.print.PrintingTask;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.text.MessageFormat;

@Service
public class PrintingService{

    private void print(MessageFormat header,MessageFormat footer) {//GEN-FIRST:event_print
        PrintingTask task = new PrintingTask(header, footer,text,printerName);
        task.execute();
    }

    private MessageFormat createFormat(String text) {
        if (text != null && text.length() > 0) {
            try {
                return new MessageFormat(text);
            } catch (IllegalArgumentException e) {
                error("Sorry, this format is invalid.");
            }
        }
        return null;
    }

    public static void message(boolean error, String msg) {
        if(error) {
            System.err.println(msg);
        } else {
            System.out.println(msg);
        }
    }

    public void error(String msg) {
        message(true, msg);
    }

    public void printText(String line,String printerName1) {
        text= new JTextArea();
        printerName=printerName1;
        text.append(line);
        MessageFormat footer=createFormat("{0}");
        print(null, footer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea text;
    private static String printerName;
    // End of variables declaration//GEN-END:variables
}
