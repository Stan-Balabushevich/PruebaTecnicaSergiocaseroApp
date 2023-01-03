package id.slava.nt.pruebatecnicasergiocaseroapp.presentation.list_poi

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity
import id.slava.nt.pruebatecnicasergiocaseroapp.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PoiListScreen(navController: NavController,
                  viewModel: PoiListViewModel = koinViewModel()){

    val list = viewModel.poiListState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary
            ) {
                ExpandableSearchView(
                    searchDisplay = "",
                    onSearchDisplayChanged = {
                        viewModel.setSearchText(it)},
                    onSearchDisplayClosed = {
                        viewModel.setSearchText("") })

            }
        },
        content = {
            PoiList(poiList = list.value, onNoteItemSelected =
                    {
                        navController.navigate(
                    Screen.DetailPoiScreen.route
                            + "?noteId=${it.id}")
                     }
                    )
                 }
            )
}

@Composable
fun PoiList(poiList: List<PoiDbEntity>,
            onNoteItemSelected: (PoiDbEntity) -> Unit) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = poiList) { poi ->
            PoiCard(poi = poi, onNoteItemSelected = onNoteItemSelected)
        }
    }
}

@Composable
private fun PoiCard(poi: PoiDbEntity,
                    onNoteItemSelected: (PoiDbEntity) -> Unit) {
    Card(
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                onNoteItemSelected(poi)
            }
    ) {
        PoiCardContent(poi = poi, onNoteItemSelected = onNoteItemSelected)
    }

}

@Composable
private fun PoiCardContent(poi: PoiDbEntity, onNoteItemSelected: (PoiDbEntity) -> Unit) {

    Row(
        modifier = Modifier
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Row() {
                Icon(
                    imageVector =  Icons.Filled.EditNote,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                )

                    Text(
                        text = poi.title ?: "",
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                        textAlign = TextAlign.End,
                        maxLines = 1
                    )

                }
            }
        }
}