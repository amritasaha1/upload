package webservice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;

import sun.net.www.protocol.http.HttpURLConnection;

public class CheckService {

public void callWebService(String inputFileName) {        
	 try {
         String url = "http://18.223.68.150:8080/DocumentService/service/create/multichannel";
         URL obj = new URL(url);
         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("appid","E1");
         con.setRequestProperty("cache-control","no-cache");
         con.setRequestProperty("Access-Control-Allow-Origin","18.223.68.150");
         con.setRequestProperty("Content-Type",
                 "application/xml;charset=utf-8");
         System.out.println("inputFileName:" + inputFileName);
         String urlParameters = getXMLInput(inputFileName);
         con.setDoOutput(true);
         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
         wr.writeBytes(urlParameters);
         wr.flush();
         wr.close();
         String responseStatus = con.getResponseMessage();

         BufferedReader in = new BufferedReader(new InputStreamReader(
                 con.getInputStream()));
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = in.readLine()) != null) {
             response.append(inputLine);
         }
         in.close();
         System.out.println("response:" + response.toString());

     } catch (Exception e) {
         System.out.println("error" + e.getMessage());
     }

   }
	
	
/**
  * Java Program to read XML as String using BufferedReader, DOM parser and jCabi-xml 
  * open source library.
  */

    public static String getXMLInput(String inputFileName) throws ParserConfigurationException, SAXException, IOException {
        
        // our XML file for this example
        File xmlFile = new File("C:/uploads/"+inputFileName);
        
        // Let's get XML file as String using BufferedReader
        // FileReader uses platform's default character encoding
        // if you need to specify a different encoding, use InputStreamReader
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null){
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String xml2String = sb.toString();
        System.out.println("XML to String using BufferedReader : ");
        System.out.println(xml2String);
        
        bufReader.close();
       
        // parsing XML file to get as String using DOM Parser
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
        Document xmlDom = docBuilder.parse(xmlFile);
        
        String xmlAsString = xmlDom.toString(); // this will not print what you want
        System.out.println("XML as String using DOM Parser : ");
        System.out.println(xmlAsString);
        
        
        // Reading XML as String using jCabi library
        XML xml = new XMLDocument(new File("C:/uploads/HIG_Demo.xml"));
        String xmlString = xml.toString();        
        System.out.println("XML as String using JCabi library : " );
        System.out.println(xmlString);
        
        
        return xmlString;
      }



//Read more: https://javarevisited.blogspot.com/2015/07/how-to-read-xml-file-as-string-in-java-example.html#ixzz5if3n8yCP

 
}
