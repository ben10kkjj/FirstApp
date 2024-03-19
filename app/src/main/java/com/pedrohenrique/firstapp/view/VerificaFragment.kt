package com.pedrohenrique.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedrohenrique.firstapp.R
import com.pedrohenrique.firstapp.databinding.FragmentVerificaBinding


class VerificaFragment : Fragment() {
    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verifica, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {

            var email = binding.etEmail.editableText.toString()
            binding.tvEmail.text = "Email: " + email

            if (email.contains("@") && email.substringAfter("@").contains(".com")) {
                binding.tvEmail.text = "Email: ${email}";
            } else {
                binding.tvEmail.text = "Email: Error"
            }
            var telefone = binding.etTelefone.editableText.toString()
            binding.tvTelefone.text = "Telefone: " + telefone
            if (telefone.length == 11) {
                binding.tvTelefone.text = "Telefone: ${telefone}";
            } else {
                binding.tvTelefone.text = "Email: Error"
            }
        }
    }
}