/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prog06_tarea;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Programa para implementar la clase principal Concesionario, que representará un concesionario de venta de coches de segunda mano. El
concesionario será capaz de gestionar un máximo de 50 coches.
* Para ello uso:
* 1) un main principal, donde se muetra un menú, se gestionan las opciones elegidas y se usan 4 métodos para su mejor 
* comprensión y orden.
* 2) la clase propiamente concesionario, con 4 métodos que son los que ejecutan cada una de las 4 opciones de menú
* 3) la clase vehiculo, donde se crean los atributos de cada objeto, se gestionan con los getter y setter y se 
* definen los constructores.
* 4) la clase validadciones, con 4 métodos para validar que los datos introducidos cumplan con nuestros requisitos.
* 
 * @author Oscar Racero
 */
public class PROG06_Tarea {

    // Declaración de 2 objetos: uno para vehiculo y otro para el concesionario
    private static Vehiculo miVehiculo = null;  // es un atributo de tipo objeto que por el momento es nulo
    private static Concesionario miConcesionario = null;  // es un atributo de tipo array que por el momento es nulo

    /**
     * método main
     *
     * @param args
     */
    public static void main(String[] args) {

        // 2 variables que se necesitan para el método donde se gestionan las opciones introducidas
        int opcion;
        String matricula = "";

        miConcesionario = new Concesionario();
        Scanner tecladoMain = new Scanner(System.in);

        //Test comentado por defecto, descomentar para probar
        /*
        Vehiculo vehiculo1 = new Vehiculo("Toyota", "1234ABC", 50000, LocalDate.of(2022,01,15), "Sedan", 15000, "Juan Pérez Perez", "12345678A");
        Vehiculo vehiculo2 = new Vehiculo("Honda", "5678XYZ", 70000, LocalDate.of(2021,01,15), "Furgoneta", 12000, "María García Garcia", "98765432B");
        miConcesionario.insertarVehiculos(vehiculo1);
        miConcesionario.insertarVehiculos(vehiculo2);
         */
        
        System.out.println("Bienvenido  al Gestor del Concesionario RacerMotor");
        System.out.println("_|-|_  _|-|_  _|-|_  _|-|_  _|-|_ ");
        System.out.println("|o-o-| |o-o-|  |o-o-|  |o-o-|  |o-o-|");
        System.out.println("");

        //Llamanos al método menú hasta que la opción introducida no sea 9
        do {
            opcion = menu();
            // opciones a realizar del menú
            switch (opcion) {
                case 1: { // introducir datos
                    System.out.println("Introducir Nuevo Vehículo.");
                    System.out.println("----------------------------");
                    //llamamos al método para introducir los datos
                    introducir();
                    miConcesionario.insertarVehiculos(miVehiculo);;
                    break;
                }
                case 2: { // Listar vehiculos
                    if (miConcesionario.listaVehiculos[0] == null) {
                        System.out.println("Incorrecto. La lista está vacía");
                    } else {
                        miConcesionario.listar();
                        break;
                    }
                    break;
                }
                case 3: { // Buscar Vehiculo
                    if (miConcesionario.listaVehiculos[0] == null) {
                        System.out.println("Incorrecto. Debes introducir un vehiculo primero");
                    } else {
                        // llamamos al método para bsucar vehiculos que está en la clase concesionario

                        System.out.print("Introduce la matricula a buscar: ");
                        matricula = tecladoMain.nextLine();
                        String resultado = miConcesionario.buscaVehiculo(matricula);
                        if (resultado != null) {
                            System.out.print(resultado);
                        } else {
                            System.out.print("Vehículo no encontrado");
                        }
                        break;
                    }
                    break;
                }
                case 4: { // Actualiza km
                    if (miConcesionario.listaVehiculos[0] == null) {
                        System.out.println("Incorrecto. Debes introducir un vehiculo primero");
                    } else {
                        miConcesionario.actualizaKM();
                    }
                    break;
                }
                case 5: {
                    break;
                }
                default:
                    throw new AssertionError();
            }

        } while (opcion != 5);
        System.out.println("===================================================================");
        System.out.println("_|-|_  _|-|_  _|-|_  _|-|_  _|-|_ ");
        System.out.println("|o-o-| |o-o-|  |o-o-|  |o-o-|  |o-o-|");
        System.out.println("Hasta su próxima visita al Gestor del Concesionario RacerMotor.");

    }// fin del main

