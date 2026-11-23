package controlador

import java.util.Scanner
import java.util.Locale

val sc = Scanner(System.`in`).useLocale(Locale.US)
val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m"

private var numero:MutableList<Int> = mutableListOf()


    fun String.formateoMenuPrincipalContacto(anchoTotal: Int): String { // Creamos una función extension
        val ancho = anchoTotal - 2 // restamos dos al ancho total para centrarlo
        if (this.length >= ancho) return "<$this>" // comprobamos si la longitud es superior  a la cadena de caracteres

        val textoEspacio = if (this.isEmpty()) "" else "$this" // Comprobamos si el texto está vacio

        val relleno = ancho - textoEspacio.length //Calculamos la cantidad de relleno

        val izq = relleno / 2
        val de = relleno - izq
        return "<" + "=".repeat(izq) + textoEspacio + "=".repeat(de) + ">"
    }

    fun menuPrincipal() {
        var salir = false
        val ancho = 48 // Ancho predeterminado para rellenar con <==>

        do {
            try {
                println("ESTADÍSTICAS CON KOTLIN".formateoMenuPrincipalContacto(ancho))
                println("0. Salir".formateoMenuPrincipalContacto(ancho))
                println("1. Registrar Alumno".formateoMenuPrincipalContacto(ancho))
                println("2. Listar Alumno".formateoMenuPrincipalContacto(ancho))
                println("3. Calcular media Grupo".formateoMenuPrincipalContacto(ancho))
                println("4. Mostrar Aprobados".formateoMenuPrincipalContacto(ancho))
                println("5. Mostrar Suspensos".formateoMenuPrincipalContacto(ancho))
                println("6. Buscar Alumno".formateoMenuPrincipalContacto(ancho))
                println("7.Eliminar Alumno".formateoMenuPrincipalContacto(ancho))
                println("Seleccione una opción".formateoMenuPrincipalContacto(ancho))
                if (!sc.hasNextInt()) {
                    sc.next()
                    println("${ROJO}Error: La opción seleccionada no está disponible$RESET")
                    continue
                }
                val opcion = sc.nextInt()
                when (opcion) {
                    1 ->println("")
                    2 ->println("")
                    3 -> println("")
                    4 -> println("")
                    5 ->print("") // No formateamos la moda ya que como solo estamos buscando y contando desde el arraylist si intentamos formatearlo no s saltaria un error de
                    6->println("")
                    7->println("")
                    0 -> {
                        salir = true
                        println("Hasta luego")
                        println("Has salido del programa....")
                    }

                    else -> println("Opción introducida no disponible.")


                }


            } catch (ex: Exception) {
                println("${ROJO} ERROR! Valor inválido detectado $RESET" + ex.message)
            } catch (e: NoSuchElementException) {
                println("${ROJO} ERROR! ERROR!: Has salido fuera del fichero $RESET " + e.message)
                salir = true
            }

        } while (!salir)


    }
