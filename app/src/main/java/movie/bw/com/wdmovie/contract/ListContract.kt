package movie.bw.com.wdmovie.contract

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import movie.bw.com.wdmovie.entity.ListBean
import movie.bw.com.wdmovie.entity.LoginBean
import java.security.AccessControlContext

interface ListContract {
    interface IPersenter{
        fun getList(map:HashMap<String,String>,context: Context)
    }
    interface IModel{
        fun getList(context: Context,map: HashMap<String, String>, modelCallback:IModelCallback<ListBean>)
    }
    interface IView{
        fun success(listBean: ListBean)
        fun failure(string: String)
    }
}