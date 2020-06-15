package ejercicios.gui;

import java.util.ArrayList;


public class NumerosPrimos {

  // ################################################################################
  // Mostrar en pantalla los N primeros números primos. Se pide por teclado la cantidad
  // de números primos que queremos mostrar.
  // ################################################################################
  // Análisis
  // Tengo que leer la cantidad de números primos que voy a mostrar. La cantidad debe
  // ser positivo. El primer número primo es el 2 (lo muestro) a partir de este son
  // todos impares. Voy probando desde el 3 todos los impares hasta que muestre la
  // cantidad que hemos indicados (necesito un contador).
  // Para comprobar si son primos, los voy dividiendo desde 3 hasta la raíz cuadrada
  // del número, si es divisible por algún número no es primo (necesito un indicador).
  // Datos de entrada: Cantidad de números a mostrar.
  // Información de salida: Los números primos indicados.
  // Variables: cantidadAMostrar, cant_mostradis, divisor (entero), esPrimo(lógico)
  // ################################################################################
  // Diseño
  // 1.- Leer cantidad de número primos a mostrar, debe ser positivo
  // 2.- Muestro el primer número primo, el 2.
  // 3.- Inicializo el contador de número mostrados a 1.
  // 4.- Inicializo la variable donde guardo el número a probar -> num=3
  // 4.- Mientras no haya mostrado la cantidad de número indicados
  // 5.- Considero que es primo. Inicializo el indicador -> esPrimo=Verdadero
  // 6.- desde el 3 hasta la raíz cuadrada del número
  // 7.- Si es divisible -> Ya no es primo -> esPrimo=Falso
  // 8.- Si es primo
  // 9.- Incremento el contador de números mostrados
  // 10.- Escribo el número primo
  // 11.- Como son impares, incremento en 2 el número a probar
  // ################################################################################

  public static ArrayList<Integer> contar(int cantidadAMostrar) {
    ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
    if (cantidadAMostrar > 0) numerosPrimos.add(2);
    int cantidadMostrados;
    int num;
    cantidadMostrados = 1;
    // ...a partir de 3
    num = 3;
    while (cantidadMostrados < cantidadAMostrar) {
      // pienso que es primo hasta que encuentre con que dividirlo
      boolean esPrimo = true;
      // ya sabemos que es impar
      for (int divisor=3; divisor<=Math.sqrt(num) && esPrimo; divisor+=2) {
        // si la división da exacta...
        if (num%divisor==0) {
          // ...ya no es primo
          esPrimo = false;
        }
      }
      if (esPrimo) {
        cantidadMostrados++;
        numerosPrimos.add(num);
      }
      num += 2;
    }
    return numerosPrimos;
  }


}