package com.example.dipmob.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dipmob.R
import com.example.dipmob.adapters.DoctorAdapter
import com.example.dipmob.models.Doctor
import com.example.dipmob.viewmodels.DoctorViewModel

class DoctorSelectionFragment : Fragment() {

    private lateinit var doctorViewModel: DoctorViewModel
    private lateinit var doctorAdapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctor_selection, container, false)

        // Inicializar el ViewModel compartido
        doctorViewModel = ViewModelProvider(requireActivity()).get(DoctorViewModel::class.java)

        // Configurar RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_doctors)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Lista de doctores simulada
        val doctors = listOf(
            Doctor("Dr. John Doe", "Cardiólogo", "Disponible"),
            Doctor("Dra. Jane Smith", "Dermatóloga", "Disponible"),
            Doctor("Dr. Carlos Rivera", "Pediatra", "No disponible")
        )

        // Configurar adaptador para el RecyclerView
        doctorAdapter = DoctorAdapter(doctors) { selectedDoctor ->
            doctorViewModel.setSelectedDoctor(selectedDoctor)
            navigateToAppointmentDetailsFragment()
        }
        recyclerView.adapter = doctorAdapter

        return view
    }

    // Navegar al siguiente fragmento
    private fun navigateToAppointmentDetailsFragment() {
        val nextFragment = AppointmentDetailsFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, nextFragment)
            .addToBackStack(null)
            .commit()
    }
}
