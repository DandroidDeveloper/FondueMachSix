package chaos.dandroid.fonduemachsix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import chaos.dandroid.fonduemachsix.dummy.DummyContent;


/**
 * An activity representing a single Item detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link ItemDetailFragment}.
 */
public class ItemDetailActivity extends ActionBarActivity implements ActionBar.TabListener{
    List<Fragment> fragList = new ArrayList<Fragment>();
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String reportDate = df.format(today);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        // Show the Up button in the action bar.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            /*getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();*/
            //set up tabs
            ActionBar bar = getSupportActionBar();
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
                ActionBar.Tab tab = bar.newTab();
                ActionBar.Tab tab2 = bar.newTab();

            switch (fragment.getArguments().getString(ItemDetailFragment.ARG_ITEM_ID)){
                        case "1":
                            tab.setText(reportDate);
                            tab.setTabListener(this);
                            bar.addTab(tab);

                            tab2.setText("Notes");
                            tab2.setTabListener(this);
                            bar.addTab(tab2);
                            break;
                        case "2":
                            tab.setText("Tasks");
                            tab.setTabListener(this);
                            bar.addTab(tab);

                            tab2.setText("Notes");
                            tab2.setTabListener(this);
                            bar.addTab(tab2);
                            break;
                        case "3":
                            tab.setText("Food");
                            tab.setTabListener(this);
                            bar.addTab(tab);

                            tab2.setText("Notes");
                            tab2.setTabListener(this);
                            bar.addTab(tab2);
                            break;
                        case "4":
                            tab.setText("Fitness");
                            tab.setTabListener(this);
                            bar.addTab(tab);

                            tab2.setText("Notes");
                            tab2.setTabListener(this);
                            bar.addTab(tab2);
                            break;
                    }







        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Fragment f = null;
        TabFragment tf = null;

        if (fragList.size() > tab.getPosition())
            fragList.get(tab.getPosition());

        if (f == null) {
            tf = new TabFragment();
            Bundle data = new Bundle();
            data.putInt("idx",  tab.getPosition());
            tf.setArguments(data);
            fragList.add(tf);
        }
        else
            tf = (TabFragment) f;

        ft.replace(android.R.id.content, tf);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (fragList.size() > tab.getPosition()) {
            ft.remove(fragList.get(tab.getPosition()));
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    
}
