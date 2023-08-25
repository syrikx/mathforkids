package com.example.mathforkids.main.problemsolving

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mathforkids.R
import com.example.mathforkids.SharedViewModel
import com.example.mathforkids.databinding.FragmentKeypadBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class KeypadFragment : Fragment() {

    private var _binding: FragmentKeypadBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: SharedViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_keypad,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // inputValue LiveData를 관찰합니다.
//        viewModel.inputValue.observe(viewLifecycleOwner, Observer { value ->
//            binding.textView.text = value.toString()  // 'binding.textView'는 당신의 TextView의 실제 바인딩 이름이 아닐 수 있습니다.
//        })
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}