package com.arkapp.expensemanager.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.arkapp.expensemanager.R;
import com.arkapp.expensemanager.data.repository.PrefRepository;

import org.jetbrains.annotations.NotNull;

import static androidx.navigation.fragment.NavHostFragment.findNavController;
import static com.arkapp.expensemanager.utils.Constants.ENTERED_USER_NAME;

public class HomeFragment extends Fragment {

    private PrefRepository prefRepository;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        prefRepository = new PrefRepository(getContext());
        addUserName();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    //Used for showing the edit icon in the toolbar
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        requireActivity().getMenuInflater().inflate(R.menu.menu_toolbar, menu);
    }

    //Toolbar options click listener
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        if (item.getItemId() == R.id.addExpense) {
            findNavController(this).navigate(R.id.action_homeFragment_to_addExpenseFragment);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addUserName() {
        if (ENTERED_USER_NAME.length() > 0)
            new CheckLoggedInUserAsyncTask(requireActivity(), prefRepository).execute();

    }
}