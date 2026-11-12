package com.example.aurelioalmeida_atividade10nov

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {

    private var maoUsuario: Int = -1
    private var maoSmart: Int = 0
    private var escolhaUsuario: String = ""
    private var escolhaSmart: String = ""
    private lateinit var imgUser: ImageView
    private lateinit var imgSmart: ImageView
    private lateinit var imgMao0: ImageView
    private lateinit var imgMao1: ImageView
    private lateinit var imgMao2: ImageView
    private lateinit var imgMao3: ImageView
    private lateinit var imgMao4: ImageView
    private lateinit var imgMao5: ImageView
    private lateinit var txtResultado: TextView
    private lateinit var txtSmart: TextView
    private lateinit var btnPar: Button
    private lateinit var btnImpar: Button
    private lateinit var btnJogar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgUser = findViewById(R.id.imgUser)
        imgSmart = findViewById(R.id.imgSmart)
        imgMao0 = findViewById(R.id.imgMao0)
        imgMao1 = findViewById(R.id.imgMao1)
        imgMao2 = findViewById(R.id.imgMao2)
        imgMao3 = findViewById(R.id.imgMao3)
        imgMao4 = findViewById(R.id.imgMao4)
        imgMao5 = findViewById(R.id.imgMao5)
        txtResultado = findViewById(R.id.txtResultado)
        txtSmart = findViewById(R.id.txtSmart)
        btnPar = findViewById(R.id.btnPar)
        btnImpar = findViewById(R.id.btnImpar)
        btnJogar = findViewById(R.id.btnJogar)

        imgMao0.setOnClickListener {
            escolhaMao(0)
        }
        imgMao1.setOnClickListener {
            escolhaMao(1)
        }
        imgMao2.setOnClickListener {
            escolhaMao(2)
        }
        imgMao3.setOnClickListener {
            escolhaMao(3)
        }
        imgMao4.setOnClickListener {
            escolhaMao(4)
        }
        imgMao5.setOnClickListener {
            escolhaMao(5)
        }
        btnPar.setOnClickListener {
            escolhaPar()
        }
        btnImpar.setOnClickListener {
            escolhaImpar()
        }
        btnJogar.setOnClickListener {
            jogar()
        }
    }

    private fun escolhaMao(numero: Int){
        maoUsuario = numero
        imgUser.setImageResource(imagemMao(numero))
    }

    private fun escolhaPar(){
        escolhaUsuario = "par"
        escolhaSmart = "impar"
        btnPar.text = "Par ✓"
        btnImpar.text = "Ímpar"
        txtSmart.text = "Smartphone: Ímpar"
    }

    private fun escolhaImpar(){
        escolhaUsuario = "impar"
        escolhaSmart = "par"
        btnPar.text = "Par"
        btnImpar.text = "Ímpar ✓"
        txtSmart.text = "Smartphone: Par"
    }

    private fun imagemMao(numero: Int): Int{
        if(numero == 0){
            return R.drawable.mao0
        }
        if(numero == 1){
            return R.drawable.mao1
        }
        if(numero == 2){
            return R.drawable.mao2
        }
        if(numero == 3){
            return R.drawable.mao3
        }
        if(numero == 4){
            return R.drawable.mao4
        }
        return R.drawable.mao5
    }

    private fun jogar(){
        if(maoUsuario == -1 || escolhaUsuario == ""){
            txtResultado.text = "Escolha a mão e par ou ímpar"
            txtResultado.setTextColor(
                Color.parseColor("#FF000000")
            )
            return
        }

        maoSmart = Random().nextInt(6)
        imgSmart.setImageResource(imagemMao(maoSmart))

        val soma = maoUsuario + maoSmart
        var resultado = "impar"
        if(soma % 2 == 0){
            resultado = "par"
        }

        if(resultado == escolhaUsuario){
            txtResultado.text = "Deu $soma, você ganhou!"
        }
        else{
            txtResultado.text = "Deu $soma, smartphone ganhou!"
        }
        txtResultado.setTextColor(
            Color.parseColor("#FFFF0000")
        )
    }
}
