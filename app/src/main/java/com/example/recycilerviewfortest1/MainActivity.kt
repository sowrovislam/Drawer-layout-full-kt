package com.example.recycilerviewfortest1
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.recycilerviewfortest1.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        Drawer Layout

        setSupportActionBar(binding.toolbar)
        navController = findNavController(R.id.nav_host_fragment)

        binding.navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,binding.drawerLayout)

        appBarConfigurationdata()


        binding.navView.setNavigationItemSelectedListener { menu->


            menu.isChecked=true

            when(menu.itemId){

                R.id.blankFragment3->   Toast.makeText(this, "ami toake ", Toast.LENGTH_SHORT).show()



            }


            return@setNavigationItemSelectedListener true
        }





    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||  super.onSupportNavigateUp()
    }


    private fun appBarConfigurationdata() {

        appBarConfiguration=AppBarConfiguration.Builder(

            R.id.blankFragment,
            R.id.blankFragment3

        ).setOpenableLayout(binding.drawerLayout)
            .build()

    }






}
