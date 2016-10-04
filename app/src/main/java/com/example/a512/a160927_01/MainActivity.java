package com.example.a512.a160927_01;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final int MY_CODE1 = 123,MY_CODE2 = 456,MY_CODE3 = 789 ;
    public Button btContact1, btContact2, btContact3;
    public String sName1, sNumber1, sName2, sNumber2, sName3, sNumber3;
    public Button btCall1, btCall2, btCall3, btSMS1, btSMS2, btSMS3;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_CODE1 && resultCode == RESULT_OK) {
            String[] strings = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(data.getData(),strings,null,null,null);
            cursor.moveToFirst();
            sName1 = cursor.getString(0);
            sNumber1 = cursor.getString(1);
            cursor.close();
            Toast.makeText(this, sName1 + ": " + sNumber1, Toast.LENGTH_SHORT).show();
        }
        else if (requestCode == MY_CODE2 && resultCode == RESULT_OK) {
            String[] strings = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(data.getData(),strings,null,null,null);
            cursor.moveToFirst();
            sName2 = cursor.getString(0);
            sNumber2 = cursor.getString(1);
            cursor.close();
            Toast.makeText(this, sName2 + ": " + sNumber2, Toast.LENGTH_SHORT).show();
        }
        else{
            String[] strings = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(data.getData(),strings,null,null,null);
            cursor.moveToFirst();
            sName3 = cursor.getString(0);
            sNumber3 = cursor.getString(1);
            cursor.close();
            Toast.makeText(this, sName3 + ": " + sNumber3, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btContact1 = (Button) findViewById(R.id.btContact1);

        btContact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intContact = new Intent(Intent.ACTION_PICK);
                intContact.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intContact, MY_CODE1);
            }
        });
        btCall1 = (Button) findViewById(R.id.btCall1);
        btCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+sName1));
                startActivity(cIntent);
            }
        });
        btSMS1 = (Button) findViewById(R.id.btSMS1);
        btSMS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 전화 번호에 대한 URI 가져오기
                // 바로 SMS를 보내지 않기 때문에 SMS 보내기 권한 설정 불필요
                Intent mIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+sNumber1));
                mIntent.putExtra("sms_body", "점검 중!");
                startActivity(mIntent);
            }
        });




        btContact2 = (Button) findViewById(R.id.btContact2);

        btContact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intContact = new Intent(Intent.ACTION_PICK);
                intContact.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intContact, MY_CODE2);
            }
        });
        btCall2 = (Button) findViewById(R.id.btCall2);
        btCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+sName2));
                startActivity(cIntent);
            }
        });
        btSMS2 = (Button) findViewById(R.id.btSMS2);
        btSMS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 전화 번호에 대한 URI 가져오기
                // 바로 SMS를 보내지 않기 때문에 SMS 보내기 권한 설정 불필요
                Intent mIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+sNumber2));
                mIntent.putExtra("sms_body", "점검 중!");
                startActivity(mIntent);
            }
        });




        btContact3 = (Button) findViewById(R.id.btContact3);

        btContact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intContact = new Intent(Intent.ACTION_PICK);
                intContact.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intContact, MY_CODE3);
            }
        });
        btCall3 = (Button) findViewById(R.id.btCall3);
        btCall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+sName3));
                startActivity(cIntent);
            }
        });
        btSMS3 = (Button) findViewById(R.id.btSMS3);
        btSMS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 전화 번호에 대한 URI 가져오기
                // 바로 SMS를 보내지 않기 때문에 SMS 보내기 권한 설정 불필요
                Intent mIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+sNumber3));
                mIntent.putExtra("sms_body", "점검 중!");
                startActivity(mIntent);
            }
        });
    }
}
