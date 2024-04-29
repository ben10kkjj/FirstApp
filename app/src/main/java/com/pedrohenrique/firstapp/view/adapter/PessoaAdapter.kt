package com.pedrohenrique.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedrohenrique.firstapp.R
import com.pedrohenrique.firstapp.databinding.ListItemPessoaBinding
import com.pedrohenrique.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa)-> Unit):
        RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){

            //Criar uma lista vazia de pessoas
            private var pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding):
            RecyclerView.ViewHolder(binding.root){


                //Carregas as informações da pessoa na lista
                fun bind(pessoa: Pessoa, clickListListener: (Pessoa)-> Unit){
                    binding.tvNome.text = pessoa.nome
                    binding.tvIdade.text = pessoa.idade.toString()
                    binding.tvFaixaE.text = pessoa.faixaE

                    if (pessoa.sexo == "Masculino"){
                        binding.ivSexoM .setImageResource(R.drawable.man)
                    }
                    else{
                        binding.ivSexoF.setImageResource(R.drawable.woman)

                    }
            //Configura algum item da lista
                    binding.root.setOnClickListener{
                        clickListListener(pessoa)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    //carrega a lista de pessoas para serem exibidas
    fun updatePessoas(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}