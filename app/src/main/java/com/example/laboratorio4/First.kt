package com.example.laboratorio4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratorio4.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [First.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [First.newInstance] factory method to
 * create an instance of this fragment.
 */
class First : Fragment() {
    private lateinit var place:String


    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
        savedInstanceState: Bundle?):View?{
        val binding: FragmentFirstBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_first, container, false
        )
        binding.initialText="Nombre"//Da el texto al text y edit text
        binding.editText="Ingrese su nombre"




       binding.atitlan.setOnClickListener{
           place = "Atitlan"
           val bundle = bundleOf("info_shown" to place)

           view!!.findNavController().navigate(R.id.action_first_to_second,bundle)
       }

        binding.izabal.setOnClickListener{
            place = "Izabal"
            val bundle = bundleOf("info_shown" to place)

            view!!.findNavController().navigate(R.id.action_first_to_second,bundle)
        }

        binding.tikal.setOnClickListener{
            place = "Tikal"
            val bundle = bundleOf("info_shown" to place)

            view!!.findNavController().navigate(R.id.action_first_to_second,bundle)
        }



        binding.starButton.setOnClickListener(){
            if(binding.nameText.getVisibility() == View.VISIBLE){
                binding.nameInput = binding.nameInsert.getText().toString()
                binding.nameText.setVisibility(View.INVISIBLE)
                binding.nameInsert.setVisibility(View.INVISIBLE)
                binding.nameShown.setVisibility(View.VISIBLE)
            }else{
                binding.nameText.setVisibility(View.VISIBLE)
                binding.nameInsert.setVisibility(View.VISIBLE)
                binding.nameShown.setVisibility(View.INVISIBLE)
            }
        }
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
    }







}
