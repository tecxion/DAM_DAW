package ej01_Variables;


/**
 * Aplicación ejemplo de tipos de variables
 
 *
 * @author FMA
 */
public class ejemplovariables2 {
    final double PI =3.1415926536;  // PI es una constante
    int x;                          // x es una variable miembro
    static int y  = 0;                                // de clase ejemplovariables

    int obtenerX(int x) {               // x es un parámetro
            int valorantiguo = this.x;  // valorantiguo es una variabe local
            return valorantiguo;
    }

    // el método main comienza la ejecución de la aplicación
    public static void main(String[] args) {
        // aquí iría el código de nuestra aplicación
    	int x  = 9;
    	ejemplovariables2 e1 = new ejemplovariables2();
    	e1.x = 7;
    	ejemplovariables2.y = 5;
    	System.out.println("x local: " + x + " x de e1: " + e1.x + " y: " + ejemplovariables2.y ); 
    	 metodo_Estatico();
    	// metodo_No_Estatico();Error 
    	 e1.metodo_No_Estatico();
    } // fin del método main

    public static void metodo_Estatico(){
    		int x =3;
    		System.out.println("hola estático, x:" + x);
    		
    }
    public  void metodo_No_Estatico(){
		int x =6;
		 int y =9;
		System.out.println("hola no estático, x:" + x);
		
}
    
} // fin de la clase ejemplovariables

