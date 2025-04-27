package com.example.appesia.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appesia.R
import com.google.android.material.snackbar.Snackbar

class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.inicioButton).setOnClickListener {
            findNavController().navigate(R.id.action_inicio_to_menu)
        }

        view.findViewById<Button>(R.id.creditosButton).setOnClickListener {
            findNavController().navigate(R.id.action_inicio_to_creditos)
        }

        view.findViewById<Button>(R.id.codigoPostalButton).setOnClickListener {
            showCodigoPostalDialog()
        }
    }

    private fun showCodigoPostalDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_codigo_postal, null)
        val editText = dialogView.findViewById<EditText>(R.id.codigoPostalEditText)

        AlertDialog.Builder(requireContext())
            .setTitle("Ingresa tu código postal")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val codigoPostal = editText.text.toString()
                if (codigoPostal.isNotEmpty()) {
                    saveCodigoPostal(codigoPostal)
                    Snackbar.make(requireView(), "Código postal guardado", Snackbar.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun saveCodigoPostal(codigoPostal: String) {
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("codigo_postal", codigoPostal)
            apply()
        }
    }
} 