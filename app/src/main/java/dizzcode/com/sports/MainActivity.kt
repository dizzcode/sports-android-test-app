package dizzcode.com.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import dizzcode.com.sports.ui.SportsApp
import dizzcode.com.sports.ui.theme.SportsTheme
import java.lang.reflect.Modifier

/**
 * Activity for Sports app
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SportsTheme {
                val layoutDirection = LocalLayoutDirection.current
                Surface(
//                    modifier = Modifier
//                        .padding(
//                            start = WindowInsets.safeDrawing.asPaddingValues()
//                                .calculateStartPadding(layoutDirection),
//                            end = WindowInsets.safeDrawing.asPaddingValues()
//                                .calculateEndPadding(layoutDirection)
//                        )
                ) {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    SportsApp(
                        windowSize = windowSize.widthSizeClass,
                        { finish() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyAppCompactPreview() {
    SportsTheme {
        Surface {
            //previews for different screen sizes
            //WindowWidthSizeClass.Compact
            //WindowWidthSizeClass.Medium
            //WindowWidthSizeClass.Expanded
            SportsApp(
                windowSize = WindowWidthSizeClass.Expanded,
                {}
            )
        }
    }
}
