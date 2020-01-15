package ro.atelieruldigital.news.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ro.atelieruldigital.news.R;

import static ro.atelieruldigital.news.utils.Constants.EXTRA_AUTHOR;
import static ro.atelieruldigital.news.utils.Constants.EXTRA_TITLE;

public class NewArticleActivity extends AppCompatActivity {

    private EditText mEditTextTitle;
    private EditText mEditTextAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);

        mEditTextAuthor = findViewById(R.id.edit_author);
        mEditTextTitle = findViewById(R.id.edit_title);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTextTitle.getText()) || TextUtils.isEmpty(mEditTextAuthor.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else { //TODO: Ask Cosmin: De ce trimitem inapoi in main activity datele si nu le introducem direct aici in db
                    replyIntent.putExtra(EXTRA_TITLE, mEditTextTitle.getText().toString());
                    replyIntent.putExtra(EXTRA_AUTHOR, mEditTextAuthor.getText().toString());
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
