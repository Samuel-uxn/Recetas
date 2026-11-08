package com.aplications.recetas.model

data class Receta(
    val id: Int,
    val titulo: String,
    val tiempo: String,
    val dificultad: String,
    //val ingredientes: List<String>,
    //val preparacion: List<String>,
    val imagenRes: Int
)