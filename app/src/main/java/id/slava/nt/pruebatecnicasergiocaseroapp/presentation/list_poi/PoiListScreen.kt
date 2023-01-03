package id.slava.nt.pruebatecnicasergiocaseroapp.presentation.list_poi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun PoiListScreen(navController: NavController,
                  viewModel: PoiListViewModel = koinViewModel()){


    val list = viewModel.poiListState.collectAsState()



}