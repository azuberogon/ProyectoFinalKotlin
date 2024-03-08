import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityObjetivosBinding
import com.example.dallyproject.imanol.Nuevos_objetivos

class Objetivos : AppCompatActivity() {

    private lateinit var btnAgregar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivos)

        btnAgregar = findViewById(R.id.btnAgregarTematica)

        btnAgregar.setOnClickListener {
            val intent = Intent(this, Nuevos_objetivos::class.java)
            startActivity(intent)
        }
    }
}
