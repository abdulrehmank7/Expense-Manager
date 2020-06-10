package com.arkapp.expensemanager.utils;

/**
 * Created by Abdul Rehman on 17-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

import com.arkapp.expensemanager.R;
import com.arkapp.expensemanager.data.models.ExpenseType;

import java.util.ArrayList;
import java.util.Date;

/**
 * This file contain all the constant value used in the app
 */
public class Constants {

    public static String ENTERED_USER_NAME = "";
    public static ExpenseType SELECTED_EXPENSE_TYPE = getAllExpenseType().get(6);
    public static Date SELECTED_EXPENSE_DATE = new Date();

    public final static String EXPENSE_RENT = "Rent";
    public final static String EXPENSE_GROCERIES = "Groceries";
    public final static String EXPENSE_ONLINE_SHOPPING = "Online Shopping";
    public final static String EXPENSE_GENERAL_MAINTENANCE = "General Maintenance";
    public final static String EXPENSE_HEALTH_CARE = "HealthCare";
    public final static String EXPENSE_FOOD_BEVERAGES = "Food & Beverages";
    public final static String EXPENSE_MISCELLANEOUS = "Other & miscellaneous";


    public static ArrayList<ExpenseType> getAllExpenseType() {
        ArrayList<ExpenseType> types = new ArrayList<>();

        types.add(new ExpenseType(EXPENSE_RENT, R.drawable.ic_mortgage, 0));
        types.add(new ExpenseType(EXPENSE_GROCERIES, R.drawable.ic_groceries, 0));
        types.add(new ExpenseType(EXPENSE_ONLINE_SHOPPING, R.drawable.ic_clothes, 0));
        types.add(new ExpenseType(EXPENSE_GENERAL_MAINTENANCE, R.drawable.ic_gas_station, 0));
        types.add(new ExpenseType(EXPENSE_HEALTH_CARE, R.drawable.ic_medicine, 0));
        types.add(new ExpenseType(EXPENSE_FOOD_BEVERAGES, R.drawable.ic_cafe, 0));
        types.add(new ExpenseType(EXPENSE_MISCELLANEOUS, R.drawable.ic_expense, 0));

        return types;
    }

}