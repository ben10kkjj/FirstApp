package com.pedrohenrique.firstapp.service.repository

import android.content.Context
import com.pedrohenrique.firstapp.service.model.Pessoa
import com.pedrohenrique.firstapp.service.repository.local.FirstAppDataBase

class PessoaRepository(context: Context) {
    private val firstAppDb = FirstAppDataBase.getDataBase(context).pessoaDAO()

    suspend fun insertPessoa(pessoa: Pessoa){
        firstAppDb.insert(pessoa = pessoa)
    }
    suspend fun  getPessoa(id:Int):Pessoa{
        return firstAppDb.getPessoa(id)
    }
    suspend fun getPessoas(): List<Pessoa>{
        return firstAppDb.getAll()
    }
    suspend fun updatePessoa(pessoa: Pessoa){
        firstAppDb.update(pessoa)
    }
    suspend fun deletePessoa(id: Int){
        firstAppDb.delete(id)
    }
}