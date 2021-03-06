package com.jaime.marvelviewer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.jaime.marvelviewer.util.ErrorCode
import com.jaime.marvelviewer.util.Util

/**
 * Base Fragment class to abstract away ViewBinding boilerplate code
 * All fragments will inherit from this, only needing to override [initOnViewCreated] when desired functionality happens
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnViewCreated()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun initOnViewCreated()

    fun initActionBar(title: String = "", showBackButton: Boolean = false) {
        val supportActionBar = (activity as? AppCompatActivity)?.supportActionBar
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(showBackButton)
    }

    /**
     * Check if a toast message is available to be displayed
     * @param errorCode the unique error value
     */
    fun toastMessage(errorCode: ErrorCode?) {
        val errorMessage = Util.getStringFromErrorCode(resources, errorCode)
        errorMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }
}
