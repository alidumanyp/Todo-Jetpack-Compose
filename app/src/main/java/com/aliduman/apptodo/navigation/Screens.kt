import androidx.navigation.NavHostController
import com.aliduman.apptodo.util.Action
import com.aliduman.apptodo.util.Constants.LIST_SCREEN
import com.aliduman.apptodo.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {

    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    val list: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

    val task: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true } // Clear the back stack
        }
    }


}