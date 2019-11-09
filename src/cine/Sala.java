package cine;

import javax.swing.JOptionPane;

public class Sala {

    private String asientos[][];
    private double precio;
    public String letras[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int filas, columnas, numero, posicion, contador;
    private String salida, letra;
    private boolean reserva;

    public Sala(int fila, int columna, double costo) {
        asientos = new String[fila][columna];
        this.filas = fila;
        this.columnas = columna;
        this.salida = "";
        this.reserva = false;
        this.contador = 0;
        this.precio = costo;
        numerarSala();
    }

    public void numerarSala() {
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                this.asientos[fila][columna] = letras[fila] + (columna + 1);
            }
        }
    }

    public String mostrarSala() {
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                salida += asientos[fila][columna] + "\t";
            }
            salida += "\n";
        }
        return salida;

    }

    public void reservarAsiento(String asiento) {
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                if (asientos[fila][columna].equals(asiento)) {
                    asientos[fila][columna] = "*";
                    this.reserva = true;
                    this.contador++;
                }
            }
        }
        if (this.reserva == false) {
            JOptionPane.showMessageDialog(null, "Error al asignar reservar el asiento");
        } else {
            JOptionPane.showMessageDialog(null, "Asiento asignado con éxito");
        }

    }

    public boolean verificarAsiento(String asientoActual) {
        letra = String.valueOf(asientoActual.charAt(0));
        numero = Integer.parseInt("" + asientoActual.charAt(1));
        for (int fila = 0; fila < this.filas; fila++) {
            if (letras[fila].equals(letra)) {
                posicion = fila;
                if (asientos[posicion][numero - 1].equals("*")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void cambiarAsiento(String cualDeseaMoverse, String asientoActual) {

        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                if (asientos[fila][columna].equals(cualDeseaMoverse)) {
                    asientos[fila][columna] = "*";
                    reserva = true;
                }
            }
        }
        if (reserva == false) {
            JOptionPane.showMessageDialog(null, "Error al cambiar asiento, intente de nuevo");
        } else {
            letra = String.valueOf(asientoActual.charAt(0));
            numero = Integer.parseInt("" + asientoActual.charAt(1));
            for (int fila = 0; fila < this.filas; fila++) {
                if (letras[fila].equals(letra)) {
                    posicion = fila;
                    if (asientos[posicion][numero - 1].equals("*")) {
                        asientos[posicion][numero - 1] = asientoActual;
                    }
                }
            }

        }

//        letra = String.valueOf(asientoActual.charAt(0));
//        numero = Integer.parseInt("" + asientoActual.charAt(1));
//        for (int fila = 0; fila < this.filas; fila++) {
//            if (letras[fila].equals(letra)) {
//                posicion = fila;
//                if (asientos[posicion][numero - 1].equals("*")) {
//                    asientos[posicion][numero - 1] = asientoActual;
//                    reserva = true;
//                }
//            }
//        }
//
//        if (reserva == false) {
//            JOptionPane.showMessageDialog(null, "error, asiento incorrecto");
//        } else {
//
//            for (int fila = 0; filas < this.filas; filas++) {
//                for (int columna = 0; columna < this.columnas; columna++) {
//                    if (asientos[fila][columna].equals(cualDeseaMoverse)) {
//                        asientos[fila][columna] = "*";
//                    }
//                }
//            }
//        }
    }

    public String vendidos() {
        this.salida += "Vendidos\tPrecio\tTotal\n";
        this.salida += contador + "\t" + precio + "\t" + (contador * precio);
        return this.salida;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public boolean isReserva() {
        return reserva;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

}
