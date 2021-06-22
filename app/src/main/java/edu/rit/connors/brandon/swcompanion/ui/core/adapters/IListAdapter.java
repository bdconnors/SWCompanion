package edu.rit.connors.brandon.swcompanion.ui.core.adapters;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.ui.core.models.ListItem;

public interface IListAdapter {
    void setItems(ArrayList<ListItem> items);
    void clearItems();
}
