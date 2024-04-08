package com.pedrohenrique.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.pedrohenrique.firstapp.databinding.FragmentCalcBinding
import com.pedrohenrique.firstapp.service.model.Pessoa
import com.pedrohenrique.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment(){
    private val  viewModel: PessoaViewModel by viewModels()

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
            var anoNascimento = binding.etIdade.editableText.toString()

            if (nome !=""&&anoNascimento !=""){

                binding.tvNome.text = "Nome: " + nome


                val anoAtual = LocalDateTime.now().year
                var idade = anoAtual - anoNascimento.toInt()

                binding.tvIdade.text = "Idade: ${idade}"

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade
                )
                viewModel.insert(pessoa)

                binding.etNome.editableText.clear()
                binding.etIdade.editableText.clear()
            }else{
                Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
            }



        }
    }


}