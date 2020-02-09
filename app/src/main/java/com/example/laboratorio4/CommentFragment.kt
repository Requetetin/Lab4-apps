package com.example.laboratorio4

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratorio4.databinding.FragmentCommentBinding


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CommentFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CommentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommentFragment : Fragment() {
    private var comment:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCommentBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_comment, container, false
        )

        arguments?.let {
            comment = it.getString("comment_shown").toString()
        }
        binding.commentShown=comment

        setHasOptionsMenu(true)


        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        if(item.itemId == R.id.share_button){
            val intent = Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, comment)
            intent.type="text/plain"

            startActivity(Intent.createChooser(intent, "Share to:"))
        }

        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
    }
}
