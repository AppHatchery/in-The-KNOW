package com.example.intheknow

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        var poses = arrayOf<Array<Any>>(arrayOf(33.797620, -84.389770, "AHF Wellness Center - AID Atlanta", "(404) 870-7700"),
            arrayOf(33.742035, -84.348907, "Planned Parenthood Atlanta", "404-688-9300"),
            arrayOf(33.774890, -84.292920, "The Center at 246 Emory Sexual Health Center", "(404) 712-9001"),
            arrayOf(33.776420, -84.294380, "Positive Impact Health Centers", "(404) 589-9040"),
            arrayOf(33.739240,  -84.428320, "Sisterlove Inc.", "(404) 254-4734"),
            arrayOf(33.739240, -84.428320, "NAESM INC.", "(404) 691-8880"),
            arrayOf(33.812937651466626, -84.39368444192554, "AAbsoluteCARE Medical Center and Pharmacy", "(404) 231-4431"),
            arrayOf(33.75116762305163, -84.45871845270862, "NAESM Mens Health and Wellness Center", "(404) 609-3197"),
            arrayOf(33.68201910437185, -84.41870606807720, "Southside Medical Center", "(404) 688-1350"),
            arrayOf(33.71352714859813, -84.30998555272242, "Southside Medical Center", "(404) 688-1350"),
            arrayOf(33.72802597913828, -84.39198806806048, "Southside Medical Center", "(404) 564-6913"),
            arrayOf(33.74032813067974, -84.31126209874249, "Southside Medical Center", "(404) 688-1350"),
            arrayOf(33.81638829685689, -84.392201368028, "Empowerment Resource Center Incorporated", "(404) 526-1145"),
            arrayOf(33.75265693818952, -84.38149486858852, "Grady Health System", "(404) 616-7737"),
            arrayOf(33.751959327817836, -84.3743670066785, "Mercy Care","(678) 843-8600"),
            arrayOf(33.76301004179868, -84.37171071407751, "Faebris Medical and Community Education", "(404) 337-7486"),
            arrayOf(33.77581339709575, -84.29288160666974, "The Center at 246 Emory Sexual Health Center", "(404) 712-9001"),
            arrayOf(33.77740015234672, -84.29417137598256, "Positive Impact Health Centers", "(404) 589-9040"))

        poses.forEach {

            googleMap.addMarker(MarkerOptions().position(LatLng(it.get(0) as Double,
                it.get(1) as Double
            )).title(it.get(2) as String).snippet(it.get(3) as String))
        }

        googleMap.setOnMarkerClickListener {
            val clickCount = it.tag as? Int

           // val aTag = it
            //val aTitle = it.title
            //com.google.android.gms.maps.InfoWindow()


            // Check if a click count was set, then display the click count.
            //clickCount?.let {
               // val newClickCount = it + 1
                //aTag = newClickCoun
            it.showInfoWindow()
           // }

            // Return false to indicate that we have not consumed the event and that we wish
            // for the default behavior to occur (which is for the camera to move such that the
            // marker is centered and for the marker's info window to open, if it has one).
            return@setOnMarkerClickListener false
        }





        val sydney = LatLng(33.75, -84.36)
        //googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 11.2f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}