package com.example.shohibulamin.menuberbuka.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.shohibulamin.menuberbuka.DetailMenuActivity;
import com.example.shohibulamin.menuberbuka.R;
import com.example.shohibulamin.menuberbuka.model.SemuamenuItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {
    List<SemuamenuItem> semuamenuItemList;
    Context mContext;

    public String[] mColors = {
        "#39add1", // light blue
        "#3079ab", // dark blue
        "#c25975", // mauve
        "#e15258", // red
        "#f9845b", // orange
        "#838cc7", // lavender
        "#7d669e", // purple
        "#53bbb4", // aqua
        "#51b46d", // green
        "#e0ab18", // mustard
        "#637a91", // dark gray
        "#f092b0", // pink
        "#b7c0c7"  // light gray
    };

    public MenuAdapter(Context context, List<SemuamenuItem> menuList) {
        this.mContext = context;
        semuamenuItemList = menuList;
    }

    @Override
    public MenuAdapter.MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        final SemuamenuItem semuamenuitem = semuamenuItemList.get(position);
        holder.tvNamaMenu.setText(semuamenuitem.getNamaMenu());

        String namaMenu = semuamenuitem.getNamaMenu();
        String deskripsiMenu = semuamenuitem.getDescripsiMenu();
        String cutDeskripsiMenu = deskripsiMenu.substring(0,100);
        holder.tvDeskripsiMenu.setText(cutDeskripsiMenu);
        String cutNamaMenu = namaMenu.substring(0,1);
        TextDrawable drawable = TextDrawable.builder().buildRound(cutNamaMenu, getColor());
        Picasso.get().load(semuamenuitem.getGambarMenu().toString()).resize(50, 50).transform(new CircleTransform()).placeholder(drawable).error(drawable).
                centerCrop().into(holder.ivGambarMenu);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaMenu = semuamenuitem.getNamaMenu();
                String idMenu = semuamenuitem.getId();
                Intent intent = new Intent(mContext, DetailMenuActivity.class);
                intent.putExtra("id", idMenu);
                intent.putExtra("nama_menu", namaMenu);
                mContext.startActivity(intent);
                Toast.makeText(mContext, "Kamu memilih menu " + namaMenu, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return semuamenuItemList.size();
    }

    public class MenuHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ivGambarMenu)
        ImageView ivGambarMenu;
        @BindView(R.id.tvNamaMenu)
        TextView tvNamaMenu;
        @BindView(R.id.tvDeskripsiMenu)
        TextView tvDeskripsiMenu;
        @BindView(R.id.card_view_hari)
        CardView cardView;

        public MenuHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    public int getColor() {
        String color;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }

    public class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size/2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }
}
