/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/** 
 *
 * @author Amadeo_Davide
 */
public class NBValidateXML {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        List docenti = null;
        Parser dom = new Parser();
        Scanner tastiera= new Scanner(System.in);
        try {
            docenti = dom.parseDocument("circolare.xml");
            
            //System.out.println("Inserisci un giorno");
            //String giorno= tastiera.nextLine();
            
            
            
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        // iterazione della lista e visualizzazione degli oggetti
         System.out.println("Numero di docenti: "+docenti.size());
        Iterator iterator = docenti.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

    }
    
}
