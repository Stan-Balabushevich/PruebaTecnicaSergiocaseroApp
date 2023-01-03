package id.slava.nt.pruebatecnicasergiocaseroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.slava.nt.pruebatecnicasergiocaseroapp.presentation.navigation.Navigation
import id.slava.nt.pruebatecnicasergiocaseroapp.ui.theme.PruebaTecnicaSergiocaseroAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PruebaTecnicaSergiocaseroAppTheme {

                Navigation()

            }
        }
    }
}

