package np.com.lashman.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import np.com.lashman.composeintro.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeIntroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Counter(modifier = Modifier.padding(innerPadding))
                        Switcher()
                        CustomList(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroTheme {
        Greeting("Android")
    }
}

@Composable
fun Counter(modifier:Modifier = Modifier){
    //var counter = 0
    var counter by remember {
        mutableStateOf(99)
    }

    Button(
        modifier = modifier,
        onClick = {
            counter += 1
        }
    ){
        Text(text="This button has been clicked $counter times.")
    }

}

@Composable
fun Switcher(){
    var checked = remember {
        mutableStateOf(false)
    }
    Column {
        Switch(checked = checked.value,
            onCheckedChange = {checked.value = it})
    }
    if(checked.value){
        Text(text = "Switch is checked")
    }else{
        Text(text = "Switch is not checked")
    }
}

@Composable
fun CustomList(modifier: Modifier = Modifier) {
    modifier.padding(16.dp)
    val itemList = List(20) { index ->
        "Control: $index"
    }
    LazyColumn(modifier = modifier) {
        items(itemList) { item ->
            Text(text = item)
        }
    }
}