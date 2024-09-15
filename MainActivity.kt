import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

        // Obtener referencias a los componentes del layout (EditTexts, ImageView, Button)
        val nombreEditText = findViewById<EditText>(R.id.et_nombre) //  nombre
        val correoEditText = findViewById<EditText>(R.id.et_correo) // correo electrónico
        val telefonoEditText = findViewById<EditText>(R.id.et_telefono) // numero celular
        val imageView = findViewById<ImageView>(R.id.imageView) // ImageView para la imagen de perfil
        val enviarButton = findViewById<Button>(R.id.btn_enviar) // Botón para enviar el formulario

        // Configurar el evento OnClickListener para el botón de enviar
        enviarButton.setOnClickListener {
            // Traer los valores de los EditTexts como cadenas de texto
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
                Toast.makeText(this, "Formulario enviado de forma exitosa", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
