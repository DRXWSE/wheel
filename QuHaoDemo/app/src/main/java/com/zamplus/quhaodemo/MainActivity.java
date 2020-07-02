package com.zamplus.quhaodemo;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zamplus.quhaodemo.Bean.UserEntity;
import com.zamplus.quhaodemo.Utils.QGridView;
import com.zamplus.quhaodemo.Utils.RequestCodeInfo;
import com.zamplus.quhaodemo.Utils.ToastUtil;
import com.zamplus.quhaodemo.adapter.CYBChangeCityGridViewAdapter;
import com.zamplus.quhaodemo.adapter.ContactAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableHeaderAdapter;
import me.yokeyword.indexablerv.IndexableLayout;


public class MainActivity extends AppCompatActivity {
    private ContactAdapter mAdapter;
    private BannerHeaderAdapter mBannerHeaderAdapter;
    private String[] city = {"东莞", "深圳", "广州", "温州", "郑州", "金华", "佛山", "上海", "苏州", "杭州", "长沙", "中山"};
    private IndexableLayout indexableLayout;
    private CYBChangeCityGridViewAdapter cybChangeCityGridViewAdapter;
    private ArrayList<String> list;
    private ImageView pic_contact_back;
    private Intent intent;
    private Button main_choose_city;
    private WindowManager.LayoutParams lp;
    private PopupWindow popupWindow;
    private View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        main_choose_city = findViewById(R.id.main_choose_city);
        main_choose_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivityForResult(new Intent(MainActivity.this,CityPickerActivity.class), RequestCodeInfo.GETCITY);

                initview();
                initAdapter();
                onlisten();

                initPopupWindow();
                showPopWindow();
            }
        });
    }


    private void initPopupWindow() {


        ImageView quxiao = contentView.findViewById(R.id.pic_contact_back);

        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        //popwindow退出时监听
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                lp = getWindow().getAttributes();
                lp.alpha = 1f; // 0.0-1.0
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp);
            }
        });

    }


    private void showPopWindow() {
        //设置popwindow，弹出后周围的透明度
        lp = getWindow().getAttributes();
        lp.alpha = 0.3f; // 0.0-1.0
        getWindow().setAttributes(lp);

        fitPopupWindowOverStatusBar(false);
        View rootview = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main,
                null);
        popupWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
    }

    public void fitPopupWindowOverStatusBar(boolean needFullScreen) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try { //利用反射重新设置mLayoutInScreen的值，当mLayoutInScreen为true时则PopupWindow覆盖全屏。
                Field mLayoutInScreen = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                mLayoutInScreen.setAccessible(true);
                mLayoutInScreen.set(popupWindow, needFullScreen);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case RequestCodeInfo.GETCITY:
                    String city = data.getExtras().getString("city");
                    if (city != null) {
                        System.out.println("ccccccctttttt" + city);
                        main_choose_city.setText(city);
                    }
                    break;
            }
        }
    }

    public void initAdapter() {
        mAdapter = new ContactAdapter(this);
        indexableLayout.setAdapter(mAdapter);
        indexableLayout.setOverlayStyle_Center();
        mAdapter.setDatas(initDatas());
//        indexableLayout.setOverlayStyle_MaterialDesign(Color.RED);
        // 全字母排序。  排序规则设置为：每个字母都会进行比较排序；速度较慢
        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST);
//        indexableLayout.addHeaderAdapter(new SimpleHeaderAdapter<>(mAdapter, "☆",null, null));

//         构造函数里3个参数,分别对应 (IndexBar的字母索引, IndexTitle, 数据源), 不想显示哪个就传null, 数据源传null时,代表add一个普通的View
//        mMenuHeaderAdapter = new MenuHeaderAdapter("↑", null, initMenuDatas());
//        indexableLayout.addHeaderAdapter(mMenuHeaderAdapter);

        // 这里BannerView只有一个Item, 添加一个长度为1的任意List作为第三个参数
        List<String> bannerList = new ArrayList<>();
        bannerList.add("");
        mBannerHeaderAdapter = new BannerHeaderAdapter("热门", null, bannerList);
        indexableLayout.addHeaderAdapter(mBannerHeaderAdapter);
    }

    public void initview() {
        intent = getIntent();
        //要在布局中显示的布局
        contentView = LayoutInflater.from(this).inflate(R.layout.dialog_pay_layout, null, false);
        //实例化PopupWindow并设置宽高
        popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, 1500);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //点击外部消失，这里因为PopupWindow填充了整个窗口，所以这句代码就没用了
        popupWindow.setOutsideTouchable(true); //设置可以点击
        popupWindow.setTouchable(true); //进入退出的动画
        popupWindow.setAnimationStyle(R.style.ActionSheetDialogStyle);

        pic_contact_back = contentView.findViewById(R.id.pic_contact_back);
        indexableLayout = contentView.findViewById(R.id.indexableLayout);
        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onlisten() {

        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<UserEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, UserEntity entity) {
                if (originalPosition >= 0) {
                    intent.putExtra("city", entity.getNick());
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    ToastUtil.showShort(MainActivity.this, "选中Header/Footer:" + entity.getNick() + "  当前位置:" + currentPosition);
                }
            }
        });
    }

    /**
     * 自定义的Banner Header
     */
    class BannerHeaderAdapter extends IndexableHeaderAdapter {
        private static final int TYPE = 1;

        public BannerHeaderAdapter(String index, String indexTitle, List datas) {
            super(index, indexTitle, datas);
        }

        @Override
        public int getItemViewType() {
            return TYPE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_city_header, parent, false);
            VH holder = new VH(view);
            return holder;
        }

        @Override
        public void onBindContentViewHolder(RecyclerView.ViewHolder holder, Object entity) {
            // 数据源为null时, 该方法不用实现
            final VH vh = (VH) holder;
            list = new ArrayList<>();
            for (int i = 0; i < city.length; i++) {
                list.add(city[i]);
            }
            System.out.println("------------city" + list);
            cybChangeCityGridViewAdapter = new CYBChangeCityGridViewAdapter(MainActivity.this, list);
            vh.head_home_change_city_gridview.setAdapter(cybChangeCityGridViewAdapter);
            vh.head_home_change_city_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    intent.putExtra("city", list.get(position));
                    System.out.println("aaaaaayyyyyyyyy" + list.get(position));
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
            vh.item_header_city_dw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("city", vh.item_header_city_dw.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

        }

        private class VH extends RecyclerView.ViewHolder {
            GridView head_home_change_city_gridview;
            TextView item_header_city_dw;

            public VH(View itemView) {
                super(itemView);
                head_home_change_city_gridview = (QGridView) itemView.findViewById(R.id.item_header_city_gridview);
                item_header_city_dw = itemView.findViewById(R.id.item_header_city_dw);
            }
        }
    }

    private List<UserEntity> initDatas() {
        List<UserEntity> list = new ArrayList<>();
        // 初始化数据
        List<String> contactStrings = Arrays.asList(getResources().getStringArray(R.array.provinces));
        List<String> mobileStrings = Arrays.asList(getResources().getStringArray(R.array.provinces));
        for (int i = 0; i < contactStrings.size(); i++) {
            UserEntity contactEntity = new UserEntity(contactStrings.get(i), mobileStrings.get(i));
            list.add(contactEntity);
        }
        return list;
    }
}
