package io.github.devcrocod

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ContactPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 60.dp), // Reduced vertical padding
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Get in Touch",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp), // Reduced padding
        )

        Text(
            "I'm always interested in new opportunities and collaborations.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 40.dp) // Reduced padding
                .fillMaxWidth(0.7f)
        )

        // Contact items with visual indicators for clickability
        ImprovedContactItem(
            icon = Icons.Default.Email,
            title = "Email",
            value = "your.email@example.com",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            accentColor = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        ImprovedContactItem(
            icon = Icons.Default.Person,
            title = "LinkedIn",
            value = "linkedin.com/in/yourprofile",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            accentColor = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        ImprovedContactItem(
            icon = Icons.Default.Face,
            title = "GitHub",
            value = "github.com/yourusername",
            textColor = MaterialTheme.colorScheme.onBackground,
            subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant,
            accentColor = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun ImprovedContactItem(
    icon: ImageVector,
    title: String,
    value: String,
    textColor: Color,
    subtitleColor: Color,
    accentColor: Color
) {
    // Added visual indicators for clickability with border and larger touch target
    Row(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(64.dp) // Increased height for better touch target
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { /* Action when clicked */ }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Icon for visual indicator
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = accentColor,
            modifier = Modifier.size(24.dp)
        )

        // Text content
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = subtitleColor
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor
            )
        }
    }
}
