package com.example.dipmob.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dipmob.R
import com.example.dipmob.viewmodels.DoctorViewModel
import java.util.*

class AppointmentDetailsFragment : Fragment() {

    private lateinit var doctorViewModel: DoctorViewModel
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_appointment_details, container, false)

        // Inicializar el ViewModel compartido
        doctorViewModel = ViewModelProvider(requireActivity()).get(DoctorViewModel::class.java)

        // Mostrar el doctor seleccionado
        val doctorName: TextView = view.findViewById(R.id.selected_doctor_name)
        val doctorSpecialty: TextView = view.findViewById(R.id.selected_doctor_specialty)
        doctorViewModel.selectedDoctor.observe(viewLifecycleOwner) { doctor ->
            doctorName.text = doctor.name
            doctorSpecialty.text = doctor.specialty
        }

        // Inicializar DatePicker y TimePicker
        datePicker = view.findViewById(R.id.date_picker)
        timePicker = view.findViewById(R.id.time_picker)
        timePicker.setIs24HourView(true) // Modo de 24 horas

        // Botón para continuar a la confirmación
        val confirmButton: Button = view.findViewById(R.id.btn_confirm_appointment)
        confirmButton.setOnClickListener {
            if (validateDateTime()) {
                val appointmentDate = getDateFromPicker()
                val appointmentTime = getTimeFromPicker()
                doctorViewModel.setAppointmentDetails(appointmentDate, appointmentTime)
                navigateToConfirmationFragment()
            }
        }

        return view
    }

    // Validar que la fecha y hora seleccionadas sean válidas
    private fun validateDateTime(): Boolean {
        // En este ejemplo simple, no se permite seleccionar fechas en el pasado
        val selectedDate = getDateFromPicker()
        val today = Calendar.getInstance().time
        return selectedDate.after(today)
    }

    // Obtener la fecha seleccionada del DatePicker
    private fun getDateFromPicker(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(datePicker.year, datePicker.month, datePicker.dayOfMonth)
        return calendar.time
    }

    // Obtener la hora seleccionada del TimePicker
    private fun getTimeFromPicker(): String {
        return "${timePicker.hour}:${timePicker.minute}"
    }

    // Navegar al fragmento de confirmación
    private fun navigateToConfirmationFragment() {
        val nextFragment = ConfirmationFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, nextFragment)
            .addToBackStack(null)
            .commit()
    }
}
