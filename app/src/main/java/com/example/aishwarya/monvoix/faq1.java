package com.example.aishwarya.monvoix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class faq1 extends AppCompatActivity {
    private List<Faq> FaqList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FaqsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new FaqsAdapter(FaqList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Faq Faq = FaqList.get(position);
                Toast.makeText(getApplicationContext(), Faq.getquestion() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareFaqData();
    }

    private void prepareFaqData() {
        Faq Faq = new Faq("How do I use MonVoix -Text to Gesture.", "Enter the text in the Search tab or speak into the microphone.");
        FaqList.add(Faq);

        Faq = new Faq("How do I use MonVoix -Gesture to Text.","Capture the gesture using camera to obtain text.");
        FaqList.add(Faq);

        Faq = new Faq("Where can I find the common sign language words ?", "Go to top-right menu and select Directory");
        FaqList.add(Faq);

        Faq = new Faq("Why is my Sms not being sent ?", "Check your network connection ,balance information or valid contact information .");
        FaqList.add(Faq);

        Faq = new Faq("Why is my gesture not getting recognised ?", "Capture image in well lit area.");
        FaqList.add(Faq);

        mAdapter.notifyDataSetChanged();
    }

}
