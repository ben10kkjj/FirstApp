package com.pedrohenrique.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedrohenrique.firstapp.R
import com.pedrohenrique.firstapp.databinding.ActivityMainBinding
import com.pedrohenrique.firstapp.databinding.FragmentCalcBinding
import java.time.LocalDateTime

class CalcFragment : Fragment(){

    private var _binding: FragmentCalcBinding? = null
    private val binding: FragmentCalcBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalcBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_calc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            var nome = binding.etNome.editableText.toString()

            binding.tvNome.text = "Nome: " + nome

            var anoNascimento = binding.etIdade.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            var idade = anoAtual - anoNascimento.toInt()

            binding.tvIdade.text = "Idade: ${idade}"

        }
    }


}