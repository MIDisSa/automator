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
    public static void updateXML(String fileName, DataInput dataInput, UserInput userInput) {
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
                
                Node node = (Node) xPath.compile("/search/modelInfo/modelStopCondition").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("ticks &gt;= %s", userInput.getNumberOfTicks()));

                node = (Node) xPath.compile("/search/modelInfo/modelStepLimit").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("%d", userInput.getNumberOfTicks()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[7]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"run_until_day_x\" %s]", userInput.getNumberOfTicks()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[8]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"nr_default_friends_inter_village\" %s]", dataInput.getNrDefaultFriendsInterVillage()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[9]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"avg_intra_village_interaction_frequency\" %s]", dataInput.getAvgIntraVillageInteractionFrequency()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[10]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"avg_inter_village_interaction_frequency\" %s]", dataInput.getAvgInterVillageInteractionFrequency()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[11]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"avg_chief_farmer_meeting_frequency\" %s]", dataInput.getAvgChiefFarmerMeetingFrequency()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[12]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"percentage_negative_WoM\" %s]", dataInput.getPercentageNegativeWoM()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[13]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"base_adoption_probability\" %s]", dataInput.getBaseAdoptionProbability()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[14]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"avg_inter_mention_percentage\" %s]", dataInput.getAvgInterMentionPercentage()));   

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[15]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"avg_intra_mention_percentage\" %s]", dataInput.getAvgIntraMentionPercentage())); 

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[16]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"max_budget\" %s]", userInput.getBudget()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[17]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"fixed_costs_direct_ad\" %s]", userInput.getFixedCostsDirectAd()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[18]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"fixed_costs_train_chiefs\" %s]", userInput.getFixedCostsTrainChiefs()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[19]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"variable_costs_direct_ad\" %s]", userInput.getVariableCostsDirectAd()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[20]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"variable_costs_discount\" %s]", userInput.getVariableCostsDiscount()));   
                
                node = (Node) xPath.compile("/search/searchSpace/paramSpec[21]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"variable_costs_delayed\" %s]", userInput.getVariableCostsDelayed()));

                node = (Node) xPath.compile("/search/searchSpace/paramSpec[22]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"variable_costs_delayed_discount\" %s]", userInput.getVariableCostsDelayedDiscount()));
                
                node = (Node) xPath.compile("/search/searchSpace/paramSpec[23]").evaluate(doc, XPathConstants.NODE);
                node.setTextContent(String.format("[\"variable_costs_train_chiefs\" %s]", userInput.getVariableCostsTrainChiefs())); 

              


                
                
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
