package com.pedrohenrique.firstapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.pedrohenrique.firstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //criar a toolbar
    private lateinit var appBarConfiguration: AppBarConfiguration

    //criara a navegação
    private lateinit var navController: NavController

    //criar o binding
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //configurar o binding (faz uma ligação da tela com a programação)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //configura a navegação e a toolbar
        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
           
//            var email = binding.edtEmail.editableText.toString()
//                binding.tvEmail.text = "Email: " + email
//
//            //verificar se o email tem @ e .com
//
//                if (email.contains("@") && email.substringAfter("@").contains(".com")) {
//                    binding.tvEmail.text = "Email: ${email}";
//                } else {
//                    binding.tvEmail.text = "Email: Error"
//                }

            //verificar telefone
//
//            var telefone = binding.edtTelefone.editableText.toString()
//            binding.tvTelefone.text = "Telefone: " + telefone
//            if (telefone.length == 11){
//                binding.tvTelefone.text = "Telefone: ${telefone}";
//            }else{
//                binding.tvTelefone.text = "Email: Error"
//            }
            }
        }
