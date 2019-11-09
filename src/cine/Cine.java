package cine;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Cine {

    public static void main(String[] args) {
        int fila, columna, opcion;
        double precio;
        boolean estado = true;
        String asiento, cualAsiento, nuevoasiento;
        JTextArea hoja = new JTextArea();

        do {
            fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de filas"));
        } while (fila < 0 || fila > 25);
        do {
            columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de columnas"));
        } while (columna < 0 || columna > 5);

        do {
            precio = Double.parseDouble(JOptionPane.showInputDialog("ingrese precio del boleto"));
        } while (precio < 0);

        Sala sala = new Sala(fila, columna, precio);

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Opciones\n1-ver sala\n2-Comprar asiento\n3-Cambiar Asiento\n4-Estadisticas"));
            switch (opcion) {
                case 1:
                    hoja.setText(sala.mostrarSala());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 2:
                    hoja.setText(sala.mostrarSala());
                    asiento = JOptionPane.showInputDialog(null, hoja, "¿Cúal asiento desea?");
                    sala.reservarAsiento(asiento);
                    break;
                case 3:
                    cualAsiento = JOptionPane.showInputDialog("ingrese el asiento en el que se encuentra");
                    if (sala.verificarAsiento(cualAsiento)) {
                        nuevoasiento = JOptionPane.showInputDialog("ingrese asiento al que se desesa mover");
                        sala.cambiarAsiento(nuevoasiento, cualAsiento);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, asiento no se encuentra reservado");
                    }

                    break;
                case 4:
                    hoja.setText(sala.vendidos());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;

            }
            sala.setSalida("");
            hoja.setText(sala.getSalida());
            sala.setReserva(false);
        } while (estado);

    }

}
