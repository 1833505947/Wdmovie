package movie.bw.com.wdmovie.api

import io.reactivex.Observable
import movie.bw.com.wdmovie.entity.LoginBean
import movie.bw.com.wdmovie.entity.RegBean
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface LoginService {
    @POST
    @FormUrlEncoded
    fun getLogin(@Url string: String,@FieldMap map: HashMap<String,String>):Observable<LoginBean>
    @POST
    @FormUrlEncoded
    fun getReg(@Url string: String,@FieldMap map: HashMap<String,String>):Observable<RegBean>

}