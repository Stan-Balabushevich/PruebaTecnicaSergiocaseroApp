package id.slava.nt.pruebatecnicasergiocaseroapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.slava.nt.pruebatecnicasergiocaseroapp.presentation.detail_poi.PoiDetailScreen
import id.slava.nt.pruebatecnicasergiocaseroapp.presentation.list_poi.PoiListScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ListPoiScreen.route
    ) {
        composable(route = Screen.ListPoiScreen.route) {
            PoiListScreen(navController = navController)
        }
        composable(
            route = Screen.DetailPoiScreen.route +
                    // if needs more arguments
                    "?noteId={noteId}",
            arguments = listOf(
                navArgument(
                    name = "noteId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            PoiDetailScreen(navController = navController)
        }
    }

}