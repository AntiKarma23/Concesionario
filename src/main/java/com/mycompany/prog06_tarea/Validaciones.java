/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog06_tarea;

import java.time.LocalDate;

/**
 * Clase dónde se implentan los 4 métodos que validan datos de la clase main
 * (siguen la numeración del mais)
 *
 * @author Oscar Racero
 */
public class Validaciones {

    /**
     * Método 5) para validar el dni
     *
     * @param dni
     * @return una variable resultado booleana para decir que el DNI del
     * propietario es correcto (tan solo el formato).
     */
    public static boolean validaDni(String dni) {
        boolean resultado = false;

        String regex = "\\d{8}[A-Za-z]";

        if (dni.matches(regex)) {
            resultado = true;
        }

        return resultado;
    }

    /**
     * Método 6) para validar la matricula que contenga 4 numeros y 3 letras
     * mayusculas
     *
     * @param matricula
     * @return una variable resultado booleana
     */
    public static boolean validaMatricula(String matricula) {
        boolean resultado = false;

        String regex = "\\d{4}[A-Z]{3}";

        if (matricula.matches(regex)) {
            resultado = true;
        }

        return resultado;
    }

    /**
     * Método 7) para validar que el nombre incluya 2 apellidos y no supere los
     * 40 caracteres
     *
     * @param nombre
     * @return una variable resultado booleana
     */
    public static boolean validaNombre(String nombre) {
        boolean resultado = false;

        String[] trozos = nombre.split(" ");

        if (trozos.length == 3 && nombre.length() <= 40) {
            resultado = true;
        }

        return resultado;
    }

    /**
     * metodo 8) para comprobar si la fecha de matriculación es anterior a la
     * actual
     *
     * @param fecha
     * @return booleano respecto a si la fecha es anterior a la actual
     */
    public static boolean compruebaFecha(LocalDate fecha) {

        return fecha.isBefore(LocalDate.now());
    }

}
