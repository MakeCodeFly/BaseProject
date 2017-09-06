package com.zoujuequn.baseproject.mvp.basepresenter;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : MVP模式中公共的基本契约
 *     email:15695947865@139.com
 * </pre>
 */
public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {
    private T mView;

    public BasePresenter(T view) {
        setView(view);
    }

    /**
     * 设置一个View，子类可以复写
     */
    @SuppressWarnings("unchecked")
    protected void setView(T view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    /**
     * 给子类使用的获取View的操作
     * 不允许复写
     *
     * @return View
     */
    protected final T getView() {
        return mView;
    }


}
