package movie.bw.com.wdmovie.model

import android.content.Context
import com.kotlinframework.net.network.ApiErrorModel
import com.kotlinframework.net.network.IModelCallback
import com.kotlinframework.net.network.NetResponseObserver
import com.kotlinframework.net.network.NetScheduler
import movie.bw.com.wdmovie.api.Api
import movie.bw.com.wdmovie.api.LoginService
import movie.bw.com.wdmovie.contract.LoginContract
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.entity.RegBean
import movie.bw.com.wdmovie.util.RetrofitUtil

class LoginModel:LoginContract.IModel {
    override fun getReg(context: Context, map: HashMap<String, String>, modelCallback: IModelCallback<RegBean>) {
        RetrofitUtil.getinstance.createService(LoginService::class.java)
            .getReg(Api.REG_URL,map)
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<RegBean>(context){
                override fun success(data: RegBean) {
                    modelCallback.sucess(data)
                }

                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                    modelCallback.failure(apiErrorModel.message)
                }

            })

    }

    override fun getLogin(context: Context,map: HashMap<String, String>, modelCallback: IModelCallback<LoginBean>) {
        RetrofitUtil.getinstance.createService(LoginService::class.java)
            .getLogin(Api.LOGIN_URL,map)
            .compose(NetScheduler.compose())
            .subscribe ( object :NetResponseObserver<LoginBean>(context){
                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                    modelCallback ?. failure(apiErrorModel.message)
                }

                override fun success(data: LoginBean) {
                    modelCallback ?. sucess(data)
                }

            })
    }
}