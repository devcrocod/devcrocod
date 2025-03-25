package io.github.devcrocod

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProjectsPage(
    scrollState: ScrollState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 32.dp, vertical = 60.dp) // Reduced vertical padding
    ) {
        Text(
            "Projects",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(bottom = 24.dp), // Reduced padding
        )

        Text(
            "Design principles and development work",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 40.dp) // Reduced padding
        )

        // Reduced to 3 project cards for fewer elements on screen
        SimplifiedProjectCard(
            title = "Aesthetic-Usability Effect",
            description = "Users often perceive aesthetically pleasing design as more usable. This project demonstrates how visual appeal can enhance usability.",
            technologies = "Kotlin, Compose, Material Design",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            borderColor = MaterialTheme.colorScheme.outline,
        )

        Spacer(modifier = Modifier.height(32.dp)) // Reduced spacing

        SimplifiedProjectCard(
            title = "Doherty Threshold",
            description = "Productivity soars when interactions are fast (<400ms). This app was optimized for rapid response times.",
            technologies = "Kotlin, Coroutines, Jetpack",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            borderColor = MaterialTheme.colorScheme.outline,
        )

        Spacer(modifier = Modifier.height(32.dp)) // Reduced spacing

        SimplifiedProjectCard(
            title = "Hick's Law",
            description = "The time to make a decision increases with the number of choices. This project simplifies complex workflows into manageable decisions.",
            technologies = "Kotlin/JS, React, Redux",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            borderColor = MaterialTheme.colorScheme.outline,
        )
    }
}

@Composable
fun SimplifiedProjectCard(
    title: String,
    description: String,
    technologies: String,
    textColor: Color,
    subtitleColor: Color,
    borderColor: Color
) {
    // Removed hover effect for better performance and simpler UI
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { /* Navigate to project details */ }
            .padding(24.dp) // Reduced padding for less scrolling
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge, // Smaller heading
            color = textColor
        )
        Spacer(modifier = Modifier.height(16.dp)) // Reduced spacing
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium, // Smaller text
            color = textColor
        )
        Spacer(modifier = Modifier.height(16.dp)) // Reduced spacing
        Text(
            text = "Technologies: $technologies",
            style = MaterialTheme.typography.bodySmall,
            color = subtitleColor
        )
    }
}

@Composable
fun ProjectDetailPage(
    projectTitle: String,
    scrollState: ScrollState,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 32.dp, vertical = 32.dp)
    ) {
        // Back button
        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text("← Back to Projects")
        }

        // Project title
        Text(
            text = projectTitle,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Project image placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Project Image",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Project description
        Text(
            text = "Project Description",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "This is a detailed description of the $projectTitle project. It includes information about the goals, challenges, and solutions implemented in this project. The description provides insights into the technologies used and the approach taken to solve the problem.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Technologies used
        Text(
            text = "Technologies Used",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "• Kotlin\n• Compose Multiplatform\n• Material Design 3\n• Coroutines",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Project outcomes
        Text(
            text = "Outcomes",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "The project was successfully delivered and met all the requirements. It provided a modern, responsive user interface with excellent performance and accessibility. The client was very satisfied with the results.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
