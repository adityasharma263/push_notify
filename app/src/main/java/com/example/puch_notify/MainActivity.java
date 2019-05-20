package com.example.puch_notify;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.pusher.pushnotifications.PushNotifications;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.app.DownloadManager;

import java.util.ArrayList;
import java.util.List;

import com.example.puch_notify.Model.Book;


public class MainActivity extends AppCompatActivity {

    List<Book> bookList;

    private RecyclerView recyclerView;
    private BooksAdapter adapter;
//    private DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushNotifications.start(getApplicationContext(), "28af143c-0118-49ae-8fbd-3b45591212bc");
        PushNotifications.addDeviceInterest("hello");
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new BooksAdapter(initDataList());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
//                Uri uri = Uri.parse("http://www.gurumann.com/MONTHLY_COST_OF_MUSCLE_BUILDING_IN_INDIA.pdf");
//                DownloadManager.Request request = new DownloadManager.Request(uri);
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                Long reference = downloadManager.enqueue(request);
//            }
//        });

    }

    //Adapter (Item Ui)

    private List<Book> initDataList(){
        Book book1= new Book("Book1","url1");
        Book book2= new Book("Book2","url2");
        Book book3= new Book("Book3","url3");
        Book book4= new Book("Book4","url4");
        bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        return bookList;
    }
}