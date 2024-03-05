package com.pedrohenrique.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohenrique.firstapp.databinding.ActivityMainBinding
import com.pedrohenrique.firstapp.databinding.TelaLinearBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
//            var nome = binding.edtNome.editableText.toString()
//
//            binding.tvNome.text = "Nome: " + nome
//
//            var anoNascimento = binding.edtIdade.editableText.toString()
//            var idade = 2024 - anoNascimento.toInt()
//
//            binding.tvIdade.text = "Idade: ${idade}"
//
//        }
           
            var email = binding.edtEmail.editableText.toString()
                binding.tvEmail.text = "Email: " + email

            //verificar se o email tem @ e .com

                if (email.contains("@") && email.substringAfter("@").contains(".com")) {
                    binding.tvEmail.text = "Email: ${email}";
                } else {
                    binding.tvEmail.text = "Email: Error"
                }

            //verificar telefone

            var telefone = binding.edtTelefone.editableText.toString()
            binding.tvTelefone.text = "Telefone: " + telefone
            if (telefone.length == 11){
                binding.tvTelefone.text = "Telefone: ${telefone}";
            }else{
                binding.tvTelefone.text = "Email: Error"
            }
            }
        }
    }