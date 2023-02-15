package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SecondActivity: AppCompatActivity(), View.OnClickListener {

    private var activePlayer = ""
    private lateinit var filledPosition: IntArray
    private lateinit var clickListener: Array<Button>
    private lateinit var player: String
    private var gameActive = true
    private var count = 0

    // region view declaration
    private lateinit var textView: TextView
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var restart: Button
    private lateinit var takePhoto: Button
    private lateinit var imageView: ImageView
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_second)

        filledPosition = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)

        // region find views
        textView = findViewById(R.id.playerName)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        restart = findViewById(R.id.restart)
        takePhoto = findViewById(R.id.takePhoto)
        imageView = findViewById(R.id.imageView)
        // endregion

        // Display the player name
        player = intent?.getStringExtra("EXTRA_TEXT").toString()
        textView.text = player
//        textView.text = savedInstanceState?.getString("PLAYER2") ?: player

        takePhoto.setOnClickListener {
            val image: Bitmap = takeScreenshotOfRootView(imageView)
            imageView.setImageBitmap(image)
            sharePalette(image)
        }

        restart.setOnClickListener {
            restartGame()
        }

        clickListener = arrayOf(button0, button1, button2, button3, button4, button5, button6, button7, button8)
        for (i in clickListener)
            i.setOnClickListener(this)

//        textView.text = savedInstanceState?.getString("PLAYER2")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString("PLAYER", textView.text.toString())
        savedInstanceState.putIntArray("LIST", filledPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textView.text = savedInstanceState.getString("PLAYER")
        filledPosition = savedInstanceState.getIntArray("LIST")!!
        for(i in filledPosition.indices) {
            if(filledPosition[i] == 0) {
                clickListener[i].text = "O"
                clickListener[i].setTextColor(Color.parseColor("#e63946"))
                clickListener[i].backgroundTintList = getColorStateList(R.color.white)
            }
            else if(filledPosition[i] == 1) {
                clickListener[i].text = "X"
                clickListener[i].setTextColor(Color.WHITE)
                clickListener[i].backgroundTintList = getColorStateList(R.color.buttons)
            }
        }
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun sharePalette(bitmap: Bitmap) {
        val bitmapPath =
            MediaStore.Images.Media.insertImage(contentResolver, bitmap, "palette", "share palette")
        val bitmapUri = Uri.parse(bitmapPath)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
        startActivity(Intent.createChooser(intent, "Share"))
    }

    companion object Screenshot {
        private fun takeScreenshot(view: View): Bitmap {
            view.isDrawingCacheEnabled = true
            view.buildDrawingCache(true)
            val b = Bitmap.createBitmap(view.drawingCache)
            view.isDrawingCacheEnabled = false
            return b
        }
        fun takeScreenshotOfRootView(v: View): Bitmap {
            return takeScreenshot(v.rootView)
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(v: View?) {


        if(!gameActive) return

        val buttonClicked = v as Button
        val clickedTag = Integer.parseInt(buttonClicked.tag.toString())

        if(filledPosition[clickedTag] != -1) return

        if(textView.text == "${Players.Player1}") {
            count++
            buttonClicked.text = "O"
            activePlayer = "${Players.Player2}"
            textView.text = "Player2"
            filledPosition[clickedTag] = 0
            buttonClicked.setTextColor(Color.parseColor("#e63946"))
            buttonClicked.backgroundTintList = getColorStateList(R.color.white)
        } else {
            count++
            buttonClicked.text = "X"
            activePlayer = "${Players.Player1}"
            textView.text = "Player1"
            filledPosition[clickedTag] = 1
            buttonClicked.setTextColor(Color.WHITE)
            buttonClicked.backgroundTintList = getColorStateList(R.color.buttons)
        }
        checkForWin()
    }

    private fun checkForWin() {
        val winPosition = arrayOf(intArrayOf(0,1,2), intArrayOf(3,4,5), intArrayOf(6,7,8),
            intArrayOf(0,3,6), intArrayOf(1,4,7), intArrayOf(2,5,8),
            intArrayOf(0,4,8), intArrayOf(2,4,6))

        for(i in winPosition.indices) {
            val value0 = winPosition[i][0]
            val value1 = winPosition[i][1]
            val value2 = winPosition[i][2]

            if(filledPosition[value0] == filledPosition[value1] && filledPosition[value1] == filledPosition[value2]) {
                if(filledPosition[value0] != -1) {
                    gameActive = false
                    if(filledPosition[value0] == 0) {
                        textView.text = "Player-1 is winner"
                    } //textView.text = "Player-1 is winner"
                    else {
                        textView.text = "Player-2 is winner"
                    }
                    return
                }
            }
        }

        if(count == 9) {
            textView. text = "It,s Draw"
            return
        }
    }

    private fun restartGame() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}