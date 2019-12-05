package cz.kopemar.listdetail.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.kopemar.listdetail.R
import kotlinx.android.synthetic.main.fragment_about.*

/**
 * Fragment with information about the app.
 */
class AboutFragment : NamedFragment() {

    override var fragmentName = R.string.about

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        vGithubButton.setOnClickListener(onGithubButton())
        vEmailButton.setOnClickListener(onEmailButton())

        super.onActivityCreated(savedInstanceState)
    }

    private fun onGithubButton(): View.OnClickListener {
        return View.OnClickListener {
            val github = activity?.resources?.getString(R.string.my_github)
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(github))
            startActivity(browserIntent)
        }
    }

    private fun onEmailButton(): View.OnClickListener {
        return View.OnClickListener {
            val mailto = activity?.resources?.getString(R.string.mailto)
            val mail = activity?.resources?.getString(R.string.my_mail)
            val mailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(mailto, mail, null))
            startActivity(mailIntent)
        }
    }
}