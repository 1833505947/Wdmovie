package movie.bw.com.wdmovie.contract

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.entity.RegBean
import java.security.AccessControlContext

interface LoginContract {
    interface IPersenter{
        fun getLogin(map:HashMap<String,String>,context: Context)
        fun getReg(map: HashMap<String, String>, context: Context)
    }
    interface IModel{
        fun getLogin(context: Context, map: HashMap<String, String>, modelCallback:IModelCallback<LoginBean>)
        fun getReg(context: Context, map: HashMap<String, String>, modelCallback: IModelCallback<RegBean>)
    }
    interface IView{
        fun success(loginBean: LoginBean)
        fun failure(string: String)
        fun success(regBean: RegBean)

    }
}