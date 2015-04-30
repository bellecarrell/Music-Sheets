package app.project.musicsheets;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Jacob on 4/5/2015.
 */
public class ComposeActivity extends GoogleDriveActivity implements View.OnDragListener, View.OnLongClickListener {

    private static final String TAG = "ComposeActivity";
    protected static final int GET_DRIVE_ID = 2;
    DriveId driveId;
    DriveFile file;
    ProgressBar mProgressBar;
    DriveContents driveContents;
    String fileString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivityForResult(new Intent(this, CreateFileActivity.class), GET_DRIVE_ID);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    public void onConnected(Bundle connectionHint) {
        super.onConnected(connectionHint);
        file = Drive.DriveApi.getFile(getGoogleApiClient(),driveId);
        EditContentsAsyncTask editContentsAsyncTask = new EditContentsAsyncTask(ComposeActivity.this);
        fileString = "Hello world";
        editContentsAsyncTask.execute();

    }

    public class EditContentsAsyncTask extends ApiClientAsyncTask<DriveFile, Void, Boolean> {
        public EditContentsAsyncTask(Context context) {
            super(context);
        }

        @Override
        protected Boolean doInBackgroundConnected(DriveFile... args) {
            try {
                DriveContentsResult driveContentsResult = file.open(
                        getGoogleApiClient(), DriveFile.MODE_WRITE_ONLY, null).await();
                if (!driveContentsResult.getStatus().isSuccess()) {
                    return false;
                }
                DriveContents driveContents = driveContentsResult.getDriveContents();
                OutputStream outputStream = driveContents.getOutputStream();
                outputStream.write(fileString.getBytes());
                com.google.android.gms.common.api.Status status =
                        driveContents.commit(getGoogleApiClient(), null).await();
                return status.getStatus().isSuccess();
            } catch (IOException e) {
                Log.e(TAG, "IOException while appending to the output stream", e);
            }
            return false;
        }
        @Override
        protected void onPostExecute(Boolean result) {
            if (!result) {
                showMessage("Error while editing contents");
                return;
            }
            showMessage("Successfully edited contents");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){

            case GET_DRIVE_ID:
                if (resultCode == RESULT_OK) {
                    // Grab the DriveId out of the passed back Intent
                    driveId = DriveId.decodeFromString(data.getParcelableExtra("driveId").toString());
                    showMessage(driveId.toString());
                    break;

                }
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }

    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
