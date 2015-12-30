package com.example.jonsen.exercise2_7b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.*;
import android.os.Process;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText name, birthday, phone, suggest;
    private RadioButton man,woman;
    private Spinner yx;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editText);
        birthday = (EditText)findViewById(R.id.editText2);
        man = (RadioButton)findViewById(R.id.radioButton);
        woman = (RadioButton)findViewById(R.id.radioButton2);
        phone = (EditText)findViewById(R.id.editText3);
        suggest =(EditText)findViewById(R.id.editText4);
        yx = (Spinner)findViewById(R.id.spinner);
        t = (TextView)findViewById(R.id.textView);
    }

    public void up(View view) {
        if (name.getText().toString().trim().equals("")) {
            showMessage("请填写姓名！");
        } else if (birthday.getText().toString().equals("")) {
            showMessage("请填写出生日期！");
        } else if (!(man.isChecked()||woman.isChecked())) {
            showMessage("请选择性别！");
        } else if (yx.getSelectedItem().toString().equals("")) {
            showMessage("请选择院系！");
        } else if (phone.getText().toString().trim().equals("")) {
            showMessage("请填写电话号码！");
        } else if (suggest.getText().toString().equals("")) {
            showMessage("请填写建议！");
        } else {
            setContentView(R.layout.xian_shi);
            TextView textView = (TextView)findViewById(R.id.textView8);
            String sex = null;
            if (man.isChecked()) {
                sex = "男";
            } else if (woman.isChecked()) {
                sex = "女";
            }
            textView.setText("姓名：" + name.getText().toString().trim()
                    + "\n出生日期：" + birthday.getText().toString().trim()
                    + "\n性别：" + sex
                    + "\n院系：" + yx.getSelectedItem().toString()
                    + "\n电话号码：" + phone.getText().toString().trim()
                    + "\n建议：" + suggest.getText().toString().trim());

        }
    }


    /*
    消息提示
     */
    private void showMessage(String message) {
        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("系统信息");
        alert.setMessage(message);
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //可在此方法内编写按下确定按钮的处理代码，但在本项目中不需要编写处理代码
            }
        });
        alert.show();//显示窗口
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE, 1, Menu.NONE, "提交");
        menu.add(Menu.NONE, 2, Menu.NONE, "退出");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case 1:
                up(t);
                break;
            case 2:
                int pid = Process.myPid();
                Process.killProcess(pid);
                break;
        }
        return true;
    }


}
