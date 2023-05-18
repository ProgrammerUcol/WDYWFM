package monkeys.dev.student_scanner_complete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

    //-SE DECLARA EL OBJETO DE AUTENTICACION-//
    private lateinit var firebaseAuth: FirebaseAuth
    //private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        //-Variables que con los datos que el usuario introduce-//
        var user = findViewById<EditText>(R.id.etxt_correo_ucol) as EditText
        var password = findViewById<EditText>(R.id.etxt_contraseña) as EditText

        //-Variables para los botones-//
        val iniciar_sesion = findViewById<Button>(R.id.btn_iniciar_sesion) as Button
        val registrarse = findViewById<Button>(R.id.btn_registrarse) as Button

        //-SE INICIALIZA EL AUTH-//
        firebaseAuth = Firebase.auth

        //-Boton de iniciar sesion-//
        iniciar_sesion.setOnClickListener {
            singIn(user.text.toString(), password.text.toString())
        }

        //-Boton de registro de nuevos usuarios-//
        registrarse.setOnClickListener {
            val nuevo = Intent(this, User_register::class.java)
            startActivity(nuevo)
        }

    }

    //-Función para evaluar el inicio de sesión-//
    private fun singIn(email: String, password: String){

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){ task ->
            if (task.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext,"Inicio de sesión exitoso", Toast.LENGTH_LONG).show()

                val intento = Intent( this, Frame_Container::class.java)
                startActivity(intento)
            }else{
                Toast.makeText(baseContext,"Error: Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }
    }
}