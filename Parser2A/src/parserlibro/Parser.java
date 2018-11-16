package parserlibro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Parser {	
	private Document dom = null;
	private ArrayList<Libro> libro = null;

	
	public Parser() {
	   libro = new ArrayList<Libro>();
	}


	public void parseFicheroXml(String fichero) throws ParserConfigurationException, SAXException, IOException {
	    // creamos una factory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    
	      try {
		// creamos un documentbuilder
		DocumentBuilder db = dbf.newDocumentBuilder();

		// parseamos el XML y obtenemos una representación DOM
		dom = db.parse(fichero);
	} catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	} catch (SAXException se) {
		se.printStackTrace();
	} catch (IOException ioe) {
		ioe.printStackTrace();
	}

}

	
	  public void parseDocument() {
		// obtenemos el elemento raíz
	    Element doc = dom.getDocumentElement();
	 // obtenemos el nodelist de elementos
	    NodeList nl = doc.getElementsByTagName("libro");
	      
	    if (nl != null && nl.getLength() > 0) {
	      for (int i = 0; i < nl.getLength(); i++) {        
	    	// obtenemos un elemento de la lista (libro)
	        Element el = (Element) nl.item(i);
	     // obtenemos un libro
	        Libro p = getLibro(el);
	     // lo añadimos al array
	        libro.add(p);
	      }
	    }
	  }
	  
	  
	 private Libro getLibro(Element libroEle){
		 
		//para cada elemento libro, obtenemos su nombre, editor, título, páginas y año.
	    String titulo = getTextValue(libroEle,"titulo");
	    String editor = getTextValue(libroEle,"editor");
	    int paginas = getIntValue(libroEle,"paginas");
	    int anyo = getAtributeValue(libroEle,titulo,"anyo"); 
	    ArrayList <Autor> Autores= getAutor(libroEle);
	    
	    //Creamos un nuevo Libro con los elementos leídos del nodo
	    Libro lib = new Libro(titulo,editor,paginas,anyo,Autores);

	    return lib;    
	    
	  }
	  

	  private String getTextValue(Element ele, String tagName) {
	    String textVal = null;
	    NodeList nl = ele.getElementsByTagName(tagName);
	    
	    if(nl != null && nl.getLength() > 0) {
	      Element el = (Element)nl.item(0);
	      textVal = el.getFirstChild().getNodeValue();
	    }  
	    
	    return textVal;
	  }
	  
	  
	  private int getIntValue(Element ele, String tagName) {        
	    return Integer.parseInt(getTextValue(ele,tagName));
	  }
	  
	  public void printLibro() {
		Iterator<Libro> it = libro.iterator();
		StringBuilder sb = new StringBuilder();
		
		while(it.hasNext()) {
		 Libro l = it.next();
	     sb.append(l.toString() + "\n\n");
	     
	    }
		
		System.out.println(sb);;	
	  }
	  private int getAtributeValue(Element ele, String tagName, String atribute) {
		    int atrib =0;
		    NodeList nl = ele.getElementsByTagName(tagName);
		    
		    if(nl != null && nl.getLength() > 0) {
		      Element el = (Element)nl.item(0);
		      atrib = Integer.parseInt(el.getAttribute("anyo"));
		    }    
		    
		    return atrib;
		  }
	  
	  private ArrayList<Autor> getAutor (Element libroEle){
			ArrayList <Autor> Autores= new ArrayList<Autor> ();
			
			// obtenemos el nodelist de elementos
			NodeList nl = libroEle.getElementsByTagName("autores");
			if (nl != null && nl.getLength() > 0) {
					// obtenemos un elemento de la lista (libro)
					Element el = (Element) nl.item(0);
					
					NodeList nl1 = libroEle.getElementsByTagName("autor");
					if (nl1 != null && nl1.getLength() > 0) {
						
						for (int i = 0; i < nl1.getLength(); i++)	{
							
							Element el1 = (Element) nl1.item(i);
							
							String nombre=getTextValue(el1,"nombre");;
							String apellido=getTextValue(el1,"apellido");
							
							Autor auxiliar= new Autor (nombre, apellido);
							Autores.add(auxiliar);
						}
						}
					}
			return Autores;
		}
	  public void print(){
			

			Iterator it = libro.iterator();
			System.out.println("longitud "+libro.size());
			while(it.hasNext()) {
				
				Libro p=(Libro) it.next();
				System.out.println(p.toString());
			}
			
		}
	  
}
