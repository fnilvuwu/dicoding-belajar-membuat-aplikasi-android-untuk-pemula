package com.example.bpaap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CharacterDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail"
        //Display Back Button
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val tvSetDesc: TextView = findViewById(R.id.tv_item_description)
        val imgSetPhoto: ImageView = findViewById(R.id.iv_item_photo)
        val tvSetBday: TextView = findViewById(R.id.tv_item_birthday)
        val tvSetBounty: TextView = findViewById(R.id.tv_item_bounty)

        val tName = intent.getStringExtra(EXTRA_NAME)
        val tDesc = intent.getStringExtra(EXTRA_DESCRIPTION)
        val tImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val tBday = intent.getStringExtra(EXTRA_BIRTHDAY)
        val tBounty = intent.getStringExtra(EXTRA_BOUNTY)

        tvSetName.text = tName
        tvSetDesc.text = tDesc
        imgSetPhoto.setImageResource(tImg)
        tvSetBday.text = tBday
        tvSetBounty.text = tBounty
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_BIRTHDAY = "extra_birthday"
        const val EXTRA_BOUNTY = "extra_bounty"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}