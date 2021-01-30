package navin.store.shopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import navin.store.shopping.R
import navin.store.shopping.model.ModelShops

class MainActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView = findViewById(R.id.BottomNavigationView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.shopFragment,
                R.id.cartFragment,
                R.id.accountFragment
            )
        )
        setupActionBarWithNavController(navController!!, appBarConfiguration)
        bottomNavigationView!!.setupWithNavController(navController!!)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController!!.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menusearch, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.menu.menusearch){
            val searchView: SearchView = MenuItemCompat.getActionView(item) as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    var shopFragment=ShopFragment()
                    shopFragment.adapterShops!!.filter.filter(newText)
                    return false
                }

            })
        }
        return super.onOptionsItemSelected(item)
    }
}