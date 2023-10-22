package com.example.addnamesavedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

object NameObject {
    private var result: String = ""
    fun setResult(name: String) {
        result = result + "\n" + name
    }
    fun getResult(): String {
        return result;
    }


}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View){
        val inputName = findViewById<EditText>(R.id.nameInput)
        val text = findViewById<TextView>(R.id.nameText)
        if (inputName.text.toString() == ""){
            text.text = "No Name Entered"
            return
        }
        NameObject.setResult(inputName.text.toString())
        inputName.text.clear()
        text.text = NameObject.getResult()
    }
}