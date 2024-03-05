/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog06_tarea;

import com.sun.source.doctree.ReturnTree;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase donde se crea el array que albergará un maximo de 50 vehículos y se
 * implementan 4 métodos
 *
 * @author Oscar Racero
 */
public class Concesionario {

    /**
     * variable numVehiculos donde se almacena un vehiculo nuevo constante
     * MAX_VEHICULO donde se establece el número máximo de vehiculos, que
     * facilita hacer pruebas o actualizar a otros valores en el futuro
     */
    private int numVehiculos = 0;
    final int MAX_VEHICULO = 50;

    // Inicializar array para almacenar un maximo de 50 vehiculos para los que ya reservamos memoria
    public Vehiculo[] listaVehiculos = new Vehiculo[MAX_VEHICULO];

    //constructores
    public Concesionario() {
    }

    // métodos
    /**
     * Método 1Conces) que busca un vehiculo en el array y si lo encuentra
     * devuelve unos parametros y si no null
     *
     * @param matricula
     * @return variable String encontrado
     */
    public String buscaVehiculo(String matricula) {

        String encontrado = null;
        for (int i = 0; i < numVehiculos; i++) { // Corregir <= por <
            if (listaVehiculos[i] != null && listaVehiculos[i].getMatricula().equals(matricula)) {
                encontrado = "El vehiculo cuya marca es " + listaVehiculos[i].getMarca()
                        + " y con matrícula " + listaVehiculos[i].getMatricula()
                        + " tiene un valor de " + listaVehiculos[i].getPrecio() + "\n";
                break;
            }
        }
        return encontrado;
    }// fin metodo buscaVehiculo

    /**
     * Metodo 2Conces) Dónde lista todos los vehículos introducidos No retorna
     * nada es void
     */
    public void listar() {

        System.out.println("Lista de vehiculos registrados en concesRacer");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo vehiculo = listaVehiculos[i];

            System.out.println("Vehiculo Nº" + i + ". Marca: " + vehiculo.getMarca() + ". Matrícula: " + vehiculo.getMatricula()
                    + ". Kilometraje: " + vehiculo.getKm() + ". Fecha de matriculación: "
                    + vehiculo.getFecha() + ". \nDescripción: " + vehiculo.getDescripcion() + ". Precio: " + vehiculo.getPrecio()
                    + "\nPropiedad de: " + vehiculo.getNombre() + ", con dni: " + vehiculo.getDni());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        }

    } // fin metodo lista Vehiculos

    /**
     * Metodo 3Conces) donde Se solicitará al usuario por teclado una matrícula
     * y un número de kilómetros. Si el vehículo con esa matrícula existe, se
     * actualizará su número de kms al valor introducido. Si no existe, se
     * mostrará un mensaje por pantalla.
     *
     * NO retorna nada es void
     */
    public void actualizaKM() {

        Scanner scanner = new Scanner(System.in);
        String matricula = "";
        int km;
        boolean encontrado = false;

        System.out.println("Vamos a actualizar los km del vehiculo que nos digas");
        System.out.print("Introduce la matricula: ");
        matricula = scanner.nextLine();

        for (int i = 0; i <= listaVehiculos.length; i++) {
            if (listaVehiculos[i].getMatricula().equals(matricula)) {
                System.out.print("Introduce los Km: ");
                km = scanner.nextInt();
                listaVehiculos[i].setKm(km);
                System.out.println(listaVehiculos[i].getMatricula() + " El nuevo kilometraje es: " + listaVehiculos[i].getKm());
                encontrado = true;
                break;
            }
        }

        System.out.println("Error. El vehiculo no existe");

    }

    /**
     * metodo 4Conces) actualizaKm, solo si existe el vehiculo
     *
     * @param vehiculo
     * @return variable resultado booleana
     */
    public int insertarVehiculos(Vehiculo vehiculo) {
        int resultado = 0;

        if (numVehiculos >= MAX_VEHICULO) {
            resultado = -1;

        } else if (buscaVehiculo(vehiculo.getMatricula()) != null) {
            resultado = -2;
        } else {
            listaVehiculos[numVehiculos] = vehiculo;
            numVehiculos++;
        }
        return resultado;

    }

} // fin clase concesionario

