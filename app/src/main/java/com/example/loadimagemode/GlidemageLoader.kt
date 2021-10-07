package com.example.loadimagemode

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView

import com.bumptech.glide.load.engine.GlideException

import com.bumptech.glide.request.RequestListener

import com.bumptech.glide.Glide

import com.bumptech.glide.request.RequestOptions

import android.widget.ProgressBar
import com.bumptech.glide.request.target.Target


class GlideImageLoader(imageView: ImageView?, progressBar: ProgressBar?,listener: RecyclerAdapter.LoadChanged?,position:Int?) {
    private val mImageView: ImageView?
    private val mProgressBar: ProgressBar?
    private val mlistener: RecyclerAdapter.LoadChanged?
    private val mposition:Int?
    fun load(url: String?, options: RequestOptions?) {
        if (url == null || options == null) return
        onConnecting()

        //set Listener & start
        ProgressAppGlideMod.expect(url, object : ProgressAppGlideMod.UIonProgressListener {
            override fun onProgress(bytesRead: Long, expectedLength: Long) {
                if (mProgressBar != null) {
                    mProgressBar.progress = (100 * bytesRead / expectedLength).toInt()
                }
            }

            override val granualityPercentage: Float
                get() = 1.0f
        })
          //  .transition(withCrossFade())
        //Get Image
        mImageView?.let {
            Glide.with(it?.getContext())
                .load(url)

                .apply(options.skipMemoryCache(true))
                .listener(object : RequestListener<Drawable?> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable?>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        ProgressAppGlideMod.forget(url)
                        onFinished()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable?>?,
                        dataSource: com.bumptech.glide.load.DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        ProgressAppGlideMod.forget(url)
                        onFinished()
                        return false
                    }
                    /*  override fun onLoadFailed(
                              @Nullable e: GlideException?,
                              model: Any?,
                              target: Target<Drawable>?,
                              isFirstResource: Boolean
                          ): Boolean {
                              ProgressAppGlideModule.forget(url)
                              onFinished()
                              return false
                          }

                          override fun onResourceReady(
                              resource: Drawable?,
                              model: Any?,
                              target: com.bumptech.glide.request.target.Target<Drawable?>?,
                              dataSource: com.bumptech.glide.load.DataSource?,
                              isFirstResource: Boolean
                          ): Boolean {
                              ProgressAppGlideModule.forget(url)
                              onFinished()
                              return false
                          }*/
                })
                .into(mImageView)
        }
    }

    private fun onConnecting() {
        if (mProgressBar != null) mProgressBar.visibility = View.VISIBLE
    }

    private fun onFinished() {
        if (mProgressBar != null && mImageView != null) {
            mProgressBar.visibility = View.GONE
            mImageView.setVisibility(View.VISIBLE)
            mposition?.let { mlistener?.Sucess(true, it,null) }
        }

    }

    init {
        mImageView = imageView
        mProgressBar = progressBar
        mlistener=listener
        mposition=position
    }
}