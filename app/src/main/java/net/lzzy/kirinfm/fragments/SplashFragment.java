package net.lzzy.kirinfm.fragments;

import android.content.Context;
import android.view.View;

import net.lzzy.kirinfm.R;

import java.util.Calendar;

/**
 * @author lzzy_gxy on 2019/5/31.
 * Description:
 */
public class SplashFragment extends BaseFragment {
    private int[] imgs = new int[]{R.drawable.splash1, R.drawable.splash2, R.drawable.splash3};
    private OnSpalshFinishedListener listener;

    @Override
    protected void populate() {
        View wall = find(R.id.fragment_splash_wall);
        int pos = Calendar.getInstance().get(Calendar.SECOND) % 3;
        wall.setBackgroundResource(imgs[pos]);
        wall.setOnClickListener(v -> listener.cancelCount());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_splash;
    }

    @Override
    public void search(String kw) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnSpalshFinishedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "必须实现OnCinemaSelectedListener接口");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnSpalshFinishedListener {
        void cancelCount();
    }
}
