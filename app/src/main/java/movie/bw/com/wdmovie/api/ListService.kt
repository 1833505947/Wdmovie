package movie.bw.com.wdmovie.api

import io.reactivex.Observable
import movie.bw.com.wdmovie.entity.ListBean
import movie.bw.com.wdmovie.entity.LoginBean
import retrofit2.http.*

interface ListService {
    @GET

    fun getList(@Url string: String,@QueryMap map: HashMap<String,String>):Observable<ListBean>
}