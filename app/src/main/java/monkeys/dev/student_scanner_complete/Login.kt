package monkeys.dev.student_scanner_complete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val iniciar_sesion = findViewById<Button>(R.id.btn_iniciar_sesion) as Button

        iniciar_sesion.setOnClickListener {
            val intent = Intent(this,Frame_Container::class.java)
            startActivity(intent)
        }
    }
}