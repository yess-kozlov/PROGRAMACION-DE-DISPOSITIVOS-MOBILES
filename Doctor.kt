package com.example.dipmob.models

data class Doctor(
    val name: String,          // Nombre del doctor
    val specialty: String,     // Especialidad del doctor
    val availability: String   // Disponibilidad del doctor (puede ser una fecha, rango de horas, etc.)
)
