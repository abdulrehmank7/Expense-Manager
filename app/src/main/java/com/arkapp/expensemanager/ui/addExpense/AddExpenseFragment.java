package com.arkapp.expensemanager.ui.addExpense;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.arkapp.expensemanager.databinding.BottomeSheetExpenseTypeBinding;
import com.arkapp.expensemanager.databinding.FragmentAddExpenseBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Calendar;

import static com.arkapp.expensemanager.utils.Constants.SELECTED_EXPENSE_TYPE;
import static com.arkapp.expensemanager.utils.Constants.getAllExpenseType;
import static com.arkapp.expensemanager.utils.GlideUtilsKt.loadImage;
import static com.arkapp.expensemanager.utils.ViewUtilsKt.getFormattedDate;
import static com.arkapp.expensemanager.utils.ViewUtilsKt.initVerticalAdapter;
import static com.arkapp.expensemanager.utils.ViewUtilsKt.isDoubleClicked;

public class AddExpenseFragment extends Fragment {

    private FragmentAddExpenseBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddExpenseBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setExpenseType();
        initExpenseTypeUI();
        initDateUI();
    }

    private void initDateUI() {
        binding.tvDate.setText(getFormattedDate(Calendar.getInstance().getTime()));

        binding.cvDate.setOnClickListener(v -> {
            //Checking if the button is not double clicked
            if (isDoubleClicked(1000)) return;
            Calendar currentDate = Calendar.getInstance();

            //Showing the date picker dialog
            DatePickerDialog.OnDateSetListener listener = (view1, year, month, dayOfMonth) -> {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(Calendar.YEAR, year);
                selectedDate.set(Calendar.MONTH, month);
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                binding.tvDate.setText(getFormattedDate(selectedDate.getTime()));
            };

            DatePickerDialog datePicker = new DatePickerDialog(requireContext(),
                                                               listener,
                                                               currentDate.get(Calendar.YEAR),
                                                               currentDate.get(Calendar.MONTH),
                                                               currentDate.get(Calendar.DAY_OF_MONTH));

            //Setting minimim date as current date.
            //datePicker.getDatePicker().setMinDate(currentDate.getTimeInMillis());
            datePicker.show();
        });
    }

    private void initExpenseTypeUI() {
        BottomeSheetExpenseTypeBinding dialogBinding = BottomeSheetExpenseTypeBinding.inflate(LayoutInflater.from(getContext()));
        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(dialogBinding.getRoot());
        initVerticalAdapter(dialogBinding.rvExpenseType, new ExpenseTypeAdapter(getAllExpenseType(), dialog), true);
        dialog.setOnDismissListener(dialog1 -> setExpenseType());

        binding.cvExpense.setOnClickListener(v -> {
            if (isDoubleClicked(1000)) return;
            dialog.show();
        });
    }

    private void setExpenseType() {
        binding.tvExpenseType.setText(SELECTED_EXPENSE_TYPE.getName());
        loadImage(binding.ivExpenseIcon, SELECTED_EXPENSE_TYPE.getResId());
    }
}