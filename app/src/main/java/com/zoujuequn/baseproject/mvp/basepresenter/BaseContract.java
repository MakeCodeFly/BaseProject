package com.zoujuequn.baseproject.mvp.basepresenter;



/**
 * MVP模式中公共的基本契约
 *
 * @version 1.0.0
 */
public interface BaseContract {
    // 基本的界面职责
    interface View<T extends Presenter> {
        // 公共的：显示一个字符串错误
        void showError(String str);

        // 公共的：显示进度条
        void showLoading();

        // 支持设置一个Presenter
        void setPresenter(T presenter);
    }

    // 基本的Presenter职责
    interface Presenter {
     /*   // 共用的开始触发
        void start();

        // 共用的销毁触发
        void destroy();*/
    }



}
