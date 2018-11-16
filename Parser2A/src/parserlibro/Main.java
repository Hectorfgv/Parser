package parserlibro;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {
	
	private static Parser p;

	public static void main(String[] args) {
		Parser p = new Parser();
		
		
		try {
			parseFile(p);
			
		
		} catch (ParserConfigurationException e) {
			System.out.println("Ha ocurrido un error.\n");
			e.printStackTrace();
		} catch(SAXException s) {
			System.out.println("No se ha podido parsear.\n");
			s.printStackTrace();
		} catch(IOException ex) {
			System.out.println("Ha ocurrido un error de I/O.\n");
			ex.printStackTrace();
		}

	}

	public static void parseFile (Parser par) throws ParserConfigurationException, SAXException, IOException {
		par.parseFicheroXml("biblioteca.xml");
		par.parseDocument();
		par.printLibro();
	}
	


}