package gt.uvg.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import gt.uvg.lab4.model.DatosMascotas
import gt.uvg.lab4.model.Mascota
import gt.uvg.lab4.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                ListaMascotasScreen()
            }
        }
    }
}

@Composable
fun ListaMascotasScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(DatosMascotas.lista) { mascota ->
            TarjetaMascota(mascota)
        }
    }
}

@Composable
fun TarjetaMascota(mascota: Mascota) {
    var adoptado by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = mascota.fotoRes),
                contentDescription = "Foto de ${mascota.nombre}",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(16.dp))

            Column(Modifier.weight(1f)) {
                Text(
                    text = mascota.nombre,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium // “texto grande”
                )
                Text(
                    text = mascota.raza,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f) // gris
                )
            }

            Spacer(Modifier.width(8.dp))

            Button(onClick = { adoptado = !adoptado }) {
                Text(if (adoptado) "¡Adoptado! ❤" else "Adoptar") // texto exacto del PDF
            }
        }
    }
}
