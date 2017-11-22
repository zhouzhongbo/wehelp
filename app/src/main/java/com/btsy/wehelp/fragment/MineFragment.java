package com.btsy.wehelp.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.btsy.wehelp.R;
import com.btsy.wehelp.activitys.LoginActivity;
import com.btsy.wehelp.database.dao.WeUser;
import com.btsy.wehelp.tools.UnitUtil;
import com.btsy.wehelp.view.CircleImageView;
import com.bumptech.glide.Glide;
import com.droi.sdk.DroiCallback;
import com.droi.sdk.DroiError;
import com.droi.sdk.core.DroiFile;
import com.droi.sdk.core.DroiUser;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;

/**
 * Created by zhouzhongbo on 2017/9/1.
 */

public class MineFragment extends Fragment implements TakePhoto.TakeResultListener,InvokeListener,View.OnClickListener {

    private WeUser user;
    private boolean islogin;
    InvokeParam invokeParam;
    TakePhoto takePhoto;
    String TAG="minefragment";
    PopupWindow mPopupWindow;
    String editbox_context;
//    Unbinder unbinder;
    CircleImageView userIcon;
    LinearLayout login_parent_view;
    TextView userName;
    Button editButton;
    RelativeLayout register_parent_view;
    EditText userEditbox;

    public static MineFragment newInstance(String param1) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MineFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_layout, container, false);
        initview(view);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("zzb","resultcode ="+resultCode+";resultCode="+resultCode+"!");
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type=PermissionManager.onRequestPermissionsResult(requestCode,permissions,grantResults);
        PermissionManager.handlePermissionsResult(getActivity(),type,invokeParam,this);
    }


    private void initview(View view){
        userIcon = (CircleImageView)view.findViewById(R.id.usr_icon);
        login_parent_view = (LinearLayout)view.findViewById(R.id.login_status_view);
        userName = (TextView)view.findViewById(R.id.user_name);
        editButton = (Button)view.findViewById(R.id.edit_user_info);
        register_parent_view = (RelativeLayout)view.findViewById(R.id.register_or_login);
        userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islogin = isLogin();
                if(!islogin){
                    goRegisterOrLogin();
                }else{
                    ShowDialog();
                }
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islogin = isLogin();
                if(!islogin){
                    goRegisterOrLogin();
                }else{
                    showUserNameEidter();
                }
            }
        });

        register_parent_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRegisterOrLogin();
            }
        });

        view.findViewById(R.id.about_container).setOnClickListener(this);
        view.findViewById(R.id.account_container).setOnClickListener(this);
        view.findViewById(R.id.feedback_container).setOnClickListener(this);
        view.findViewById(R.id.update_container).setOnClickListener(this);
        view.findViewById(R.id.other_container).setOnClickListener(this);
    }




    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshUi();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void  onClick(View view){
        boolean islogin = isLogin();
        if(!islogin){
            goRegisterOrLogin();
            Toast.makeText(getActivity(),R.string.please_login_at_first,Toast.LENGTH_SHORT).show();
            return;
        }
        int id = view.getId();
        switch(id){
            case R.id.about_container:
                Toast.makeText(getActivity(),"关于栏位点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.account_container:
                Toast.makeText(getActivity(),"账号栏位点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback_container:
                Toast.makeText(getActivity(),"反馈栏位点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.update_container:
                Toast.makeText(getActivity(),"自更新栏位点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.other_container:
                Toast.makeText(getActivity(),"其他栏位点击",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


    private boolean isLogin(){
        boolean islogin;
        user = DroiUser.getCurrentUser(WeUser.class);
        if (user != null && user.isAuthorized() && !user.isAnonymous()) {
            islogin = true;
        } else {
            islogin = false;
        }
        return islogin;
    }

    public void goRegisterOrLogin(){
        Intent mintent = new Intent(getActivity(), LoginActivity.class);
        mintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mintent);
    }


    public void refreshUi(){
        islogin = isLogin();
        if(islogin){
            login_parent_view.setVisibility(View.VISIBLE);
            register_parent_view.setVisibility(View.GONE);
            String name = user.getNickname();
            if(name != null&&!name.equals("")){
                Log.d("zzb","11name ="+name);
                userName.setText(name);
            }else{
                Log.d("zzb","22name ="+user.getUserId());
                userName.setText(user.getUserId());
            }
            DroiFile icon = user.getUserIcon();
            if(icon != null && icon.hasUri()){
                Glide.with(getActivity()).load(icon.getUri()).into(userIcon);
            }else{
                Glide.with(getActivity()).load(R.drawable.default_icon).into(userIcon);
            }
        }else{
            login_parent_view.setVisibility(View.GONE);
            register_parent_view.setVisibility(View.VISIBLE);
            Glide.with(getActivity()).load(R.drawable.default_icon).into(userIcon);
        }
    }

//    public void setUserIcon(final TImage imageFile){
//        String imagePath = imageFile.getOriginalPath();
//        final DroiFile droifile = new DroiFile(new File(imagePath));
//        droifile.saveInBackground(new DroiCallback<Boolean>() {
//            @Override
//            public void result(Boolean aBoolean, DroiError droiError) {
//                if(droiError.isOk()){
//                    user.setUserIcon(droifile);
//                    user.saveInBackground(new DroiCallback<Boolean>() {
//                        @Override
//                        public void result(Boolean aBoolean, DroiError droiError) {
//                            if(droiError.isOk()){
//                                Log.d("zzb","update icon success");
//                            }
//                        }
//                    });
//                }
//            }
//        });
//    }




    /**
     *  获取TakePhoto实例
     * @return
     */
    public TakePhoto getTakePhoto(){
        if (takePhoto==null){
            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(getActivity(),this));
        }
        return takePhoto;
    }

    @Override
    public void takeSuccess(TResult result) {
        Log.i(TAG, "takeSuccess:" + result.toString());
        String imagePath = result.getImage().getOriginalPath();
        final DroiFile droifile = new DroiFile(new File(imagePath));
        droifile.saveInBackground(new DroiCallback<Boolean>() {
            @Override
            public void result(Boolean aBoolean, DroiError droiError) {
                if(droiError.isOk()){
                    user.setUserIcon(droifile);
                    user.saveInBackground(new DroiCallback<Boolean>() {
                        @Override
                        public void result(Boolean aBoolean, DroiError droiError) {
                            if(droiError.isOk()){
                                Log.d("zzb","update icon success");
                            }
                        }
                    });
                }
            }
        });
        userIcon.setImageBitmap(BitmapFactory.decodeFile(result.getImage().getOriginalPath()));
    }

    @Override
    public void takeFail(TResult result,String msg) {
        Log.i(TAG, "takeFail:" + msg);
    }

    @Override
    public void takeCancel() {
        Log.i(TAG, "takecancel!");
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type=PermissionManager.checkPermission(TContextWrap.of(getActivity()),invokeParam.getMethod());
        if(PermissionManager.TPermissionType.WAIT.equals(type)){
            this.invokeParam=invokeParam;
        }
        return type;
    }

    CropOptions op =  new CropOptions.Builder().
            setAspectX(200).setAspectY(200).
            setWithOwnCrop(true).
            create();

    private void ShowDialog(){
        new AlertDialog.Builder(getActivity()).setItems(
                new String[] { "拍摄照片", "从相册选择"},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                takePhoto.onPickFromCaptureWithCrop(UnitUtil.createOutUri(),op);
                                break;
                            case 1:
                                takePhoto.onPickFromGalleryWithCrop(UnitUtil.createOutUri(),op);
                                break;
                            default:
                                break;
                        }
                    }
                }).show();
    }

    public void showUserNameEidter(){
        View popupView = getActivity().getLayoutInflater().inflate(R.layout.popupwin_edit_userinfo, null);
        userEditbox = (EditText)popupView.findViewById(R.id.userinfo_input);
        popupView.findViewById(R.id.cancle_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();
            }
        });
        popupView.findViewById(R.id.sure_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editbox_context!= null&&!editbox_context.equals("")){
                    user.setNickname(editbox_context);
                    userName.setText(editbox_context);
                    user.saveInBackground(new DroiCallback<Boolean>() {
                        @Override
                        public void result(Boolean aBoolean, DroiError droiError) {
                            if(droiError.isOk()){
                                Log.d("zzb","user info is save ok !");
                            }else{
                                Log.d("zzb","user info save failed !");
                            }
                        }
                    });
                    mPopupWindow.dismiss();
                }else{
                    Toast.makeText(getActivity(),"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        userEditbox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editbox_context = userEditbox.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        userEditbox.setHint(R.string.hint_nickname);
        if(user.getNickname()!= null){
            userEditbox.setText(user.getNickname());
        }else{
            userEditbox.setText(user.getUserId());
        }



        mPopupWindow = new PopupWindow(popupView, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setContentView(popupView);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        View rootview = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine_layout, null);

        mPopupWindow.showAtLocation(rootview, Gravity.CENTER,0,0);
    }
}
