package movie.bw.com.wdmovie.util

import movie.bw.com.wdmovie.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitUtil private constructor(){

    companion object {
        val getinstance:RetrofitUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitUtil()
        }
    }

    lateinit var retrofit: Retrofit

    fun init(string:String){
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(
                if (BuildConfig.DEBUG)HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
            ))
            .connectTimeout(5,TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .writeTimeout(5,TimeUnit.SECONDS)
            .build();
        retrofit = Retrofit.Builder()
            .baseUrl(string)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build();
    }
    /**
     * 动态代理模式，创建请求接口类
     * @param tClass
     * @param <T>
     * @return
    </T> */
    fun <T> createService(tClass:Class<T>):T{
        return retrofit.create(tClass)
    }
}