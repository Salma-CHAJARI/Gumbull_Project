package com.example.startlist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startlist.Adapter.GumbullAdapter;
import com.example.startlist.Bean.Gumbull;
import com.example.startlist.service.GumbullService;
import com.google.android.material.appbar.MaterialToolbar;


public class GumbullActivity extends AppCompatActivity {

    private RecyclerView list;
    private GumbullService gumballService;
    private GumbullAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.material);
        setSupportActionBar(toolbar);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.gumball_color_light));
        list = findViewById(R.id.recycle);
        gumballService = GumbullService.getInstance();

        gumballService.create(new Gumbull("Gumball Watterson ", "https://th.bing.com/th/id/OIP.JvoS61MsWPEKzvW9jt1suQAAAA?rs=1&pid=ImgDetMain", 4.5F));
        gumballService.create(new Gumbull("Darwin Watterson ", "https://th.bing.com/th/id/OIP.TO8Irpf6Wk646fMbHVcmAwHaHP?rs=1&pid=ImgDetMain", 3.4F));
        gumballService.create(new Gumbull("Anais Watterson", "https://i.pinimg.com/736x/54/3f/a3/543fa34ae5ca24f07e419fb610e04a40.jpg", 5F));
        gumballService.create(new Gumbull("Richard Watterson", "https://superawesomevectors.com/wp-content/uploads/2024/04/richard-watterson-free-vector-character-thumb.jpg", 2.2F));
        gumballService.create(new Gumbull("Nicole Watterson", "https://th.bing.com/th/id/OIP.ac81HPSYNssv4MPTDKq2cgHaFI?rs=1&pid=ImgDetMain", 3.4F));
        gumballService.create(new Gumbull("Tobias Wilson", "https://i.pinimg.com/736x/7f/ab/2d/7fab2d8084bf337c89b3fa5772c3256d--a-crush-gumball.jpg", 3.4F));
        gumballService.create(new Gumbull("Penny", "https://i.pinimg.com/736x/04/c1/bd/04c1bd9e6b8718f409c9a36e1e049f61.jpg", 2F));
        gumballService.create(new Gumbull("Carrie Krueger", "https://i.pinimg.com/736x/53/f2/87/53f287cb81eb6d5631b7c9a1391e3665--cartoon-network-gumball.jpg", 3F));
        gumballService.create(new Gumbull("Banana Joe ", "https://i.pinimg.com/236x/77/de/5f/77de5f76d9d0ac075a573cc13a92ee2e--gumball-bananas.jpg", 4.2F));
        gumballService.create(new Gumbull("Principal Brown", "https://i.pinimg.com/236x/29/95/9e/29959ec270b04befd1c289a12f9dea92--gumball.jpg", 5F));
        gumballService.create(new Gumbull("Miss Lucy Simian", "https://pm1.narvii.com/6684/6877173fa876f55c468491dc696e70c6cf1d77dd_hq.jpg", 3.6F));
        gumballService.create(new Gumbull("Larry Needlemeyer", "https://artworks.thetvdb.com/banners/v4/actor/9095193/photo/62e24056c05c4.jpg", 2.5F));
        gumballService.create(new Gumbull("Anton", "https://th.bing.com/th/id/R.6883318eb331df320ee09df4e2c8f3d7?rik=yjYg9HK4JoIKhA&riu=http%3a%2f%2fpm1.narvii.com%2f6550%2f450d68bd25a0edc236d34f239e3551fdddb7e091_00.jpg&ehk=XjWpw%2f%2fFWRbRqMgI9whgkiuqUASFVDzVENGcpHF35j4%3d&risl=&pid=ImgRaw&r=0", 3.5F));
        gumballService.create(new Gumbull("Hector Jötunheim", "https://i.pinimg.com/236x/d5/1e/10/d51e10165aa7cdab35e0d4b7db1b74a7.jpg?nii=t", 4.5F));



        adapter = new GumbullAdapter(gumballService.findAll(), this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);


        MenuItem searchItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return true;
            }

        });


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            String txt = "Partager les images et les carractères de Gumbull avec vos enfants,vos frères ou vos amis!!";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Stars")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);
    }
}
