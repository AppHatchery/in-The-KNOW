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
        var poses = arrayOf<Array<Any>>(arrayOf(-30.0, 150.0, "Atlanta" ), arrayOf(-34.0, 154.0, "Sydney"), arrayOf(-38.0, 158.0, "Ocean"))

        poses.forEach {


            googleMap.addMarker(MarkerOptions().position(LatLng(it.get(0) as Double,
                it.get(1) as Double
            )).title(it.get(2) as String))
        }

        googleMap.setOnMarkerClickListener {
            val clickCount = it.tag as? Int

           // val aTag = it
            //val aTitle = it.title


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





        val sydney = LatLng(-34.0, 151.0)
        //googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
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