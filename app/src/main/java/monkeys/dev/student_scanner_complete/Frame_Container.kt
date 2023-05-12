package monkeys.dev.student_scanner_complete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class Frame_Container : AppCompatActivity() {

    lateinit var navegation : BottomNavigationView

    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId){
            R.id.item_Scanner_QR -> {
                supportFragmentManager.commit {
                    replace<Scanner_QR_Fragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.item_Registro -> {
                supportFragmentManager.commit {
                    replace<Registro_Fragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.item_Ayuda_Comentarios -> {
                supportFragmentManager.commit {
                    replace<Ayuda_Comentarios_Fragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_container)

        navegation = findViewById(R.id.Nav_menu)
        navegation.setOnNavigationItemSelectedListener(mOnNavMenu)

        supportFragmentManager.commit {
            replace<Scanner_QR_Fragment>(R.id.frame_container)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}