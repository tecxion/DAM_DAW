package ej12_ejemplos_SWING;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class GestorFrasesGUI extends JFrame {
    private ArrayList<String> frases;
    private JTextArea textArea;
    private final String fichero = "src/ej12_ejemplos_SWING/frases.txt";

    public GestorFrasesGUI() {
        frases = new ArrayList<>();
        configurarVentana();
        configurarMenu();
        configurarPanel();
    }

    private void configurarVentana() {
        setTitle("Gestor de Frases");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void configurarMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        
        JMenuItem leer = new JMenuItem("Leer frases del fichero");
        JMenuItem anadir = new JMenuItem("Añadir frase");
        JMenuItem eliminar = new JMenuItem("Eliminar frase");
        JMenuItem aleatoria = new JMenuItem("Mostrar frase aleatoria");
        JMenuItem guardar = new JMenuItem("Guardar frases en fichero");
        
        // Menú Salir
        JMenu menuSalir = new JMenu("Salir");
        JMenuItem itemSalir = new JMenuItem("Cerrar aplicación");
        
        leer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leerFichero();
            }
        });

        anadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anadirFrase();
            }
        });

        eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarFrase();
            }
        });

        aleatoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFraseAleatoria();
            }
        });

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarFichero();
            }
        });

        /*
        itemSalir.addActionListener(new ActionListener(){
        	 public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
        });
        */
        itemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear un diálogo modal
                JDialog confirmDialog = new JDialog(GestorFrasesGUI.this, "Confirmar salida", true);
                confirmDialog.setSize(300, 150);
                confirmDialog.setLocationRelativeTo(GestorFrasesGUI.this);

                // Panel con los elementos
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                JLabel mensaje = new JLabel("¿Estás seguro de que quieres salir?");
                mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(mensaje);

                // Botones
                JPanel botonesPanel = new JPanel();
                JButton botonSi = new JButton("Sí");
                JButton botonNo = new JButton("No");

                botonesPanel.add(botonSi);
                botonesPanel.add(botonNo);
                panel.add(botonesPanel);

                // Acción del botón "Sí"
               /* botonSi.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                */
                //Con expresiones lambda se crean métodos más compactos
                botonSi.addActionListener(event -> System.exit(0));

                // Acción del botón "No"
                /*botonNo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        confirmDialog.dispose();
                    }
                });
                */
                botonNo.addActionListener(event -> confirmDialog.dispose());

                confirmDialog.getContentPane().add(panel);
                confirmDialog.setVisible(true);
            }
        });

        //También es válido lo siguiente
       // itemSalir.addActionListener(e -> System.exit(0));
        
        menu.add(leer);
        menu.add(anadir);
        menu.add(eliminar);
        menu.add(aleatoria);
        menu.add(guardar);

        // Agregar item al menú Salir
        menuSalir.add(itemSalir);
        
        menuBar.add(menu);
        //menuBar.add(Box.createHorizontalGlue()); // Empuja el siguiente menú a la derecha
        menuBar.add(menuSalir);
        setJMenuBar(menuBar);
    }

    private void configurarPanel() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void actualizarTexto() {
        textArea.setText("");
        for (int i = 0; i < frases.size(); i++) {
            textArea.append((i + 1) + ". " + frases.get(i) + "\n");
        }
    }

    private void anadirFrase() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextField texto = new JTextField();
        panel.add(new JLabel("Introduce la frase:"), BorderLayout.NORTH);
        panel.add(texto, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(this, panel, "Añadir frase", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String frase = texto.getText().trim();
            if (!frase.isEmpty()) {
                frases.add(frase);
                actualizarTexto();
            }
        }
    }

    private void eliminarFrase() {
        if (frases.isEmpty()) {
            textArea.setText("No hay frases para eliminar.\n");
            return;
        }

        String[] lista = new String[frases.size()];
        for (int i = 0; i < frases.size(); i++) {
            lista[i] = (i + 1) + ". " + frases.get(i);
        }

        JList<String> listaFrases = new JList<>(lista);
        JScrollPane scroll = new JScrollPane(listaFrases);
        scroll.setPreferredSize(new Dimension(400, 200));

        int result = JOptionPane.showConfirmDialog(this, scroll, "Selecciona una frase a eliminar", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedIndex = listaFrases.getSelectedIndex();
            if (selectedIndex != -1) {
                frases.remove(selectedIndex);
                actualizarTexto();
            }
        }
    }

    private void mostrarFraseAleatoria() {
        if (frases.isEmpty()) {
            textArea.setText("No hay frases disponibles.\n");
        } else {
            int index = (int) (Math.random() * frases.size());
            textArea.setText("Frase aleatoria:\n" + frases.get(index));
        }
    }

    private void leerFichero() {
        frases.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                frases.add(linea);
            }
            actualizarTexto();
        } catch (IOException e) {
            textArea.setText("Error al leer el fichero: " + e.getMessage());
        }
    }

    private void guardarFichero() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            for (String s : frases) {
                bw.write(s);
                bw.newLine();
            }
            textArea.setText("Frases guardadas correctamente.\n");
        } catch (IOException e) {
            textArea.setText("Error al guardar el fichero: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GestorFrasesGUI().setVisible(true);
            }
        });
    }
}
