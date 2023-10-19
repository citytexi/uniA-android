package com.ajouunia.feature.guide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.component.NonScaleText
import com.ajouunia.core.domain.entity.GuideEntity

@Composable
fun GuideInfoScreen(
    modifier: Modifier = Modifier,
    guideEntity: GuideEntity
) = Column(
    modifier = modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(20.dp)
    ) {
        NonScaleText(
            text = guideEntity.title,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(700),
            color = Purple4,
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5))
            .padding(20.dp)
    ) {
        item {
            NonScaleText(
                text = guideEntity.content,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                lineHeight = 22.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuideInfoScreenPreview() {
    GuideInfoScreen(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        guideEntity = GuideEntity(
            index = 1,
            title = "Counseling & Support Office for international students",
            content = "nTarget: International First-year or exchange students at Ajou University\\n\\nContents: Basic, must-know information on life at Ajou University, such as information on course registration, scholarships, online classes, etc.\\n\\n\\n② Writing Clinic\\n\\nTarget: International undergraduates who struggle with Korean writing or wish to improve their Korean writing skills\\n\\nContents: Proofreading/editing support (for Korean spelling/grammar, general writing issues, etc.) for academic essays, team project papers, presentation materials, or exam practice essays.\\n\\n\\n③ Learning/Study Aids\\n\\nTarget: International undergraduate students who are having difficulty with their schoolwork and/or who wish to improve their GPA\\n\\nContents: Diverse learning programs, such as tutors for majors and/or classes, special lectures for improving study skills, counseling on learning strategies, etc.\\n\\n\\n④ Cultural Experiences\\n\\nTarget: International students who are interested in Korean culture (undergraduate, graduate, exchange students, etc.)\\n\\nContents: Diverse cultural experiences/activities that allow students to better understand and/or learn about Korean culture, history, and traditions, etc.\\n\\n\\n⑤ Individual Counseling\\n\\nTarget: International students at Ajou University (undergraduate, graduate, exchange students, etc.)\\n\\nContents: Trained counselors are available to discuss a wide range of topics related to university life, including personal issues, career paths, schoolwork/GPA, and general issues related to life in Korea. Counseling is offered in diverse formats, such as in-person, contactless (Zoom), and open chat.\\n\\n\\n⑥ Outreach counseling services\\n\\nTarget: International students who are interested in learning about counseling and/or who wish to receive counseling\\n\\nContents: Operation of a counseling booth for international students on International Day and at various Ajou festivals. The booth offers brief counseling sessions and an opportunity for students to get information about counseling.\\n\\n\\n☎ How to Use?\\n\\nLocation: Innovation Hub Lounge, Yulgok Hall B1\\n\\nFee Free of charge (some programs may require a minimal participation fee.)\\n\\nHow to apply\\n Visit the Office: Rm. 153, Yulgok Hall\\n Phone: 031-219-3598\\n Email: icounseling@ajou.ac.kr\"},{\"indexs\":2,\"contents\":\"① For new students\\n\\n> Submit an application form during the application period as directed by OIA staff\\n> Receive the account number for depositing the dormitory payment\\n"
        )
    )
}