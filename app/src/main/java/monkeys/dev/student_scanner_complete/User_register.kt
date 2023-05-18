package monkeys.dev.student_scanner_complete

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class User_register : AppCompatActivity() {

    //-SE DECLARA EL OBJETO DE AUTENTICACION-//
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_register)

        //SE INICIALIZA EL AUTH
        firebaseAuth = Firebase.auth

        //-Variables que recopilan la nueva credencial-//
        val nuevoemail = findViewById<EditText>(R.id.etxt_correo_ucol) as EditText
        val nuevopassword = findViewById<EditText>(R.id.etxt_contraseña) as EditText

        //-Variables de los botones-//
        val registrarse = findViewById<Button>(R.id.btn_registrarse) as Button

        //-Registro de nuevo usuario-//
        registrarse.setOnClickListener {
            if(nuevoemail.text.toString() == "" || nuevopassword.text.toString() == "")
            {
                Toast.makeText(this, "¡Aún faltan campos por rellenar!", Toast.LENGTH_LONG).show()
            }else{
                createAccount(nuevoemail.text.toString(), nuevopassword.text.toString())
            }
        }
    }

    private fun createAccount(email: String, password: String){
        //-Inicia función-//
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(baseContext,"Usuario creado exitosamente, ¡Inicia sesión!", Toast.LENGTH_LONG).show()
                    val user = firebaseAuth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext,"Error, revisa la ayuda de cada campo o verifica tu conexion a internet", Toast.LENGTH_LONG).show()
                    updateUI(null)
                }
            }
        //-Fin de la función-//
    }

    private fun updateUI(user: FirebaseUser?){
        //-Lo procesa como nuevo usuario a Firebase-//
    }
}