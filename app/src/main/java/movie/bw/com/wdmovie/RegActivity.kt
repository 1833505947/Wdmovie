package movie.bw.com.wdmovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_reg.*
import movie.bw.com.wdmovie.contract.LoginContract
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.entity.RegBean
import movie.bw.com.wdmovie.persenter.LoginPersenter
import movie.bw.com.wdmovie.util.EncryptUtil

class RegActivity : AppCompatActivity(),LoginContract.IView, View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.register ->  //Toast.makeText(this,"1111111111",Toast.LENGTH_LONG).show()
                Regclock()
        }

    }

    lateinit var name_zc:EditText
    lateinit var birth:EditText
    lateinit var sex:EditText
    lateinit var pass_zc:EditText
    lateinit var pass_reset:EditText
    lateinit var email:EditText
    lateinit var phone_zc:EditText
    override fun success(loginBean: LoginBean) {

    }

    override fun failure(string: String) {

    }

    override fun success(regBean: RegBean) {
        Toast.makeText(this,regBean.message,Toast.LENGTH_LONG).show()
    }

    lateinit var loginPersenter: LoginPersenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        initView()
        initData()

    }

    private fun initData() {
        loginPersenter = LoginPersenter()


    }
private fun Regclock(){
    register.setOnClickListener(this)
    val name_zc1:String = name_zc.text.toString();
    val email1:String = email.text.toString()
    val pass_zc1:String = pass_zc.text.toString()
    val pass_reset1:String = pass_reset.text.toString()
    val birth1:String = birth.text.toString()
    val phone_zc1:String = phone_zc.text.toString()
    val sex1:String = sex.text.toString()

    val decrypt = EncryptUtil.encrypt(pass_reset1)
    val decrypt1 = EncryptUtil.encrypt(pass_zc1)
    val map=HashMap<String,String>()
    map.put("nickName",name_zc1)
    map.put("phone",phone_zc1)
    map.put("pwd",decrypt)
    map.put("pwd2",decrypt1)
    map.put("sex",sex1)
    map.put("birthday",birth1)
    map.put("email",email1)
    loginPersenter.attach(this)
    loginPersenter.getReg(map,this)
}
    private fun initView() {
        register.setOnClickListener(this)
        name_zc = findViewById(R.id.name_zc)
        sex = findViewById(R.id.sex)
        birth = findViewById(R.id.birth)
        phone_zc = findViewById(R.id.phone_zc)
        pass_zc = findViewById(R.id.pass_zc)
        email = findViewById(R.id.email)
        pass_reset = findViewById(R.id.pass_reset)
    }

}
