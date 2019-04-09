package movie.bw.com.wdmovie.persenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import movie.bw.com.wdmovie.contract.ListContract
import movie.bw.com.wdmovie.contract.LoginContract
import movie.bw.com.wdmovie.entity.ListBean
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.model.ListModel
import movie.bw.com.wdmovie.model.LoginModel
import movie.bw.com.wdmovie.net.LoginCallback

class ListPersenter: ListContract.IPersenter {

    lateinit var listModel: ListModel
    lateinit var iview:ListContract.IView

    fun attach( iview : ListContract.IView) {

        this.iview = iview
        listModel = ListModel()
    }

    override fun getList(map: HashMap<String, String>, context: Context) {


        if (listModel!=null){
            listModel.getList(context,map,object :IModelCallback<ListBean>{
                override fun sucess(data: ListBean) {
                    iview ?. success(data)
                }

                override fun failure(string: String) {
                    if (iview!=null){
                        iview ?. failure(string)
                    }
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