/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog06_tarea;

import java.time.*;


/**
 * @version 2. Para la tarea 6
 * @author Osso
 *
 * Clase vehículo con los 8 datos necesarios que pide el ejercicio para construir
 * el objeto. Admás contiene un método especial para calcular los años de antigüedad.
 */
public class Vehiculo {

    /**
     * atributos solicitados: marca, matricula, km, fecha(dia, mes y año),
     * descripción, precio, nombre y DNI
     */
    private String marca = "";
    private String matricula = "";
    private int km = 0;
    private String descripcion = "";
    private int precio = 0;
    private String nombre = "";
    private String dni = "";
    private LocalDate fecha;
    

    // constructores
    
    /**
     * constructor vacio
     */
    public Vehiculo() {
    }

    /**
     * Constructor para la opcion 6 del menú para mostrar el propietario (nombre y DNI)
     *
     * @param nombre
     * @param dni
     */
    public Vehiculo(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /**
     * Constructor Descripcion de la opcion 7 del menú
     *
     * @param marca
     * @param matricula
     * @param km
     * @param descripcion
     */
    public Vehiculo(String marca, String matricula, int km, String descripcion) {
        this.marca = marca;
        this.matricula = matricula;
        this.km = km;
        this.descripcion = descripcion;
    }

    /**
     * Constructor completo para inicializar el objeto mi vehiculo
     *
     * @param marca
     * @param matricula
     * @param km
     * @param fecha
     * @param descripcion
     * @param precio
     * @param nombre
     * @param dni
     */
    public Vehiculo(String marca, String matricula, int km, LocalDate fecha, String descripcion, int precio, String nombre, String dni) {

        this.marca = marca;

        this.matricula = matricula;

        this.km = km;

        this.fecha = fecha;

        this.descripcion = descripcion;

        this.precio = precio;

        this.nombre = nombre;

        this.dni = dni;

    }

    // setters y getters
    /**
     * get para recuperar marca
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * set para establecer marca
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * /**
     * get para recuperar matricula
     *
     * @return marca
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * set para establecer matricula
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * get para recuperar km
     * @return km
     */
    public int getKm() {
        return km;
    }
    /**
     * set para establecer km
     * @param km 
     */
    public void setKm(int km) {
        this.km = km;
    }
    /**
     * get para recuperar Descripción
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * set para establecer descripción
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * get para recuperar precio del vehiculo
     * @return precio
     */
    public int getPrecio() {
        return precio;
    }
    /**
     * set para establecer precio del vehiculo
     * @param precio 
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    /**
     * get para recuperar nombre del propietario
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * set para establecer nombre del propietario
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * get para recuperar DNI
     * @return dni
     */
    public String getDni() {
        return dni;
    }
    /**
     * set para establecer dni
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    // otros metodos
    
    
    /**
     * metodo para calcular los años de antigüedad
     * @return años de antigüedad
     */
    public int calculaAnios () {
    
        
         LocalDate hoy = LocalDate.now();
         return (Period.between(fecha, hoy).getYears());
        
    
    }
}
