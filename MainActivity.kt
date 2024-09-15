import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establecer el diseño XML que estamos usando para esta actividad
        setContentView(R.layout.activity_main)

        // Obtener referencias a los componentes del layout (EditTexts, ImageView, Button)
        val nombreEditText = findViewById<EditText>(R.id.et_nombre) // Campo para el nombre
        val correoEditText = findViewById<EditText>(R.id.et_correo) // Campo para el correo electrónico
        val telefonoEditText = findViewById<EditText>(R.id.et_telefono) // Campo para el número de teléfono
        val imageView = findViewById<ImageView>(R.id.imageView) // ImageView para la imagen de perfil (inicialmente logo del IPN)
        val enviarButton = findViewById<Button>(R.id.btn_enviar) // Botón para enviar el formulario

        // Configurar el evento OnClickListener para el botón de enviar
        enviarButton.setOnClickListener {
            // Extraer los valores de los EditTexts como cadenas de texto
            val nombre = nombreEditText.text.toString()
            val correo = correoEditText.text.toString()
            val telefono = telefonoEditText.text.toString()

            // Validar que todos los campos estén llenos
            if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
                // Mostrar un mensaje si algún campo está vacío
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Si todos los campos están completos, cambiar la imagen en el ImageView
                imageView.setImageResource(R.drawable.ipn_logo) // Cambiar la imagen a IPN-Logo
                // Mostrar un mensaje de éxito
                Toast.makeText(this, "Formulario enviado correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}oString()
            val correo = correoEditText.text.toString()
            val telefono = telefonoEditText.text.toString()

            // Validar que todos los campos estén llenos
            if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Lógica para cambiar la imagen de perfil
                imageView.setImageResource(R.drawable.new_image)
                Toast.makeText(this, "Formulario enviado correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
