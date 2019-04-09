package movie.bw.com.wdmovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout

import android.widget.Toast
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.activity_list.*
import movie.bw.com.wdmovie.adapter.ListAdapter
import movie.bw.com.wdmovie.contract.ListContract
import movie.bw.com.wdmovie.entity.ListBean
import movie.bw.com.wdmovie.persenter.ListPersenter

class ListActivity : AppCompatActivity(),ListContract.IView,XRecyclerView.LoadingListener {
    var page:Int = 1
    lateinit var xre:XRecyclerView
    override fun onLoadMore() {
                page++
        initData()
    }

    override fun onRefresh() {
        page=1
        initData()
    }

    override fun success(listBean: ListBean) {
        if (page==1){
            xre.adapter = ListAdapter(this,listBean.result)
        }else{
            xre.adapter?.notifyDataSetChanged()
        }
        Toast.makeText(this,listBean.message,Toast.LENGTH_LONG).show()
    }

    override fun failure(string: String) {
        Toast.makeText(this,string,Toast.LENGTH_LONG).show()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initView()
        initData();
    }

    lateinit var listPersenter: ListPersenter

    private fun initData() {
        listPersenter = ListPersenter();
        val map = HashMap<String,String>()
        map.put("page","1")
        map.put("count","10")
        listPersenter.attach(this)
        listPersenter.getList(map,this)
    }

    private fun initView() {
        xre = findViewById(R.id.xre)
        xre.layoutManager = LinearLayoutManager(this)
        xre.setLoadingListener(this)
        xre.setLoadingMoreEnabled(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        listPersenter.detach()
    }
}
