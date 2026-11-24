package modelo
val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m"

data class Alumnos(
    val nombre: String,
    val apellido: String,
    val nota:Double,
){
    init {  /**Bloque init de la data class Alumno donde es el propio alumno quien realiza las comprobaciones
     de  si el nombre no está vacio , apellido y nota se encuentra en un intervalo ***/
        require(nombre.isNotBlank()) {"${ROJO} El nombre no puede estar vacio $RESET"}
        require(apellido.isNotBlank()){"${ROJO} El apellido no puede estar vacio $RESET"}
        require(nota in 0.0..10.0 ){"${ROJO} Error! la nota debe ser entre 0 y 10 $RESET"}
    }
}


interface GestorFuncionesAlumnos{ // Interfaz generica que contiene los metodos principales
    fun registrarAlumno(alumnos: MutableList<Alumnos>) // Metodo registrar  exigira nombre  apellido y nota del alumno

    /** Los metodos listar,calcularMedia,Mostrar aprobados  mostrar suspensos , buscar alumnos y eliminar
     * Siempre  haran una  comprobacion   de si la lista se encuentra vacia en caso afirmativo saltara un mensaje de error
     * y devolvera al usuario al menu principal**/
    fun listarAlumnos(alumnos: List<Alumnos>) // nseñara el contenido de la lista actual
    fun calcularMedia(alumnos: List<Alumnos>): Double //  Calculara la media grupal de la lista
    fun mostrarAprobados(alumnos: List<Alumnos>) // Filtrara los alumnos  con el metodo .filter  y unicamente enseñara aquellos alumnos por encima o igual que cinco
    fun mostrarSuspensos(alumnos: List<Alumnos>) // Realiza el mismo procedimiento pero unicamente enseña del cinco (sin incluirlo) hasta el 0
    fun buscarAlumno(alumnos: List<Alumnos>) // Buscara el alumno y lo enseñara
    fun eliminarAlumno(alumnos: MutableList<Alumnos>) // Eliminara al alumno de la posicion seleccionada

}