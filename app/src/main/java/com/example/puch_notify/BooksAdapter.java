package com.example.puch_notify;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.puch_notify.Model.Book;

import java.util.List;
import android.app.DownloadManager;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {
    private List<Book> books;

//    DownloadManager dm;

    public BooksAdapter(List<Book> bookList) {
        books = bookList;
    }




    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.one_book, viewGroup, false);
        return new BooksViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder booksViewHolder, int position) {
            Book book = books.get(position);

            booksViewHolder.bookName.setText(book.getName());
            booksViewHolder.url.setText(book.getUrl());
//            final Context c = this;
            booksViewHolder.bookParentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager dm = (DownloadManager)v.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://www.gurumann.com/MONTHLY_COST_OF_MUSCLE_BUILDING_IN_INDIA.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = dm.enqueue(request);
                }
            });

    }


    @Override
    public int getItemCount() {
        return books.size();
    }






    public class BooksViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout bookParentLayout;
        private TextView bookName,url;
        public BooksViewHolder(@NonNull View parentView) {
            super(parentView);
            bookName = parentView.findViewById(R.id.bookName);
            url = parentView.findViewById(R.id.url);
            bookParentLayout = parentView.findViewById(R.id.bookParentLayout);
        }
    }
}
