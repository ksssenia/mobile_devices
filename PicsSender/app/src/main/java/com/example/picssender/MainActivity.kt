package com.example.picssender

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import com.example.takephotoapp.databinding.ActivityMainBinding
import java.io.File


class MainActivity : AppCompatActivity() {

    private var latestTmpUri: Uri? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendPhotoButton.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_STREAM, latestTmpUri)
            i.putExtra(Intent.EXTRA_SUBJECT, "КПП НАИ-196 Кожухарь")
            startActivity(i)
        }

        binding.takeImgButton.setOnClickListener {
            takePhoto()
        }
    }

    private val takePhotoLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                latestTmpUri?.let { uri ->
                    binding.image.setImageURI(uri)
                }
            }
        }

    private fun takePhoto() {
        lifecycleScope.launchWhenStarted {
            getFileUri().let { uri ->
                latestTmpUri = uri
                takePhotoLauncher.launch(uri)
            }
        }
    }

    private fun getFileUri(): Uri {
        val tmpFile = File.createTempFile("my_photo", ".png", cacheDir).apply {
            createNewFile()
            deleteOnExit()
        }

        return FileProvider.getUriForFile(
            applicationContext,
            "${BuildConfig.APPLICATION_ID}.provider",
            tmpFile
        )
    }
}