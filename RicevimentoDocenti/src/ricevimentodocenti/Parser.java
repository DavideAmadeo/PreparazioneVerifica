/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Amadeo_Davide
 */
public class Parser {
    private List docenti;

    public Parser() {
        docenti = new ArrayList();
    }

    public List parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        String doc;
        //Docente doc;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                doc= getTextValue((Element) nodelist.item(i), "td");
                docenti.add(doc);
            }
        }
        return docenti;
    }
    
    public Docente getDocente(Element element){
        Docente docente;
        String nome=getTextValue(element, "nome");
        String giorno=getTextValue(element, "giorno");
        String ora=getTextValue(element, "ora");
        docente= new Docente(nome, giorno, ora);
        return docente;
    }
    
    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag) {
        String tmp= "";
        NodeList nodelist;
        nodelist= element.getElementsByTagName(tag);
        if(nodelist!=null && nodelist.getLength()>0){
            docenti.add(element);
            for(int i=0; i<nodelist.getLength(); i++){
                element= (Element) nodelist.item(i);
                if(element!=null && element.getFirstChild()!=null){
                    tmp+= element.getFirstChild().getNodeValue()+" ";
                }
            }
        }
        return tmp;
    }
    
    // restituisce il valore intero dell’elemento figlio specificato
    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }
    
    // restituisce il valore numerico dell’elemento figlio specificato
    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }
    
}
