package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";//model
	private EditText bodyText;		//model
	private ListView oldTweetsList;		//model
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();		//model
	private ArrayAdapter<Tweet> adapter;		//view

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState); // view
		setContentView(R.layout.main); // view

		bodyText = (EditText) findViewById(R.id.body); //view
		Button saveButton = (Button) findViewById(R.id.save); //view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //view

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString(); //controller
				tweets.add(new NormalTweet(text)); // controller
				adapter.notifyDataSetChanged(); // view
				saveInFile(); // model
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();					//model
		loadFromFile();						//model
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);		//view
		oldTweetsList.setAdapter(adapter);					//view
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);					//model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));		//model
			Gson gson = new Gson();					//model
			// Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-09-22
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);		//view
		} catch (FileNotFoundException e) {				//model
			tweets = new ArrayList<Tweet>();			//model
		} catch (IOException e) {						//controller
			throw new RuntimeException(e);				//controller
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,			//model
					0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);		//controller
			Gson gson = new Gson();						//view
			gson.toJson(tweets, writer);				//view
			writer.flush();								//view
			fos.close();								//view
		} catch (FileNotFoundException e) {				//controller
			throw new RuntimeException(e);					//controller
		} catch (IOException e) {					//controller
			throw new RuntimeException(e);				//controller
		}
	}
}