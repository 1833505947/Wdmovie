package movie.bw.com.wdmovie.persenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import movie.bw.com.wdmovie.contract.LoginContract
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.entity.RegBean
import movie.bw.com.wdmovie.model.LoginModel
import movie.bw.com.wdmovie.net.LoginCallback

class LoginPersenter: LoginContract.IPersenter {


    lateinit var loginModel: LoginModel
    lateinit var iview:LoginContract.IView

    fun attach( iview : LoginContract.IView) {

        this.iview = iview
        loginModel = LoginModel()
    }

    override fun getLogin(map: HashMap<String, String>, context: Context) {

        if (loginModel!=null){
            loginModel.getLogin(context,map,object :IModelCallback<LoginBean>{
                override fun failure(string: String) {
                    if (iview!=null){
                        iview.failure(string)
                    }
                }

                override fun sucess(data: LoginBean) {
                    if (iview!=null){
                        iview.success(data)
                    }
                }

            })
        }
    }
    override fun getReg(map: HashMap<String, String>, context: Context) {
        if (loginModel!=null){
            loginModel.getReg(context,map,object : IModelCallback<RegBean>{
                override fun sucess(data: RegBean) {
                    iview?.success(data)
                }

                override fun failure(string: String) {
                    iview?.failure(string)
                }

            })
        }
    }
    fun detach(){
        if (iview!=null){
            iview==null
        }
    }
}