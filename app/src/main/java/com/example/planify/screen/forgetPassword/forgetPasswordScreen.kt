package com.example.planify.screen.forgetPassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.EmailOrNum
import com.example.planify.components.Password
import com.example.planify.components.backgroundScreen
import com.example.planify.components.buttonNext
import com.example.planify.components.configPassword
import com.example.planify.components.roundedContainerScreen
import com.example.planify.components.textConfirmPassword
import com.example.planify.components.textDetailAccountForgetPassword
import com.example.planify.components.textEmailOrNumPhoneForgetPassword
import com.example.planify.components.textForgetNewPassword
import com.example.planify.components.textForgetPassword
import com.example.planify.components.textLinkResetForgetPassword
import com.example.planify.components.textNewPassword


@Composable
fun forgetPasswordScreen(modifier: Modifier){
    var currentStep by rememberSaveable { mutableStateOf(1) }
    var emailOrNum by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var configPassword by rememberSaveable { mutableStateOf("") }
    backgroundScreen {
        Column (
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.size(50.dp))
            textForgetPassword()
            Spacer(modifier = Modifier.size(50.dp))
            roundedContainerScreen {
                when(currentStep){
                    1 -> {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(0.8f),
                                horizontalAlignment = Alignment.Start
                            ){
                                textDetailAccountForgetPassword()
                                Spacer(modifier = Modifier.size(39.dp))
                                textEmailOrNumPhoneForgetPassword()
                                Spacer(modifier = Modifier.size(17.dp))
                                EmailOrNum(emailOrNum){
                                    emailOrNum = it
                                }
                                Spacer(modifier = Modifier.size(234.dp))
                            }
                            buttonNext { currentStep = 2}
                        }
                    }
                    2 -> {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(0.8f),
                                horizontalAlignment = Alignment.Start
                            ){
                                textDetailAccountForgetPassword()
                                Spacer(modifier = Modifier.size(39.dp))
                                textLinkResetForgetPassword()
                                Spacer(modifier = Modifier.size(244.dp))
                            }
                            buttonNext { currentStep = 3}
                        }
                    }
                    3 -> {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(0.8f),
                                horizontalAlignment = Alignment.Start
                            ){
                                textForgetNewPassword()
                                Spacer(modifier = Modifier.size(41.dp))
                                textNewPassword()
                                Spacer(modifier = Modifier.size(9.dp))
                                Password(password) {
                                    password = it
                                }
                                Spacer(modifier = Modifier.size(38.dp))
                                textConfirmPassword()
                                Spacer(modifier = Modifier.size(9.dp))
                                configPassword(configPassword) {
                                    configPassword = it
                                }
                                Spacer(modifier = Modifier.size(152.dp))
                            }
                            buttonNext { currentStep = 1 }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun previewForgetPasswordScreen(){
    forgetPasswordScreen(modifier = Modifier)
}