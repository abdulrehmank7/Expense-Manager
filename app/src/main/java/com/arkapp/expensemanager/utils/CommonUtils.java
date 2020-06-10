package com.arkapp.expensemanager.utils;

import com.arkapp.expensemanager.data.models.ExpenseType;
import com.google.gson.Gson;

import java.util.Date;

/**
 * Created by Abdul Rehman on 10-06-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
public class CommonUtils {
    public static Gson gson = new Gson();

    public static String convertExpenseType(ExpenseType data) {
        return gson.toJson(data);
    }

    public static ExpenseType convertExpenseType(String data) {
        return gson.fromJson(data, ExpenseType.class);
    }

    public static String convertDate(Date data) {
        return gson.toJson(data);
    }

    public static Date convertDate(String data) {
        return gson.fromJson(data, Date.class);
    }
}
