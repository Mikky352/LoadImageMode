package com.example.loadimagemode

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.squareup.okhttp.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okio.*

import java.io.IOException

import android.view.View
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

import com.example.loadimagemode.RecyclerAdapter.LoadChanged


class FragmentAsyncViewModel: ViewModel() {
    val Adapter by lazy { RecyclerAdapter<LoadingData>(R.layout.image_loading2) }
    var loadingData = LoadingData()
    var urlList: MutableList<String> = mutableListOf()
    var loadingDataList: MutableList<LoadingData> = mutableListOf()
    val Url1: ObservableField<String> = ObservableField("")
    val Url2: ObservableField<String> = ObservableField("")
    val Url3: ObservableField<String> = ObservableField("")
    val Url4: ObservableField<String> = ObservableField("")
    var change2 = MutableLiveData<Int>()
    var count:Int?=0
    var buttonText: ObservableField<Boolean> = ObservableField(false)
    var buttonVisibility: ObservableField<Boolean> = ObservableField(true)

    init {

        var imagelistener= object : LoadChanged {
            /*override fun Sucess(bool: Boolean, position: Int) {
   Log.e("ChangedValue","change value of imagelistener "+bool+"  "+Int)
                    if(bool){

                      loadingDataList.get(position).show=false
                        Adapter.apply {
                            if(position==1) {
                                loadingDataList.get(position).url1="https://cdn.wallpapersafari.com/36/6/WCkZue.png"
                                addItemsAtPosition(loadingDataList, position)
                                //addItems(loadingDataList)
                            }
                            if(position==2) {
                                loadingDataList.get(position).url1="https://www.iliketowastemytime.com/sites/default/files/hamburg-germany-nicolas-kamp-hd-wallpaper_0.jpg"
                                addItemsAtPosition(loadingDataList, position)
                                //addItems(loadingDataList)
                            }
                            if(position==3) {
                                loadingDataList.get(position).url1="https://images.hdqwalls.com/download/drift-transformers-5-the-last-knight-qu-5120x2880.jpg"
                                addItemsAtPosition(loadingDataList, position)
                                //addItems(loadingDataList)
                            }
                            if(position==4) {
                                loadingDataList.get(position).url1="https://survarium.com/sites/default/files/calendars/survarium-wallpaper-calendar-february-2016-en-2560x1440.png"
                                addItemsAtPosition(loadingDataList, position)
                                //addItems(loadingDataList)
                            }
                        }
                        *//*Adapter.apply {
                            addItems(loadingDataList)
                        }*//*
                    }



            }*/

            override fun Sucess(bool: Boolean, position: Int, drawable: Drawable?) {
                Log.e("ChangedValue","change value of imagelistener "+bool+"  "+Int+"  "+ loadingDataList.get(position)+"  "+loadingDataList.get(position).show)
                if(bool){

                    loadingDataList.get(position).show=false

                    count =count!! + 1
                    Log.e("ViewVisiblity","Button visiblity  " +position+" "+count)
                    if(count==4){
                        Log.e("ViewVisiblity","Button visiblity inside count " +position)
                        buttonVisibility.set(false)
                        //param?.sucess(true)
                        change2.value=1
                    }
                    /*Adapter.apply {
                        if(position==0) {
                           // loadingDataList.get(position).url1="https://cdn.wallpapersafari.com/36/6/WCkZue.png"
                            loadingDataList.get(position).drawable = drawable
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                        if(position==1) {

                            loadingDataList.get(position).drawable = drawable //loadingDataList.get(position).url1="https://www.iliketowastemytime.com/sites/default/files/hamburg-germany-nicolas-kamp-hd-wallpaper_0.jpg"
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                        if(position==2) {
                            loadingDataList.get(position).drawable = drawable
                          //  loadingDataList.get(position).url1="https://images.hdqwalls.com/download/drift-transformers-5-the-last-knight-qu-5120x2880.jpg"
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                        if(position==3) {
                            loadingDataList.get(position).drawable = drawable
                         //   loadingDataList.get(position).url1="https://survarium.com/sites/default/files/calendars/survarium-wallpaper-calendar-february-2016-en-2560x1440.png"
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                    }
                    Adapter.apply {
                        addItems(loadingDataList)
                    }*/
                }

            }
        }
        Url1.set("https://cdn.wallpapersafari.com/36/6/WCkZue.png")
        Url2.set("https://www.iliketowastemytime.com/sites/default/files/hamburg-germany-nicolas-kamp-hd-wallpaper_0.jpg")
        Url3.set("https://images.hdqwalls.com/download/drift-transformers-5-the-last-knight-qu-5120x2880.jpg")
        Url4.set("https://survarium.com/sites/default/files/calendars/survarium-wallpaper-calendar-february-2016-en-2560x1440.png")
        urlList.add("https://cdn.wallpapersafari.com/36/6/WCkZue.png")

        urlList.add("https://www.iliketowastemytime.com/sites/default/files/hamburg-germany-nicolas-kamp-hd-wallpaper_0.jpg")
        urlList.add("https://images.hdqwalls.com/download/drift-transformers-5-the-last-knight-qu-5120x2880.jpg")
        urlList.add("https://survarium.com/sites/default/files/calendars/survarium-wallpaper-calendar-february-2016-en-2560x1440.png")

        for ((index, value) in urlList.withIndex()) {
            loadingData = LoadingData()
            loadingData.url1 = value
            Log.e("Url", "url inside is " + loadingData.url1)
            loadingDataList.add(loadingData)
        }
        Adapter.apply {
            addItems(loadingDataList)
            setImageListener(imagelistener)
        }






}
    var change=  object:LoadChange{
        override fun Sucess(bool: Boolean) {

            if(bool){

            }else{


            }

        }

    }

