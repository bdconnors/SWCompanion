package edu.rit.connors.brandon.swcompanion.ui.util;

import android.app.Activity;

import java.util.List;

import edu.rit.connors.brandon.swcompanion.constants.WebSource;
import edu.rit.connors.brandon.swcompanion.network.util.INetworkService;

public interface IListAdapter<T> {
    void setItems(List<T> items);
    List<T> getItems();
    T getItem(int position);
    void clearItems();
    Activity getActivity();
}
