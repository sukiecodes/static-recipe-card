package com.example.cs501staticrecipecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cs501staticrecipecard.ui.theme.CS501StaticRecipeCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS501StaticRecipeCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecipeCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RecipeCard(modifier: Modifier = Modifier) {
    Card( // card will hold all recipe contents
        modifier = modifier.wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            // changes the background color of card from default grey to white
        ),
    ) {
        Row(
            // this row contains the recipe title and image
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
        ) {
            Text(
                text = "Iced Strawberry Matcha Latte",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .widthIn(max = 200.dp),
            )
            Box {
                Image(
                    painter = painterResource(R.drawable.matcha),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )
            }
        }
        HorizontalDivider(thickness = 1.dp)
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(24.dp)
        ) {
            LazyColumn { // ingredients and instructions
                item {
                    Text(text = "Ingredients", fontWeight = FontWeight.Bold)
                    Text(text = "▸ Strawberries, finely chopped (1/3 cup)")
                    Text(text = "▸ Cane sugar (1 teaspoon)")
                    Text(text = "▸ Matcha powder (1 teaspoon)")
                    Text(text = "▸ Cold water (1/4 cup)")
                    Text(text = "▸ Ice")
                    Text(text = "▸ Milk (1 cup)")
                    Text(text = "▸ Maple syrup or honey (optional, to taste)")
                }
            }
            LazyColumn {
                item {
                    Text(text = "Instructions", fontWeight = FontWeight.Bold)
                    Text(text = "1) Place the strawberries and sugar in a small bowl. Use a fork " +
                            "to combine, lightly mashing the strawberries as you mix. Set aside.")
                    Text(text = "2) Sift the matcha powder into another small bowl to remove any " +
                            "lumps. Add the water and use a matcha whisk to whisk briskly from side " +
                            "to side until the matcha is fully dispersed and a foamy layer forms on top. ")
                    Text(text = "3) Place the strawberries at the bottom of a tall glass. Fill " +
                            "halfway with ice, then pour in enough milk to fill the glass " +
                            "two thirds of the way full. Top with the matcha mixture.")
                    Text(text = "4) Stir to combine and taste with a straw. If desired, sweeten " +
                            "with maple syrup or honey to taste.")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    CS501StaticRecipeCardTheme {
        RecipeCard()
    }
}