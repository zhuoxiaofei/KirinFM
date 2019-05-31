package net.lzzy.kirinfm.constants;

import net.lzzy.kirinfm.R;
import net.lzzy.kirinfm.utils.AppUtils;

import net.lzzy.sqllib.DbPackager;

/**
 * @author lzzy_gxy
 * @date 2019/3/11
 * Description:
 */
public final class DbConstants {
    private DbConstants() {
    }

    /**
     * 数据库名称
     */
    private static final String DB_NAME = "practices.db";
    /**
     * 版本号
     */
    private static final int DB_VERSION = 1;
    /**
     * 打包数据库信息
     */
    public static DbPackager packager;

    static {
        packager = DbPackager.getInstance(AppUtils.getContext()
                , DB_NAME, DB_VERSION, R.raw.models);
    }
}
