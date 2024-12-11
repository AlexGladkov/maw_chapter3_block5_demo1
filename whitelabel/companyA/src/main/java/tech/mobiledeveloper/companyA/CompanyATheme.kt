package tech.mobiledeveloper.companyA

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import tech.mobiledeveloper.companyA.theme.CompanyAPrimary
import tech.mobiledeveloper.companyA.theme.CompanyASecondary

@Composable
fun CompanyATheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = CompanyAPrimary,
            secondary = CompanyASecondary
        ),
        typography = Typography(),
        content = content
    )
}