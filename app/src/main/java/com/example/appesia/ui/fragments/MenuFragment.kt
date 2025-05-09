package com.example.appesia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appesia.R

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.naturalButton).setOnClickListener {
            findNavController().navigate(R.id.action_menu_to_natural)
        }

        view.findViewById<Button>(R.id.antropicoButton).setOnClickListener {
            findNavController().navigate(R.id.action_menu_to_antropico)
        }

        view.findViewById<Button>(R.id.regresarButton).setOnClickListener {
            findNavController().navigateUp()
        }
    }
} 