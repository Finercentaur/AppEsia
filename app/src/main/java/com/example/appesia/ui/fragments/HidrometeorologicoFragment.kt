package com.example.appesia.ui.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appesia.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class HidrometeorologicoFragment : Fragment() {

    private var exoPlayer: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hidrometeorologico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el reproductor de video
        val videoUrl = "https://example.com/video.mp4" // Reemplazar con la URL real del video
        val playerView = view.findViewById<PlayerView>(R.id.videoPlayerView)
        exoPlayer = ExoPlayer.Builder(requireContext()).build()
        playerView.player = exoPlayer
        val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
        exoPlayer?.setMediaItem(mediaItem)
        exoPlayer?.prepare()

        // Configurar los botones de riesgos
        view.findViewById<Button>(R.id.inundacionButton).setOnClickListener {
            // Mostrar información sobre inundaciones
        }

        view.findViewById<Button>(R.id.huracanButton).setOnClickListener {
            // Mostrar información sobre huracanes
        }

        view.findViewById<Button>(R.id.sequiaButton).setOnClickListener {
            // Mostrar información sobre sequías
        }

        view.findViewById<Button>(R.id.evaluacionButton).setOnClickListener {
            findNavController().navigate(R.id.action_hidrometeorologico_to_evaluacion)
        }

        view.findViewById<Button>(R.id.regresarButton).setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        exoPlayer?.release()
        exoPlayer = null
    }
} 