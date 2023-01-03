package id.slava.nt.pruebatecnicasergiocaseroapp.presentation.detail_poi

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PoiDetailScreen(navController: NavController,
                    viewModel: DetailPoiViewModel = koinViewModel()){

    val poi = viewModel.poiState.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = {
                            navController.navigateUp()
                    }) {
                        Icon(
                            imageVector =  Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                }

            }
        },
        content = {

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)){

                Spacer(modifier = Modifier.height(16.dp))
                GlideImage(imageModel = { poi.imageUrl },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = poi.id.toString()  )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = poi.title ?: "" )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = poi.coordinates ?: "" )
            }

        }
    )





}