package net.lzzy.kirinfm.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

/**
 * @author lzzy_gxy
 * @date 2019/3/27
 * Description:
 */
public abstract class BaseFragment extends Fragment {
    public BaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        populate();
    }

    /**
     * 执行onCreateView中初始化视图组件、填充数据任务
     */
    protected abstract void populate();

    /**
     * 获取视图组件
     */
    public abstract int getLayoutRes();

    /**
     * 获取视图组件id
     */
    <T extends View> T find(int id) {
        return Objects.requireNonNull(getView()).findViewById(id);
    }

    public abstract void search(String kw);

}
