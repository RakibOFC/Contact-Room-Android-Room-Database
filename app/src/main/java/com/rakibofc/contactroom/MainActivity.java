package com.rakibofc.contactroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rakibofc.contactroom.model.Contact;
import com.rakibofc.contactroom.model.ContactViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactViewModel contactViewModel;
    private TextView textView;
    private StringBuilder dbUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        dbUserInfo = new StringBuilder();

        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
                .getApplication())
                .create(ContactViewModel.class);

        contactViewModel.getAllContacts().observe(this, contacts -> {

            for (Contact contact : contacts) {

                dbUserInfo.append(contact.getName()).append(" ").append(contact.getOccupation()).append(" - ");
            }
            textView.setText(dbUserInfo.toString());
        });

        /* Insert Date in database table */
        /*Contact contact = new Contact("New Name2", "New Occupation");
        ContactViewModel.insert(contact);*/
    }
}