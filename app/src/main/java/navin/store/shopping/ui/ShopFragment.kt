package navin.store.shopping.ui

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import navin.store.shopping.R
import navin.store.shopping.adapter.AdapterShops
import navin.store.shopping.databinding.FragmentShopBinding
import navin.store.shopping.model.ModelShops

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ShopFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var viewBinding:FragmentShopBinding?=null
    private var recyclerView:RecyclerView?=null
    private var listShops:ArrayList<ModelShops>?=null
    private var adapterShops:AdapterShops?=null

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
        // View Binding
        viewBinding=FragmentShopBinding.inflate(inflater,container,false)
        val view= viewBinding!!.root

        recyclerView=view.findViewById(R.id.recyclerviewShops)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager=LinearLayoutManager(requireContext())

        listShops= ArrayList()

        listShops!!.add(ModelShops("Navjoyt Medical","woman,parsa,gujarat,animal,woman,parsa, gujarat, animal",
            "Navragpura",R.drawable.jeans))
        listShops!!.add(ModelShops("Para Footwear","Type","Address",R.drawable.partyweartl))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.silkisaree))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.jeans))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.silkisaree))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.partyweartl))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.jeans))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.silkisaree))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.partyweartl))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.jeans))
        listShops!!.add(ModelShops("Name","Type","Address",R.drawable.silkisaree))

        adapterShops= AdapterShops(requireContext(), listShops!!)
        recyclerView!!.adapter=adapterShops
        return view
    }





    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}