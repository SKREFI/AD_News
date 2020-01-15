package ro.atelieruldigital.news.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ro.atelieruldigital.news.R;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleItemView;
        private final TextView authorItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            titleItemView = itemView.findViewById(R.id.rv_item_title);
            authorItemView = itemView.findViewById(R.id.rv_item_author);
        }
    }

    private final LayoutInflater mInflater;
    private List<Article> mArticles; // Cached copy of words

    public ArticleListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mArticles != null) {
            Article current = mArticles.get(position);
            holder.titleItemView.setText(current.getTitle());
            holder.authorItemView.setText(current.getAuthor());
        } else {
            // Covers the case of data not being ready yet.
            holder.titleItemView.setText("No title");
            holder.authorItemView.setText("No author");
        }
    }

    public void setArticles(List<Article> articles){
        mArticles = articles;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mArticles != null)
            return mArticles.size();
        else return 0;
    }
}