package test.demo.code.playwings.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import test.demo.code.playwings.R;
import test.demo.code.playwings.ui.Fragment.PayFragment;

public class ShoppingActivity extends AppCompatActivity implements PayFragment.Listener {

    public static Intent newIntent(Context context) {
        return new Intent(context, ShoppingActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, PayFragment.newInstance())
                    .commit();
        }
    }

    /**
     * 인트로 엑티비티에 화면을 전달된 프래그먼트로 변경한다.
     * 프래그먼트 종류
     *
     * @param fragment 메인 화면으로 보여질 프래그먼트
     */
    private void replaceFragment(Fragment fragment) {
        // 프래그먼트 할당을 위해 프래그먼트 트렌젝션을 호출한다.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 현재보고 있는 프래그먼트를 전달받은 프래그먼트로 변경한다.
        transaction.replace(R.id.fragment_container, fragment);
        // 뒤로가기 버튼 클릭시 이전 프래그먼트를 보여줄수 있도록 한다.
        transaction.addToBackStack(null);

        // 엑티비티에 프래그먼트 할당을 완료한다.
        transaction.commit();
    }

    @Override
    public void buyProduct(String usrName) {
        startActivity(ProductActivity.newIntent(this, usrName));
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            startActivity(ProductActivity.newIntent(this));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
