package tech.mobiledeveloper.mawc3b5d1.companyB.paid

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import tech.mobiledeveloper.company_b.CompanyBPrimary
import tech.mobiledeveloper.company_b.CompanyBSecondary

@Composable
fun CompanyBTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = CompanyBPrimary,
            secondary = CompanyBSecondary
        ),
        typography = Typography(),
        content = content
    )
}