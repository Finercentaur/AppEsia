package com.example.appesia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appesia.R

class AntropicoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_antropico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.quimicoButton).setOnClickListener {
            findNavController().navigate(R.id.action_antropico_to_quimico)
        }

        view.findViewById<Button>(R.id.sanitarioButton).setOnClickListener {
            findNavController().navigate(R.id.action_antropico_to_sanitario)
        }

        view.findViewById<Button>(R.id.socioButton).setOnClickListener {
            findNavController().navigate(R.id.action_antropico_to_socio)
        }

        view.findViewById<Button>(R.id.regresarButton).setOnClickListener {
            findNavController().navigateUp()
        }
    }
} 