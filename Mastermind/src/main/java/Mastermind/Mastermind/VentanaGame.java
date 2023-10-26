package Mastermind.Mastermind;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class VentanaGame extends JFrame {
    private static final long serialVersionUID = 1L;
    public int numBotones = 6;
    public int numIntentos = 10;
    public int numSeleccion = 4;
    public JButton[] seleccionColores;
    private Color[] combinacionMaestra;
    private JLabel colorSeleccionadoLabel,historial;
    private Color[] coloresSeleccionados;
    private int colorSeleccionadoIndex;
    private int intentosRestantes;

    public VentanaGame() {
        getContentPane().setLayout(null);
        setTitle("MasterMind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        seleccionColores = new JButton[numBotones];
        coloresSeleccionados = new Color[numBotones];
        colorSeleccionadoIndex = 0;
        intentosRestantes = numIntentos;

        colorSeleccionadoLabel = new JLabel();
        colorSeleccionadoLabel.setBounds(10, 46, 300, 25);
        colorSeleccionadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(colorSeleccionadoLabel);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(30 * (numBotones + 1), 10, 80, 25);//Aqui se establece la posicion
        getContentPane().add(btnBorrar);

        JButton btnAdivinar = new JButton("Adivinar");
        btnAdivinar.setBounds(294, 10, 80, 25);
        getContentPane().add(btnAdivinar);

        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coloresSeleccionados = new Color[numBotones];
                colorSeleccionadoIndex = 0;
                actualizarEtiquetaColorSeleccionado();
            }
        });

        combinacionMaestra = generarCombinacionMaestra();
        System.out.println("Combinación maestra: " + Arrays.toString(combinacionMaestra));

        for (int i = 0; i < numBotones; i++) {
            JButton btnNewButton = new JButton();
            btnNewButton.setBounds(30 * (i + 1), 10, 25, 25);
            btnNewButton.setBackground(obtenerColor(i + 1));
            getContentPane().add(btnNewButton);
            seleccionColores[i] = btnNewButton;

            int finalI = i;
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (colorSeleccionadoIndex < numSeleccion) {
                        JButton botonPresionado = (JButton) e.getSource();
                        Color colorBoton = botonPresionado.getBackground();
                        coloresSeleccionados[colorSeleccionadoIndex] = colorBoton;
                        colorSeleccionadoIndex++;
                        actualizarEtiquetaColorSeleccionado();
                    }
                }
            });
        }
        
        btnAdivinar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Arrays.equals(coloresSeleccionados, combinacionMaestra)) {
                    JOptionPane.showMessageDialog(null, "¡Has adivinado la combinación!", "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    intentosRestantes--;
                    if (intentosRestantes == 0) {
                        JOptionPane.showMessageDialog(null, "¡Te has quedado sin intentos!", "Juego Terminado", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Combinación incorrecta. Intentos restantes: " + intentosRestantes, "Intento Fallido", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }

    private void actualizarEtiquetaColorSeleccionado() {
        StringBuilder colorText = new StringBuilder("<html>Colores seleccionados: ");
        for (Color color : coloresSeleccionados) {
            if (color != null) {
                colorText.append("<span style='background-color: rgb(").append(color.getRed()).append(",").append(color.getGreen()).append(",").append(color.getBlue()).append("); width: 25px; height: 25px;'>&nbsp;&nbsp;</span>");
            }
        }
        colorText.append("</html>");
        colorSeleccionadoLabel.setText(colorText.toString());
    }

    private Color obtenerColor(int indice) {//Aqui se almacena los colores posibles
        switch (indice) {
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.YELLOW;
            case 5:
                return Color.ORANGE;
            case 6:
                return Color.PINK;
            case 7:
                return Color.BLACK;
            case 8:
                return Color.CYAN;
            case 9:
                return Color.MAGENTA;
            case 10:
                return Color.DARK_GRAY;
            default:
                return Color.GRAY;
        }
    }

    private Color[] generarCombinacionMaestra() {
        Random random = new Random();
        Color[] combinacion = new Color[numSeleccion];
        for (int i = 0; i < numSeleccion; i++) {
            int colorIndex = random.nextInt(numBotones);
            combinacion[i] = obtenerColor(colorIndex + 1);
        }
        return combinacion;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaGame frame = new VentanaGame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
