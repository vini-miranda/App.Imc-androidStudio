package com.viniciusmiranda.meuimc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCalcular.setOnClickListener {
            val campoAltura = edtMainAltura.text.toString()
            val campoPeso = edtMainPeso.text.toString()
            
            if(campoAltura.isEmpty()) {
                edtMainAltura.error="Preencha a altura"
                edtMainAltura.requestFocus()
            }
            else if(campoPeso.isEmpty()){
                edtMainPeso.error = "Preencha o peso"
                edtMainPeso.requestFocus()

            } else {


            val altura = edtMainAltura.text.toString().toDouble().toFloat()
            val peso = edtMainPeso.text.toString().toDouble().toFloat()
            val imc = peso/(altura*altura)
                val result = "% .2f".format(imc)

                if (imc <= 18.5) {
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Seu IMC")
                    alert.setMessage("IMC: $result Classificação:Magreza")
                    alert.setPositiveButton("Novo Cálculo") {dialog, which ->
                        var mIntent= Intent(this, this::class.java)
                        startActivity(mIntent)
                        finish()
                    }
                    alert.setNeutralButton("Editar") {dialog, which ->  }
                    alert.show()
            }
            else if(imc > 18.5 && imc <= 24.9) {
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Seu IMC")
                    alert.setMessage("IMC: $result Classificação:Adequado")
                    alert.setPositiveButton("Novo Cálculo") {dialog, which ->
                        var mIntent= Intent(this, this::class.java)
                        startActivity(mIntent)
                        finish()
                    }
                    alert.setNeutralButton("Editar") {dialog, which ->  }
                    alert.show()
            }
            else if(imc > 25 && imc <= 29.9 ) {
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Seu IMC")
                alert.setMessage("IMC: $result Classificação:Sobrepeso")
                    alert.setPositiveButton("Novo Cálculo") {dialog, which ->
                        var mIntent= Intent(this, this::class.java)
                        startActivity(mIntent)
                        finish()
                    }
                    alert.setNeutralButton("Editar") {dialog, which ->  }
                    alert.show()
            }
            else if(imc > 30 && imc <= 39.9 ) {
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Seu IMC")
                alert.setMessage("IMC: $result Classificação:Obesidade")
                    alert.setPositiveButton("Novo Cálculo") {dialog, which ->
                        var mIntent= Intent(this, this::class.java)
                        startActivity(mIntent)
                        finish()
                    }
                    alert.setNeutralButton("Editar") {dialog, which ->  }
                    alert.show()
            }
            else if(imc > 40) {
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Seu IMC")
                alert.setMessage("IMC: $result Classificação: Obesidade Grave")
                    alert.setPositiveButton("Novo Cálculo") {dialog, which ->
                        var mIntent= Intent(this, this::class.java)
                        startActivity(mIntent)
                        finish()
                    }
                    alert.setNeutralButton("Editar") {dialog, which ->  }
                    alert.show()
                }
            }
        }
    }
}




