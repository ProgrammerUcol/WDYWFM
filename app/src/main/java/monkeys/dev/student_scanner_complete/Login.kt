package monkeys.dev.student_scanner_complete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    //SE DECLARA EL OBJETO DE AUTENTICACION
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        //SE INICIALIZA EL AUTH
        auth = Firebase.auth
        val iniciar_sesion = findViewById<Button>(R.id.btn_iniciar_sesion) as Button

        iniciar_sesion.setOnClickListener {
            val intent = Intent(this,Frame_Container::class.java)
            startActivity(intent)
        }
    }
}