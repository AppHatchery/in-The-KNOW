package com.apphatchery.intheknow.ui.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import com.apphatchery.intheknow.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [videosInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class videosInfo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos_info, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment videosInfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            videosInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var titleText : TextView = view.findViewById(R.id.titleOfVid)
        //var contentText : TextView = view.findViewById(R.id.textOfNews)






        //titleText.setText(Global.vidTitle)
        //textOfNews.setText(Global.newsContent)



        var v = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view)
        var v2 = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view2)
        var v3 = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view3)
        var v4 = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view4)
        var v5 = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view5)
        var v6 = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view6)
        var v7 = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view7)
        var v8 = view.findViewById<com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView>(R.id.third_party_player_view8)

        v.getPlayerUiController().showFullscreenButton(true)
        v.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "F-_qJdcKxaI"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })

        v2.getPlayerUiController().showFullscreenButton(true)
        v2.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "aRz30Q_S5vY"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })

        v3.getPlayerUiController().showFullscreenButton(true)
        v3.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "jw3TJuJae1c"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })

        v4.getPlayerUiController().showFullscreenButton(true)
        v4.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "LvTJnX8nIWY"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })


        v5.getPlayerUiController().showFullscreenButton(true)
        v5.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "-Xx92whZS0o"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })

        v6.getPlayerUiController().showFullscreenButton(true)
        v6.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "jyDHRJ_zwQ4"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })

        v7.getPlayerUiController().showFullscreenButton(true)
        v7.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "zk71hFVgniE"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })

        v8.getPlayerUiController().showFullscreenButton(true)
        v8.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = "fGhKPyV86yM"
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })


    }
}