package com.pedrohenrique.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pedrohenrique.firstapp.databinding.FragmentPessoaBinding
import com.pedrohenrique.firstapp.service.model.Pessoa
import com.pedrohenrique.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment(){
    private val  viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_calc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            var nome = binding.etNome.editableText.toString()
            var anoNascimento = binding.etIdade.editableText.toString()
            var sexo = binding.etSexo.editableText.toString()
            var faixaE = ""
            if (nome !=""&&anoNascimento !=""){

                binding.tvNome.text = "Nome: " + nome


                val anoAtual = LocalDateTime.now().year
                var idade = anoAtual - anoNascimento.toInt()

                if(idade <=12){
                    faixaE = "Infantil"
                }
                else if(idade<18){
                    faixaE = "Adolescente"
                }
                else if(idade<=64){
                    faixaE = "Adulto"
                }
                else{
                    faixaE = "Idoso"
                }

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade,
                    sexo = sexo,
                    faixaE = faixaE

                )
                viewModel.insert(pessoa)

                binding.etNome.editableText.clear()
                binding.etIdade.editableText.clear()
                findNavController().navigateUp()
            }else{
                Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
            }



        }
    }


}