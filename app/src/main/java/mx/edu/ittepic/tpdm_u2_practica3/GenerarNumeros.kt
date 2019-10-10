package mx.edu.ittepic.tpdm_u2_practica3

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import java.io.OutputStreamWriter
import kotlin.random.Random

 class GenerarNumeros(i: String, f: String, context: Context) : AsyncTask<Void, Void, List<Int>>() {
    var i = i.toInt()
    var f = f.toInt()
    var con = context
    var np = ""
    override fun doInBackground(vararg p0: Void?): List<Int> {
        val num = List(2000) {
            Random.nextInt(i,f)
        }
        return num
    }

    override fun onPostExecute(result: List<Int>?) {
        super.onPostExecute(result)
        var conteo = 0
        var et = ""

        (0..1999).forEach {
            conteo = 0
            et = result?.get(it).toString()
            (1..et.toInt()).forEach {
                if (et.toInt() % it == 0) {
                    conteo++
                }
            }
            if (conteo <= 2 && et.toInt()>1) {
                np=np+et+", "
            }
        }
        guardarTXT(np)
    }
    fun guardarTXT(NP: String){
        val guardarArchivo = OutputStreamWriter(con.openFileOutput("primos.txt", Activity.MODE_PRIVATE))
        guardarArchivo.write(NP)
        guardarArchivo.flush()
        guardarArchivo.close()
        Toast.makeText(con,"Números primos guardados!", Toast.LENGTH_SHORT).show()
        Toast.makeText(con,NP, Toast.LENGTH_LONG).show()
    }
}