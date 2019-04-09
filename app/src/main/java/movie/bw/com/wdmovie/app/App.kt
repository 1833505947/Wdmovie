package movie.bw.com.wdmovie.app

import android.app.Application
import movie.bw.com.wdmovie.api.Api
import movie.bw.com.wdmovie.util.RetrofitUtil

class App :Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitUtil.getinstance.init(Api.BASE_URL)
    }
}