package controlador
import showMessage
import formateoMenuPrincipalContacto
import modelo.Alumnos
import modelo.GestorFuncionesAlumnos

class GestorListaAlumno: GestorFuncionesAlumnos {

    override fun registrarAlumno(alumnos: MutableList<Alumnos>) {
        try {
            // Pedimos el nombre y apellido del alumno
            print ("Introduce el nombre del Alumno\n : ")
            val nombre = readln().trim()
            print("Introduce el apellido del Alumno\n : ")
            val apellido = readln().trim()

            print("Introduce la nota del Alumno (Ejemplo : 1.5,9.5...) \n : ")
            val nota = readln().toDoubleOrNull() // Convertimos la nota a Double
            require(nota!=null){showMessage("La nota debe de ser un valor numerico")} // Comprobamos que no sea nula

            alumnos.add(Alumnos(nombre, apellido, nota))  // Añadimos a la lista el registro
            println("Se ha registrado el Alumno correctamente")

        }catch (e: IllegalArgumentException){
            showMessage("Error! inesperado durante el registro del alumno ")
        }
    }

    override fun listarAlumnos(alumnos: List<Alumnos>) {

        if( alumnos.isEmpty()){ // Comprobamos si la lista no esta vacia
            showMessage("Error!  lista vacia ")
            return
        }
        alumnos.forEachIndexed { index, alumnos -> println("${index+1}. ${alumnos.nombre} ${alumnos.apellido} - Nota : ${alumnos.nota}")  } // Recorremos la lista por indice

    }

    override fun calcularMedia(alumnos: List<Alumnos>): Double {
        if(alumnos.isEmpty()){ //  Comprobamos si la lista no está vacia
            showMessage("Error!  lista vacia ")
            return 0.0 // Devolvemos 0
        }
        return alumnos.map{it.nota}.average() // Calculamos la media grupal
    }

    override fun mostrarAprobados(alumnos: List<Alumnos>) {
        val ancho = 25 // Fijamos un ancho fijo
        if(alumnos.isEmpty()){
            showMessage("Error!  lista vacia ")
            return
        }

        val alumnoAprobado = alumnos.filter { it.nota >=5.0 }  // Filtramos  la nota    y solo se enseñaran los alumnos con una nota con un cinco o superior
        println("Alumnos Aprobados".formateoMenuPrincipalContacto(ancho))
        alumnoAprobado.forEach { alumno ->println("Nombre: ${alumno.nombre} | Apellido: ${alumno.apellido} | Nota: ${alumno.nota}")  } // Recorremos los alumnos aprobados

    }

    override fun mostrarSuspensos(alumnos: List<Alumnos>) {
        val ancho = 25 // Ancho fijo
        if(alumnos.isEmpty()){
            showMessage("Error!  lista vacia ")
            return
        }
        val alumnoSuspensos = alumnos.filter { it.nota <=5.0 } // Realizamos el mismo proceso de filtrado pero con la accion contraria para que asi unicamente  se muestren toda nota inferior a cinco y superior a 0
        println("Alumnos Suspensos".formateoMenuPrincipalContacto(ancho))

        alumnoSuspensos.forEach { alumno ->println("Nombre: ${alumno.nombre} | Apellido: ${alumno.apellido} | Nota: ${alumno.nota}")  } // Recorremos los alumnos suspensos
    }

    override fun buscarAlumno(alumnos: List<Alumnos>) {
        if(alumnos.isEmpty()){ // Comprueba si la lista esta vacia
            showMessage("Error!  lista de alumnos  vacia ")
            return
        }
        println("Introduce el metodo de busque  del Alumno  (nombre, apellido) ")
        val alumnoBuscado = readln().trim() // Lee el alumno  ya sea por nombre o por apellido

        if(alumnoBuscado.isEmpty()){ // Comprobamos el nombre o apellido no este vacio
            showMessage("Error! el alumno no puede estar vacio")
            return
        }
        val alumnoEncontrado = alumnos.filter {
            /** Realizamos un filtro por nombre o apellido en donde se mostrara el resultado de manera dinamica**/
            it.nombre.contains(alumnoBuscado,ignoreCase = true) ||
                    it.apellido.contains(alumnoBuscado,ignoreCase = true)
        }
        if( alumnoEncontrado.isEmpty()){ // En el caso de fallar en la busqueda se imprime un mensaje
            showMessage("Error!  no se ha encontrado ningun alumno ")
        }else{
            alumnoEncontrado.forEach { alumno ->println("${alumno.nombre} ${alumno.apellido} - Nota:${alumno.nota}")  }
        }

    }

    override fun eliminarAlumno(alumnos: MutableList<Alumnos>) {
        if(alumnos.isEmpty()){  // Comprobar si la lista está vacia
            showMessage("Error!  No hay alumnos en la lista  ")
        }
        // Enseñamos la lista de alumnos actual
        listarAlumnos(alumnos) // Enseñamos la lista de alumnos con las posiciones

        println("Introduce la posicion del alumno que quieras eliminar")
        val posicion = readln().toIntOrNull() // Leemos la posicion  que el usuario desea eleminar

        if(posicion!=null && posicion in 1..alumnos.size){ // Indicamos que si  la posicion es distinto de nulo y  se encuentra entre la posicion 1 y el maximo de la lista entonces posicion -1
            alumnos.removeAt(posicion-1)
            println("Alumno Eliminado correctamente")
        }else{
            showMessage("Error posicion no válida") // Metodo de libreria importada
        }

    }

}