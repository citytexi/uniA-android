package com.ajouunia.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.onboarding.route.AgreementServiceRoute
import com.ajouunia.feature.onboarding.route.SignInRoute

const val SIGN_IN_NAVIGATION_ROUTE = "sign_in_route"
const val AGREEMENT_SERVICE_ROUTE = "agreement_service_route"
const val FORGOT_PASSWORD_NAVIGATION_ROUTE = "forgot_password_route"

fun NavController.navigateToSignIn(navOptions: NavOptions? = null) {
    this.navigate(SIGN_IN_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToAgreementService(navOptions: NavOptions? = null) {
    this.navigate(AGREEMENT_SERVICE_ROUTE, navOptions)
}

fun NavController.navigateToForgotPassword(navOptions: NavOptions? = null) {
    this.navigate(AGREEMENT_SERVICE_ROUTE, navOptions)
}

fun NavGraphBuilder.onBoarding(
    navigateToAgreementService: (NavOptions) -> Unit,
    navigateToForgotPassword: (NavOptions) -> Unit,
    navigateToHome: (NavOptions) -> Unit
) {
    composable(route = SIGN_IN_NAVIGATION_ROUTE) {
        SignInRoute(
            navigateToAgreementService = navigateToAgreementService,
            navigateToForgotPassword = navigateToForgotPassword,
            navigateToHome = navigateToHome
        )
    }
    composable(route = AGREEMENT_SERVICE_ROUTE) {
        AgreementServiceRoute(
            navigateToTerms = {},
            navigateToPrivacy = {},
            navigateToConfirmEmail = {}
        )
    }
}