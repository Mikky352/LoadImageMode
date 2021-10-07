package com.example.loadimagemode

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide

import android.widget.TextView

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData


class FragmentSyncViewModel: ViewModel() {
    val Adapter by lazy { RecyclerAdapter<LoadingData>(R.layout.image_loading) }
    var loadingData = LoadingData()
    var buttonText: ObservableField<Boolean> = ObservableField(false)
    var buttonVisibility: ObservableField<Boolean> = ObservableField(true)
    var urlList: MutableList<String> = mutableListOf()
    var loadingDataList: MutableList<LoadingData> = mutableListOf()
    var count:Int?=0
    var param: MainViewVisiblity?=null
    var change = MutableLiveData<Int>()

    val Url1: ObservableField<String> = ObservableField("https://cdn.wallpapersafari.com/36/6/WCkZue.png")
    val Url2: ObservableField<String> = ObservableField("https://www.iliketowastemytime.com/sites/default/files/hamburg-germany-nicolas-kamp-hd-wallpaper_0.jpg")
    val Url3: ObservableField<String> = ObservableField("https://images.hdqwalls.com/download/drift-transformers-5-the-last-knight-qu-5120x2880.jpg")
    val Url4: ObservableField<String> = ObservableField("https://survarium.com/sites/default/files/calendars/survarium-wallpaper-calendar-february-2016-en-2560x1440.png")


