package com.example.bpaap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacters: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Straw Hat Pirates"

        rvCharacters = findViewById(R.id.rv_characters)
        rvCharacters.setHasFixedSize(true)

        list.addAll(getListCharacters())
        showRecyclerList()
    }

    private fun getListCharacters(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataBounty = resources.getStringArray(R.array.data_bounty)

        val listCharacter = ArrayList<Character>()
        for (i in dataName.indices) {
            val character =
                Character(
                    dataName[i],
                    dataDescription[i],
                    dataPhoto.getResourceId(i, -1),
                    dataBirthday[i],
                    dataBounty[i]
                )
            listCharacter.add(character)
        }
        return listCharacter
    }

    private fun showRecyclerList() {
        rvCharacters.layoutManager = LinearLayoutManager(this)
        val ListCharacterAdapter = ListCharacterAdapter(list)
        rvCharacters.adapter = ListCharacterAdapter
    }

    //Modify ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(
                    this@MainActivity,
                    AboutActivity::class.java
                )
                startActivity(iAbout)
            }
        }
    }
}