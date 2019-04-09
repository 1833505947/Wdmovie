package movie.bw.com.wdmovie.model

import android.content.Context
import com.kotlinframework.net.network.ApiErrorModel
import com.kotlinframework.net.network.IModelCallback
import com.kotlinframework.net.network.NetResponseObserver
import com.kotlinframework.net.network.NetScheduler
import movie.bw.com.wdmovie.api.Api
import movie.bw.com.wdmovie.api.ListService
import movie.bw.com.wdmovie.api.LoginService
import movie.bw.com.wdmovie.contract.ListContract
import movie.bw.com.wdmovie.contract.LoginContract
import movie.bw.com.wdmovie.entity.ListBean
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.util.RetrofitUtil

class ListModel:ListContract.IModel {

    override fun getList(context: Context,map: HashMap<String, String>, modelCallback: IModelCallback<ListBean>) {
        RetrofitUtil.getinstance.createService(ListService::class.java)
            .getList(Api.LIST_URL,map)
            .compose(NetScheduler.compose())
            .subscribe(object : NetResponseObserver<ListBean>(context){
                override fun success(data: ListBean) {
                    modelCallback ?. sucess(data)
                }

                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                    modelCallback ?. failure(apiErrorModel.message)
                }

            })


             }

}