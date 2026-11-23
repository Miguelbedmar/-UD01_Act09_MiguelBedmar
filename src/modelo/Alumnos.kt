package modelo
val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m"

data class Alumnos(
    val nombre: String,
    val apellido: String,
    val nota:Double,
){
    init {
        require(nombre.isNotBlank()) {"${ROJO} El nombre no puede estar vacio $RESET"}
        require(apellido.isNotBlank()){"${ROJO} El apellido no puede estar vacio $RESET"}
        require(nota in 0.0..10.0 ){"${ROJO} Error! la nota debe ser entre 0 y 10 $RESET"}
    }
}


