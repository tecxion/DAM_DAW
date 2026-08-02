package ej12_ejemplos_SWING;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class FrasesSwingApp {
    private JFrame frame;
    private JTextArea textArea;
    private ArrayList<String> frases;
    private String fichero = "src/ej12_ejemplos_SWING/frases.txt";

    public FrasesSwingApp() {
        frases = new ArrayList<>();
        frame = new JFrame("Gestor de Frases");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        // Área de texto para mostrar frases
        textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Panel de botones
        JPanel botonera = new JPanel();
        botonera.setLayout(new GridLayout(2, 3));

        JButton btnLeer = new JButton("Leer frases del fichero");
        JButton btnAnadir = new JButton("Añadir frase");
        JButton btnEliminar = new JButton("Eliminar frase");
        JButton btnAleatoria = new JButton("Mostrar frase aleatoria");
        JButton btnMostrar = new JButton("Mostrar frases");
        JButton btnGuardar = new JButton("Escribir fichero");

        botonera.add(btnLeer);
        botonera.add(btnAnadir);
        botonera.add(btnEliminar);
        botonera.add(btnAleatoria);
        botonera.add(btnMostrar);
        botonera.add(btnGuardar);

        panel.add(botonera, BorderLayout.SOUTH);

        // Acción: Leer fichero
        btnLeer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leerFichero();
            }
        });

        // Acción: Añadir frase
        btnAnadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String frase = JOptionPane.showInputDialog(frame, "Introduce una frase:");
                if (frase != null && !frase.trim().isEmpty()) {
                    frases.add(frase);
                    JOptionPane.showMessageDialog(frame, "Frase añadida correctamente");
                }
            }
        });

        // Acción: Eliminar frase
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frases.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No hay frases para eliminar.");
                    return;
                }
                String[] lista = frases.toArray(new String[0]);
                String seleccion = (String) JOptionPane.showInputDialog(frame, "Selecciona la frase a eliminar:", "Eliminar frase",
                        JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]);
                if (seleccion != null) {
                    frases.remove(seleccion);
                    JOptionPane.showMessageDialog(frame, "Frase eliminada correctamente");
                }
            }
        });

        // Acción: Mostrar aleatoria
        btnAleatoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frases.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No hay frases para mostrar.");
                } else {
                    int indice = (int) (Math.random() * frases.size());
                    JOptionPane.showMessageDialog(frame, "Frase aleatoria: \n" + frases.get(indice));
                }
            }
        });

        // Acción: Mostrar frases
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < frases.size(); i++) {
                    sb.append((i + 1) + ". " + frases.get(i) + "\n");
                }
                textArea.setText(sb.toString());
            }
        });

        // Acción: Escribir en el fichero
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frases.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No hay frases que guardar.");
                    return;
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fichero));
                    for (String frase : frases) {
                        writer.write(frase);
                        writer.newLine();
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Frases guardadas correctamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al escribir el fichero: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }

    private void leerFichero() {
        frases.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = reader.readLine()) != null) {
                frases.add(linea);
            }
            reader.close();
            JOptionPane.showMessageDialog(frame, "Frases cargadas correctamente.");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "Fichero no encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error de lectura: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new FrasesSwingApp();
    }
}
