package com.faragostaresh.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.faragostaresh.osport.R;
import com.faragostaresh.osport.VideoSingleActivity;

import java.util.List;

/**
 * Created by Belal on 11/9/2015.
 * https://www.simplifiedcoding.net/android-custom-listview-with-images-using-recyclerview-and-volley/
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {

    private ImageLoader imageLoader;
    private Context context;

    //List of video
    List<Video> video;

    public VideoListAdapter(List<Video> video, Context context){
        super();
        //Getting all the video
        this.video = video;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.large_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Video singelVideo =  video.get(position);

        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(singelVideo.getLargeUrl(), ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        holder.imageView.setImageUrl(singelVideo.getLargeUrl(), imageLoader);

        holder.textViewTitle.setText(singelVideo.getTitle());
        //holder.textViewVideoUrl.setText(String.valueOf(singelVideo.getVideoUrl()));

        // Set click
        holder.imageView.setOnClickListener(new clickInternetAccess(singelVideo.getId()));
    }

    @Override
    public int getItemCount() {
        return video.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public NetworkImageView imageView;
        public TextView textViewTitle;
        public TextView textViewVideoUrl;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewVideo);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            //textViewVideoUrl= (TextView) itemView.findViewById(R.id.textViewVideoUrl);
        }
    }


    public class clickInternetAccess extends Activity implements View.OnClickListener {
        int id;
        public clickInternetAccess(int id) {
            this.id = id;
        }

        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), VideoSingleActivity.class);
            intent.putExtra("id", id);
            view.getContext().startActivity(intent);
        }
    }
}
