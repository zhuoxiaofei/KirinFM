package net.lzzy.kirinfm.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import net.lzzy.kirinfm.utils.AppUtils;


/**
 * @author lzzy_gxy
 * @date 2019/4/11
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Fragment fragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutRes());
        AppUtils.addActivity(this);
        manager = getSupportFragmentManager();
        fragment = manager.findFragmentById(getContainerId());
        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction().add(getContainerId(), fragment).commit();
        }
    }

    protected Fragment getFragment() {
        return fragment;
    }

    protected FragmentManager getManager() {
        return manager;
    }

    /**
     * 获取视图组件
     *
     * @return
     */
    protected abstract int getLayoutRes();

    /**
     * 获取容器id
     *
     * @return
     */
    protected abstract int getContainerId();

    /**
     * 生成托管的fragment对象
     *
     * @return
     */
    protected abstract Fragment createFragment();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppUtils.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppUtils.setRunning(getLocalClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppUtils.setStopped(getLocalClassName());
    }
}
