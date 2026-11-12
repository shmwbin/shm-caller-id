package `in`.shmcallerid.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private lateinit var numberInput: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(28, 40, 28, 28)
            setBackgroundColor(Color.rgb(245, 248, 255))
        }

        val title = TextView(this).apply {
            text = "SHM Caller ID"
            textSize = 28f
            setTextColor(Color.rgb(20, 50, 100))
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Smart Caller Identification"
            textSize = 15f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
        }

        numberInput = EditText(this).apply {
            hint = "Enter 10-digit mobile number"
            inputType = 3
            textSize = 16f
            setSingleLine(true)
        }

        val searchButton = Button(this).apply {
            text = "SEARCH NUMBER"
            setOnClickListener {
                searchNumber()
            }
        }

        resultText = TextView(this).apply {
            text = "Search a mobile number to see available information."
            textSize = 16f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(10, 30, 10, 10)
        }

        layout.addView(title)
        layout.addView(subtitle)

        layout.addView(
            numberInput,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = 35
            }
        )

        layout.addView(searchButton)
        layout.addView(resultText)

        setContentView(layout)
    }

    private fun searchNumber() {
        val number = numberInput.text.toString().trim()

        if (!number.matches(Regex("^[6-9][0-9]{9}$"))) {
            resultText.text = "Please enter a valid 10-digit Indian mobile number."
            return
        }

        resultText.text =
            "Number: +91 $number\n\n" +
            "Caller information is not available yet.\n" +
            "Database connection will be added in a later step."
    }
}
