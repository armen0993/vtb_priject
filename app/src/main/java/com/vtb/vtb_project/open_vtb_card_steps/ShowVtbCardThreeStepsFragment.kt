package com.vtb.vtb_project.open_vtb_card_steps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.vtb.vtb_project.R
import com.vtb.vtb_project.databinding.FragmentOpenVtbCardThreeStepsBinding

class ShowVtbCardThreeStepsFragment : Fragment() {
    private val sharedViewModel:SharedViewModel by activityViewModels()
    private lateinit var bindingShow: FragmentOpenVtbCardThreeStepsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_open_vtb_card_three_steps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingShow = FragmentOpenVtbCardThreeStepsBinding.bind(view)
        bindingShow.btnGetStarted.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_goToPersonal_information)

        }
        bindingShow.step1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_goToPersonal_information)
        }
        bindingShow.btnClose.setOnClickListener {
            sharedViewModel.closeActivity(true)
        }
    }
}