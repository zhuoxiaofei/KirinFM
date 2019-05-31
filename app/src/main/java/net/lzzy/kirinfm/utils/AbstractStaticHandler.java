package net.lzzy.kirinfm.utils;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * @author lzzy_gxy
 * @date 2019/4/12
 * Description:
 */
public abstract class AbstractStaticHandler<T> extends Handler {
    private final WeakReference<T> context;

    public AbstractStaticHandler(T context) {
        this.context = new WeakReference<>(context);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        T t = context.get();
        handleMessage(msg, t);
    }

    /**
     * 处理消息的业务逻辑
     *
     * @param msg
     * @param t
     */
    public abstract void handleMessage(Message msg, T t);
}
