package com.example.easyframe.toolmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.easyframe.R;

import java.io.File;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EasyGlideUtils {

    /**
     * 获取当前默认的配置
     *
     * @return
     */
    public static RequestOptions getDefaultOptions(int loadimg,int errorimg) {
        return new RequestOptions().centerCrop().placeholder(loadimg).error(errorimg);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param url     http头地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, String url, ImageView into,int loadimg,int error) {
        load(context, url, into, getDefaultOptions(loadimg,error));

    }

    /**
     * 加载图片
     *
     * @param context
     * @param url     http头地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, String url, ImageView into, RequestOptions requestOptions) {
        Glide.with(context).load(url).apply(requestOptions).transition(withCrossFade()).into(into);
    }


    /**
     * 加载自定义 View 背景
     *
     * @param context
     * @param url
     * @param into
     */
    public static void loadView(Context context, final String url, final View into,int loadimg,int errimg) {
        Glide.with(context).load(url).apply(getDefaultOptions(loadimg,errimg)).transition(withCrossFade()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                into.setBackground(resource);
            }
        });


    }


    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param url      http头地址
     * @param into     需要加载的View
     */
    public static void load(Fragment fragment, String url, ImageView into,int loadimg,int errimg) {
        load(fragment, url, into, getDefaultOptions(loadimg,errimg));
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param url      http头地址
     * @param into     需要加载的View
     */
    public static void load(Fragment fragment, String url, ImageView into, RequestOptions requestOptions) {
        Glide.with(fragment).load(url).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param file    图片文件
     * @param into    需要加载图片的View
     */
    public static void load(Context context, File file, ImageView into,int loadimg,int errimg) {
        load(context, file, into, getDefaultOptions(loadimg,errimg));
    }

    /**
     * 加载图片
     *
     * @param context
     * @param file    图片文件
     * @param into    需要加载图片的View
     */
    public static void load(Context context, File file, ImageView into, RequestOptions requestOptions) {
        Glide.with(context).load(file).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param file     图片文件
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, File file, ImageView into,int loadimg,int errimg) {
        load(fragment, file, into, getDefaultOptions(loadimg,errimg));
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param file     图片文件
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, File file, ImageView into, RequestOptions requestOptions) {
        Glide.with(fragment).load(file).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param uri     Uri地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, Uri uri, ImageView into,int loadimg,int errimg) {
        load(context, uri, into, getDefaultOptions(loadimg,errimg));
    }

    /**
     * 加载图片
     *
     * @param context
     * @param uri     Uri地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, Uri uri, ImageView into, RequestOptions requestOptions) {
        Glide.with(context).load(uri).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param uri      Uri地址
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, Uri uri, ImageView into,int loadimg,int errimg) {
        load(fragment, uri, into, getDefaultOptions(loadimg,errimg));
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param uri      Uri地址
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, Uri uri, ImageView into, RequestOptions requestOptions) {
        Glide.with(fragment).load(uri).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    public static void load(Context context, int resId, ImageView imageView,int loadimg,int errimg) {
        Glide.with(context).load(resId).apply(getDefaultOptions(loadimg,errimg)).into(imageView);
    }

    public static void load(Context context, String url, int width, int height, final ImageView imageView,int loadimg,int errimg) {
        Glide.with(context).load(url).apply(getDefaultOptions(loadimg,errimg)).into(new SimpleTarget<Drawable>(width, height) {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                imageView.setImageDrawable(resource);
            }
        });
    }

    public static void load(Context context, Uri uri, int width, int height, final ImageView imageView,int loadimg,int errimg) {
        Glide.with(context).load(uri).apply(getDefaultOptions(loadimg,errimg)).into(new SimpleTarget<Drawable>(width, height) {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                imageView.setImageDrawable(resource);
            }
        });
    }
}
