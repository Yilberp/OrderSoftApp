package co.edu.ufps.ordersoft.fragmentos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.vistas.HomeActivity
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mAuth: FirebaseAuth
    val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val usuario: EditText = view.findViewById(R.id.user_reg)
        val clave: EditText = view.findViewById(R.id.password_reg)
        val btn_login: Button = view.findViewById(R.id.btn_reg)
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()
        btn_login.setOnClickListener {
            signUp(usuario.text.toString(), clave.text.toString())
        }
        return view
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.currentUser
        if(currentUser != null){
            //reload();
        }
    }
    public fun signUp(email: String, password: String){
    mAuth.createUserWithEmailAndPassword(email, password)
    .addOnCompleteListener() { task ->
        if (task.isSuccessful) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "createUserWithEmail:success")
            val user = mAuth.currentUser
            Toast.makeText(
                context, "Register OK.",
                Toast.LENGTH_SHORT
            ).show()
            irHome()
            //updateUI(user)
        } else {
            // If sign in fails, display a message to the user.
            Log.w(TAG, "createUserWithEmail:failure", task.exception)
            Toast.makeText(context, "Authentication failed.",
                Toast.LENGTH_SHORT).show()
            //updateUI(null)
            }
        }
    }
    private fun irHome() {
        val intent = Intent(context, HomeActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignUpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}