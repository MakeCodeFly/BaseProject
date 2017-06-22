package com.zoujuequn.baseproject.mvp.contract;


import com.zoujuequn.baseproject.base.BasePresenter;
import com.zoujuequn.baseproject.base.BaseView;

/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : 事例Contract
 *     email:15695947865@139.com
 * </pre>
 */

public interface ExampleContract {

    interface View extends BaseView<Presenter> {
        void onExampleSuccess();
    }

    interface Presenter extends BasePresenter {
        void doExample();
    }
}
