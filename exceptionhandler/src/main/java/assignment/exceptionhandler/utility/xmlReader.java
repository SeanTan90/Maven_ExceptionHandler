package assignment.exceptionhandler.utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import assignment.exceptionhandler.ActionDetails;
import assignment.exceptionhandler.ProjectDetails;
import assignment.exceptionhandler.Storage;

public class xmlReader {
		
	private static Document doc;
	static Storage store;
	static String file;
	
	public xmlReader(String file, Storage store) {
		this.store = store;
		this.file = file;
	}
	
	public static void parseXmlFile(){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			doc = db.parse(file);
		
		parseDocument();

		}catch(ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
			//pce.printStackTrace();
		}catch(SAXException se) {
			System.out.println(se.getMessage());
			//se.printStackTrace();
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
			//ioe.printStackTrace();
		}
	}

	
	private static void parseDocument(){

		Element docEle = doc.getDocumentElement();

		NodeList projectList = docEle.getElementsByTagName("project");
		if(projectList != null && projectList.getLength() > 0) {
			for(int i = 0 ; i < projectList.getLength();i++) {

				Element projectElement = (Element)projectList.item(i);
				String projectName = projectElement.getAttribute("name");
				System.out.println("Project Name: " + projectName);

				NodeList moduleList = projectElement.getElementsByTagName("module");
				if(moduleList != null && moduleList.getLength() > 0) {
					for(int j = 0 ; j < moduleList.getLength();j++) {


						Element moduleElement = (Element)moduleList.item(j);
						String moduleName = moduleElement.getAttribute("name");
						System.out.println("Module Name: " + moduleName);

						NodeList exceptionList = moduleElement.getElementsByTagName("exception");
						if(exceptionList != null && exceptionList.getLength() > 0) {
							for(int k = 0 ; k < exceptionList.getLength();k++) {

								Element exceptionElement = (Element)exceptionList.item(k);
								String exceptionType = exceptionElement.getAttribute("type");
								System.out.println("Exception type: " + exceptionType);
								ProjectDetails projDtls = new ProjectDetails(projectName, moduleName, exceptionType);
								store.addProject(projDtls);

								NodeList actionList = exceptionElement.getElementsByTagName("action");
								if(actionList != null && actionList.getLength() > 0) {
									for(int l = 0 ; l < actionList.getLength();l++) {

										Element actionElement = (Element)actionList.item(l);

										NodeList children = actionElement.getChildNodes();
										for(int p = 0; p < children.getLength(); p++) {
											Node child = children.item(p);
											if (child.getNodeType() == Node.ELEMENT_NODE)
											{
												String actionName = child.getNodeName();// eg. Email
												Map<String, String> attributeDtls = new HashMap<>();
												
												System.out.print(actionName + " ");
												
												for(int s=0; s < child.getAttributes().getLength(); s++) { //for loop for many attributes getAttributes.size()
												Node attribute = child.getAttributes().item(s);
												
												String attributeTo = attribute.getNodeName(); // e.g to
												String attributeContactDtls = attribute.getNodeValue(); // e.g abc@hotmail.com
												
												String attributeDetails = attributeTo + " " + attributeContactDtls; //to abc@hotmail.com
												
												System.out.println(attributeDetails); // "to abc@hotmail.com
												
												attributeDtls.put(attributeTo, attributeContactDtls); //Store attributes into a map
												}
												
												ActionDetails actDtls =new ActionDetails(actionName, attributeDtls);
												store.getActionSet(projDtls).add(actDtls);
												
												
											}
												//create object actionDetails to store the actionName and Hashset of attributes (eg. to: abc@gmail.com...)
												
												
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}






