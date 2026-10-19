package com.example.myapplication

import android.os.Bundle
import android.util.Log.i
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.collections.mutableListOf

class ItemList : ComponentActivity() {
    companion object {
        var itemsList = mutableListOf<Item>()



    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                    MainScreen(itemsList)
                }
            }
        }
    }


@Composable
fun MainScreen( itemsList : MutableList<Item> ) {

    for(item in 1..40){
        itemsList.add(   Item(
            title = "item $item",
            image =R.drawable.images
        ))
    }

    LazyColumn(
        modifier = Modifier.padding(top = 40.dp, bottom = 40.dp, start = 16.dp, end = 16.dp)
    ){
        items(itemsList){ item ->
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Image(
                    painter = painterResource(item.image),
                    contentDescription = "Image",
                    modifier = Modifier.padding(8.dp).size(80.dp).clip(shape = CircleShape),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    item.title,
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize=30.sp

                )
            }
        }
    }
}

