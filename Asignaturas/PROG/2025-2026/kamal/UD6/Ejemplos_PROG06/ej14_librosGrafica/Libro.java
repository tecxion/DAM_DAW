package ej14_librosGrafica;

import java.io.Serializable;

public class Libro implements Serializable{
	
		// atributos
		private String isbn;
		private String titulo;
		private String autor;
		private int	numeroPaginas;
		private double precio;
		
		// constructor con parámetros
		public Libro(String i, String t, String a, int n, double p) {
			this.isbn = i;
			this.titulo = t;
			this.autor = a;
			this.numeroPaginas = n;
			this.precio = p;
		}
		//constructor vacío
				public Libro(){
					
				}
		
		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		
		
		
		//getters y Setters
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String t) {
			this.titulo = t;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String t) {
			this.isbn = t;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String t) {
			this.autor = t;
		}
		public int getNumeroPaginas() {
			return numeroPaginas;
		}
		public void setNumeroPaginas(int t) {
			this.numeroPaginas = t;
		}
		
		@Override
	    public String toString()
	    {
			 StringBuilder sb = new StringBuilder();       
			
		      sb.append("\n************************");
		      sb.append("\nISBN: ");
		      sb.append(this.isbn);
		      sb.append("\nTitulo: ");
		      sb.append(this.titulo);
		      sb.append("\nAutor: ");
		      sb.append(this.autor);
		      sb.append("\nPaginas: ");
		      sb.append(this.numeroPaginas); 
		      sb.append("\nPrecio: ");
		      sb.append(this.precio);
		      sb.append("\n************************");
		      return sb.toString();
	        
	        		
	    }
}
