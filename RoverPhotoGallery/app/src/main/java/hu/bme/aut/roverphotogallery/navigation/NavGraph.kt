package hu.bme.aut.roverphotogallery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.roverphotogallery.ui.screen.MainScreen
import hu.bme.aut.roverphotogallery.ui.screen.NasaMarsApiScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen(
                onShowPhotosPressed = {
                    navController.navigate(Screen.NasaMarsAPI.route)
                }
            )
        }
        composable(Screen.NasaMarsAPI.route) {
            NasaMarsApiScreen()
        }
    }
}

