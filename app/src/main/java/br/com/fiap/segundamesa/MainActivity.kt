package br.com.fiap.segundamesa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.fiap.segundamesa.ui.screens.HomeScreen
import br.com.fiap.segundamesa.ui.theme.SegundaMesaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SegundaMesaTheme {
                HomeScreen()
            }
        }
    }
}
