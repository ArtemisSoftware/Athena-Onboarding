package com.artemissoftware.athenaonboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.artemissoftware.athenaonboard.custom.Tooltip
import com.artemissoftware.athenaonboard.databinding.ActivityLibraryBinding
import com.artemissoftware.athenaonboard.databinding.TooltipViewBinding

class LibraryActivity : AppCompatActivity() {


  //  private lateinit var binding: ActivityLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)


//        binding = ActivityLibraryBinding.inflate(layoutInflater)

//        binding.mainView.addOnWindowFocusChangeListener {
//            binding.tooltip.setPosition(binding.imageView2)
//        }
        findViewById<ConstraintLayout>(R.id.main_view).addOnWindowFocusChangeListener {
            findViewById<Tooltip>(R.id.tooltip).setPosition(findViewById<ImageView>(R.id.imageView2))
            findViewById<Tooltip>(R.id.tooltip).visibility = View.VISIBLE
        }
    }
}