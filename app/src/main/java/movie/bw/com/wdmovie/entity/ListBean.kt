package movie.bw.com.wdmovie.entity

data class ListBean(
    val message: String,
    val result: List<Result>,
    val status: String
) {
    data class Result(

        var fare: Int,
        var id: Int,
        var imageUrl: String? = null,
        var name: String? = null,
        var releaseTime: Long,
        var summary: String? = null
    )
}