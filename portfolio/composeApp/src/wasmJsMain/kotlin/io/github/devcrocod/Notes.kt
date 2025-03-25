package io.github.devcrocod

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotesPage(
    scrollState: androidx.compose.foundation.ScrollState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 32.dp, vertical = 60.dp) // Reduced vertical padding
    ) {
        Text(
            "Notes",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(bottom = 24.dp), // Reduced padding
        )

        Text(
            "Thoughts, ideas, and articles about development and design",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(bottom = 40.dp) // Reduced padding
                .fillMaxWidth(0.8f)
        )

        // Blog Posts - Reduced to 3 for fewer elements
        SimplifiedBlogPost(
            title = "Implementing Clean Architecture in Kotlin",
            date = "May 15, 2023",
            summary = "An exploration of how Clean Architecture principles can be applied to Kotlin projects, with practical examples and benefits.",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            dividerColor = MaterialTheme.colorScheme.outline,
        )

        SimplifiedBlogPost(
            title = "The Power of Compose Multiplatform",
            date = "March 22, 2023",
            summary = "How Compose Multiplatform is changing the way we think about cross-platform development with shared UI code.",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            dividerColor = MaterialTheme.colorScheme.outline,
        )

        SimplifiedBlogPost(
            title = "Minimalism in UI Design",
            date = "January 10, 2023",
            summary = "Why less is often more in user interface design, and principles to create effective minimalist interfaces.",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            dividerColor = MaterialTheme.colorScheme.outline,
            isLast = true // No divider for the last item
        )
    }
}

@Composable
fun SimplifiedBlogPost(
    title: String,
    date: String,
    summary: String,
    textColor: Color,
    subtitleColor: Color,
    dividerColor: Color,
    isLast: Boolean = false
) {
    // Removed hover effect for better performance and simpler UI
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp) // Reduced padding
            .clickable { /* Navigate to blog post */ }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge, // Smaller heading
            color = textColor
        )
        Text(
            text = date,
            style = MaterialTheme.typography.bodySmall,
            color = subtitleColor,
            modifier = Modifier.padding(vertical = 8.dp) // Reduced padding
        )
        Text(
            text = summary,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(0.9f),
            color = textColor
        )

        // Only show divider if not the last item
        if (!isLast) {
            HorizontalDivider(
                modifier = Modifier.padding(top = 16.dp), // Reduced padding
                thickness = DividerDefaults.Thickness, 
                color = dividerColor
            )
        }
    }
}
