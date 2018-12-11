package test.demo.code.playwings.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import test.demo.code.playwings.R;
import test.demo.code.playwings.ui.Fragment.ProductFragment;
import test.demo.code.playwings.ui.Fragment.ProductListFragment;

public class ProductActivity extends AppCompatActivity implements ProductListFragment.Listener, ProductFragment.Listener {

    private static final String BUY_USER = "test.demo.code.playwings.ui.Activity.ProductActivity.BUY_USER";

    public static Intent newIntent(Context context, String userName) {
        Intent intent = new Intent(context, ProductActivity.class);
        intent.putExtra(BUY_USER, userName);
        return intent;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ProductActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, ProductListFragment.newInstance())
                    .commit();
        }
        String userName = getIntent().getStringExtra(BUY_USER);
        if (userName != null) {
            Toast.makeText(this, userName, Toast.LENGTH_LONG).show();
            getIntent().removeExtra(BUY_USER);
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
    public void showProduct(int id) {
        replaceFragment(ProductFragment.newInstance(id));
    }

    @Override
    public void buyProduct() {
        startActivity(ShoppingActivity.newIntent(this));
        finish();
    }
}