    fun onClick(view: View) {
        var textview : TextView =view as TextView
        if ( textview.text== "Resume") {

            Glide.with(view.context).resumeRequests()
            buttonText.set(false)

        }else if (textview.text=="Pause"){
            Glide.with(view.context).pauseRequests();
            buttonText.set(true)
        }


    }

  public  interface LoadChange {
        fun Sucess(bool:Boolean)
    }

        object BindingAdapters {


    val progressListener: ProgressListener = object : ProgressListener {
        override fun update(bytesRead: Long, contentLength: Long, done: Boolean) {
            val progress = (100 * bytesRead / contentLength).toInt()

            // Enable if you want to see the progress with logcat
            // Log.v(LOG_TAG, "Progress: " + progress + "%");
            // progressBar.setProgress(progress)
            if (done) {
                Log.i("GifActivity", "Done loading")
            }
        }


    }
    var mOkHttpClient = OkHttpClient()


    private val uiScope = CoroutineScope(Dispatchers.Main)

    /*@JvmStatic@BindingAdapter(value = ["setImageAsync", "placeholder"], requireAll = false)
    fun setImageAsync(
        imageView: ImageView,
        url: String?,
        drawable: Drawable,
    ) {
        mOkHttpClient.networkInterceptors().add(Interceptor { chain ->
            val originalResponse = chain.proceed(chain.request())
            originalResponse.newBuilder()
                .body(ProgressResponseBody(originalResponse.body(), progressListener))
                .build()
        })
        uiScope.launch {

            async {
                Log.e("Url", "url above " + url)
                imageView.setImageDrawable(drawable)
                try {
                    if (!url.isNullOrEmpty()) {
                        when {
                            url.startsWith("content://") -> {
                                imageView.setImageURI(Uri.parse(url))
                            }
                            else -> {
                                Log.e("Url", "url before setting " + url)



                                Glide.with(imageView.context)
                                    .load(url)
                                    .listener(object : RequestListener<Drawable?> {
                                        override fun onLoadFailed(
                                            @Nullable e: GlideException?,
                                            model: Any,
                                            target: Target<Drawable?>,
                                            isFirstResource: Boolean
                                        ): Boolean {
                                            //progressBar.setVisibility(View.GONE)
                                            return false
                                        }

                                        override fun onResourceReady(
                                            resource: Drawable?,
                                            model: Any,
                                            target: Target<Drawable?>,
                                            dataSource: DataSource,
                                            isFirstResource: Boolean
                                        ): Boolean {
                                            //progressBar.setVisibility(View.GONE)
                                            return false
                                        }
                                    })
                                    .error(drawable).placeholder(drawable)
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                                    .skipMemoryCache(true)
                                    .into(imageView)
                                //Glide.get(imageView.context).
                                //Glide.get(imageView.context).register(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(mOkHttpClient))
                                // Glide.with(imageView.context).load(url).error(drawable).placeholder(drawable).into(imageView)


                            }
                        }
                    } else {
                        imageView.setImageDrawable(drawable)
                    }
                } catch (e: Exception) {

                }
            }
        }

    }
*/

    /*@BindingAdapter(value = ["setRecyclerAdapter"], requireAll = false)
    fun setRecyclerAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<*>
    ) {
        recyclerView.adapter = adapter
    }
*/

    class ProgressResponseBody(
        private val responseBody: ResponseBody,
        private val progressListener: ProgressListener
    ) :
        ResponseBody() {
        private var bufferedSource: BufferedSource? = null
        override fun contentType(): MediaType {
            return responseBody.contentType()
        }

        @Throws(IOException::class)
        override fun contentLength(): Long {
            return responseBody.contentLength()
        }

        @Throws(IOException::class)
        override fun source(): BufferedSource {
            if (bufferedSource == null) {
                bufferedSource = Okio.buffer(source(responseBody.source()))
            }
            return bufferedSource!!
        }

        private fun source(source: Source): Source {
            return object : ForwardingSource(source) {
                var totalBytesRead = 0L

                @Throws(IOException::class)
                override fun read(sink: Buffer?, byteCount: Long): Long {
                    val bytesRead = super.read(sink, byteCount)
                    // read() returns the number of bytes read, or -1 if this source is exhausted.
                    totalBytesRead += if (bytesRead != -1L) bytesRead else 0
                    progressListener.update(
                        totalBytesRead,
                        responseBody.contentLength(),
                        bytesRead == -1L
                    )
                    return bytesRead
                }
            }
        }


        }
    }
}