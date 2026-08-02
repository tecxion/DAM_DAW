import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pelicula {

	// Indicamos que el titulo es la clave principal.
	// https://www.objectdb.com/java/jpa/entity/id#entity_identification
	@Id
	private String Titulo;
	
	private String director;
	private String genero;
	private int anio_estreno;
	private int duracion_minutos;

	public Pelicula(String titulo, String director, String genero, int anio_estreno, int duracion_minutos) {
		super();
		Titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.anio_estreno = anio_estreno;
		this.duracion_minutos = duracion_minutos;
	}

	@Override
	public String toString() {
		
		return "Titulo: " + this.getTitulo() + "\nDirector: " + director + "\nGenero: " + this.getGenero()
				+ "\nAño de estreno: " + anio_estreno + "\nDuracion: " + duracion_minutos + " Minutos.";
	}
	
	
	public String getTitulo() {
		if (Titulo != null) {
			return Titulo.trim();
		}
		return Titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo!=null) {
			Titulo = titulo.trim();
		} else {
			Titulo=titulo;
		}
		
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		if (genero != null) {
			return genero.trim();
		}
		return genero;
	}

	public void setGenero(String genero) {
		if (genero!=null) {
			this.genero = genero.trim();
		} else {
			this.genero=genero;
		}
	}

	public int getAnio_estreno() {
		return anio_estreno;
	}

	public void setAnio_estreno(int anio_estreno) {
		this.anio_estreno = anio_estreno;
	}

	public int getDuracion_minutos() {
		return duracion_minutos;
	}

	public void setDuracion_minutos(int duracion_minutos) {
		this.duracion_minutos = duracion_minutos;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new Pelicula(this.getTitulo(), this.getDirector(), this.getGenero() , this.getAnio_estreno(), this.getDuracion_minutos());
	}

}
