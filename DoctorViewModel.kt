package com.example.dipmob.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dipmob.models.Doctor
import java.util.*

class DoctorViewModel : ViewModel() {

    // LiveData para el doctor seleccionado
    private val _selectedDoctor = MutableLiveData<Doctor>()
    val selectedDoctor: LiveData<Doctor> get() = _selectedDoctor

    // LiveData para los detalles de la cita (fecha y hora)
    private val _appointmentDetails = MutableLiveData<AppointmentDetails>()
    val appointmentDetails: LiveData<AppointmentDetails> get() = _appointmentDetails

    // Método para establecer el doctor seleccionado
    fun setSelectedDoctor(doctor: Doctor) {
        _selectedDoctor.value = doctor
    }

    // Método para establecer los detalles de la cita
    fun setAppointmentDetails(date: Date, time: String) {
        _appointmentDetails.value = AppointmentDetails(date, time)
    }

    // Clase para almacenar los detalles de la cita
    data class AppointmentDetails(
        val date: Date,
        val time: String
    )
}
