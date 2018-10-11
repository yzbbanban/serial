package com.yzb.serial.activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzb.serial.R;
import com.yzb.serial.adapter.GridViewAdapter;
import com.yzb.serial.app.SerialApplication;
import com.yzb.serial.entity.ApiInfo;
import com.yzb.serial.entity.Bucket;
import com.yzb.serial.model.ICallBack;
import com.yzb.serial.model.SendOperaModel;
import com.yzb.serial.model.SharedPreModel;
import com.yzb.serial.ui.CleanEditText;
import com.yzb.serial.util.StringUtil;
import com.yzb.serial.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements ICallBack {

    private static final String TAG = "MainActivity";


    @BindView(R.id.gv_bucket1)
    GridView gvBucket1;
    @BindView(R.id.gv_bucket2)
    GridView gvBucket2;
    @BindView(R.id.gv_bucket3)
    GridView gvBucket3;
    @BindView(R.id.gv_bucket4)
    GridView gvBucket4;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.bac)
    LinearLayout bac;


    private List<Bucket> dataList1;
    private List<Bucket> dataList2;
    private List<Bucket> dataList3;
    private List<Bucket> dataList4;

    private GridViewAdapter adapter1;
    private GridViewAdapter adapter2;
    private GridViewAdapter adapter3;
    private GridViewAdapter adapter4;

    private AlertDialog.Builder builder;

    private AlertDialog alertDialog;

    private SendOperaModel sendOperaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initData();
        initView();

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        tv_center.setText("对料管理系统");
        tv_right.setText("设置");
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUrl();
            }
        });
    }

    @Override
    protected void initData() {
        dataList1 = new ArrayList<>();
        dataList2 = new ArrayList<>();
        dataList3 = new ArrayList<>();
        dataList4 = new ArrayList<>();
        for (int i = 0; i < 32; i++) {

            Bucket bucket = new Bucket();
            String name = "";
            if (i < 9) {
                name = "P0" + (i + 1);
            } else {
                name = "P" + (i + 1);
            }
            bucket.setId(i + 1);
            bucket.setIdName(name);
            bucket.setExplain(name);
            bucket.setUpdateTime(System.currentTimeMillis() / 1000);
            bucket.setStatus(0);
            if (i < 8) {
                dataList1.add(bucket);
            } else if (i >= 8 && i < 16) {
                dataList2.add(bucket);
            } else if (i >= 16 && i < 24) {
                dataList3.add(bucket);
            } else {
                dataList4.add(bucket);
            }
        }
        sendOperaModel = new SendOperaModel();
    }

    @OnClick(R.id.btn_1)
    public void setBtn1() {
        gvBucket1.setVisibility(View.VISIBLE);
        gvBucket2.setVisibility(View.GONE);
        gvBucket3.setVisibility(View.GONE);
        gvBucket4.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_2)
    public void setBtn2() {
        gvBucket1.setVisibility(View.GONE);
        gvBucket2.setVisibility(View.VISIBLE);
        gvBucket3.setVisibility(View.GONE);
        gvBucket4.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_3)
    public void setBtn3() {
        gvBucket1.setVisibility(View.GONE);
        gvBucket2.setVisibility(View.GONE);
        gvBucket3.setVisibility(View.VISIBLE);
        gvBucket4.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_4)
    public void setBtn4() {
        gvBucket1.setVisibility(View.GONE);
        gvBucket2.setVisibility(View.GONE);
        gvBucket3.setVisibility(View.GONE);
        gvBucket4.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initView() {
        adapter1 = new GridViewAdapter(this, dataList1);
        adapter2 = new GridViewAdapter(this, dataList2);
        adapter3 = new GridViewAdapter(this, dataList3);
        adapter4 = new GridViewAdapter(this, dataList4);

        gvBucket1.setAdapter(adapter1);

        gvBucket1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long arg3) {
                Bucket bucket = dataList1.get(position);

                invokeBucket(bucket);
            }
        });

        gvBucket2.setAdapter(adapter2);

        gvBucket2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long arg3) {
                Bucket bucket = dataList2.get(position);
                invokeBucket(bucket);
            }
        });

        gvBucket3.setAdapter(adapter3);

        gvBucket3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long arg3) {
                Bucket bucket = dataList3.get(position);
                invokeBucket(bucket);
            }
        });

        gvBucket4.setAdapter(adapter4);

        gvBucket4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long arg3) {
                Bucket bucket = dataList4.get(position);
                invokeBucket(bucket);
            }
        });
    }

    /**
     * 设置接口参数
     */
    private void setUrl() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v = getLayoutInflater().inflate(R.layout.edit_url_dialog, null);
        builder.setView(v);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Button btnAdd = v.findViewById(R.id.btn_dialog_add);
        Button btnCancel = v.findViewById(R.id.btn_dialog_cancel);
        ImageButton ibtnClose = v.findViewById(R.id.ibtn_dialog_close);
        final EditText etDialogIp = v.findViewById(R.id.et_dialog_ip);

        ApiInfo apiInfo = SharedPreModel.getAPiSp(this);
        if (StringUtil.isNotBlank(apiInfo.getIp())) {
            etDialogIp.setText(apiInfo.getIp());
        }

        //添加或更新
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ToastUtil.showShortToast("Add");
                String ip = etDialogIp.getText().toString().trim();
                if ("".equals(ip)) {
                    ToastUtil.showShortToast("请输入");
                } else {
                    SerialApplication.URL = "http://" + ip + ":8888/app/";
                    Log.i(TAG, "onClick: " + SerialApplication.URL);
                    SharedPreModel.saveApiSp(MainActivity.this, ip);
                    alertDialog.dismiss();
                }

            }
        });
        //取消
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showShortToast("Cancel");
                alertDialog.dismiss();
            }
        });
        ibtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    /**
     * 比对开锁
     */
    private void invokeBucket(final Bucket bucket) {
        builder = new AlertDialog.Builder(this);
        View v = getLayoutInflater().inflate(R.layout.edit_bucket_dialog, null);
        builder.setView(v);
        alertDialog = builder.create();
        alertDialog.show();
        Button btnAdd = v.findViewById(R.id.btn_dialog_add);
        Button btnCancel = v.findViewById(R.id.btn_dialog_cancel);
        Button btnOk = v.findViewById(R.id.btn_dialog_ok);
        ImageButton ibtnClose = v.findViewById(R.id.ibtn_dialog_close);
        final TextView etDialogIdName = v.findViewById(R.id.tv_dialog_id_name);
        final CleanEditText etDialogName = v.findViewById(R.id.et_dialog_name);
        if (StringUtil.isNotBlank(bucket.getIdName())) {
            etDialogIdName.setText(bucket.getIdName());
        }

        //比对
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ToastUtil.showShortToast("Add");
                String name = etDialogName.getText().toString().trim();
                if ("".equals(name)) {
                    ToastUtil.showShortToast("请输入");
                } else {
                    //比对
                    bucket.setName(name);

                    ApiInfo apiInfo = SharedPreModel.getAPiSp(MainActivity.this);
                    if (StringUtil.isNotBlank(apiInfo.getIp())) {
                        SerialApplication.URL = "http://" + apiInfo.getIp() + ":8888/app/";
                    } else {
                        ToastUtil.showLongToast("请先设置 ip");
                        alertDialog.dismiss();
                    }
                    ToastUtil.showLongToastTop("比对中");
                    sendOperaModel.compare(bucket, MainActivity.this);
                }

            }
        });
        //关锁
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = SerialApplication.LOCK_STATUS;
                if (status == 0) {
                    ToastUtil.showLongToast("请先比对！！！");
                } else {
                    ToastUtil.showShortToast("关锁中。。。");
                    bucket.setStatus(0);
                    sendOperaModel.send(bucket, MainActivity.this);
                }

            }
        });

        //开锁
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = SerialApplication.LOCK_STATUS;
                if (status == 0) {
                    ToastUtil.showLongToast("请先比对！！！");
                } else {
                    ToastUtil.showShortToast("开锁中。。。");
                    bucket.setStatus(1);
                    sendOperaModel.send(bucket, MainActivity.this);
                }

            }
        });

        ibtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }


    @Override
    public void setSuccess(Object message) {
        String msg = String.valueOf(message);

        if ("3".equals(msg)) {
            //比对成功
            ToastUtil.showLongToastTop("比对成功");
            SerialApplication.LOCK_STATUS = 1;

        } else if ("1".equals(msg)) {
            //开锁
            ToastUtil.showLongToastTop("开锁成功");
            alertDialog.dismiss();
            SerialApplication.LOCK_STATUS = 0;

        } else {
            ToastUtil.showLongToastTop("关锁成功");
            alertDialog.dismiss();
            SerialApplication.LOCK_STATUS = 0;
        }
    }

    @Override
    public void setFailure(Object message) {
        ToastUtil.showLongToastTop("" + message);
    }
}
