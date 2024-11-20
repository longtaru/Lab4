package mob.longnd.lab4.bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import mob.longnd.lab4.R;

public class Bai1Activity extends AppCompatActivity {
    Button btnFrag1, btnFrag2;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnFrag1=findViewById(R.id.btn_frag1);
        btnFrag2=findViewById(R.id.btn_frag2);
        frameLayout=findViewById(R.id.fr_content);

        fragmentManager=getSupportFragmentManager();

        LogoFragment logoFragment = new LogoFragment();
        fragmentManager.beginTransaction().replace(R.id.fr_content,logoFragment).commit();

        btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogoFragment logoFragment = new LogoFragment();
                fragmentManager.beginTransaction().replace(R.id.fr_content,logoFragment).commit();
            }
        });

        btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NameFragment nameFragment = new NameFragment();
                fragmentManager.beginTransaction().replace(R.id.fr_content,nameFragment).commit();
            }
        });
    }
}