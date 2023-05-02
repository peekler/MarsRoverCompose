package hu.bme.aut.roverphotogallery.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object NasaMarsAPI : Screen("nasamars")
}