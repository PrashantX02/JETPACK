package com.pain.jetpack_03

import android.media.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.pain.jetpack_03.ui.theme.Jetpack_03Theme
import kotlin.math.absoluteValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_03Theme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    val modifier : Modifier = Modifier.padding(innerPadding)
                    demo_view_pager(modifier)
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun demo_view_pager(modifier: Modifier){
    val pager_state = rememberPagerState(initialPage = 0,0f, { 10 })

    LaunchedEffect(Unit) {
        pager_state.scrollToPage(0)
    }



   Box(
       modifier = Modifier
           .fillMaxSize(),
       contentAlignment = Alignment.Center
   ){
       Column{
           HorizontalPager (
               modifier = Modifier
                   .height(300.dp),
               state = pager_state,
               contentPadding = PaddingValues(horizontal = 10.dp),
               pageSpacing = 20.dp,
               verticalAlignment = Alignment.CenterVertically
           ) { page ->

               Card (
                   modifier = Modifier
                       .height(300.dp)
                       .shadow(0.5.dp)
                       .clip(RoundedCornerShape(4.dp))
                       .graphicsLayer {
                           val pageOffset = (
                                   (pager_state.currentPage - page) + pager_state
                                       .currentPageOffsetFraction
                                   ).absoluteValue

                           alpha = lerp(
                               start = 0f,
                               stop = 1f,
                               fraction = 1f - pageOffset.coerceIn(0f, 1f)
                           )
                       }
               ){
                   Image(
                       painter = painterResource(R.drawable.eren),
                       contentDescription = "",
                       contentScale = ContentScale.Crop,
                       modifier = Modifier.fillMaxSize()
                   )
               }
           }

// indicators
           Box(
               modifier = Modifier
                   .fillMaxWidth(),
               contentAlignment = Alignment.TopCenter
           ){
               Row{
                   repeat(pager_state.pageCount) { iteration ->
                       val color = if (pager_state.currentPage == iteration) Color.DarkGray else Color.LightGray
                       Box(
                           modifier = Modifier
                               .padding(2.dp, top = 10.dp)
                               .clip(CircleShape)
                               .background(color)
                               .size(10.dp)
                       )
                   }
               }
           }
       }
   }
}
