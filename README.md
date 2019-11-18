# LoadingButton
# 自定义加载按钮
[![](https://jitpack.io/v/zhuoCreator/LoadingButton.svg)](https://jitpack.io/#zhuoCreator/LoadingButton)



Step 1. Add the JitPack repository to your build file
```
 allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' } 
    }
}

```

Step 2. Add the dependency

   
```
     implementation 'com.github.zhuoCreator:LoadingButton:v1.0.0'
```


# 效果图
![](https://github.com/zhuoCreator/LoadingButton/blob/master/app/src/main/res/drawable/GIF.gif)  


# 使用方法
1.在XML下添加 LoadingButton
```

<com.zhuoCreator.loadingbutton.LoadingButton
        android:id="@+id/loadingButton"
        android:layout_width="300dp"
        android:layout_height="40dp"
        app:LoadingButton_drawableLeft="@drawable/lj"
        app:LoadingButton_drawablePadding="10dp"
        app:LoadingButton_text="@string/app_name"
        app:LoadingButton_textColor="@color/colorPrimaryDark"
        app:LoadingButton_textSize="18sp" />

```


2.代码示例
```
 @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loadingButton){
            toast("正在加载中，不可点击");
            mLoadingButton.startLoading();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLoadingButton.stopLoading();
                    toast("加载完成，可以点击");
                }
            },3000);
        }
    }

```




# 支持的属性
```
 <attr name="LoadingButton_text" format="string"></attr>                    文本内容默认无（必填）
 <attr name="LoadingButton_textColor" format="color"></attr>                字体颜色默认白色
 <attr name="LoadingButton_textSize" format="dimension"></attr>             字体大小默认14sp
 <attr name="LoadingButton_background" format="reference"></attr>           按钮背景默认gradient_btn_shape
 <attr name="LoadingButton_drawableLeft" format="reference"></attr>         按钮文本左边图默认无
 <attr name="LoadingButton_drawablePadding" format="dimension"></attr>      按钮文本与图片的距离默认0

```
