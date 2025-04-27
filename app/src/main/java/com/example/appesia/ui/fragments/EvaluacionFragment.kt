package com.example.appesia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appesia.R

class EvaluacionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_evaluacion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val respuesta1RadioGroup = view.findViewById<RadioGroup>(R.id.respuesta1RadioGroup)
        val respuesta2RadioGroup = view.findViewById<RadioGroup>(R.id.respuesta2RadioGroup)
        val resultadoTextView = view.findViewById<TextView>(R.id.resultadoTextView)

        view.findViewById<Button>(R.id.enviarButton).setOnClickListener {
            val puntuacion = calcularPuntuacion(respuesta1RadioGroup, respuesta2RadioGroup)
            mostrarResultado(puntuacion, resultadoTextView)
        }

        view.findViewById<Button>(R.id.regresarButton).setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun calcularPuntuacion(
        respuesta1RadioGroup: RadioGroup,
        respuesta2RadioGroup: RadioGroup
    ): Int {
        var puntuacion = 0

        // Verificar primera pregunta
        val respuesta1Seleccionada = respuesta1RadioGroup.checkedRadioButtonId
        if (respuesta1Seleccionada == R.id.respuesta1ARadioButton) {
            puntuacion++
        }

        // Verificar segunda pregunta
        val respuesta2Seleccionada = respuesta2RadioGroup.checkedRadioButtonId
        if (respuesta2Seleccionada == R.id.respuesta2ARadioButton) {
            puntuacion++
        }

        return puntuacion
    }

    private fun mostrarResultado(puntuacion: Int, resultadoTextView: TextView) {
        val totalPreguntas = 2
        val mensaje = "Tu puntuación: $puntuacion/$totalPreguntas"
        resultadoTextView.text = mensaje
    }
} 