package tarea_24_25_tiempo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainGUI extends JFrame {

    private static final String FICHERO = "src/tarea_24_25_tiempo/canciones.txt";

    ArrayList<Cancion> canciones = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	

    // Campos de formulario
    private JTextField tfTitulo;
    private JTextField tfDuracion;
   

    // Tabla
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public MainGUI() {
        super("Canciones - Swing/AWT");

       

        // Carga automática al iniciar
       Principal.lecturaFichero(FICHERO, canciones);

        construirInterfaz();
        refrescarTabla();

        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void construirInterfaz() {
        // Layout principal
        setLayout(new BorderLayout(10, 10));

        // ---------------- Panel superior: formulario (GridLayout) ----------------
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 8, 8));

        panelFormulario.add(new JLabel("Título:"));
        tfTitulo = new JTextField();
        panelFormulario.add(tfTitulo);

        panelFormulario.add(new JLabel("Duración:"));
        tfDuracion = new JTextField();
        panelFormulario.add(tfDuracion);

        

        add(panelFormulario, BorderLayout.NORTH);

        // ---------------- Panel central: tabla (BorderLayout) ----------------
        String[] columnas = {"Título", "Duración"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // tabla solo lectura
            }
        };

        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // ---------------- Panel inferior: botones (FlowLayout) ----------------
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnAnadir = new JButton("Añadir");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnDesordenar = new JButton("Desordenar");
        
      

        panelBotones.add(btnAnadir);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnDesordenar);
      

        add(panelBotones, BorderLayout.SOUTH);

        // ---------------- Eventos ----------------
        btnAnadir.addActionListener(e -> accionAnadir());
        btnMostrar.addActionListener(e -> refrescarTabla());
       // btnEliminar.addActionListener(e -> accionEliminar());
        //btnDesordenar.addActionListener(e -> accionDesordenar());
     
    }

    // -------------------------------------------------------------------------
    // Acciones
    // -------------------------------------------------------------------------

    private void accionAnadir() {
        String titulo = tfTitulo.getText().trim();
        String duracion =tfDuracion.getText().trim();
        

        // Validaciones mínimas
        if (titulo.isEmpty() || duracion.isEmpty() ) {
            JOptionPane.showMessageDialog(this,
                    "Título y duración son obligatorios.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
       // int dur = Integer.parseInt(duracion);
        //validación necesaria
       int dur;
        try {
            dur = Integer.parseInt(duracion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La duración debe ser un número entero.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
            tfDuracion.requestFocus();
            return;
        }

        // Validación lógica (MUY recomendable)
        if (dur <= 0) {
            JOptionPane.showMessageDialog(this,
                    "La duración debe ser mayor que 0.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cancion c = new Cancion(titulo, dur);

        if (canciones.add(c)) {
            JOptionPane.showMessageDialog(this,
                    "Canción añadida correctamente.",
                    "OK",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
            refrescarTabla();
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo añadir.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    

    // -------------------------------------------------------------------------
    // Utilidades
    // -------------------------------------------------------------------------

    private void refrescarTabla() {
        // Vaciar tabla
        modeloTabla.setRowCount(0);

       //Recorrer biblioteca
        for (Cancion l : canciones) {
            Object[] fila = {
                    l.getTitulo(),
                    l.getDuracion()
                  
            };
            //añadir una fila por cada libro
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarFormulario() {
        tfTitulo.setText("");
        tfDuracion.setText("");
       
    }

   
    
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}