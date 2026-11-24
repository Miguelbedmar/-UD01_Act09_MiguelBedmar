package controlador
import formateoMenuPrincipalContacto
import modelo.Alumnos
import modelo.GestorFuncionesAlumnos
import java.util.Scanner
import java.util.Locale
import showMessage
val sc = Scanner(System.`in`).useLocale(Locale.US)
val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m"

private var alumnos:MutableList<Alumnos> = mutableListOf()
private var gestorPrincipal: GestorFuncionesAlumnos= GestorListaAlumno()
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
                    1 ->gestorPrincipal.listarAlumnos(alumnos)
                    2 ->gestorPrincipal.listarAlumnos(alumnos)
                    3 -> {
                        if (alumnos.isEmpty()){
                            showMessage("ERROR! La lista está vacia")
                        }
                        val media=gestorPrincipal.calcularMedia(alumnos)
                        println("La media total del grupo es : %.2f".format(media))
                    }
                    4 -> gestorPrincipal.mostrarAprobados(alumnos)
                    5 ->gestorPrincipal.mostrarSuspensos(alumnos)
                    6->gestorPrincipal.buscarAlumno(alumnos)
                    7->gestorPrincipal.eliminarAlumno(alumnos)
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
