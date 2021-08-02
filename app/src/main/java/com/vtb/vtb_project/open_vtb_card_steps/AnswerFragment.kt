package com.vtb.vtb_project.open_vtb_card_steps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.vtb.vtb_project.R
import com.vtb.vtb_project.databinding.FragmentAnswerBinding

class AnswerFragment : Fragment() {
    lateinit var showBinding: FragmentAnswerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showBinding = FragmentAnswerBinding.inflate(inflater)
        return showBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBinding.btnProceedToProfile.setOnClickListener{
            Navigation.findNavController(showBinding.root).navigate(R.id.action_go_to_contractFragment)
        }
    }
}