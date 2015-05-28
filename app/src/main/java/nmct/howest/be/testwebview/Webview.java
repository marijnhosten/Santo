package nmct.howest.be.testwebview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class Webview extends Fragment {

    private OnFragmentInteractionListener mListener;

    public Webview() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_webview, container, false);

        WebView wv = (WebView) v.findViewById(R.id.webview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        wv.loadUrl("http://student.howest.be/jef.hellemans/JEF/santo/klantenoverzicht.jpg");
        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
        mListener.onFragmentInteraction(uri);
     }
     }

     @Override
     public void onAttach(Activity activity) {
     super.onAttach(activity);
     try {
     mListener = (OnFragmentInteractionListener) activity;
     } catch (ClassCastException e) {
     throw new ClassCastException(activity.toString()
     + " must implement OnFragmentInteractionListener");
     }
     }

     @Override
     public void onDetach() {
     super.onDetach();
     mListener = null;
     }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
