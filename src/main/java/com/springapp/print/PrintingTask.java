package com.springapp.print;

import com.springapp.service.PrintingService;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;
import java.net.URISyntaxException;
import java.text.MessageFormat;

public class PrintingTask extends SwingWorker<Object, Object> {
    private final MessageFormat headerFormat;
    private final MessageFormat footerFormat;
    private volatile boolean complete = false;
    private volatile String message;
    private javax.swing.JTextArea text;
    private String printerName;

    public PrintingTask(MessageFormat header, MessageFormat footer, JTextArea text,String printerName) {
        this.headerFormat = header;
        this.footerFormat = footer;
        this.printerName=printerName;
        this.text=text;
    }

    @Override
    protected Object doInBackground() throws URISyntaxException {
        try {

            PrintService[] printServices= PrintServiceLookup.lookupPrintServices(null, null);
            PrintService ps=null;

            for(PrintService ps1 : printServices)
            {
                if(ps1.getName().equals(printerName)){ps=ps1;}
            }

            if(ps==null)
            {
                complete=false;
                message="Printer not found";
                return null;
            }

            complete = text.print(headerFormat, footerFormat,
                    false, ps,null, true);

            message = "Printing " + (complete ? "complete" : "canceled");
        } catch (Exception ex) {
            message = "Sorry, a printer error occurred";
        }
        return null;
    }

    @Override
    protected void done() {
        PrintingService.message(!complete, message);
    }
}