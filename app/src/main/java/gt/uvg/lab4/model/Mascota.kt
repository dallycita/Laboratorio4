package gt.uvg.lab4.model

// Modelo para cada mascota que se mostrará en la lista
data class Mascota(
    val id: Int,
    val nombre: String,
    val raza: String,
    val fotoRes: Int
)