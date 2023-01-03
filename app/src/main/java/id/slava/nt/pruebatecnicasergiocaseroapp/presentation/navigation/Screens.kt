package id.slava.nt.pruebatecnicasergiocaseroapp.presentation.navigation

sealed class Screen(val route: String) {
    object ListPoiScreen: Screen("list_poi_screen")
    object DetailPoiScreen: Screen("detail_poi_screen")
}
