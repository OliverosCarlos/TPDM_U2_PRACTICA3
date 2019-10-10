package mx.edu.ittepic.tpdm_u2_practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var n: EditText? = null
    var m: EditText? = null
    var boton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        n = findViewById(R.id.numN)
        m = findViewById(R.id.numM)
        boton = findViewById(R.id.ejecutar)

        ejecutar?.setOnClickListener{
        var GN =  GenerarNumeros(
                n?.text.toString(),
                m?.text.toString(),
                applicationContext
            ).execute()
        }
    }


}
