package com.yuzhi.fine.myActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuzhi.fine.R;
import com.yuzhi.fine.view.ChooseInputItemView;
import com.yuzhi.fine.view.EditInputItemView;

public class TenantConnectionActivity extends Activity {


    static final int CAMERA_HEADER_REQUEST = 1;
    static final int CAMERA_CARD_REQUEST = 2;

    EditInputItemView eiv_name ;
    ChooseInputItemView civ_gender;
    ChooseInputItemView civ_cardtype;
    Button btnPicHeader;
    Button btnPicCard;

    ImageView ivCard;
    ImageView ivHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_connection);
        initView();

    }


    public void initView(){

        eiv_name = (EditInputItemView)findViewById(R.id.eiv_name);

        civ_gender = (ChooseInputItemView)findViewById(R.id.civ_gender);
        civ_gender.setItemsM(new String[]{"男","女"});

        civ_cardtype = (ChooseInputItemView)findViewById(R.id.civ_cardtype);
        civ_cardtype.setItemsM(new String[]{"二代身份证","护照","港澳通行证","暂住证"});

        ivCard = (ImageView)findViewById(R.id.iv_card);
        ivHeader = (ImageView)findViewById(R.id.iv_head);

        //拍照按钮

        btnPicHeader = (Button) findViewById(R.id.btn_pic_header);
        btnPicHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new AlertDialog.Builder(TenantConnectionActivity.this).setTitle("hkhk").setMessage("jj").show();

                                //启动系统相机
//                                Intent intent = new Intent();
//                                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
//                                intent.putExtra(MediaStore.EXTRA_OUTPUT , new File(Environment.getExternalStorageDirectory(),"header.jpg") );
//                                startActivityForResult(intent,10);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, CAMERA_HEADER_REQUEST);

                System.out.println("人像按钮按下");
            }
        });

        btnPicCard = (Button)findViewById(R.id.btn_pic_card);
        btnPicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, CAMERA_CARD_REQUEST);

                System.out.println("证件按钮按下");
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //显示返回码
        Toast.makeText(TenantConnectionActivity.this,"result:"+requestCode,Toast.LENGTH_SHORT).show();

        Bundle bundle = data.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式


        if (requestCode == CAMERA_HEADER_REQUEST){
           //显示到界面
            ivHeader.setImageBitmap(bitmap);
        }else if (requestCode == CAMERA_CARD_REQUEST){
           //显示到界面
            ivCard.setImageBitmap(bitmap);
        }
    }
}
