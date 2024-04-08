package com.pedrohenrique.firstapp.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoa")
data class Pessoa(
    var nome: String = "",
    var idade: Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
)
