package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;

    //    private View button_imc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button_imc = findViewById(R.id.button_imc);
        rvMain = findViewById(R.id.main_rv);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter();
        rvMain.setAdapter(adapter);


//        button_imc.setOnClickListener(v -> {
//           Intent intent = new Intent(MainActivity.this, ImcActivity.class);
//           startActivity(intent);
//          });
    }

    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

    private class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        private void bind(int position){
            TextView textTest = itemView.findViewById(R.id.textview_test);
            textTest.setText("teste de rolagem" + position);
        }
    }


}
