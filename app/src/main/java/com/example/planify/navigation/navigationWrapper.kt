package com.example.planify.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.planify.screen.categories.ui.CategoriasScreen
import com.example.planify.screen.categories.ui.CategoryFormScreen
import com.example.planify.screen.forgetPassword.ui.forgetPasswordScreen
import com.example.planify.screen.homePage.ui.homePageScreen
import com.example.planify.screen.launch.ui.launchScreen1
import com.example.planify.screen.launch.ui.launchScreen2
import com.example.planify.screen.login.ui.loginScreen
import com.example.planify.screen.notebook.ui.LibretaScreen
import com.example.planify.screen.notebook.ui.NotebookAddScreen
import com.example.planify.screen.profile.ui.PasswordChangeScreen
import com.example.planify.screen.profile.ui.ProfileEditScreen
import com.example.planify.screen.profile.ui.ProfileScreen
import com.example.planify.screen.register.ui.registerScreen
import com.example.planify.screen.welcome.ui.welcomePlanifyScreen
import com.example.planify.screen.welcome.ui.welcomePlanifyViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navigationWrapper(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = launchScreen1) {
        composable<launchScreen1> {
            launchScreen1(
                modifier = modifier,
                navigateTolaunchScreen2 = {
                    navController.navigate(launchScreen2)
                }
            )
        }

        composable<launchScreen2> {
            launchScreen2(
                modifier = modifier,
                navigateToLoginScreen =
                    {
                        navController.navigate(loginScreen)
                    }, navigateToWelcomePlanify = {
                    navController.navigate(welcomePlanifyScreen)
                }
            )
        }
        composable<loginScreen> {
            loginScreen(
                modifier = modifier,
                navegateToRegister = {
                    navController.navigate(register)
                },
                navegateToForgetPassword = {
                    navController.navigate(forgetPasswordScreen)
                },
                navegateToHome = {
                    navController.navigate(homePageScreen) {
                        popUpTo(loginScreen) { inclusive = true }
                    }
                }
            )
        }

        composable<forgetPasswordScreen> {
            forgetPasswordScreen(
                modifier = modifier,
                navigateToLogin = {
                    navController.navigate(loginScreen)
                }
            )
        }

        composable<register> {
            registerScreen(
                modifier = modifier,
                navigateToLogin = {
                    navController.navigate(loginScreen)
                }
            )
        }

        composable<welcomePlanifyScreen> { navBackStackEntry ->
            val viewModel: welcomePlanifyViewModel = viewModel(navBackStackEntry)
            welcomePlanifyScreen(
                modifier = modifier,
                viewModel = viewModel,
                navigateToSecondWelcome = {
                    navController.navigate(register)
                }
            )
        }

        composable<homePageScreen> {
            homePageScreen(
                modifier = modifier,
                onSettingsClick = {
                    navController.navigate(profileScreen)
                },
                onNoteBookClick = {
                    navController.navigate(notebookScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onCategoryClick = {
                    navController.navigate(categoriesScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onHomeClick = {
                    navController.navigate(homePageScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }


        composable<profileChangePasswordScreen> {
            PasswordChangeScreen(
                modifier = modifier,
                onBackClick = {
                    navController.navigate(profileScreen) {
                        popUpTo(profileChangePasswordScreen) { inclusive = true }
                    }
                }
            )
        }

        composable<profileEditScreen> {
            ProfileEditScreen(
                modifier = modifier,
                onBackClick = {
                    navController.navigate(profileScreen) {
                        popUpTo(profileEditScreen) { inclusive = true }
                    }
                },
                onCancelClick = {
                    navController.navigate(profileScreen) {
                        popUpTo(profileEditScreen) { inclusive = true }
                    }
                }
            )
        }

        composable<profileScreen> {
            ProfileScreen(
                modifier = modifier,
                onBackClick = {
                    navController.navigate(homePageScreen) {
                        popUpTo(profileScreen) { inclusive = true }
                    }
                },
                onEditProfileClick = {
                    navController.navigate(profileEditScreen) {
                        popUpTo(profileScreen) { inclusive = false }
                    }
                },
                onChangePasswordClick = {
                    navController.navigate(profileChangePasswordScreen) {
                        popUpTo(profileScreen) { inclusive = false }
                    }
                },
                onLogoutClick = {
                    navController.navigate(loginScreen) {
                        popUpTo(profileScreen) { inclusive = true }
                    }
                }
            )
        }
        composable<notebookScreen> {
            LibretaScreen(
                modifier = modifier,
                navController = navController,
                onAddGoalClick = {
                    navController.navigate(notebookAddScreen)
                },
                onHomeClick = {
                    navController.navigate(homePageScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onSettingsClick = {navController.navigate(profileScreen)},
                onNoteBookClick = {
                    navController.navigate(notebookScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onCategoryClick = {
                    navController.navigate(categoriesScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<notebookAddScreen> {
            NotebookAddScreen(
                onBackClick = { navController.popBackStack() },
                onSaveClick = { navController.popBackStack() }
            )
        }


        composable<categoriesScreen> {
            CategoriasScreen(
                modifier = modifier,
                onEditCategory = { categoryName ->
                    navController.navigate("categoryFormScreen/$categoryName")
                },
                onAddCategory = {
                    navController.navigate("categoryFormScreen/")
                },
                onBack = {
                    navController.navigateUp()
                },
                onSettingsClick = { navController.navigate(profileScreen) },
                onNoteBookClick = {
                    navController.navigate(notebookScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onCategoryClick = {
                    navController.navigate(categoriesScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onHomeClick = {
                    navController.navigate(homePageScreen) {
                        popUpTo(homePageScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = "categoryFormScreen/{categoryName}",
            arguments = listOf(navArgument("categoryName") {
                defaultValue = ""
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            val isEditMode = categoryName.isNotEmpty()

            CategoryFormScreen(
                isEditMode = isEditMode,
                categoryName = categoryName,
                onCategoryNameChange = {}, // opcional si se usa desde el ViewModel
                onSave = {
                    navController.navigate(categoriesScreen) {
                        popUpTo("categoryFormScreen/$categoryName") { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onCancel = {
                    navController.navigate(categoriesScreen) {
                        popUpTo("categoryFormScreen/$categoryName") { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onBack = {
                    navController.navigate(categoriesScreen) {
                        popUpTo("categoryFormScreen/$categoryName") { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}








