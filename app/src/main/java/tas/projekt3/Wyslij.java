package tas.projekt3;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.*;
import com.loopj.android.http.*;

 import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Wyslij extends ActionBarActivity {

    private static AsyncHttpClient client = new AsyncHttpClient();
    public TextView textview;
    EditText fname,nick,haslo;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyslij);
        fname = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        nick=(EditText) findViewById(R.id.editText2);
        haslo=(EditText) findViewById(R.id.editText3);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                RequestParams params = new RequestParams();
                params.put("name", fname.getText().toString());
                client.setBasicAuth(nick.getText().toString(),haslo.getText().toString());
                client.get("http://uam.grzegorz2047.pl:8080/products/add", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        // If the response is JSONObject instead of expected JSONArray
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {

                        System.out.println("");
                    }
                });

            }
        });

    }
}