    /**
     * metodo 1) menú donde se dan las 5 opciones para operar
     *
     * @return opcion elegida
     */
    public static int menu() {
        int opcion;

        System.out.println("Opciones: ");
        System.out.println("==========");
        System.out.println("1.- Nuevo Vehiculo \n2.- Listar Vehículo \n3.- Buscar Vehículo \n4.- Actualiza km \n5. Salir del gestor");
        System.out.print("Opción deseada: ");

        Scanner teclado = new Scanner(System.in);
        opcion = teclado.nextInt();

        return opcion;
    } // fin método menú

    /**
     * metodo 2) menú donde se piden los 8 datos del vehiculo Tipo void almacena
     * variables pero no retorna nada. Variables que se guardan: Marca,
     * matricula, km, fecha, descripcion, precio, nombre, dni
     */
    static void introducir() {

        String marca = "";
        String matricula = "";
        int km = 0;
        LocalDate fecha;
        String descripcion = "";
        int precio = 0;
        String nombre = "";
        String dni = "";

        Scanner teclado = new Scanner(System.in);

        String ultima = "";
        System.out.print("Introducir marca: ");
        marca = teclado.nextLine();

        //bucle que pide la matricula y lo sigue preguntando hasta que el método validaMatricula da por correcto la matricula mintroducida
        do {
            System.out.print("Introducir matricula(3 letras mayúsculas): ");
            matricula = teclado.nextLine();
        } while (Validaciones.validaMatricula(matricula) == false);

        km = introduceKm();

        System.out.println("Introducir fecha matriculación (datos por separados)");
        // llamar a metodo "introducirFecha" para solicitar los datos de la fecha
        fecha = introducirFecha();
        teclado.nextLine();

        System.out.print("Introducir descripción: ");
        descripcion = teclado.nextLine();
        System.out.print("Introducir precio: ");
        precio = teclado.nextInt();
        teclado.nextLine();
        do {
            System.out.print("Introducir nombre y apellidos del propietario: ");
            nombre = teclado.nextLine();
        } while (Validaciones.validaNombre(nombre) == false);

        //bucle que pide el DNI y lo sigue preguntando hasta que el método letraValida da por correcto el DNI introducido
        do {
            System.out.print("Introducir DNI(letra mayúscula): ");
            dni = teclado.nextLine();
        } while (Validaciones.validaDni(dni) == false);

        // Instancio ya el objeto con todos los datos validados
        miVehiculo = new Vehiculo(marca, matricula, km, fecha, descripcion, precio, nombre, dni);
        System.out.println(" Todos los datos son correctos y se han guardados");
        // Muestro todos los datos introducidos
        System.out.println("Su coche es de marca " + miVehiculo.getMarca() + " con matricula " + miVehiculo.getMatricula() + " con un número de km de " + miVehiculo.getKm()
                + ", contiene la siguiente descripción \"" + miVehiculo.getDescripcion() + "\" el coche tiene un precio de " + miVehiculo.getPrecio() + ".\nSu nombre es "
                + miVehiculo.getNombre() + " y su DNI " + miVehiculo.getDni() + ".");
    } // fin metodo introducir

    /**
     * metodo 3) para introducir la fecha
     *
     * @return fecha tipo Localdate
     */
    public static LocalDate introducirFecha() {

        Scanner teclado = new Scanner(System.in);
        LocalDate fecha;

        do {
            System.out.print("Introducir día: ");
            int dia = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Introducir mes: ");
            int mes = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Introducir año: ");
            int anio = teclado.nextInt();
            teclado.nextLine();

            fecha = LocalDate.of(anio, mes, dia);

        } while (Validaciones.compruebaFecha(fecha) == false);

        System.out.println("La fecha introducida es: " + fecha);
        return fecha;
    } // fin metodo introducir fecha

    /**
     * Método 4) para introducir los km y validarlo pueden usar
     *
     * @return los kilometros de tipo entero
     */
    public static int introduceKm() {
        Scanner teclado = new Scanner(System.in);
        int km;
        do {
            System.out.print("Introducir número km: ");
            km = teclado.nextInt();

            // validar si los km son numeros positivos
        } while (km < 0);

        return km;
    }

} // fin metodo clase
