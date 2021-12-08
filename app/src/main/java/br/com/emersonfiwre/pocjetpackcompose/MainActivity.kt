package br.com.emersonfiwre.pocjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.emersonfiwre.pocjetpackcompose.ui.theme.CinzelFamily
import br.com.emersonfiwre.pocjetpackcompose.ui.theme.PocJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FeedItem()
                }
            }
        }
    }
}


@Composable
fun FeedItem() {
    Column {
        Box {
            Image(
                painter = painterResource(id = R.drawable.thumbnail),
                contentDescription = "Thumbnail"
            )
            Text(
                text = "29:32",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp, 8.dp)//horizontal, vertical
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),// inserindo tipo um spacer na row
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.channel_image),
                contentDescription = "Channel Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Column {
                Text(text = "Jetpack Compose - Começo do conhecimento")
                Spacer(modifier = Modifier.size(8.dp))//colocando espaçamento
                Row {
                    Text(
                        text = "Emerson Torres",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "- 225 views",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "- 2 weeks ago",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
fun CustomText(@StringRes textResId: Int) {//Forçando a passar um int que seja um arquivo de string em tempo de compilação
    Text(
        text = stringResource(id = textResId),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Log.d("CustomText", "Welcome CLicked")
            },
        color = Color(0xFFA80800),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body1// fazer um estilo para deixar definido um estilo muito utilzado
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PocJetPackComposeTheme {
        FeedItem()
    }
}