package com.pedrohenrique.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pedrohenrique.firstapp.R
import com.pedrohenrique.firstapp.databinding.FragmentAllPessoasBinding
import com.pedrohenrique.firstapp.databinding.FragmentPessoaDetailBinding
import com.pedrohenrique.firstapp.view.adapter.PessoaAdapter
import com.pedrohenrique.firstapp.viewmodel.AllPessoasViewModel
import com.pedrohenrique.firstapp.viewmodel.PessoaViewModel


class PessoaDetailFragment : Fragment() {


    //chamar a viewmodel para pegar os dados
    private val viewModel: PessoaViewModel by viewModels()

    //criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null
    private val binding: FragmentPessoaDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // configurar o binding
        _binding = FragmentPessoaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    //chamar a função onViewCreated onde vamos implementar o código
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Pegar o id da pessoa que foi enviado pela pessoa AllpessoaFragment
        //Setar a pessoa para ser carregada
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))
        }

        //carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner) { pessoa ->
            binding.tvNome.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString() + " anos"
            binding.tvFaixaEtaria.text = pessoa.faixaE

            if (pessoa.sexo == "Masculino") {
                binding.ivSexoM.setImageResource(R.drawable.man)
            } else {
                binding.ivSexoF.setImageResource(R.drawable.woman)
            }
        }
    }
}

