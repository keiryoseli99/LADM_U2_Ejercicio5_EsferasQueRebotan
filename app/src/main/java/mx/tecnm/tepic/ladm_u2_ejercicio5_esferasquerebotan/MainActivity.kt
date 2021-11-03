package mx.tecnm.tepic.ladm_u2_ejercicio5_esferasquerebotan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
    }
}