package mx.tecnm.tepic.ladm_u2_ejercicio5_esferasquerebotan

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Esferas(l:Lienzo){
    var puntero = l
    var posicionX = l.x
    var posicionY = l.y
    var limiteX = true
    var limiteY = true
    var x = 0f
    var y = 0f
    var tam = 0f
    var vel = 0
    var colors = arrayOf(Color.GREEN,
                        Color.BLUE,
                        Color.MAGENTA,
                        Color.RED,
                        Color.BLACK,
                        Color.CYAN,
                        Color.GRAY,
                        Color.DKGRAY,
                        Color.WHITE)
    //lateinit var color: Color
    var indice = 0

    init {
        //x = (Math.random()*2000).toFloat() //donde inicia x
        //y = ((Math.random()*1200)*-1).toFloat() //donde inicio y
        tam = (((10..20).random())*3).toFloat() //tamaños de las esferas
        //mas pequeñas a mas grandes
    }

    fun moverEsfera(){
        y += tam
        if(y>1000) y = ((Math.random()*2000)*-1).toFloat()

        if (limiteX == true) {
            posicionX = (Math.random()*2000).toFloat()
            if (posicionX >= puntero.width) {
                limiteX = false
            }
        }else {
            posicionX = (Math.random()*2000).toFloat()
            if (posicionX <= 0f) {
                limiteX = true
            }
        }
        if (limiteY == true) {
            posicionY = ((Math.random()*1300)).toFloat()
            if (posicionY >= puntero.height) {
                limiteY = false
            }
        }else {
            posicionY = ((Math.random()*1300)).toFloat()
            if (posicionY <= 0f) {
                limiteY = true
            }
        }
    }

    fun pintarEsfera(c: Canvas){
        val p = Paint()
        (0..7).forEach {
            if (indice==9) indice = 0
            p.color = colors[indice]
            indice++
            c.drawCircle(posicionX,posicionY,tam,p)
        }
        /*p.color = Color.MAGENTA
        c.drawCircle(posicionX,posicionY,tam,p)*/
    }
}