package fr.app.foxtrot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smarteist.autoimageslider.SliderViewAdapter;

import fr.app.foxtrot.R;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterViewHolder> {
    private Context context;

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.image_slider, null);
        return new SliderAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapterViewHolder viewHolder, int position) {

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView.getContext()).
                        load("https://boygeniusreport.files.wordpress.com/2018/06/screen-shot-2018-06-21-at-2-40-48-pm.png").
                        apply(new RequestOptions()
                                .placeholder(R.drawable.img_header_placeholder)
                                .error(R.drawable.img_header_error)).
                        fitCenter().
                        into(viewHolder.imageView);
                break;
            case 1:
                Glide.with(viewHolder.itemView.getContext()).
                        load("https://cdn.neow.in/news/images/uploaded/2019/06/1561799189_test_story.jpg").
                        apply(new RequestOptions()
                                .placeholder(R.drawable.img_header_placeholder)
                                .error(R.drawable.img_header_error)).
                        fitCenter().
                        into(viewHolder.imageView);
                break;
            case 2:
                Glide.with(viewHolder.itemView.getContext()).
                        load("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fdavidthier%2Ffiles%2F2019%2F06%2F520004fe437f3d16a81549b4760797926e5bc563.jpg").
                        apply(new RequestOptions()
                                .placeholder(R.drawable.img_header_placeholder)
                                .error(R.drawable.img_header_error)).
                        fitCenter().
                        into(viewHolder.imageView);
                break;
            case 3:
                Glide.with(viewHolder.itemView.getContext()).
                        load("https://www.wepc.com/wp-content/uploads/2019/06/steam.jpg").
                        apply(new RequestOptions()
                                .placeholder(R.drawable.img_header_placeholder)
                                .error(R.drawable.img_header_error)).
                        fitCenter().
                        into(viewHolder.imageView);
                break;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    public class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder{
        ImageView imageView;
        View itemView;
        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_slider_photo);
            this.itemView = itemView;
        }
    }
}
