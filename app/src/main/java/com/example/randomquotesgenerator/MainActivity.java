package com.example.randomquotesgenerator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private TextView quoteIdTextView;
    private TextView quoteTextView;
    private TextView authorTextView;
    private ImageView getQuoteButton;
    private ImageView shareQuoteButton;
    private ProgressBar loadingProgressBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        quoteIdTextView = findViewById(R.id.quoteIdTextView);
        quoteTextView = findViewById(R.id.quoteTextView);
        authorTextView = findViewById(R.id.authorTextView);
        getQuoteButton = findViewById(R.id.getQuoteButton);
        shareQuoteButton = findViewById(R.id.shareQuoteButton);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);


        quoteTextView.setVisibility(View.GONE);
        authorTextView.setVisibility(View.GONE);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.quoteData.observe(this, quote -> {

            loadingProgressBar.setVisibility(View.GONE);

            quoteTextView.setText(quote.getQuote());
            authorTextView.setText("- " + quote.getAuthor());
            quoteTextView.setVisibility(View.VISIBLE);
            authorTextView.setVisibility(View.VISIBLE);
        });

        viewModel.fetchQuote();

        loadingProgressBar.setVisibility(View.VISIBLE);

        getQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                quoteTextView.setVisibility(View.GONE);
                authorTextView.setVisibility(View.GONE);
                viewModel.fetchQuote();
            }
        });

        shareQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareQuote();
            }
        });
    }

    private void shareQuote() {
        String quote = quoteTextView.getText().toString();
        String author = authorTextView.getText().toString();

        String shareText = quote + "\n" + author;

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(shareIntent, "Share Quote"));
    }
}
