package com.example.appidade

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtAnoAtual : EditText
    private lateinit var txtAnoNascimento : EditText

    private lateinit var lbAnos : TextView
    private lateinit var lbMeses : TextView
    private lateinit var lbDias : TextView
    private lateinit var lbHoras : TextView
    private lateinit var lbMinutos : TextView
    private lateinit var lbSegundos : TextView

    private lateinit var bttCalcular : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtAnoAtual = findViewById(R.id.txtAnoAtual)
        txtAnoNascimento = findViewById(R.id.txtAnoNascimento)

        lbAnos = findViewById(R.id.lbAnos)
        lbMeses = findViewById(R.id.lbMeses)
        lbDias = findViewById(R.id.lbDias)
        lbHoras = findViewById(R.id.lbHoras)
        lbMinutos = findViewById(R.id.lbMinutos)
        lbSegundos = findViewById(R.id.lbSegundos)

        bttCalcular = findViewById(R.id.bttCalcular)

        bttCalcular.setOnClickListener{
            calcular()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcular(){
        calcAnos()
        calcMeses()
        calcDias()
        calcHoras()
        calcMinutos()
        calcSegundos()

        Toast.makeText(this, "Calculo feito!", Toast.LENGTH_SHORT).show()
    }

    private fun calcAnos(){
        var idadeAnos : Double

        val anoNasc : Double = txtAnoNascimento.text.toString().toDouble()
        val anoAtual : Double = txtAnoAtual.text.toString().toDouble()

        idadeAnos = anoAtual - anoNasc

        lbAnos.text = idadeAnos.toString()
    }

    private fun calcMeses(){
        val anoNasc : Long = txtAnoNascimento.text.toString().toLong()
        val anoAtual : Long = txtAnoAtual.text.toString().toLong()

        val idadeMeses : Long = (anoAtual - anoNasc) * 12

        lbMeses.text = idadeMeses.toString()
    }

    private fun calcDias(){
        val anoNasc : Long = txtAnoNascimento.text.toString().toLong()
        val anoAtual : Long = txtAnoAtual.text.toString().toLong()

        val idadeDias : Long = (anoAtual-anoNasc)* 365

        lbDias.text = idadeDias.toString()
    }

    private fun calcHoras(){
        val anoNasc : Long = txtAnoNascimento.text.toString().toLong()
        val anoAtual : Long = txtAnoAtual.text.toString().toLong()

        val idadeHoras : Long = (anoAtual-anoNasc) * 8760

        lbHoras.text = idadeHoras.toString()
    }

    private fun calcMinutos(){
        val anoNasc : Long = txtAnoNascimento.text.toString().toLong()
        val anoAtual : Long = txtAnoAtual.text.toString().toLong()

        val idadeMinutos : Long = (anoAtual - anoNasc) * 525600

        lbMinutos.text = idadeMinutos.toString()
    }

    private fun calcSegundos(){
        val anoNasc : Long = txtAnoNascimento.text.toString().toLong()
        val anoAtual : Long = txtAnoAtual.text.toString().toLong()

        val idadeSegundos : Long = (anoAtual - anoNasc) * 31536000

        lbSegundos.text = idadeSegundos.toString()
    }

}