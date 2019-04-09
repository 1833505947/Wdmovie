package movie.bw.com.wdmovie.net

import movie.bw.com.wdmovie.entity.LoginBean

interface LoginCallback {
    interface IView{
        fun success(loginBean: LoginBean)
        fun failure(string: String)
    }
}