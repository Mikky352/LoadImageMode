package com.example.loadimagemode


    public interface ProgressListener {
        fun update(bytesRead: Long, contentLength: Long, done: Boolean)
    }