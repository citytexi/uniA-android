package com.ajouunia.core.designsystem.component

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajouunia.core.designsystem.Purple4
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.extensions.nonScaleSp
import com.ajouunia.core.designsystem.uniaiconpack.IconEyeHide
import com.ajouunia.core.designsystem.uniaiconpack.IconEyeShow
import com.ajouunia.core.designsystem.urbanistFamily

// region const value field
private val TextFieldHeight: Dp = 52.dp
private val DefaultTextFieldRound: Dp = 10.dp
private val BasicTextFieldStartPadding = 10.dp
// endregion

@Composable
fun UniATextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (newValue: String) -> Unit,
    backgroundColor: Color = Color.White,
    title: String? = null,
    enable: Boolean = true,
    hint: String? = null,
    hintBackgroundColor: Color? = Color.Transparent,
    enabledSideBtn: Boolean = false,
    sideBtnText: String? = null,
    round: Dp = DefaultTextFieldRound,
    onSideBtnClick: (() -> Unit)? = null,
    error: String? = null,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    description: String? = null,
    singleLine: Boolean = true,
) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusRequester = remember {
        FocusRequester()
    }

    Column(
        modifier = modifier,
    ) {
        if (!title.isNullOrEmpty()) {
            // title
        }

        Box(
            modifier = Modifier
                .heightIn(min = TextFieldHeight)
                .wrapContentHeight(Alignment.CenterVertically)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(round)
                )
                .border(
                    width = 1.dp,
                    color = when (isFocused) {
                        true -> Purple4
                        false -> Color(0xFFE3E3E3)
                    },
                    shape = RoundedCornerShape(round)
                )
                .focusRequester(focusRequester)
        ) {
            UniABasicTextField(
                value = value,
                onValueChange = onValueChange,
                hint = hint,
                enable = enable,
                passwordVisible = passwordVisible,
                onPasswordVisibleChanged = {
                    passwordVisible = it
                },
                enabledSideBtn = enabledSideBtn,
                sideBtnText = sideBtnText,
                round = round,
                onSideBtnClick = onSideBtnClick,
                isPassword = isPassword,
                interactionSource = interactionSource,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction,
                ),
                singleLine = singleLine,
            )
        }
    }


}

@Composable
private fun UniABasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    enable: Boolean = true,
    passwordVisible: Boolean = false,
    onPasswordVisibleChanged: (Boolean) -> Unit,
    enabledSideBtn: Boolean = false,
    sideBtnText: String? = null,
    round: Dp = DefaultTextFieldRound,
    onSideBtnClick: (() -> Unit)? = null,
    isPassword: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Default,
    ),
    singleLine: Boolean = true,
) {
    BasicTextField(
        modifier = Modifier
            .height(TextFieldHeight)
            .fillMaxWidth()
            .padding(start = BasicTextFieldStartPadding),
        enabled = enable,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        visualTransformation = if (!passwordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        maxLines = 1,
        textStyle = TextStyle(
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(400),
            fontStyle = FontStyle.Normal,
            fontSize = 13.sp.nonScaleSp,
            lineHeight = 19.sp.nonScaleSp
        ),
        cursorBrush = SolidColor(Purple4),
        interactionSource = interactionSource,
        decorationBox = @Composable { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
            ) {
                innerTextField()

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (value.isEmpty() && hint != null) {
                        Text(hint)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    if (isPassword) {
                        Icon(
                            when (passwordVisible) {
                                true -> UniAIconPack.IconEyeShow
                                false -> UniAIconPack.IconEyeHide
                            },
                            contentDescription = "IC_PASSWORD_VISIBLE",
                            modifier = Modifier.clickable { onPasswordVisibleChanged(!passwordVisible) },
                            tint = Color(0xFF777986)
                        )
                    }

                    Spacer(modifier = Modifier.width(9.dp))

                }
            }
        },
    )
}

@Preview
@Composable
fun PreviewUniATextField() {
    var value by remember { mutableStateOf<String?>(null) }
    var value2 by remember { mutableStateOf<String?>(null) }
    var value3 by remember { mutableStateOf<String?>(null) }

    Column(
//        modifier = Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // default text field
        UniATextField(
            value = value ?: "asdas",
            onValueChange = { value = it },
            error = null
        )

        // password text field
        UniATextField(
            value = value2 ?: "dasds",
            onValueChange = { value2 = it },
            isPassword = true
        )

        // error text field
        UniATextField(
            value = value3 ?: "",
            onValueChange = { value3 = it },
            error = "특수문자는 사용할 수 없습니다!"
        )

    }
}