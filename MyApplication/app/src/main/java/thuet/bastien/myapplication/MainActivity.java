package thuet.bastien.myapplication;

        import android.content.ActivityNotFoundException;
        import android.content.Intent;
        import android.os.Bundle;
        import android.speech.RecognizerIntent;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView mVoiceInputTv;
    private ImageButton mSpeakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk);

        mVoiceInputTv = (TextView) findViewById(R.id.voiceInput);
        mSpeakBtn = (ImageButton) findViewById(R.id.btnSpeak);
        mSpeakBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });
    }

    public void talk(View view) {

        Intent startNewActivity  = new Intent(this, wait.class);
        startActivity(startNewActivity);

        //startActivity(new Intent(this, wait.class));
    }

    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello, How can I help you?");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> the_way = new ArrayList<String>();
                    the_way.add("do you know the way");
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if(the_way.get(0).equals(result.get(0))){
                        ArrayList<String> new_way = new ArrayList<String>();
                        new_way.add("I know the way,brotherrrrrrrrr");
                        mVoiceInputTv.setText(new_way.get(0));
                    } else {
                        mVoiceInputTv.setText(result.get(0));
                    }
                }
                break;
            }
        }
    }
}