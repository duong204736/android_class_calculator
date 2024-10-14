package com.example.myapplication


//import android.R
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.security.KeyStore.TrustedCertificateEntry


class MainActivity : AppCompatActivity() {

    lateinit var display: TextView
    var firstVal = 0
    var secondVal = 0
    var firstValInputting = true
    var operator = "add" // default operator is add
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display = findViewById<TextView>(R.id.textView)

        val num9 =  findViewById<Button>(R.id.button44)
        val num8 =  findViewById<Button>(R.id.button42)
        val num7 =  findViewById<Button>(R.id.button43)
        val num6 =  findViewById<Button>(R.id.button49)
        val num5 =  findViewById<Button>(R.id.button47)
        val num4 =  findViewById<Button>(R.id.button46)
        val num3 =  findViewById<Button>(R.id.button52)
        val num2 =  findViewById<Button>(R.id.button53)
        val num1 =  findViewById<Button>(R.id.button50)
        val num0 =  findViewById<Button>(R.id.button39)

        val bs =  findViewById<Button>(R.id.button21)
        val add =  findViewById<Button>(R.id.button51)
        val sub =  findViewById<Button>(R.id.button48)
        val mul =  findViewById<Button>(R.id.button45)
        val div =  findViewById<Button>(R.id.button15)

        val calculate =  findViewById<Button>(R.id.button41)

        val invert =  findViewById<Button>(R.id.button38)

        // TODO: Clear button
        val clearDisplay =  findViewById<Button>(R.id.button20 )
        // Set an OnClickListener
        num9.setOnClickListener { addNum(9) }
        num8.setOnClickListener { addNum(8) }
        num7.setOnClickListener { addNum(7) }
        num6.setOnClickListener { addNum(6) }
        num5.setOnClickListener { addNum(5) }
        num4.setOnClickListener { addNum(4) }
        num3.setOnClickListener { addNum(3) }
        num2.setOnClickListener { addNum(2) }
        num1.setOnClickListener { addNum(1) }
        num0.setOnClickListener { addNum(0) }

        add.setOnClickListener { setTheOperator("add") }
        sub.setOnClickListener { setTheOperator("sub") }
        mul.setOnClickListener { setTheOperator("mul") }
        div.setOnClickListener { setTheOperator("div") }

        calculate.setOnClickListener { cal() }
        bs.setOnClickListener { removeNum() }
        invert.setOnClickListener { invertNum() }

        clearDisplay.setOnClickListener { clr() }
    }
    fun addNum(n: Int){
        if (firstValInputting) {
            firstVal = firstVal*10 + n
            display.text = firstVal.toString()
        } else {
            secondVal = secondVal*10 + n
            display.text = secondVal.toString()
        }
    }
    fun removeNum(){
        if (firstValInputting) {
            firstVal %= 10
            display.text = firstVal.toString()
        } else {
            secondVal %= 10
            display.text = secondVal.toString()
        }
    }
    fun invertNum() {
        if (firstValInputting) {
            firstVal =- firstVal
            display.text = firstVal.toString()
        } else {
            secondVal = - secondVal
            display.text = secondVal.toString()
        }
    }
    fun setTheOperator(op: String) {

        if (firstValInputting) {
            firstValInputting = false
            operator = op
        } else {
                // calulate here
            cal()
        }
    }
    fun cal() {
        if (operator == "add") {
            firstVal = firstVal + secondVal
            display.text = firstVal.toString()
        } else if (operator == "sub") {
            firstVal = firstVal - secondVal
            display.text = firstVal.toString()
        }else if (operator == "mul") {
            firstVal = firstVal * secondVal
            display.text = firstVal.toString()
        }else if (operator == "div") {
            if (secondVal == 0) {
                display.text = "Can not divide by zero"
            } else {
                firstVal = firstVal / secondVal
                display.text = firstVal.toString()
            }
        }
        secondVal = 0
        operator = "add"   //set back to default operator
        // After this point, user can keep calculate by typing the secondVal
    }
    fun clr () {
        firstVal = 0
        secondVal = 0
        firstValInputting = true
        display.text = "0"
        operator = "add"
    }

}