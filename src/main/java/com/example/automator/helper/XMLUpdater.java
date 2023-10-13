package com.example.automator.helper;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;  

import org.w3c.dom.Document;  
import org.w3c.dom.Node;  

import java.io.File;  

public class XMLUpdater {
    public void updateXML(String fileName, int value) {
            try {
                //Load XML
                System.out.println("loading XML");
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setValidating(false);
                dbf.setNamespaceAware(true);
                dbf.setFeature("http://xml.org/sax/features/namespaces", false);
                dbf.setFeature("http://xml.org/sax/features/validation", false);
                dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
                dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
                DocumentBuilder b = dbf.newDocumentBuilder();
                Document doc = b.parse(new File("optimization-settings-go-here/"+ fileName));
                
                
                //Update XML
                System.out.println("updating XML");
                XPath xPath = XPathFactory.newInstance().newXPath();
                Node node = (Node) xPath.compile("/search/searchSpace/paramSpec[7]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"max_budget\" %d]", value));

                //Save XML
                System.out.println("saving XML");
                Transformer tf = TransformerFactory.newInstance().newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "no");
                tf.setOutputProperty(OutputKeys.METHOD, "xml");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                DOMSource domSource = new DOMSource(doc);
                StreamResult sr = new StreamResult(new File("optimization-settings-go-here/" + fileName));
                tf.transform(domSource, sr);


            } catch (Exception e) {
                System.out.println(e);
        }
    }
}
