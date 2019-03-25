package route.com.g2holyquran;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import route.com.g2holyquran.Model.Hadeth;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/21/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class HadethDialogFragment extends DialogFragment {

    public HadethDialogFragment(){

    }

    Hadeth hadethItem;

    public void setHadethItem(Hadeth hadethItem) {
        this.hadethItem = hadethItem;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.dialog_fragment_hadeth,container,false);

        TextView title= view.findViewById(R.id.title);
        TextView content= view.findViewById(R.id.content);
        title.setText(hadethItem.getTitle());
        content.setText(hadethItem.getContent());

      return view;
    }
}
