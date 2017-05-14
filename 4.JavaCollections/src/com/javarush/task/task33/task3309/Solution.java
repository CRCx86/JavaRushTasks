package com.javarush.task.task33.task3309;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Pattern;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException {

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        marshaller.marshal(obj, document);

        NodeList nodeList = document.getElementsByTagName("*");

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);

            if (nNode.getNodeName().equals(tagName)) {
                Comment comment1 = document.createComment(comment);
                nNode.getParentNode().insertBefore(comment1, nNode);
            }
            replaceTextCDATA(nNode, document);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        StringWriter stringWriter1 = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(stringWriter1));


        return stringWriter1.toString();
    }

    public static void replaceTextCDATA(Node node, Document document) {

        if(node.getNodeType() == 3 && Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find()) {
            Node cnode = document.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cnode, node);
        }

        NodeList nodeList = node.getChildNodes();

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            replaceTextCDATA(nodeList.item(temp), document);
        }
    }

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException {
        String result = Solution.toXmlWithComment(new AnExample(),
                "needCDATA", "it's a comment - <needCDATA>");
        System.out.println(result);
    }

    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample {
        public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};
    }
}
