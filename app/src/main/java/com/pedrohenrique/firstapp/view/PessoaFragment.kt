package com.pedrohenrique.firstapp.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
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

        //Carregar a pessoa caso tenha selecionado
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))
        }

        binding.btnEnviar.setOnClickListener {
            var nome = binding.etNome.editableText.toString()
            var anoNascimento = binding.etIdade.editableText.toString()
            var sexo = ""
            var faixaE = ""


            if (nome !=""&&anoNascimento !="" &&
                binding.rbMasculino.isChecked || binding.rbFeminino.isChecked){

                if(binding.rbMasculino.isChecked){
                    sexo = "Masculino"
                }else{
                    sexo = "Feminino"
                }


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
                viewModel.pessoa.value?.let {

                    viewModel.update(pessoa)

                }?: run {
                    viewModel.insert(pessoa)
                }


                binding.etNome.editableText.clear()
                binding.etIdade.editableText.clear()
                findNavController().navigateUp()
            }else{
                Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
            }



        }
        binding.btnDeletar.setOnClickListener{
            AlertDialog.Builder(requireContext())
                .setTitle("Exclusão de pessoa")
                .setMessage("Você realmente deseja excluir?")
                .setPositiveButton("Sim"){ _,_ ->
                    viewModel.delete(viewModel.pessoa.value?.id ?: 0)
                    findNavController().navigateUp()
                }
                .setNegativeButton("Não"){_,_ ->}
                .show()

            viewModel.delete(viewModel.pessoa.value?.id ?: 0)
            findNavController().navigateUp()
        }
        viewModel.pessoa.observe(viewLifecycleOwner){pessoa->
            binding.etNome.setText(pessoa.nome)
            binding.etIdade.setText((LocalDateTime.now().year - pessoa.idade).toString())

            if (pessoa.sexo == "Masculino"){
                binding.rbMasculino.isChecked = true
            }else{
                binding.rbFeminino.isChecked = true
            }
            binding.btnDeletar.visibility = View.VISIBLE
        }
    }
}