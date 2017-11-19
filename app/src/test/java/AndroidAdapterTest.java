
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import nyc.c4q.buzzfeedquizgame.R;
import nyc.c4q.buzzfeedquizgame.controler.AndroidAdapter;
import nyc.c4q.buzzfeedquizgame.model.Model;

import static org.junit.Assert.assertEquals;

/**
 * Created by muridjonrahimov on 11/18/17.
 */

public class AndroidAdapterTest {

    @Test
public void shouldReturnList() {
        List<Model> myTestList = new ArrayList<>();

        myTestList.add(new Model("Yes", true, R.drawable.android_five));

        AndroidAdapter androidAdapter = new AndroidAdapter(myTestList);
        int count = androidAdapter.getItemCount();
        assertEquals(2, count);
    }
}
