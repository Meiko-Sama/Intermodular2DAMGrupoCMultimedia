package com.angelmascarell.intermodular2damc.home.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.angelmascarell.intermodular2damc.core.routes.LocalNavController
import com.angelmascarell.intermodular2damc.home.data.model.RentRoomModel
import com.angelmascarell.intermodular2damc.home.presentation.composables.BasicTextField
import com.angelmascarell.intermodular2damc.ui.theme.NormalPurple
import com.angelmascarell.intermodular2damc.ui.theme.SoftPurple
import com.angelmascarell.intermodular2damc.ui.theme.TitleTextStyle
import com.angelmascarell.intermodular2damc.ui.theme.UltraPurple

@Composable
fun HomeScreen(navController: NavHostController = LocalNavController.current,homeViewModel: HomeViewModel = hiltViewModel()) {
    val rentRoomList by homeViewModel.rentRooms.observeAsState(emptyList())

    LaunchedEffect(rentRoomList) {
        Log.i("RentRoom", "${rentRoomList.size}")

        rentRoomList.forEachIndexed { index, rentRoom ->
            Log.i("RentRoom: $index", "$rentRoom")
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(SoftPurple)
            .verticalScroll(rememberScrollState())
    ) {
        val (header, body, footer) = createRefs()

        Header(modifier = Modifier.constrainAs(header) {
            top.linkTo(parent.top)
            bottom.linkTo(body.top)
        })
        Body(modifier = Modifier.constrainAs(body) {
            top.linkTo(header.bottom)
            bottom.linkTo(footer.top)
        }, rentRoomList,navController)
        Footer(modifier = Modifier.constrainAs(footer) {
            top.linkTo(body.bottom)
            bottom.linkTo(parent.bottom)
        })

        createVerticalChain(header, body, footer, chainStyle = ChainStyle.SpreadInside)
    }
}

@Composable
fun Header(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp, bottom = 20.dp)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Home", style = TitleTextStyle, fontSize = 30.sp)

        var textValue by remember { mutableStateOf(String()) }
        SearchProductTextField(value = textValue) { newValue -> textValue = newValue }
    }
}

@Composable
fun Body(modifier: Modifier, rentRoomList: List<RentRoomModel>, navController: NavHostController) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        rentRoomList.forEachIndexed { _, rentRoom ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(NormalPurple)
                    .padding(16.dp)
                    //.clickable { navController.navigate(Routes.DetailsScreen.createRoute(restaurant.id)) }
            ) {
                Column {
                    Text(
                        text = "number: "+rentRoom.number,
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "type: "+rentRoom.type,
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "beds: "+rentRoom.beds,
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "available: "+rentRoom.available,
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "price: "+rentRoom.price,
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    /*val imageUrl = rentRoom.img
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .height(90.dp) // Adjust height as needed
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium) // Apply shape if needed
                    )*/
                }
            }
        }
    }
}

@Composable
fun SearchProductTextField(value: String, onTextChanged: (String) -> Unit) {
    BasicTextField(
        value = value,
        placeholder = "xd",
        label = "xd",
        onTextChanged = onTextChanged,
        imageVector = Icons.Default.Search
    )
}

@Composable
fun Footer(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "xd",
                fontSize = 16.sp,
                color = UltraPurple
            )
        }
    }
}
