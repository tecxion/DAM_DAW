package ej07_OperadoresLogicos;



/**
 *
 * @author FMA
 */
public class operadoreslogicos { 
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("OPERADORES LÓGICOS");

        System.out.println("Negacion:\n ! false es : " + (! false));
        System.out.println(" ! true es : " + (! true));

        System.out.println("Operador AND (&):\n false & false es : " + (false & false));
        System.out.println(" false & true es : " + (false & true));
        System.out.println(" true & false es : " + (true & false));
        System.out.println(" true & true es : " + (true & true));

        System.out.println("Operador OR (|):\n false | false es : " + (false | false));
        System.out.println(" false | true es : " + (false | true));
        System.out.println(" true | false es : " + (true | false));
        System.out.println(" true | true es : " + (true | true));

        System.out.println("Operador OR Exclusivo (^):\n false ^ false es : " + (false ^ false));
        System.out.println(" false ^ true es : " + (false ^ true));
        System.out.println(" true ^ false es : " + (true ^ false));
        System.out.println(" true ^ true es : " + (true ^ true));

        System.out.println("Operador &&:\n false && false es : " + (false && false));
        System.out.println(" false && true es : " + (false && true));
        System.out.println(" true && false es : " + (true && false));
        System.out.println(" true && true es : " + (true && true));

        System.out.println("Operador ||:\n false || false es : " + (false || false));
        System.out.println(" false || true es : " + (false || true));
        System.out.println(" true || false es : " + (true || false));
        System.out.println(" true || true es : " + (true || true));
    } // fin main
} // fin operadoreslogicos
 