    init {

        var imagelistener= object : RecyclerAdapter.LoadChanged {
           /* override fun Sucess(bool: Boolean, position: Int) {

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
                    Adapter.apply {
                        addItems(loadingDataList)
                    }
                }



            }*/

            override fun Sucess(bool: Boolean, position: Int, drawable: Drawable?) {
                //Log.e("ChangedValue","change value of imagelistener "+bool+"  "+position+"  "+ loadingDataList.get(position)+"  "+loadingDataList.get(position).show)
                if(bool){
                  if(loadingDataList.isEmpty()==false) {
                      loadingDataList.get(position).show = false


                  }

                    count =count!! + 1
                    Log.e("ViewVisiblity","Button visiblity  " +position+" "+count)
                    if(count==4){
                        Log.e("ViewVisiblity","Button visiblity inside count " +position)
                        buttonVisibility.set(false)
                        //param?.sucess(true)
                        change.value=1
                    }
                    if(position==0 && position==1 && position ==2 && position==3){
                                buttonVisibility.set(false)
                        Log.e("ViewVisiblity","Button visiblity inside " +position)
                    }
                    /*Adapter.apply {
                        if(position==0) {
                            loadingDataList.get(position).drawable = drawable
                            //loadingDataList.get(position).url1="https://cdn.wallpapersafari.com/36/6/WCkZue.png"
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                        if(position==1) {
                            loadingDataList.get(position).drawable = drawable
                            //loadingDataList.get(position).url1="https://www.iliketowastemytime.com/sites/default/files/hamburg-germany-nicolas-kamp-hd-wallpaper_0.jpg"
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                        if(position==2) {
                            loadingDataList.get(position).drawable = drawable
//                            loadingDataList.get(position).url1="https://images.hdqwalls.com/download/drift-transformers-5-the-last-knight-qu-5120x2880.jpg"
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                        if(position==3) {
                            loadingDataList.get(position).drawable = drawable
                           // loadingDataList.get(position).url1="https://survarium.com/sites/default/files/calendars/survarium-wallpaper-calendar-february-2016-en-2560x1440.png"
                            addItemsAtPosition(loadingDataList, position)
                            //addItems(loadingDataList)
                        }
                    }*/
                    /*Adapter.apply {
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
            loadingData= LoadingData()
            loadingData.url1=value
            loadingDataList.add(loadingData)
        }
        Adapter.apply {
            addItems(loadingDataList)
            setImageListener(imagelistener)
        }

    }

    //object BindingAdapters {




    fun onClick(view: View) {
       var textview :TextView=view as TextView
        if ( textview.text== "Resume") {

            Glide.with(view.context).resumeRequests()
            buttonText.set(false)

          }else if (textview.text=="Pause"){
            Glide.with(view.context).pauseRequests();
            buttonText.set(true)
          }


    }

    fun setMainVisiblity(param: MainViewVisiblity?) {

    }


    /* private val uiScope = CoroutineScope(Dispatchers.Main )
      @BindingAdapter(value = ["setImageSync", "placeholder"], requireAll = false)
     fun setImageSync(
         imageView: ImageView,
         url: String?,
         drawable: Drawable,
     ) {
         uiScope.launch {
             imageView.setImageDrawable(drawable)
             Log.e("Url","url above "+url)
             try {
                 if (!url.isNullOrEmpty()) {
                     when {
                         url.startsWith("content://") -> {
                             imageView.setImageURI(Uri.parse(url))
                         }
                         else -> {

                             Log.e("Url","url before setting "+url)
                             //Glide.with(imageView.context).load(url).error(drawable).placeholder(drawable).into(imageView)
                             Glide.with(imageView.context)
                                 .load(url)
                                 .listener(object : RequestListener<Drawable?> {

                                     override fun onLoadFailed(
                                         @Nullable e: GlideException?,
                                         model: Any?,
                                         target: com.bumptech.glide.request.target.Target<Drawable?>?,
                                         isFirstResource: Boolean
                                     ): Boolean {
                                         // progressBar.setVisibility(View.GONE)
                                         return false
                                     }


                                     override fun onResourceReady(
                                         p0: Drawable?,
                                         p1: Any?,
                                         p2: com.bumptech.glide.request.target.Target<Drawable?>?,
                                         p3: com.bumptech.glide.load.DataSource?,
                                         p4: Boolean
                                     ): Boolean {
                                         return false
                                     }
                                 })
                                 .error(drawable).placeholder(drawable)
                                 .diskCacheStrategy(DiskCacheStrategy.NONE)
                                 .skipMemoryCache(true)
                                 .into(imageView)



                         }
                     }
                 } else {
                     imageView.setImageDrawable(drawable)
                 }
             } catch (e: Exception) {

             }
         }

     }*/

//        var options: RequestOptions = RequestOptions()
//            .centerCrop()
//            .priority(Priority.HIGH)
//
//
//        class GlideImageLoader(
//            private val mImageView: ImageView?,
//            private val mProgressBar: ProgressBar?
//        ) {
//            fun load(url: String?, options: RequestOptions?) {
//                if (url == null || options == null) return
//                onConnecting()
//
//                //set Listener & start
//                ProgressAppGlideModule.expect(url, object : ProgressAppGlideModule.UIonProgressListener {
//                    override fun onProgress(bytesRead: Long, expectedLength: Long) {
//                        if (mProgressBar != null) {
//                            mProgressBar.progress = (100 * bytesRead / expectedLength).toInt()
//                        }
//                    }
//
//                    override val granualityPercentage: Float
//                        get() = 1.0f
//                })
//                //Get Image
//                Glide.with(mImageView!!.context)
//                    .load(url)
//                    .transition(withCrossFade())
//                    .apply(options.skipMemoryCache(true))
//                    .listener(object : RequestListener<Drawable?> {
//                        override fun onLoadFailed(
//                            @Nullable e: GlideException?,
//                            model: Any?,
//                            target: Target<Drawable?>?,
//                            isFirstResource: Boolean
//                        ): Boolean {
//                            ProgressAppGlideModule.forget(url)
//                            onFinished()
//                            return false
//                        }
//
//                        fun onResourceReady(
//                            resource: Drawable?,
//                            model: Any?,
//                            target: Target<Drawable?>?,
//                            dataSource: DataSource?,
//                            isFirstResource: Boolean
//                        ): Boolean {
//                            ProgressAppGlideModule.forget(url)
//                            onFinished()
//                            return false
//                        }
//                    })
//                    .into(mImageView)
//            }
//
//            private fun onConnecting() {
//                if (mProgressBar != null) mProgressBar.visibility = View.VISIBLE
//            }
//
//            private fun onFinished() {
//                if (mProgressBar != null && mImageView != null) {
//                    mProgressBar.visibility = View.GONE
//                    mImageView.visibility = View.VISIBLE
//                }
//            }
//        }
   // }
    }
