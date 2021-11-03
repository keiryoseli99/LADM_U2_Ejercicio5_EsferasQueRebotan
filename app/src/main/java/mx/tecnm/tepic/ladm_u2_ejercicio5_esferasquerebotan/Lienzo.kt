package mx.tecnm.tepic.ladm_u2_ejercicio5_esferasquerebotan

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity) : View(p){
    /*
    CADA ESFERA TIENE UN X,Y. AL INICIAR TIENE UN TAMAÑO Y COLOR DIFERENTE C/U
    AL INICIAR TOMAN UN CAMINO DIFERENTE (1 DE 4). LAS ESFERAS MAS GRANDES CAMINAN MAS LENTO
    LAS ESFERAS MAS PEQUEÑAS SON MAS AGILES. LA CANTIDAD DE ESFERAS ES VARIABLE
     */
    val principal = p
    val esfera = Esferas(this)
    val hiloEsferas = MovimientoEsferas(this,esfera)

    init {
        hiloEsferas.start()
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p = Paint()
        c.drawColor(Color.YELLOW)
        (0..499).forEach {
            hiloEsferas.esfera[it].pintarEsfera(c)
        }
    }
}

class MovimientoEsferas(p:Lienzo, e:Esferas) : Thread(){
    val puntero = p
    val esfera = ArrayList<Esferas>()

    init {
        (1..500).forEach {
            val esf = Esferas(p)
            esfera.add(esf)
        }
    }

    override fun run() {
        super.run()
        while (true){
            (0..499).forEach {
                esfera[it].moverEsfera()
            }
            puntero.principal.runOnUiThread {
                puntero.invalidate()
            }
            sleep(170)
        }
    }
}