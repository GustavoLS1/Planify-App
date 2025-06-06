package com.example.planify.components

import android.R.id.input
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.ui.theme.SecondColor
import java.text.NumberFormat
import java.util.Locale

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
fun Code(code: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = code,
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
        placeholder = { Text(text = "código") },
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

@Composable
fun CurrencyTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    val digits = value.filter { it.isDigit() }
    val formatted = formatPesos(digits)

    TextField(
        value = TextFieldValue(
            text = formatted,
            selection = TextRange(formatted.length)
        ),
        placeholder = { Text(text = "Cantidad") },
        onValueChange = { newValue ->
            val newDigits = newValue.text.filter { it.isDigit() }
            onValueChange(newDigits)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}

@Composable
fun CurrencyTextFieldNotebook(
    onValueChange: (String) -> Unit,
) {
    var rawInput by remember { mutableStateOf("") }
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = textFieldValue,
        placeholder = { Text(text = "Cantidad") },
        onValueChange = { newValue ->
            val digits = newValue.text.filter { it.isDigit() }

            // Actualizar el input limpio
            rawInput = digits

            // Formatear con pesos
            val formatted = formatPesos(digits)

            // Colocar el cursor al final del texto formateado
            textFieldValue = TextFieldValue(
                text = formatted,
                selection = TextRange(formatted.length)
            )
            onValueChange(formatted)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}

@Composable
fun CurrencyTextFieldNotebookAmout(
    onValueChange: (String) -> Unit,
    enabled: Boolean
) {
    var rawInput by remember { mutableStateOf("") }
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = textFieldValue,
        enabled = enabled,
        placeholder = { Text(text = "Cantidad") },
        onValueChange = { newValue ->
            val digits = newValue.text.filter { it.isDigit() }

            // Actualizar el input limpio
            rawInput = digits

            // Formatear con pesos
            val formatted = formatPesos(digits)

            // Colocar el cursor al final del texto formateado
            textFieldValue = TextFieldValue(
                text = formatted,
                selection = TextRange(formatted.length)
            )
            onValueChange(formatted)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}

fun formatPesos(input: String): String {
    return if (input.isNotEmpty()) {
        try {
            val number = input.toLong()
            "$" + NumberFormat.getNumberInstance(Locale("es", "CO")).format(number)
        } catch (e: NumberFormatException) {
            ""
        }
    } else ""
}

@Composable
fun NombreTextField() {
    var nombre by remember { mutableStateOf("") }

    TextField(
        value = nombre,
        onValueChange = { nombre = it },
        placeholder = { Text("Nombre") },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        singleLine = true
    )
}

@Composable
fun SearchBar(query: String,
              onQueryChanged: (String) -> Unit,
              onAddClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChanged,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.Black
                )
            },
            placeholder = {
                Text("Buscar", color = Color.DarkGray)
            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(Modifier.width(8.dp))
        iconButtonAddCategories(
            onAddClick = onAddClick,
        )

    }
}