package com.example.hp.location;

        import android.content.Context;
        import android.content.pm.PackageManager;
        import android.location.Location;
        import android.media.MediaPlayer;
        import android.net.Uri;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.MediaController;
        import android.widget.TextView;

        import com.google.android.gms.common.ConnectionResult;
        import com.google.android.gms.common.api.GoogleApiClient;

        import com.google.android.gms.location.LocationRequest;
        import com.google.android.gms.location.LocationServices;

        import android.location.LocationListener;
        import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {
    MediaPlayer m= new MediaPlayer();
    public static int a=0;
    public Button button;
    public   VideoView videoView;
    public MediaController mediaController;
    private TextView latitude;
    private TextView distance;
    private TextView longitude;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        latitude = (TextView) findViewById(R.id.latitude);
        longitude = (TextView) findViewById(R.id.longitude);
        distance = (TextView) findViewById(R.id.distance);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Connect the client.
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        // Disconnecting the client invalidates it.
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000); // Update location every second
        mLocationRequest.setExpirationDuration(30000);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


    public void onLocationChanged(Location location) {
        double l1=25.2661673;
        double  l2=82.9860949;
        double  l3=24;

        double r=calculateDistance(l1,l2,location.getLatitude(),location.getLongitude());
        if(r<1000){
            player2();
        }
        else{
            player1();



        }
        //txtOutput.setText(location.toString());

        distance.setText(Double.toString(calculateDistance(l1,l2,location.getLatitude(),location.getLongitude())));
        latitude.setText(Double.toString(location.getLatitude()));
        longitude.setText(Double.toString(location.getLongitude()));
    }
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2)
    {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1151.5;
            dist = dist * 1.609344;
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg)
    {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad)
    {
        return (rad * 180.0 / Math.PI);
    }

    public void player1()
    {
        videoView=(VideoView)findViewById(R.id.videoView);
        mediaController= new MediaController(MainActivity.this);
        String videopath="android.resource://com.example.hp.location/"+R.raw.video;
        Uri uri=Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
    public void player2()
    {
        videoView=(VideoView)findViewById(R.id.videoView);
        mediaController= new MediaController(MainActivity.this);
        String videopath="android.resource://com.example.hp.location/"+R.raw.video2;
        Uri uri=Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
    public void player3()
    {
        videoView=(VideoView)findViewById(R.id.videoView);
        mediaController= new MediaController(MainActivity.this);
        String videopath="android.resource://com.example.hp.location/"+R.raw.video2;
        Uri uri=Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
    public void player4()
    {
        videoView=(VideoView)findViewById(R.id.videoView);
        mediaController= new MediaController(MainActivity.this);
        String videopath="android.resource://com.example.hp.location/"+R.raw.video2;
        Uri uri=Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
    public void player5()
    {
        videoView=(VideoView)findViewById(R.id.videoView);
        mediaController= new MediaController(MainActivity.this);
        String videopath="android.resource://com.example.hp.location/"+R.raw.video2;
        Uri uri=Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }


}
