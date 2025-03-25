package io.github.devcrocod

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AboutPage(
    scrollState: androidx.compose.foundation.ScrollState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 32.dp, vertical = 60.dp) // Reduced vertical padding
    ) {
        Text(
            "About Me",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(bottom = 24.dp), // Reduced padding
        )

        Text(
            "I'm a software developer with a passion for creating intuitive, efficient, and meaningful digital experiences. I specialize in Kotlin development across platforms, from mobile to web applications.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(bottom = 40.dp) // Reduced padding
                .fillMaxWidth(0.8f),
        )

        // Work Experience Section - Limited to 2 items for fewer elements
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp) // Reduced padding
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Column(
                modifier = Modifier.padding(24.dp) // Added padding inside box
            ) {
                Text(
                    "Experience",
                    style = MaterialTheme.typography.titleLarge, // Smaller heading
                    modifier = Modifier.padding(bottom = 16.dp), // Reduced padding
                )

                // Limited to 2 most recent experiences
                SimplifiedExperienceItem(
                    position = "Senior Developer",
                    company = "XYZ Company",
                    period = "2020-Present",
                    description = "Leading development of multiplatform applications using Kotlin and Compose.",
                    textColor = MaterialTheme.colorScheme.onBackground,
                    subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    dividerColor = MaterialTheme.colorScheme.outline,
                )

                SimplifiedExperienceItem(
                    position = "Mobile Developer",
                    company = "ABC Corp",
                    period = "2018-2020",
                    description = "Developed Android applications with Kotlin, focusing on clean architecture.",
                    textColor = MaterialTheme.colorScheme.onBackground,
                    subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    dividerColor = MaterialTheme.colorScheme.outline,
                )
            }
        }

        // Education Section - Combined into a single box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Column(
                modifier = Modifier.padding(24.dp) // Added padding inside box
            ) {
                Text(
                    "Education",
                    style = MaterialTheme.typography.titleLarge, // Smaller heading
                    modifier = Modifier.padding(bottom = 16.dp), // Reduced padding
                )

                // Combined education into a single item with both degrees
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Master of Computer Science",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "University of Technology • 2014-2016",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Bachelor of Software Engineering",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "State University • 2010-2014",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SimplifiedExperienceItem(
    position: String,
    company: String,
    period: String,
    description: String,
    textColor: Color,
    subtitleColor: Color,
    dividerColor: Color
) {
    // Removed hover effect for better performance and simpler UI
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp) // Reduced padding
    ) {
        Text(
            text = position,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
            color = textColor
        )
        Text(
            text = "$company • $period",
            style = MaterialTheme.typography.bodyMedium,
            color = subtitleColor,
            modifier = Modifier.padding(vertical = 4.dp) // Reduced padding
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 4.dp) // Reduced padding
                .fillMaxWidth(0.9f),
            color = textColor
        )
        HorizontalDivider(
            modifier = Modifier.padding(top = 16.dp), // Reduced padding
            thickness = DividerDefaults.Thickness, 
            color = dividerColor
        )
    }
}
