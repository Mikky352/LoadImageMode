package com.example.loadimagemode

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
/*import com.squareup.okhttp.Interceptor
import com.squareup.okhttp.OkHttpClient*/
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import android.R
import android.widget.ProgressBar
import com.bumptech.glide.Priority

import com.bumptech.glide.request.RequestOptions





class BindingAdapter {
    object Binder{
       /* var mOkHttpClient = OkHttpClient()*/

        private val uiScope = CoroutineScope(Dispatchers.Main)

        @JvmStatic@BindingAdapter(value = ["setImageAsync", "placeholder","listener","position","progressBar"], requireAll = false)
        fun setImageAsync(
            imageView: ImageView?,
            url: String?,
            drawable: Drawable?,
            listener: RecyclerAdapter.LoadChanged?,
           position: Int?,
            progressBar:ProgressBar?
        ) {
            /*mOkHttpClient.networkInterceptors().add(Interceptor { chain ->
                val originalResponse = chain.proceed(chain.request())
                originalResponse.newBuilder()
                    .body(
                        FragmentAsyncViewModel.BindingAdapters.ProgressResponseBody(
                            originalResponse.body(),
                            FragmentAsyncViewModel.BindingAdapters.progressListener
                        )
                    )
                    .build()
            })*/


            var options: RequestOptions? = RequestOptions()
                .centerCrop()
                .placeholder(drawable)
                .error(drawable)
                .priority(Priority.HIGH)
            uiScope.launch {

                async {
                    Log.e("Url", "url above " + url)
                    //imageView?.setImageDrawable(drawable)
                    try {
                        if (!url.isNullOrEmpty()) {
                            when {
                                url.startsWith("content://") -> {
                                    imageView?.setImageURI(Uri.parse(url))
                                }
                                else -> {
                                    Log.e("Url", "url before setting " + url)

                                       GlideImageLoader(imageView,progressBar,listener,position).load(url,options)

                                   /* imageView?.let {
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
                                                    Log.e("valueChange", "positon l" + position+"  "+listener)
                                                   *//* position?.let { it1 ->
                                                        listener?.Sucess(true,
                                                            it1
                                                        )
                                                    }*//*

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
                                                    // listener.Sucess(true,position)
                                                    Log.e("valueChange", "positon r" + position+"  "+listener)
                                                    position?.let { it1 ->
                                                        drawable?.let { it2 ->
                                                            listener?.Sucess(true,
                                                                it1,
                                                                it2
                                                            )
                                                        }
                                                        imageView.setImageDrawable(resource)
                                                    }
                                                    return false
                                                }
                                            })

                                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                                            .skipMemoryCache(true)
                                            .into(it)
                                           // .error(drawable)
                                           // .placeholder(drawable)
                                    }*/
                                    //Glide.get(imageView.context).
                                    //Glide.get(imageView.context).register(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(mOkHttpClient))
                                    // Glide.with(imageView.context).load(url).error(drawable).placeholder(drawable).into(imageView)


                                }
                            }
                        } else {
                            imageView?.setImageDrawable(drawable)
                        }
                    } catch (e: Exception) {

                    }
                }
            }

        }


        @JvmStatic
        @BindingAdapter(value = ["setImageSync", "placeholder","listener","position","progressBar"], requireAll = false)
        fun setImageSync(
            imageView: ImageView?,
            url: String?,
            drawable: Drawable?,
            listener: RecyclerAdapter.LoadChanged?,
            position: Int?,
            progressBar: ProgressBar?
        ) {

            var options: RequestOptions? = RequestOptions()
                .centerCrop()
                .placeholder(drawable)
                .error(drawable)
                .priority(Priority.HIGH)

            uiScope.launch {
                //imageView?.setImageDrawable(drawable)
                Log.e("Url","url above "+url)
                try {
                    if (!url.isNullOrEmpty()) {
                        when {
                            url.startsWith("content://") -> {
                                imageView?.setImageURI(Uri.parse(url))
                            }
                            else -> {

                                Log.e("Url","url before setting "+url)


                                GlideImageLoader(imageView,progressBar,listener,position).load(url,options)


                                //Glide.with(imageView.context).load(url).error(drawable).placeholder(drawable).into(imageView)
                               /* imageView?.let {
                                    //if (position!! < 4) {
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
                                                    //listener.Sucess(true,position)
                                                    Log.e(
                                                        "valueChange",
                                                        "positon l" + position + "  " + listener
                                                    )
                                                    *//* position?.let { it1 ->
                                                    listener?.Sucess(true,
                                                        it1
                                                    )
                                                }*//*
                                                    return false
                                                }


                                                override fun onResourceReady(
                                                    p0: Drawable?,
                                                    p1: Any?,
                                                    p2: com.bumptech.glide.request.target.Target<Drawable?>?,
                                                    p3: com.bumptech.glide.load.DataSource?,
                                                    p4: Boolean
                                                ): Boolean {
                                                    Log.e(
                                                        "valueChange",
                                                        "positon r" + position + "  " + listener
                                                    )
                                                    position?.let { it1 ->
                                                        p0?.let { it2 ->
                                                            listener?.Sucess(
                                                                true,
                                                                it1,
                                                                it2
                                                            )
                                                        }
                                                        imageView.setImageDrawable(p0)
                                                    }
                                                    return false
                                                }
                                            })
                                            .error(drawable)
                                            .placeholder(drawable)
                                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                                            .skipMemoryCache(true)
                                            .into(it)


                                  //  }
                                    }*/




                            }
                        }
                    } else {
                        imageView?.setImageDrawable(drawable)
                    }
                } catch (e: Exception) {

                }
            }

        }

       @JvmStatic @BindingAdapter(value = ["setRecyclerAdapter"], requireAll = false)
        fun setRecyclerAdapter(
            recyclerView: RecyclerView,
            adapter: RecyclerView.Adapter<*>
        ) {
            recyclerView.adapter = adapter
        }



    }
}