package com.example.planify.components

import android.R.id.input
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ), // Texto negro para mejor visibilidad
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        )
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
        placeholder = { Text(text = "Contraseña") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        ),
        trailingIcon = {
            val imagen = if (passordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passordVisibility = !passordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },
        visualTransformation = if (passordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun Name(name: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ), // Texto negro para mejor visibilidad
        placeholder = { Text(text = "Nombre") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        )
    )
}

@Composable
fun Number(number: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = number,
        onValueChange = {
            if (it.all { char -> char.isDigit() }) onTextChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ), // Texto negro para mejor visibilidad
        placeholder = { Text(text = "Número") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        )
    )
}

@Composable
fun EmailOrNum(value: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { input ->
            // Permitir solo caracteres válidos para emails y números
            if (input.all { it.isLetterOrDigit() || it in "@._-" }) {
                onTextChanged(input)
            }
        },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ),
        placeholder = { Text(text = "Correo o número") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        )
    )
}


@Composable
fun configPassword(configPassword: String, onTextChanged: (String) -> Unit) {
    var passordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = configPassword,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
        placeholder = { Text(text = "Confirmar contraseña") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        ),
        trailingIcon = {
            val imagen = if (passordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passordVisibility = !passordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },
        visualTransformation = if (passordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}