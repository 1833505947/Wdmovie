package movie.bw.com.wdmovie


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import movie.bw.com.wdmovie.contract.LoginContract
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.entity.RegBean
import movie.bw.com.wdmovie.persenter.LoginPersenter
import movie.bw.com.wdmovie.util.EncryptUtil

class MainActivity : AppCompatActivity(),LoginContract.IView,View.OnClickListener {
    override fun success(regBean: RegBean) {
    }

    lateinit var loginPersenter: LoginPersenter
    lateinit var phone: EditText
    lateinit var pwd: EditText

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.bt_login->Login()

            R.id.go_reg->goreg()
            //Toast.makeText(this,"点击",Toast.LENGTH_LONG).show();
        }
    }

    private fun goreg(){
        val intent = Intent()
        intent.setClass(this,RegActivity().javaClass)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        loginPersenter = LoginPersenter()
    }

    private fun initView() {
        bt_login.setOnClickListener(this)
        go_reg.setOnClickListener(this)
         phone = findViewById(R.id.phone);
         pwd = findViewById(R.id.pwd);
     //   bt_login = findViewById(R.id.bt_login);
    }
    fun Login(){
        val map = HashMap<String, String>()
        val phone1:String = phone.text.toString()
        val pwd1:String = pwd.text.toString()
        val encrypt = EncryptUtil.encrypt(pwd1);
        map.put("phone",phone1)
        map.put("pwd", encrypt)

        loginPersenter.attach(this)
        loginPersenter.getLogin(map,this)

    }
    override fun failure(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun success(loginBean: LoginBean) {
       // Toast.makeText(this, loginBean.result.userInfo.phone, Toast.LENGTH_SHORT).show()
        var intent=Intent()
        intent.setClass(this,ListActivity().javaClass)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPersenter.detach()
    }
}
