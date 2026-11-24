package controlador
import showMessage
import modelo.Alumnos
import modelo.GestorFuncionesAlumnos

class GestorListaAlumno: GestorFuncionesAlumnos {

    override fun registrarAlumno(alumnos: MutableList<Alumnos>) {
        try {
            // Pedimos el nombre y apellido del alumno
            print ("Introduce el nombre del Alumno")
            val nombre = readln().trim()
            print("Introduce el apellido del Alumno")
            val apellido = readln().trim()

            print("Introduce la nota del Alumno (Ejemplo : 1.5,9.5...)")
            val nota = readln().toDoubleOrNull()
            require(nota!=null){showMessage("La nota debe de ser un valor numerico")}

            alumnos.add(Alumnos(nombre, apellido, nota))
            println("Se ha registrado el Alumno correctamente")

        }catch (e: IllegalArgumentException){
            showMessage("Error! inesperado durante el registro del alumno ")
        }
    }

    override fun listarAlumnos(alumnos: List<Alumnos>) {

        if( alumnos.isEmpty()){
            showMessage("Error!  lista vacia ")
            return
        }
        alumnos.forEachIndexed { index, alumnos -> println("${index+1}. ${alumnos.nombre} ${alumnos.apellido} - Nota : ${alumnos.nota}")  }

    }

    override fun calcularMedia(alumnos: List<Alumnos>): Double {
        if(alumnos.isEmpty()){
            showMessage("Error!  lista vacio ")
        }
        return alumnos.map{it.nota}.average()
    }

    override fun mostrarAprobados(alumnos: List<Alumnos>) {

        TODO("Not yet implemented")
    }

    override fun mostrarSuspensos(alumnos: List<Alumnos>) {
        TODO("Not yet implemented")

    }

    override fun buscarAlumno(alumnos: List<Alumnos>) {

        TODO("Not yet implemented")
    }

    override fun eliminarAlumno(alumnos: MutableList<Alumnos>) {

        TODO("Not yet implemented")
    }

}