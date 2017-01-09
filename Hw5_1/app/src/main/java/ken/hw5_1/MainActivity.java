package ken.hw5_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvPhotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        final List<Photos> photos = getphotos();
        lvPhotos.setAdapter(new PhotoAdaptper(this, photos));
        lvPhotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Photos photo = photos.get(position);
                String text = photo.getName()+"價格為"+photo.getPrice();
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void findview() {
        lvPhotos = (ListView) findViewById(R.id.lvPhotos);
    }

    private List<Photos> getphotos(){
        List<Photos> photos = new ArrayList<>();
        photos.add(new Photos(R.drawable.asusz2deluxe,"Asus ZenFone2 Deluxe","NT.5000"));
        photos.add(new Photos(R.drawable.asusz2laser,"Asus ZenFone2 Laser","NT.2000"));
        photos.add(new Photos(R.drawable.asusz3deluxe,"Asus ZenFone3 Deluxe","NT.8000"));
        photos.add(new Photos(R.drawable.asusz3ultra,"Asus ZenFone3 Ultra","NT.10000"));
        photos.add(new Photos(R.drawable.samsunga3,"Samsung Galaxy A3","NT.3000"));
        photos.add(new Photos(R.drawable.samsunga5,"Samsung Galaxy A5","NT.5000"));
        photos.add(new Photos(R.drawable.samsunga7,"Samsung Galaxy A7","NT.7000"));
        photos.add(new Photos(R.drawable.samsunga8,"Samsung Galaxy A8","NT.8000"));
        photos.add(new Photos(R.drawable.samsunga9,"Samsung Galaxy A9","NT.9000"));
        return photos;

    }

    private class PhotoAdaptper extends BaseAdapter {
        Context context;
        List<Photos> photos;

        public PhotoAdaptper(Context context, List<Photos> photos) {
            this.context = context;
            this.photos = photos;
        }
        @Override
        public View getView(final int position, View itemView, ViewGroup parent) {
            Photos photo = photos.get(position);
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            if(itemView==null){
                itemView = layoutInflater.inflate(R.layout.item_view,parent,false);
            }
            ImageView ivPhone = (ImageView)itemView.findViewById(R.id.ivPhone);
            ivPhone.setImageResource(photo.getImageId());

            TextView tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvName.setText(photo.getName());
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Photos photo = photos.get(position);
                    String text=photo.getName();
                    Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
                }
            });


            TextView tvPrice = (TextView)itemView.findViewById(R.id.tvPrice);
            tvPrice.setText(photo.getPrice());
            tvPrice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Photos photo = photos.get(position);
                    String text=photo.getPrice();
                    Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
                }
            });

            return itemView;
        }


        @Override
        public int getCount() {
            return photos.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


    }
}
