package com.vtb.vtb_project.open_vtb_card_steps




import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.vtb.vtb_project.R
import com.vtb.vtb_project.databinding.FragmentPersonalInformationBinding
import com.vtb.vtb_project.tools.ToolsForEditText



class PersonalInformationFragment : Fragment() {
    private lateinit var showBinding: FragmentPersonalInformationBinding
    private lateinit var country: Array<String>
    private lateinit var citizenShip: Array<String>
    private lateinit var arrayAdapterGender: ArrayAdapter<String>
    private var isCheckedCountry: Boolean = false
    private var isCheckedCitizenship: Boolean = false
    private val shareViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personal_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showBinding = FragmentPersonalInformationBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        showBinding.btnClose.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_goToHomeFragment)
        }
    }


    override fun onResume() {
        super.onResume()

        //region checked firstName

        showBinding.editUserFirstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(
                editUserFirstName: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
                if (!showBinding.editUserFirstName.text.isNullOrEmpty()) {
                    showBinding.textInputLayoutFirstName.isErrorEnabled = false
                    showBinding.textInputLayoutFirstName.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        //endregion
        //region checked surName
        showBinding.editUserSurname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!showBinding.editUserSurname.text.isNullOrEmpty()) {
                    showBinding.textInputLayoutSurname.isErrorEnabled = false
                    showBinding.textInputLayoutSurname.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        //endregion
        //region checked dateOfBirth
        showBinding.editUserDateOfBirth.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!showBinding.editUserDateOfBirth.text.isNullOrEmpty()) {
                    showBinding.textInputLayoutDateOfBirth.isErrorEnabled = false
                    showBinding.textInputLayoutDateOfBirth.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        //endregion

        showBinding.editUserDateOfBirth.setOnClickListener {
            ToolsForEditText.createDateDialog(
                requireContext(),
                "dd.MM.yyyy",
                showBinding.editUserDateOfBirth
            )
        }
        //region create Country
        country = resources.getStringArray(R.array.country_name)
        val arrayAdapterCountry =
            ArrayAdapter(requireContext(), R.layout.drop_down_item_country, country)
        showBinding.autoCompleteUserCountry.setAdapter(arrayAdapterCountry)
//endregion
        //region checked Country Edit
        showBinding.autoCompleteUserCountry.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(
                autoCompleteUserCountry:
                CharSequence?, p1: Int, p2: Int, p3: Int
            ) {
                if (!country.contains(autoCompleteUserCountry.toString())) {
                    showBinding.textInputLayoutCountry.isErrorEnabled = true
                    showBinding.textInputLayoutCountry.error =
                        resources.getString(R.string.error_editText)
                    isCheckedCountry = false
                } else {
                    showBinding.textInputLayoutCountry.isErrorEnabled = false
                    showBinding.textInputLayoutCountry.error = null
                    isCheckedCountry = true
                }
            }

            override fun afterTextChanged(autoCompleteUserCountry: Editable?) {
            }
        })
        //endregion

        //region create citizen ship
        citizenShip = resources.getStringArray(R.array.citizen_ship)
        val arrayAdapterCitizenShip =
            ArrayAdapter(requireContext(), R.layout.drop_down_item_country, citizenShip)
        showBinding.editUserCitizenShip.setAdapter(arrayAdapterCitizenShip)
        //endregion
        //region checked CitizenShip Edit
        showBinding.editUserCitizenShip.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(
                editUserCitizenShip:
                CharSequence?, p1: Int, p2: Int, p3: Int
            ) {
                if (!citizenShip.contains(editUserCitizenShip.toString())) {
                    showBinding.textInputLayoutCitizenShip.isErrorEnabled = true
                    showBinding.textInputLayoutCitizenShip.error =
                        resources.getString(R.string.error_editText)
                    isCheckedCitizenship = false
                } else {
                    showBinding.textInputLayoutCitizenShip.isErrorEnabled = false
                    showBinding.textInputLayoutCitizenShip.error = null
                    isCheckedCitizenship = true
                }
            }

            override fun afterTextChanged(autoCompleteUserCountry: Editable?) {
            }
        })
        //endregion

        //region create gender
        val gender = resources.getStringArray(R.array.gender)
        arrayAdapterGender =
            ArrayAdapter(requireContext(), R.layout.drop_down_item_country, gender)
        showBinding.editUserGender.setAdapter(arrayAdapterGender)
        //endregion
        //region checked gender
        showBinding.editUserGender.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!showBinding.editUserGender.text.isNullOrEmpty()) {
                    showBinding.textInputLayoutGender.isErrorEnabled = false
                    showBinding.textInputLayoutGender.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        //endregion
        showBinding.btnGoToMobilePhoneNumberFragment.setOnClickListener {
            sendData()
            when {
                isCheckedCitizenship && isCheckedCountry &&
                        !showBinding.editUserFirstName.text.isNullOrEmpty() &&
                        !showBinding.editUserSurname.text.isNullOrEmpty() &&
                        !showBinding.editUserDateOfBirth.text.isNullOrEmpty() &&
                        !showBinding.editUserGender.text.isNullOrEmpty() -> {

                    Navigation.findNavController(showBinding.root)
                        .navigate(R.id.action_go_to_mobile_phone_number)
                }
                else -> {
                    when {
                        showBinding.editUserFirstName.text.isNullOrEmpty() -> showBinding.textInputLayoutFirstName.error =
                            resources.getString(R.string.errors_go_to_click_next)
                        showBinding.editUserSurname.text.isNullOrEmpty() -> showBinding.textInputLayoutSurname.error =
                            resources.getString(R.string.errors_go_to_click_next)
                        showBinding.editUserDateOfBirth.text.isNullOrEmpty() -> showBinding.textInputLayoutDateOfBirth.error =
                            resources.getString(R.string.errors_go_to_click_next)
                        !isCheckedCountry -> showBinding.textInputLayoutCountry.error =
                            resources.getString(R.string.error_editText)
                        !isCheckedCitizenship -> showBinding.textInputLayoutCitizenShip.error =
                            resources.getString(R.string.error_editText)
                        showBinding.editUserGender.text.isNullOrEmpty() -> showBinding.textInputLayoutGender.error =
                            resources.getString(R.string.errors_go_to_click_next)
                    }
                }
            }
        }
    }

    private fun sendData() {
        shareViewModel.setCountryName(
            country.indexOf(
                showBinding.autoCompleteUserCountry.text.toString()
            )
        )
        shareViewModel.setCitizenShipName(
            citizenShip.indexOf(
                showBinding.editUserCitizenShip.text.toString()
            )
        )

        shareViewModel.setGenderName(showBinding.editUserGender.text.toString())
        shareViewModel.inputUserFirstName(showBinding.editUserFirstName.text.toString())
        shareViewModel.inputUserSurName(showBinding.editUserSurname.text.toString())
        shareViewModel.inputDateBirthName(showBinding.editUserDateOfBirth.text.toString())
    }
}