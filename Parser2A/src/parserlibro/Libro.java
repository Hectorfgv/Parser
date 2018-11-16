package parserlibro;
import java.util.ArrayList;

public class Libro {

	private String titulo;
	private String editor;
	private int paginas;
	private int anyo;
	private ArrayList <Autor> Autores;
	
	public Libro(String titulo, String editor, int paginas, int anyo, ArrayList<Autor> autores) {
		super();
		this.titulo = titulo;
		this.editor = editor;
		this.paginas = paginas;
		this.anyo = anyo;
		Autores = autores;
		
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public ArrayList<Autor> getAutores() {
		return Autores;
	}
	public void setAutores(ArrayList<Autor> autores) {
		Autores = autores;
	}
	
	@Override
	public String toString() {		
		
		String aux= "libro titulo=" + titulo + "\n editor=" + editor + "\n paginas=" + paginas + "\n anyo=" + anyo
				+ ",\n Autores=";
		
		for (int i=0; i<Autores.size();i++) {
			Autor autor=Autores.get(i);
			
			aux= aux +autor.toString();
				
		}
		return aux;				
		
	}	
	
}