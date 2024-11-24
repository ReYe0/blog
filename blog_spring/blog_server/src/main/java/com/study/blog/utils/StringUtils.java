package com.study.blog.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 封装字符串的工具
 */
public class StringUtils {
    /**
     * 获取字符串中的 链接数组
     * @param str
     * @return
     */
    public static List<String> getUrls(String str) {
        Pattern pattern = Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
//        String a = "[{\"element\":\"lbtEl\",\"name\":\"轮播图\",\"icon\":\"el-icon-data-board\",\"attribute\":{\"marginTop\":0,\"marginBottom\":0,\"marginLeft\":0,\"marginRight\":0,\"imageList\":[{\"name\":\"image\",\"url\":\"https://paiqi-1.oss-cn-beijing.aliyuncs.com/paiqi/20220512/d5b886c221f64c15ae96632d41ca1bda.jpg\",\"height\":800,\"width\":750,\"uid\":1652326171322,\"status\":\"success\"},{\"name\":\"image\",\"url\":\"https://paiqi-1.oss-cn-beijing.aliyuncs.com/paiqi/20220512/5e82ceaad5444b1d8f315fce840d9035.jpg\",\"height\":800,\"width\":750,\"uid\":1652326180600,\"status\":\"success\"}],\"Time\":3}},{\"element\":\"imageEl\",\"name\":\"图片\",\"icon\":\"el-icon-picture-outline\",\"attribute\":{\"marginTop\":0,\"marginBottom\":0,\"marginLeft\":0,\"marginRight\":0,\"image\":\"https://paiqi-1.oss-cn-beijing.aliyuncs.com/paiqi/20220512/c40ec60a89ce4c48b6972ac43e470c09.jpg\"}},{\"element\":\"videoEl\",\"name\":\"视频\",\"icon\":\"el-icon-video-camera\",\"attribute\":{\"marginTop\":0,\"marginBottom\":0,\"marginLeft\":0,\"marginRight\":0,\"video\":\"https://paiqi-1.oss-cn-beijing.aliyuncs.com/paiqi/20220512/fbe7fc1335bd4dc7b8bca6c2693b5200.mp4\"}},{\"element\":\"textEl\",\"name\":\"文本\",\"icon\":\"el-icon-edit\",\"attribute\":{\"marginTop\":0,\"marginBottom\":0,\"marginLeft\":0,\"marginRight\":0,\"content\":\"内容\"}},{\"element\":\"linkEl\",\"name\":\"分割线\",\"icon\":\"el-icon-tickets\",\"attribute\":{\"marginTop\":25,\"marginBottom\":25,\"marginLeft\":0,\"marginRight\":0,\"borderStyle\":\"solid\",\"borderWidth\":1,\"borderColor\":\"#000\",\"width\":100}},{\"element\":\"phoneEl\",\"name\":\"电话\",\"icon\":\"el-icon-phone-outline\",\"attribute\":{\"fontSize\":14,\"color\":\"#fff\",\"background\":\"#07C160\",\"content\":\"拨打电话\",\"btnWeight\":\"normal\",\"phone\":\"13332333333\"}},{\"element\":\"shopCardEl\",\"name\":\"商家名片\",\"icon\":\"el-icon-wallet\",\"attribute\":{\"name\":\"测试地址\",\"address\":\"四川国际大厦\",\"phone\":\"14444444444\",\"lat\":30.66068,\"lng\":104.071519,\"marginTop\":0,\"marginBottom\":0,\"marginLeft\":80,\"marginRight\":0}},{\"element\":\"noticeEl\",\"name\":\"公告\",\"icon\":\"el-icon-takeaway-box\",\"attribute\":{\"direction\":\"left\",\"scrollamount\":3,\"marginTop\":0,\"marginBottom\":0,\"marginLeft\":0,\"marginRight\":0,\"color\":\"#000\",\"content\":\"公告的格式变化就是不回家的说不定还巴适得很不合适的\"}}]";
        Matcher matcher = pattern.matcher(str);
        List<String> urlArr = new ArrayList<>();
        while (matcher.find()) {
            urlArr.add(matcher.group());
        }
        return urlArr;
    }
}
