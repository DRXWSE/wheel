package com.zamplus.stringarrayindexof;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex Yin
 * 日期: 2020/4/13
 * 时间: 10:39
 * 邮箱：yindechao2015@163.com
 * 该类作用：
 */
public class Utils {
    private String[] shenTiZhuangKuang = new String[]{"健康", "良好", "一般"};
    private String[] xueXing = new String[]{"A型", "B型", "AB型", "O型", "其他"};
    private String[] xueLi = new String[]{"初中及以下", "高中及中专", "本科及大专", "研究生及以上"};
    private String[] zhiYe = new String[]{"机关及事业单位工作者", "企业高级职员", "职工", "专业人员", "学生", "私营业主", "自由职业者", "无业", "退休", "其他"};
    private String[] hangYe = new String[]{"机构组织", "农林牧渔", "医药卫生", "建筑建材", "冶金矿产", "石油化工", "水利水电", "交通运输", "信息产业", "机械机电", "轻工食品", "服装纺织", "专业服务", "安全防护", "环保绿化", "旅游休闲", "办公文教", "电子电工", "玩具礼品", "家具用品", "物资", "包装", "体育", "办公", "其他"};
    private String[] nianXin = new String[]{"1-5万", "6-10万", "11-20万", "20-50万", "50-100万", "100万以上"};
    private String[] paoBuNianShu = new String[]{"1年及以内", "2-3年", "4-6年", "7-10年", "10年以上"};

    private String[] chuanZhuoPaoXiePinPai = new String[]{"NIKE", "Adidas", "Asics", "Mizuno", "New Balance", "PUMA", "LI-NING", "Saucony", "Brooks", "Do-win", "Kalenji", "personarchives.shoesbrand12", "斯凯奇 Skechers", "其他"};
    private String[] chuanZhuoYunDongFuZhuang = new String[]{"NIKE", "Adidas", "Asics", "Mizuno", "New Balance", "PUMA", "LI-NING", "Do-win", "Kalenji", "CW-X", "Skins", "Under Armou", "斯凯奇 Skechers", "其他"};
    private String[] yunDongShouBiaoPinPai = new String[]{"佳明", "阿尔法", "松拓", "迪卡侬", "百锐腾", "西格玛", "其他"};

    private String[] zuiAiHeDeYunDongYinLiao = new String[]{"佳得乐", "personarchives.drBrand2", "脉动", "宝矿力", "红牛", "超级维体", "日加满", "启力", "酷乐仕", "维他命", "维体", "魔力氨基酸", "其他"};
    private String[] shiYongDePaoBuApp = new String[]
            {"NIKE RUNNING", "Micoach", "Runtastic", "Endomondo", "佳明", "郁金香运动", "去动", "动动", "乐动力", "戈壁之眼", "悦跑圈", "行者", "其他"};

    //多选
    private boolean[] paoxie_checkedItems = new boolean[14];//跑鞋
    private boolean[] fuzhuang_checkedItems = new boolean[14];//服装
    private boolean[] shoubiao_checkedItems = new boolean[7];//手表
    private boolean[] yinliao_checkedItems = new boolean[13];//运动饮料
    private boolean[] app_checkedItems = new boolean[13];//使用的跑步app


    public void ArrayToList(){
        List<String> shentizhuangkuang = Arrays.asList(shenTiZhuangKuang);
        List<String> xuexing = Arrays.asList(xueXing);
        List<String> xueli = Arrays.asList(xueLi);
        List<String> zhiye = Arrays.asList(zhiYe);
        List<String> hangye = Arrays.asList(hangYe);
        List<String> nianxin = Arrays.asList(nianXin);
        List<String> paobunianshu = Arrays.asList(paoBuNianShu);
        List<String> chuanzhuopaoxiepinpai = Arrays.asList(chuanZhuoPaoXiePinPai);
        List<String> chuanzhuoyundongfuzhuang = Arrays.asList(chuanZhuoYunDongFuZhuang);
        List<String> yundongshoubiaopinpai = Arrays.asList(yunDongShouBiaoPinPai);
        List<String> zuihaihedeyundongyinliao = Arrays.asList(zuiAiHeDeYunDongYinLiao);
        List<String> shiyongdepaobuapp = Arrays.asList(shiYongDePaoBuApp);
    }


}
